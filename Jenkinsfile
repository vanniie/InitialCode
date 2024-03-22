pipeline {
  agent any
  stages {
    stage('Checkout Latest') {
      steps {
        git(url: 'InitialCode', branch: 'main')
      }
    }

    stage('Install Dependencies') {
      steps {
        sh ' mvn install'
      }
    }

  }
}