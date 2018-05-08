pipeline {
    agent any
    stages{
        stage('Build'){
            steps {
                sh 'mvn clean install'
                script {
                    currentBuild.displayName = "ROOT."
                }
            }
            post {
                success {
                    echo 'Now Archiving...'
                    archiveArtifacts artifacts: '**/target/*.war'
                }
            }
        }
        
         stage ('Deploy to Application Server'){
            steps {
                build job: 'deploy-to-application'
            }
        }
       
    }
}
