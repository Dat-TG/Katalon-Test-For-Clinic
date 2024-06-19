import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.testobject.ConditionType

// Load test data
TestData data = findTestData('Data Files/Drug Report Month Year')

// Helper function to create dynamic test objects
TestObject createDynamicTestObject(String xpath) {
	TestObject to = new TestObject()
	to.addProperty("xpath", ConditionType.EQUALS, xpath)
	return to
}

// Wait for the navigation item "Tài liệu" to be visible and click it
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PHNG KHM GROUP21/a_Nav_2'), 10)
WebUI.click(findTestObject('Object Repository/Page_PHNG KHM GROUP21/a_Nav_2'))

// Wait for the "Lập báo cáo thuốc" to be visible and click it
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PHNG KHM GROUP21/a_LapBaoCaoThuoc'), 10)
WebUI.click(findTestObject('Object Repository/Page_PHNG KHM GROUP21/a_LapBaoCaoThuoc'))

TestObject monthField = createDynamicTestObject('/html/body/div[1]/div/div[1]/input')
TestObject yearField = createDynamicTestObject('/html/body/div[1]/div/div[2]/input')

for (def index : (0..data.getRowNumbers() - 1)) {
	// Get data from each row
	String month = data.getValue('Month', index + 1)
	String year = data.getValue('Year', index + 1)
	String expectedResult = data.getValue('ExpectedResult', index + 1)

	try {
		// Input for month and year
		WebUI.setText(monthField, month)
		WebUI.setText(yearField, year)
		
		// Submit
		TestObject submit_button = createDynamicTestObject('/html/body/div[2]/div[1]/button')
		WebUI.click(submit_button)
		
		if (expectedResult == 'Success') {
			// Verify success: An alert will be shown because we dont add any drugs
			WebUI.verifyAlertPresent(10)
			WebUI.acceptAlert()
		} else {
			// Check if the required validation alert is shown
			boolean isValidationAlertShown = WebUI.getAttribute(monthField, 'validationMessage') != '' || WebUI.getAttribute(yearField, 'validationMessage') != ''
			
			// Verify if the validation alert is shown
			WebUI.verifyEqual(isValidationAlertShown, true, FailureHandling.STOP_ON_FAILURE)
		}
		
		
	} catch (Exception e) {
		println "Error: " + e.message
	}
}



