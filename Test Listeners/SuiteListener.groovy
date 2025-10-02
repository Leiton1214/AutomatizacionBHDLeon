import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.context.TestSuiteContext
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable



class SuiteListener {
	@BeforeTestSuite
	def openBrowserAndLogin(TestSuiteContext testSuiteContext) {
		// ESTO SOLO SE EJECUTA UNA VEZ ANTES DE QUE EMPIECE LA SUITE
		println "--- INICIANDO SUITE: " + testSuiteContext.getTestSuiteId() + " ---"
		
		// 1. Abrir el navegador
		WebUI.openBrowser('')
		WebUI.maximizeWindow()
		
		// 2. Navegar usando la Variable Global 'URL'
		WebUI.navigateToUrl(GlobalVariable.URL) 
		
		// 3. Ejecutar el Login UNA SOLA VEZ
		WebUI.callTestCase(
			TestCaseFactory.findTestCase('Test Cases/Test1-Login'),
			[:],
			FailureHandling.STOP_ON_FAILURE
		)
	}

	@AfterTestSuite
	def closeBrowser(TestSuiteContext testSuiteContext) {
		// ESTO SOLO SE EJECUTA UNA VEZ AL FINALIZAR LA SUITE
		println "--- FINALIZANDO SUITE: " + testSuiteContext.getTestSuiteId() + " ---"
		WebUI.closeBrowser()
	}
}