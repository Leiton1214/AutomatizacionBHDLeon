import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable


class TestListener {
	@BeforeTestCase
	def openBrowserAndLogin() {
		
		// 1. Abrir el navegador
		WebUI.openBrowser('')
		WebUI.maximizeWindow()
		
		// 2. Navegar usando la Variable Global URL de tu perfil (¡Ajuste clave!)
		WebUI.navigateToUrl(GlobalVariable.URL) 
		
		// 3. Llamar al Test Case de Login
		// Asegúrate de que el nombre del Test Case sea exactamente 'Test1-Login'
		WebUI.callTestCase(
			TestCaseFactory.findTestCase('Test1-Login'),
			[:],
			FailureHandling.STOP_ON_FAILURE
		)
	}

	@AfterTestCase
	def closeBrowser() {
		// 4. Cerrar el navegador sin condiciones
		WebUI.closeBrowser()
	}
}