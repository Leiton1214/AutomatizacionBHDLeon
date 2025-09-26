pipeline {
    agent any

    environment {
        KATALON_HOME = "C:\\Users\\user\\Desktop\\Katalon_Studio_Engine_Windows_64-10.3.1"
        KATALON_API_KEY = credentials('katalon-api-key') // <-- guarda tu API Key en Jenkins Credentials
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/Leiton1214/AutomatizacionBHDLeon.git'
            }
        }

        stage('Run Katalon Tests') {
            steps {
                script {
                    bat """
                        "${KATALON_HOME}\\katalonc.exe" -noSplash -runMode=console ^
                        -projectPath="AutomatizacionBHDLeon.prj" ^
                        -retry=0 ^
                        -testSuitePath="Test Suites/Test Suite Login - Consulta Cuentas" ^
                        -executionProfile=default ^
                        -browserType="Chrome" ^
                        -apiKey=%KATALON_API_KEY%
                    """
                }
            }
        }
    }

    post {
        always {
            echo "📂 Publicando reportes..."
            // Publica los reportes JUnit que genera Katalon en Reports/...
            junit allowEmptyResults: true, testResults: 'Reports/**/*.xml'

            // Archiva TODOS los reportes de Katalon (HTML, CSV, etc.)
            archiveArtifacts artifacts: 'Reports/**/*.*', allowEmptyArchive: true
        }

        success {
            echo "✅ Todas las pruebas pasaron con éxito."
        }

        unstable {
            echo "⚠️ Algunas pruebas fallaron o no se pudieron reportar correctamente."
        }

        failure {
            echo "❌ Hubo un error en la ejecución."
        }
    }
}

