pipeline {
    agent {
        kubernetes{
            inheritFrom 'kube-agent'
        }
    }

    stages {
        stage('set up') {
            steps {
                sh 'rm -rf better_backend'
                sh 'git clone https://github.com/kagami7410/better_backend.git '
            }
        }
        stage('maven package') {
            steps {
                withMaven(maven: 'mvn'){
                    sh 'mvn clean package'
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
