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

WebUI.waitForElementVisible(findTestObject('Consultar Cuenta/Menu'), 30)

WebUI.click(findTestObject('Consultar Cuenta/Menu'))

WebUI.click(findTestObject('Consultar Cuenta/Menu Usuario'))

WebUI.click(findTestObject('Object Repository/Consulta Pago/Pagos'))

WebUI.click(findTestObject('Object Repository/Consulta Pago/Orden de pago'))

WebUI.click(findTestObject('Object Repository/Consulta Pago/Ingreso Orden de Pago'))

WebUI.click(findTestObject('Object Repository/Consulta Pago/Account Transfer Home'))

