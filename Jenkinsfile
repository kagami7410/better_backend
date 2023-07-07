pipeline {
    agent {
        kubernetes{
            inheritFrom 'kube-agent'
        }
    }

//    tools {
////        maven 'Maven 3.8.6'
//    }

    stages {
//        stage('set up') {
//            steps {
//                sh 'rm -rf better_backend'
//                sh 'git clone https://github.com/kagami7410/better_backend.git '
//
//            }
//        }
//            stage('maven package') {
//        steps {
//            sh 'mvn clean package'
//        }
//    }
//
//            stage('docker build') {
//        steps {
//            sh 'docker build -t better_backend_app .'
//            echo 'docker build complete!!!!!!!'
//        }
//    }
        stage('Test'){
            steps {
                echo 'HEllo test'
            }
        }
  }
}
