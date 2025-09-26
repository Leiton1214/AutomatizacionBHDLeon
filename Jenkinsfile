pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/Leiton1214/AutomatizacionBHDLeon.git'
            }
        }

        stage('Run Katalon Tests') {
            steps {
                script {
                    bat """
                        katalonc -noSplash -runMode=console -projectPath="AutomatizacionBHDLeon.prj" ^
                        -retry=0 -testSuitePath="Test Suites/Test Suite Login - Consulta Cuentas" ^
                        -executionProfile=default -browserType="Chrome"
                    """
                }
            }
        }
    }

    post {
        always {
            junit '**/Reports/**/JUnit_Report.xml'
        }
        success {
            echo '✅ Pruebas ejecutadas con éxito.'
        }
        failure {
            echo '❌ Fallaron las pruebas.'
        }
    }
}
