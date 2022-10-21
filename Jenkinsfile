pipeline {
    agent any
    tools {
        maven 'maven'
        jdk 'jdk'
    }
    stages {

        stage ('Build') {
            steps {
                sh 'mvn -Dmaven.test.failure.ignore=true -Dtest=!GameTest install'
            }
            post {
                success {
                    junit 'target/surefire-reports/**/*.xml' 
                }
            }
        }
    }
}
