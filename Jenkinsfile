pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/Leiton1214/AutomatizacionBHDLeon.git'
            }
        }

        stage('Run Katalon Tests') {
            steps {
                withCredentials([string(credentialsId: 'katalon-api-key', variable: 'KATALON_KEY')]) {
                    bat """
                    "C:\\Users\\user\\Desktop\\Katalon_Studio_Engine_Windows_64-10.3.1\\katalonc.exe" ^
                     -noSplash -runMode=console ^
                     -projectPath="C:\\Users\\user\\.jenkins\\workspace\\AutomatizacionBHDLeon\\AutomatizacionBHDLeon.prj" ^
                     -retry=0 ^
                     -testSuitePath="Test Suites/Test Suite Login - Consulta Cuentas" ^
                     -executionProfile=default ^
                     -browserType="Chrome" ^
                     -apiKey=%KATALON_KEY%
                    """
                }
            }
        }
    }

    post {
        always {
            junit '**/Reports/**/*.xml'
        }
        failure {
            echo "❌ Fallaron las pruebas."
        }
        success {
            echo "✅ Todas las pruebas pasaron."
        }
    }
}

