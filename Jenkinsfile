pipeline {
    agent any

    environment {
        KATALON_API_KEY = credentials('katalon-api-key')   // ID de credencial que creaste en Jenkins
        KATALON_CMD = "C:\\Users\\user\\Desktop\\Katalon_Studio_Engine_Windows_64-10.3.1\\katalonc.exe"
    }

    stages {
        stage('Checkout') {
            steps {
                // usa el repo correcto (tu usuario)
                git branch: 'main', url: 'https://github.com/Leiton1214/AutomatizacionBHDLeon.git'
            }
        }

        stage('Verify workspace & project') {
            steps {
                script {
                    echo "Workspace: ${env.WORKSPACE}"
                    bat "dir \"${env.WORKSPACE}\""
                    // Verificamos que el .prj exista en el workspace
                    if(!fileExists("${env.WORKSPACE}\\AutomatizacionBHDLeon.prj")) {
                        error "ERROR: No se encontró AutomtizacionBHDLeon.prj en ${env.WORKSPACE}. Asegúrate que el .prj esté en la raíz del repo."
                    } else {
                        echo "✅ .prj encontrado en workspace."
                    }
                }
            }
        }

        stage('Run Katalon Tests') {
            steps {
                script {
                    // define el nombre EXACTO de tu Test Suite (copiar desde Katalon)
                    def testSuite = "Test Suites/Test Suite Login - Consulta Cuentas"

                    // usa el .prj dentro del workspace
                    def projectPath = "${env.WORKSPACE}\\AutomatizacionBHDLeon.prj"

                    echo "Ejecutando Katalon Engine..."
                    bat """
                        "${KATALON_CMD}" -noSplash -runMode=console -projectPath="${projectPath}" ^
                        -retry=0 -testSuitePath="${testSuite}" -executionProfile=default -browserType="Chrome" ^
                        -apiKey=%KATALON_API_KEY% --config -webui.autoUpdateDrivers=true
                    """
                }
            }
        }

        stage('Publish Reports') {
            steps {
                // publica todos los xml que Katalon genera en Reports/...
                junit allowEmptyResults: true, testResults: 'Reports/**/*.xml'
                // (opcional) mostrar HTML si instalaste plugin HTML Publisher
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
        success { echo '✅ Pruebas ejecutadas con éxito.' }
        failure { echo '❌ Falló la ejecución. Revisa el log y los reportes.' }
    }
}

