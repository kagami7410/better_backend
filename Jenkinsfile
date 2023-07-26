pipeline {
    agent {
        kubernetes{
            inheritFrom 'kube-agent'
        }
    }
        stage('Test'){
            steps {
                echo 'Hello test'
            }
        }
}

