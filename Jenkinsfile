pipeline {
    agent any 
    stages {
        stage('Build') { 
            steps {
              bat 'gradle -version'
            }
        }
        stage('Test') { 
            steps {
              git branch: 'main', credentialsId: 'Jenkins', url: 'https://github.com/manojboot/movie-details-service.git'

            }
        }
        stage('Deploy') { 
            steps {
              bat 'gradle build'
            }
        }
    }
}