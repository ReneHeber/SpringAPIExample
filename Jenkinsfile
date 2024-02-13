pipeline {
    agent {
        label 'docker-agent-alpine-jdk17'
    }

    triggers {
        pollSCM '* * * * *'
    }

    tools {
        maven 'jenkins-maven'
    }

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

/*        stage('generate reports') {
            steps {
                echo "generate cucumber reports.."
                 cucumber buildStatus: "UNSTABLE",
                fileIncludePattern: "** /* *//*.json",
                jsonReportDirectory: "target"
            }
        }*/

/*         stage('Deliver') {
            steps {
                retry(3) {
                    echo 'Deliver....'
                    sh '''
                    echo "doing delivery stuff.."
                    '''
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
    } */
}