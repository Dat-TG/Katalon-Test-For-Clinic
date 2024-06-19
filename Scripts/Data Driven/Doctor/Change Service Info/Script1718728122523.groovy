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

// Load test data
TestData data = findTestData('Data Files/Service')

// Wait for the navigation item "Tìm kiếm" to be visible and click it
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PHNG KHM GROUP21/a_Nav_3'), 10)
WebUI.click(findTestObject('Object Repository/Page_PHNG KHM GROUP21/a_Nav_3'))

// Wait for the Service Link to be visible and click it
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PHNG KHM GROUP21/a_DichVu_Doctor'), 10)
WebUI.click(findTestObject('Object Repository/Page_PHNG KHM GROUP21/a_DichVu_Doctor'))

for (def index : (0..data.getRowNumbers() - 1)) {
	// Get data from each row
	String price = data.getValue('Price', index + 1)
	String name = data.getValue('Name', index + 1)
	String expectedResult = data.getValue('ExpectedResult', index + 1)

	try {
		// Wait for the Edit icon to be visible and click it
		WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PHNG KHM GROUP21/i_edit_first_service_table'), 10)
		WebUI.click(findTestObject('Object Repository/Page_PHNG KHM GROUP21/i_edit_first_service_table'))
		
		// Wait for the name input field to be visible and set a new name
		WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PHNG KHM GROUP21/input_service_name'), 10)
		WebUI.setText(findTestObject('Object Repository/Page_PHNG KHM GROUP21/input_service_name'), name)
		
		// Wait for the price input field to be visible and set a new price
		WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PHNG KHM GROUP21/input_service_price'), 10)
		WebUI.setText(findTestObject('Object Repository/Page_PHNG KHM GROUP21/input_service_price'), price)
		
		// Wait for the Confirm button to be visible and click it
		WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PHNG KHM GROUP21/button_submit_service'), 10)
		WebUI.click(findTestObject('Object Repository/Page_PHNG KHM GROUP21/button_submit_service'))
		
		// Verify the expected result
		if (expectedResult == 'Success') {
			// Wait for the success message to be visible and verify its presence
			WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PHNG KHM GROUP21/div_Chnh sa thng tin thuc thnh cng'), 10)
			WebUI.verifyElementVisible(findTestObject('Object Repository/Page_PHNG KHM GROUP21/div_Chnh sa thng tin thuc thnh cng'), FailureHandling.STOP_ON_FAILURE)
		} else {
			// Check if the required validation alert is shown
			boolean isValidationAlertShown = WebUI.getAttribute(findTestObject('Object Repository/Page_PHNG KHM GROUP21/input_service_price'), 'validationMessage') != '' || WebUI.getAttribute(findTestObject('Object Repository/Page_PHNG KHM GROUP21/input_service_name'), 'validationMessage') != ''
			
			// Verify if the validation alert is shown
			WebUI.verifyEqual(isValidationAlertShown, true, FailureHandling.STOP_ON_FAILURE)
			
			// Close modal
			WebUI.click(findTestObject('Object Repository/Page_PHNG KHM GROUP21/button_close_modal_service'))
		}
	} catch (Exception e) {
		println "Error: " + e.message
	} 
}
