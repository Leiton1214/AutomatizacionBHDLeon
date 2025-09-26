import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable
// Capturar ID de cuenta y fecha
// Mostrar en logs
// Guardar en Global Variables
// Guardar en archivo externo
import java.io.FileWriter as FileWriter

WebUI.waitForElementVisible(findTestObject('Consultar Cuenta/Menu'), 30)

WebUI.click(findTestObject('Consultar Cuenta/Menu'))

WebUI.click(findTestObject('Consultar Cuenta/Menu Usuario'))

WebUI.click(findTestObject('Object Repository/Consultar Cuenta/Catálogo de Productos'))

WebUI.click(findTestObject('Object Repository/Consultar Cuenta/Desplegar Opciones'))

WebUI.click(findTestObject('Object Repository/Productos/Producto'))

WebUI.click(findTestObject('Object Repository/Productos/Cuenta de ahorros personal'))

WebUI.switchToWindowIndex(1)

WebUI.maximizeWindow()

WebUI.waitForElementVisible(findTestObject('Object Repository/Creacion/Cliente'), 10)

WebUI.setText(findTestObject('Object Repository/Creacion/Cliente'), '111653')

WebUI.waitForElementVisible(findTestObject('Object Repository/Creacion/Moneda'), 10)

WebUI.click(findTestObject('Creacion/Moneda'))

WebUI.setText(findTestObject('Object Repository/Creacion/Moneda'), 'DOP')

WebUI.click(findTestObject('Object Repository/Creacion/Validar'))

WebUI.click(findTestObject('Object Repository/Creacion/Grabar'))

WebUI.click(findTestObject('Creacion/Boton Aceptar'))

String cuentaID = WebUI.getText(findTestObject('Creacion/label_IdCuenta'))

String fechaCreacion = WebUI.getText(findTestObject('Creacion/label_Fecha'))

WebUI.comment('✅ Cuenta creada con ID: ' + cuentaID)

WebUI.comment('📅 Fecha de creación: ' + fechaCreacion)

GlobalVariable.CUENTAID = cuentaID

GlobalVariable.FECHACREACION = fechaCreacion

FileWriter writer = new FileWriter('C:/Users/user/Desktop/Cuentas Creadas Katalon Studio/cuentas_creadas.txt', true)

writer.write(((('Cuenta: ' + cuentaID) + ' | Fecha: ') + fechaCreacion) + '\n')

writer.close()

