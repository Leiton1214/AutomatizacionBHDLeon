import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


WebUI.callTestCase(findTestCase('Test1-Login'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/Page_T24 - OFICINAPRINCIPAL/Menu'))

WebUI.click(findTestObject('Object Repository/Page_T24 - OFICINAPRINCIPAL/Menu Usuario'))

WebUI.click(findTestObject('Object Repository/Page_T24 - OFICINAPRINCIPAL/Operaciones Minoristas'))

WebUI.click(findTestObject('Object Repository/Page_T24 - OFICINAPRINCIPAL/Buscar Cuenta'))

WebUI.click(findTestObject('Object Repository/Page_Acuerdo Aa - OFICINA PRINCIPAL/Borrar X'))

WebUI.setText(findTestObject('Object Repository/Page_Acuerdo Aa - OFICINA PRINCIPAL/Ingresar ID'), '9680585')

WebUI.click(findTestObject('Object Repository/Page_Acuerdo Aa - OFICINA PRINCIPAL/Encontrar'))

WebUI.click(findTestObject('Object Repository/Page_Acuerdo Aa - OFICINA PRINCIPAL/Vision General'))

WebUI.closeBrowser()

