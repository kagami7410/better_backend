pipeline {
    agent {
        kubernetes{
            yaml '''
                apiVersion: v1
                kind: Pod
                spec:
                    containers:
                    - name: java
                      image: openjdk:17
                      command:
                      - cat 
                      tty: true
                    - name: docker-container
                      image: docker
                      command:
                      - cat
                      tty: true
                      volumeMounts:
                      - name: docker-sock-volume
                        mountPath: /var/run/docker.sock
                       
                    volumes:
                    - name: docker-sock-volume
                    - hostPath: 
                       path: /var/run/docker.sock
                      name: dockersock
                        
                    
                      
                    '''
        }
    }

    tools {
        maven 'maven'
    }

    stages {
        stage('set up') {
            steps {
                sh 'rm -rf better_backend'
                sh 'git clone https://github.com/kagami7410/better_backend.git '
                sh 'java -version'
            }
        }

        stage('maven package') {
        steps {
            script{
                container("java")
                        {
                            //                     def mvnHOME = tool name: 'maven', type: 'maven'
                            sh 'java -version'
                            sh "mvn -version"
                            sh 'mvn compile'
                            sh "mvn clean package"
                        }
                  }
            }
        }

        stage('docker test') {
            steps {
                script{
                    container("docker-container")
                            {
                                //                     def mvnHOME = tool name: 'maven', type: 'maven'
                                sh 'docker pull openjdk:17'
                                sh 'java -version'
                            }
                }
            }
        }
        stage('docker build') {
            steps {
                sh 'docker build -t better_backend_app .'
                sh 'docker tag better_backend_app sujan7410/better_back_end:v1.1.0'
                sh 'docker push sujan7410/better_back_end:v1.1.0'
        }
    }
        stage('deploy'){
            steps{
                echo("deployed!")
            }
        }
  }
}
