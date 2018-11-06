pipeline {
    agent any
    stages{
        stage('Build'){
            steps {
                sh 'clean install'
            }
            post {
                success {
                    echo 'Now Archiving...'
                    archiveArtifacts artifacts: '**/target/*.war'
                }
            }
        }
    }
}
