pipeline {
    agent any

    tools {
        gradle 'Gradle_8.14'
        jdk 'JDK_11'
    }

    parameters {
        string(name: 'TAGS', defaultValue: '@all', description: 'Cucumber tags to filter tests')
        string(name: 'ENV', defaultValue: 'test', description: 'Environment for the tests')
    }

    environment {
        GRADLE_HOME = tool 'Gradle_8.14'
        JAVA_HOME = tool 'JDK_11'
    }

    stages {
        stage('Clonar Repositorio') {
            steps {
                git 'https://github.com/flavio-arc9/bluetab-desafio-selenium.git'
            }
        }

        stage('Configurar Dependencias') {
            steps {
                sh 'gradle dependencies' 
            }
        }

        stage('Compilar') {
            steps {
                sh 'gradle build'
            }
        }

        stage('Ejecutar Pruebas') {
            steps {
                script {
                    def gradleArgs = ['test', '--info']

                    if (params.TAGS?.trim()) {
                        gradleArgs += "-Dcucumber.filter.tags=${params.TAGS.trim()}"
                    }

                    if (params.ENV?.trim()) {
                        gradleArgs += "-Dcucumber.env=${params.ENV.trim()}"
                    }

                    sh "gradle ${gradleArgs.join(' ')}"
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