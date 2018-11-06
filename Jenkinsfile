pipeline {
    
    agent any
    
    tools {
    maven 'mvn'
    }
    
    parameters {
         string(name: 'qa_env', defaultValue: '54.89.152.232', description: 'QA Environment Server')
    }
    
    stages{
        stage('Build'){
            steps {
                sh 'mvn clean install'
            }
            post {
                success {
                    echo 'Now Archiving...'
                    archiveArtifacts artifacts: '**/target/*.war'
                }
            }
        }
        stage ('Deployments'){
            parallel{
                stage ('Deploy to Staging'){
                    steps {
                        sh "scp /var/lib/jenkins/workspace/Build-QA-Environment/target/shop-0.0.1-SNAPSHOT.war ec2-user@${params.qa_env}:/home/ec2-user"
                        sh "ssh ec2-user@${params.qa_env}"
                        sh "cd /home/ec2-user"
                        sh "ls -al"
                    }
                }
            }
        }
    }
}
