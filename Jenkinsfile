pipeline {
    agent any
    stages {
        stage('build') {
            steps {
                sh 'mvn -v'
                sh 'mvn package'
            }
        }
    }
}