pipeline {
    agent {
        docker {
            image 'maven:3-alpine'
            args '-v /root/.m2:/root/.m2'
        }
    }
    options {
        skipStagesAfterUnstable()
    }
    stages {
        stage('Test') { 
            steps {
                sh 'mvn test'
                script {
                    def logz = currentBuild.rawBuild.getLog(10000);
                    def result = logz.find { it.contains('Sucess') }
                    if (result) {
                        error ('Sucesso ao executar ' + result)
                    }
                }
        }
    }
        stage('Results') {
            steps {
                 script {
                    def logz = currentBuild.rawBuild.getLog(10000);
                    def result = logz.find { it.contains('Sucess') }
                    if (result) {
                        error ('Sucesso ao executar ' + result)
                    }
                }
            }
       
        }
   }
}
