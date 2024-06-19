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
TestData data = findTestData('Data Files/Drug Report Not Existed')

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

// Input for month and year
TestObject monthField = createDynamicTestObject('/html/body/div[1]/div/div[1]/input')
TestObject yearField = createDynamicTestObject('/html/body/div[1]/div/div[2]/input')
WebUI.setText(monthField, '6')
WebUI.setText(yearField, '2024')

for (def index : (0..data.getRowNumbers() - 1)) {
	// Get data from each row
	String name = data.getValue('Name', index + 1)
	String quantity = data.getValue('Quantity', index + 1)
	String used = data.getValue('Used', index + 1)

	try {
		// Click "+"
		WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PHNG KHM GROUP21/button_add_drug_report'), 10)
		WebUI.click(findTestObject('Object Repository/Page_PHNG KHM GROUP21/button_add_drug_report'))
		
		// Construct the dynamic input field XPaths
		String nameXPath = "//*[@id=\"Name${index+1}\"]"
		String quantityXPath = "//*[@id=\"Quantity${index+1}\"]"
		String usedXPath = "//*[@id=\"Used${index+1}\"]"
		
		// Create dynamic test objects
		TestObject nameField = createDynamicTestObject(nameXPath)
		TestObject quantityField = createDynamicTestObject(quantityXPath)
		TestObject usedField = createDynamicTestObject(usedXPath)
		
		// Input
		// Click on the input field to bring it into focus
		WebUI.click(nameField)
		WebUI.setText(nameField, name)
		WebUI.setText(quantityField, quantity)
		WebUI.setText(usedField, used)
		
		
	} catch (Exception e) {
		println "Error: " + e.message
	}
}

// Submit
TestObject submit_button = createDynamicTestObject('/html/body/div[2]/div[1]/button')
WebUI.click(submit_button)

// Verify failed at row 2
TestObject failedField = createDynamicTestObject('//*[@id="Unit2"]')
// Check if the required validation alert is shown
boolean isValidationAlertShown = WebUI.getAttribute(failedField, 'validationMessage') != ''

// Verify if the validation alert is shown
WebUI.verifyEqual(isValidationAlertShown, true, FailureHandling.STOP_ON_FAILURE)



