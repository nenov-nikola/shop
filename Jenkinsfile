pipeline {
    agent any
    stages{
        stage('Build'){
            steps {
                script {
                    currentBuild.displayName = "ROOT."
                }
                sh 'mvn clean install'
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
