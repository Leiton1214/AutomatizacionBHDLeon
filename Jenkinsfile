pipeline {
    agent any

    environment {
        // API Key de Katalon (guárdala en Jenkins como credencial segura)
        KATALON_API_KEY = credentials('katalon-api-key')
        // Ruta a Katalon Engine en tu máquina
        KATALON_CMD = "C:\\Users\\user\\Desktop\\Katalon_Studio_Engine_Windows_64-10.3.1\\katalonc.exe"
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/Leiton1214/AutomatizacionBHDLeon.git'
            }
        }

        stage('Run Katalon Tests') {
            steps {
                bat """
                "%KATALON_CMD%" -noSplash -runMode=console -projectPath="C:\\Users\\user\\git\\AutomatizacionBHDLeon\\AutomatizacionBHDLeon.prj" ^
                -retry=0 -testSuitePath="Test Suites/TuTestSuite" -executionProfile="default" -browserType="Chrome" ^
                -apiKey=%KATALON_API_KEY% ^
                --config -webui.autoUpdateDrivers=true
                """
            }
        }

        stage('Publish Reports') {
            steps {
                junit '**/Reports/**/*.xml'
                publishHTML(target: [
                    allowMissing: true,
                    alwaysLinkToLastBuild: true,
                    keepAll: true,
                    reportDir: 'Reports',
                    reportFiles: 'report.html',
                    reportName: 'Katalon HTML Report'
                ])
            }
        }
    }

    post {
        always {
            echo 'Limpieza final del workspace'
            cleanWs()
        }
        success {
            echo '✅ Pruebas ejecutadas con éxito'
        }
        failure {
            echo '❌ Algunas pruebas fallaron, revisar reportes'
        }
    }
}

