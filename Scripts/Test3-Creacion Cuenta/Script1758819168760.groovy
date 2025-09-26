import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable // Solo importa la clase GlobalVariable si la necesitas, sin alias.
import java.io.FileWriter // Importa la clase de manejo de archivos de Java.

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

WebUI.closeWindow()

WebUI.switchToWindowIndex(0)

