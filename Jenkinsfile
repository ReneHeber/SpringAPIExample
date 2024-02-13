pipeline {
    agent {
        label 'docker-agent-alpine-jdk17'
    }

    triggers {
        pollSCM '*/5 * * * *'
    }

    tools {
        maven 'jenkins-maven'
    }

    stages {
        stage('Build') {
            steps {
                echo "Building.."
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                '''
                sh 'mvn -Dmaven.test.failure.ignore=true install'
                sh "mvn -B -DskipTests clean package"
            }
        }

        stage('Test') {
            steps {
                echo "Testing.."
                sh "mvn test"
            }
        }

         stage('Deliver') {
            steps {
                retry(3) {
                    echo 'Deliver....'
                    sh '''
                    echo "doing delivery stuff.."
                    '''
                }
            }
        }
    }

    post {
        always {
            echo "I will always get executed"
        }
        success {
            echo "I will be executed if the build is success"
        }
        failure {
            echo "I will be executed if the build fails"
        }
        unstable {
            echo "I will be executed if the build is unstable"
        }
    }

}