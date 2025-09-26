import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


WebUI.callTestCase(findTestCase('Test1-Login'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementClickable(findTestObject("Consultar Cuenta/Menu"), 30)

WebUI.click(findTestObject('Object Repository/Consultar Cuenta/Menu'))

WebUI.click(findTestObject('Object Repository/Consultar Cuenta/Menu Usuario'))

WebUI.click(findTestObject('Object Repository/Consultar Cuenta/Operaciones Minoristas'))

WebUI.click(findTestObject('Object Repository/Consultar Cuenta/Buscar Cuenta'))

WebUI.click(findTestObject('Object Repository/Consultar Cuenta Segunda Fase/Borrar X'))

WebUI.setText(findTestObject('Object Repository/Consultar Cuenta Segunda Fase/Ingresar ID'), '9680585')

WebUI.click(findTestObject('Object Repository/Consultar Cuenta Segunda Fase/Encontrar'))

WebUI.click(findTestObject('Object Repository/Consultar Cuenta Segunda Fase/Vision General'))

WebUI.closeBrowser()

