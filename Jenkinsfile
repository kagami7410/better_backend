pipeline {
    agent {
        kubernetes{
            inheritFrom 'kube-agent'
        }
    }
    stages{
        stage('Test'){
            steps {
                echo 'Hello test'
            }
        }
    }
}

