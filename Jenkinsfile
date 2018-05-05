pipeline {
    agent any
    
    parameters {
         string(name: 'tomcat_dev', defaultValue: '18.222.67.251', description: 'Dev Server')
    }
    
    stages{
        stage('Build'){
            steps {
                sh 'mvn clean package'
            }
            post {
                success {
                    echo 'Now Archiving...'
                    archiveArtifacts artifacts: '**/target/*.war'
                }
            }
        }
        stage ('Deploy to Staging'){
            steps {
                sh "scp -i /var/lib/jenkins/key.pem **/target/*.war ubuntu@${params.tomcat_dev}:/opt/tomcat/webapps"
            }
            post {
                success {
                    echo 'Code deployed !!'
                }

                failure {
                    echo ' Deployment failed !!'
                }
            }
        }
    }
}

