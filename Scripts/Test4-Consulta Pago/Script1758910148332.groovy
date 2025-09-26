import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.callTestCase(findTestCase('Test1-Login'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('Consultar Cuenta/Menu'), 30)

WebUI.click(findTestObject('Consultar Cuenta/Menu'))

WebUI.click(findTestObject('Consultar Cuenta/Menu Usuario'))

WebUI.click(findTestObject('Object Repository/Consulta Pago/Pagos'))

WebUI.click(findTestObject('Object Repository/Consulta Pago/Orden de pago'))

WebUI.click(findTestObject('Object Repository/Consulta Pago/Ingreso Orden de Pago'))

WebUI.click(findTestObject('Object Repository/Consulta Pago/Account Transfer Home'))

