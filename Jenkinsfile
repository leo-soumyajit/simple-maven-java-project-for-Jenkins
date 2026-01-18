pipeline {
    agent any

    stages {
        // Stage 1: Checkout Code from GitHub
        stage('Checkout Code') {
            steps {
                echo 'Checking out source code...'
                // Replace the URL below with your actual GitHub repository URL
                git branch: 'main', url: 'https://github.com/leo-soumyajit/simple-maven-java-project-for-Jenkins.git'
            }
        }

        // Stage 2: Run Unit Tests
        stage('Run Tests') {
            steps {
                echo 'Starting Unit Tests...'
                // This command executes tests located in the src/test directory
                sh 'mvn test'
            }
        }

        // Stage 3: Build JAR using Maven
        stage('Build JAR') {
            steps {
                echo 'Building Maven Project...'
                // Skipping tests here since they were already executed in the previous stage
                sh 'mvn clean package -DskipTests'
            }
        }

        // Stage 4: Build Docker Image
        stage('Build Docker Image') {
            steps {
                echo 'Building Docker Image...'
                sh 'docker build -t my-java-app .'
            }
        }

        // Stage 5: Deploy Container
        stage('Deploy') {
            steps {
                echo 'Deploying application to server...'
                script {
                    try {
                        // Stop and remove the existing container if it is running
                        sh 'docker stop java-container || true'
                        sh 'docker rm java-container || true'
                    } catch (Exception e) {
                        echo 'No existing container found, proceeding with deployment...'
                    }

                    // Start the new container
                    // Map Host Port 8000 to Container Port 5000
                    sh 'docker run -d -p 8000:5000 --name java-container my-java-app'
                }
            }
        }
    }
}