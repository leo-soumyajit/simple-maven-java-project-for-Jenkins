pipeline {
    agent any

    environment {
        // Your Docker Hub details
        DOCKER_IMAGE = 'soumyajit2005/jenkins-cicd-javaapp'
        DOCKER_TAG = 'latest'
        
        // This ID matches the credentials we just created in Jenkins
        REGISTRY_CREDENTIALS = 'docker-hub-creds'
    }

    stages {
        // Stage 1: Checkout Source Code from GitHub
        stage('Checkout Code') {
            steps {
                echo 'Checking out source code...'
                git branch: 'main', url: 'https://github.com/leo-soumyajit/simple-maven-java-project-for-Jenkins.git'
            }
        }

        // Stage 2: Run Unit Tests
        stage('Run Tests') {
            steps {
                echo 'Starting Unit Tests...'
                // If tests fail, the pipeline stops here
                sh 'mvn test'
            }
        }

        // Stage 3: Build JAR File
        stage('Build JAR') {
            steps {
                echo 'Building Maven Project...'
                // Skipping tests here as they were already run in the previous stage
                sh 'mvn clean package -DskipTests'
            }
        }

        // Stage 4: Build Docker Image
        stage('Build Docker Image') {
            steps {
                echo 'Building Docker Image...'
                // Building image with tag: soumyajit2005/my-java-app:latest
                sh "docker build -t ${DOCKER_IMAGE}:${DOCKER_TAG} ."
            }
        }

        // Stage 5: Push Image to Docker Hub ☁️
        stage('Push to Docker Hub') {
            steps {
                echo 'Pushing image to Docker Hub...'
                // Securely logging in using the stored credentials
                withCredentials([usernamePassword(credentialsId: REGISTRY_CREDENTIALS, passwordVariable: 'DOCKER_PASS', usernameVariable: 'DOCKER_USER')]) {
                    sh 'echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin'
                    sh "docker push ${DOCKER_IMAGE}:${DOCKER_TAG}"
                }
            }
        }

        // Stage 6: Deploy to Server 🚀
        stage('Deploy') {
            steps {
                echo 'Deploying application...'
                script {
                    try {
                        // Stop and remove the old container if it exists
                        sh 'docker stop java-container || true'
                        sh 'docker rm java-container || true'
                    } catch (Exception e) {
                        echo 'No existing container found...'
                    }
                    
                    // Remove local image to force pulling the fresh one from Hub
                    sh "docker rmi ${DOCKER_IMAGE}:${DOCKER_TAG} || true"
                    
                    // Pull the fresh image from Docker Hub
                    sh "docker pull ${DOCKER_IMAGE}:${DOCKER_TAG}"

                    // Run the new container on Port 8000
                    sh "docker run -d -p 8000:5000 --name java-container ${DOCKER_IMAGE}:${DOCKER_TAG}"
                }
            }
        }
    }
}