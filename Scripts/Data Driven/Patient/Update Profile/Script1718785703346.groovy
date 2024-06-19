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

// Helper function to create dynamic test objects
TestObject createDynamicTestObject(String xpath) {
	TestObject to = new TestObject()
	to.addProperty("xpath", ConditionType.EQUALS, xpath)
	return to
}

// Load test data
TestData data = findTestData('Data Files/Profile')

// Click dropdown button at user icon
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PHNG KHM GROUP21/a_Dch v_navbarDropdownMenuAvatar'), 10)
WebUI.click(findTestObject('Object Repository/Page_PHNG KHM GROUP21/a_Dch v_navbarDropdownMenuAvatar'))

// Click Account
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PHNG KHM GROUP21/a_Ti khon'), 10)
WebUI.click(findTestObject('Object Repository/Page_PHNG KHM GROUP21/a_Ti khon'))

for (def index : (0..data.getRowNumbers() - 1)) {
	// Get data
	String name=data.getValue('Name', index+1)
	String dob=data.getValue('DOB', index+1)
	String gender=data.getValue('Gender', index+1)
	String phone=data.getValue('Phone', index+1)
	String email=data.getValue('Email', index+1)
	String address=data.getValue('Address', index+1)
	String expectedResult=data.getValue('ExpectedResult', index+1)

	try {
		// Click Edit button
		WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PHNG KHM GROUP21/i_L Cng t 123_fas fa-edit'), 10)
		WebUI.click(findTestObject('Object Repository/Page_PHNG KHM GROUP21/i_L Cng t 123_fas fa-edit'))
		
		// Set new value
		WebUI.setText(findTestObject('Object Repository/Page_PHNG KHM GROUP21/input_Username_Name'), name)
		WebUI.setText(findTestObject('Object Repository/Page_PHNG KHM GROUP21/input_address_edit_profile'), address)
		WebUI.setText(findTestObject('Object Repository/Page_PHNG KHM GROUP21/input_dob_edit_profile'), dob)
		WebUI.setText(findTestObject('Object Repository/Page_PHNG KHM GROUP21/input_email_edit_profile'), email)
		if (gender == 'Nam') {
			WebUI.click(findTestObject('Object Repository/Page_PHNG KHM GROUP21/input_Gender_Male'))
		} else {
			WebUI.click(findTestObject('Object Repository/Page_PHNG KHM GROUP21/input_Gender_Female'))
		}
		
		WebUI.setText(findTestObject('Object Repository/Page_PHNG KHM GROUP21/input_phone_edit_profile'), phone)
		
		// Click confirm button
		WebUI.waitForElementClickable(findTestObject('Object Repository/Page_PHNG KHM GROUP21/button_submit_profile'), 10)
		WebUI.click(findTestObject('Object Repository/Page_PHNG KHM GROUP21/button_submit_profile'))
		
		
		
		if (expectedResult == 'Success') {
			// Verify success message
			WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PHNG KHM GROUP21/div_Chnh sa thng tin c nhn thnh cng. Bn c t_30e4b4'), 10)
			WebUI.verifyElementVisible(findTestObject('Object Repository/Page_PHNG KHM GROUP21/div_Chnh sa thng tin c nhn thnh cng. Bn c t_30e4b4'))
		} else {
			// Check if the required validation alert is shown
			boolean isValidationAlertShown = WebUI.getAttribute(findTestObject('Object Repository/Page_PHNG KHM GROUP21/input_Username_Name'), 'validationMessage') != '' || WebUI.getAttribute(findTestObject('Object Repository/Page_PHNG KHM GROUP21/input_address_edit_profile'), 'validationMessage') != '' || WebUI.getAttribute(findTestObject('Object Repository/Page_PHNG KHM GROUP21/input_dob_edit_profile'), 'validationMessage') != '' || WebUI.getAttribute(findTestObject('Object Repository/Page_PHNG KHM GROUP21/input_email_edit_profile'), 'validationMessage') != '' || WebUI.getAttribute(findTestObject('Object Repository/Page_PHNG KHM GROUP21/input_phone_edit_profile'), 'validationMessage') != ''
			// Verify if the validation alert is shown
			WebUI.verifyEqual(isValidationAlertShown, true, FailureHandling.STOP_ON_FAILURE)
			TestObject closeModalButton = createDynamicTestObject("//*[@id=\"editProfileModal\"]/div/div/div[1]/button")
			WebUI.click(closeModalButton)
		}
		
		
	} catch (Exception e) {
		println "Error: " + e.message
	}
}


