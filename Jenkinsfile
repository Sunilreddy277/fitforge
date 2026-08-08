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
                sh 'chmod +x mvnw'
                sh './mvnw clean package -DskipTests'
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t fitforge-backend:latest .'
            }
        }

        stage('Deploy') {
            steps {
                sh '''
                    docker stop fitforge-backend || true
                    docker rm fitforge-backend || true
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