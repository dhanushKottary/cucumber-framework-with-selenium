pipeline {
    agent any

    environment {
        // Environment variables for email configuration
        RECIPIENTS = 'dhanushprabhakarkottary@gmail.com'
    }

    stages {
        stage('Build') {
            steps {
                echo 'Building...'
                // Add your build steps here
            }
        }
        stage('Test') {
            steps {
                echo 'Testing...'
                // Add your test steps here
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying...'
                // Add your deploy steps here
            }
        }
    }

    post {
        success {
            script {
                emailext(
                    subject: "SUCCESS: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
                    body: "Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]' was successful.\n\nCheck console output at ${env.BUILD_URL} to view the results.",
                    to: "${env.RECIPIENTS}"
                )
            }
        }
        failure {
            script {
                emailext(
                    subject: "FAILURE: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
                    body: "Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]' has failed.\n\nCheck console output at ${env.BUILD_URL} to view the results.",
                    to: "${env.RECIPIENTS}"
                )
            }
        }
        unstable {
            script {
                emailext(
                    subject: "UNSTABLE: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
                    body: "Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]' is unstable.\n\nCheck console output at ${env.BUILD_URL} to view the results.",
                    to: "${env.RECIPIENTS}"
                )
            }
        }
        always {
            script {
                emailext(
                    subject: "NOTIFICATION: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]' finished",
                    body: "Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]' has finished.\n\nCheck console output at ${env.BUILD_URL} to view the results.",
                    to: "${env.RECIPIENTS}"
                )
            }
        }
    }
}

