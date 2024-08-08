pipeline {
    agent {
        docker 'maven:3.3.3'
        args '-v $HOME/.m2:/root/.m2:z -u root'
        reuseNode true
    }
    stages {
        stage('build') {
            steps {
                sh 'mvn -v'
                sh 'mvn package'
            }
        }
    }
}