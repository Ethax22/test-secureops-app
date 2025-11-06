pipeline {
    agent any
    
    stages {
        stage('Checkout') {
            steps {
                echo '========== CHECKOUT =========='
                checkout scm
            }
        }
        
        stage('Build') {
            steps {
                echo '========== BUILD =========='
                sh 'chmod +x gradlew'
                sh './gradlew clean build -x test'
            }
        }
        
        stage('Unit Tests') {
            steps {
                echo '========== UNIT TESTS =========='
                sh './gradlew test'
            }
            post {
                always {
                    junit '**/build/test-results/test/*.xml'
                }
            }
        }
        
        stage('Deploy') {
            when { branch 'main' }
            steps {
                echo '========== DEPLOY =========='
                script {
                    if (!env.DEPLOY_KEY) {
                        error('Missing DEPLOY_KEY')
                    }
                }
            }
        }
    }
    
    post {
        success {
            echo '✅ SUCCESS'
        }
        failure {
            echo '❌ FAILURE'
        }
    }
}

