pipeline {
    agent any
    tools {
        maven 'maven'
        jdk 'jdk'
    }
    stages {

        stage ('Build') {
            steps {
                sh 'mvn install'
            }
            post {
                success {
                    junit 'target/surefire-reports/**/*.xml' 
                }
            }
        }
    }
}
//-Dmaven.test.failure.ignore=true