pipeline {
    agent any

    tools {
        gradle 'Gradle_8.14'
        jdk 'JDK_11'
    }

    environment {
        GRADLE_HOME = tool 'Gradle_8.14'
        JAVA_HOME = tool 'JDK_11'
        TAGS = "" 
        ENV = "test"
    }

    stages {
        stage('Clonar Repositorio') {
            steps {
                git 'https://github.com/flavio-arc9/bluetab-desafio-selenium.git'
            }
        }

        stage('Configurar Dependencias') {
            steps {
                gradlew 'dependencies'
            }
        }

        stage('Compilar') {
            steps {
                gradlew 'build'
            }
        }

        stage('Ejecutar Pruebas') {
            steps {
                script {
                    def gradleArgs = ['test']

                    if (env.TAGS != "") {
                        gradleArgs += "-Dcucumber.filter.tags=${env.TAGS}"
                    }

                    if (env.ENV != "") {
                        gradleArgs += "-Dcucumber.env=${env.ENV}"
                    }
                    gradlew(gradleArgs.join(' '))
                }
            }
        }

        stage('Generar Informes') {
            steps {
                script {
                    def cucumberReportDir = "${WORKSPACE}/build/reports/"
                    archiveArtifacts artifacts: "${cucumberReportDir}/*.html", allowEmptyArchive: true
                }
            }
        }
    }

    post {
        always {
            echo 'Pipeline completada'
        }
        success {
            echo 'Pipeline exitosa'
        }
    }
}