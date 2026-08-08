pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/Sunilreddy277/fitforge.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvnw.cmd clean package -DskipTests'
            }
        }

        stage('Docker Build') {
            steps {
                bat 'docker build -t fitforge-backend:latest .'
            }
        }

        stage('Deploy') {
            steps {
                bat '''
                    docker stop fitforge-backend || exit /b 0
                    docker rm fitforge-backend || exit /b 0
                    docker run -d --name fitforge-backend -p 8082:8081 fitforge-backend:latest
                '''
            }
        }
    }

    post {
        success {
            echo 'FitForge CI/CD Pipeline completed successfully!'
        }

        failure {
            echo 'FitForge CI/CD Pipeline failed!'
        }
    }
}