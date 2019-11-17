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
            }
        }
        stage('Build') {
            steps {
                sh 'javac src/test/java/br/com/animais/adocao/dao/teste/CadastroOngTeste.java && java src/test/java/br/com/animais/adocao/dao/teste/CadastroOngTeste'
            }
        }
        stage('Results') { 
            steps {
                 script {
                    def logz = currentBuild.rawBuild.getLog(10000);
                    def result = logz.find { it.contains('Ong:Acao animal') }
                    if (result) {
                        error ('Buildou corretamnete ' + result)
                    }
                }
            }
        }
       
    }
}
