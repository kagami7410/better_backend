pipeline {
    agent {
        kubernetes{
            inheritFrom 'kubeagent'
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
//                     def mvnHOME = tool name: 'maven', type: 'maven'
                    sh 'java -version'
                    sh "mvn -version"
                    sh 'mvn compile'
                    sh "mvn clean package"
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
