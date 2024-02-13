pipeline {
    agent any

    triggers {
        pollSCM '* * * * *'
    }

    environment {
        NAME = 'Sarah'
        LASTNAME = 'Kaiser'
// 		mavenHome = tool 'jenkins-maven'
    }

/* 	tools {
		jdk 'java-17'
	} */

    stages {
        stage('Build') {
            steps {
                echo "Building.. because %NAME% %LASTNAME% said so.."
                sh '''
                echo "placeholder for %NAME%"
                '''
// 				mvn clean install -DskipTests
            }
        }
        stage('Test') {
            steps {
                echo "Testing.."
                sh '''
                echo "doing test stuff.."
                '''
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