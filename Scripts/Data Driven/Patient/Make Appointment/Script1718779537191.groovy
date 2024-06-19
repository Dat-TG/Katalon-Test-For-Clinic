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
TestData data = findTestData('Data Files/Appointment')

// Helper function to create dynamic test objects
TestObject createDynamicTestObject(String xpath) {
	TestObject to = new TestObject()
	to.addProperty("xpath", ConditionType.EQUALS, xpath)
	return to
}

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PHNG KHM GROUP21/a_Lp phiu hn'), 10)
WebUI.click(findTestObject('Object Repository/Page_PHNG KHM GROUP21/a_Lp phiu hn'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PHNG KHM GROUP21/div_Chn bc s                               _58807b'), 10)
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_PHNG KHM GROUP21/div_Chn bc s                               _58807b'), 10)

// Create Test Object
TestObject doctorField = createDynamicTestObject("/html/body/div/div[2]/div/div/div[1]/div/form/div/div[1]/select")
TestObject nameField = createDynamicTestObject("//*[@id=\"name\"]")
TestObject phoneField = createDynamicTestObject("//*[@id=\"phone-number\"]")
TestObject emailField = createDynamicTestObject("//*[@id=\"email\"]")
TestObject dobField = createDynamicTestObject("//*[@id=\"date-of-birth\"]")
TestObject maleRadio = createDynamicTestObject("//*[@id=\"male\"]")
TestObject femaleRadio = createDynamicTestObject("//*[@id=\"female\"]")
TestObject dateField = createDynamicTestObject("//*[@id=\"date-meet\"]")
TestObject timeField = createDynamicTestObject("//*[@id=\"time-meet\"]")
TestObject submitButton = createDynamicTestObject("/html/body/div/div[2]/div/div/div[1]/div/form/div/div[10]/button")

for (def index : (0..data.getRowNumbers() - 1)) {
	// Get data from each row
	String id = data.getValue('ID', index + 1)
	String doctor = data.getValue('Doctor', index + 1)
	String name = data.getValue('Name', index + 1)
	String phone = data.getValue('Phone', index + 1)
	String email = data.getValue('Email', index + 1)
	String dob = data.getValue('DOB', index + 1)
	String gender = data.getValue('Gender', index + 1)
	String date = data.getValue('Date', index + 1)
	String time = data.getValue('Time', index + 1)
	String expectedResult = data.getValue('ExpectedResult', index + 1)

	try {
		// Input for month and year
		WebUI.selectOptionByValue(doctorField, "{\"ID\":\"${id}\", \"Name\":\"${doctor}\"}", false)
		WebUI.setText(nameField, name)
		WebUI.setText(phoneField, phone)
		WebUI.setText(emailField, email)
		WebUI.setText(dobField, dob)
		WebUI.setText(dateField, date)
		WebUI.setText(timeField, time)
		if (gender=='Nam') {
			WebUI.click(maleRadio)
		} else {
			WebUI.click(femaleRadio)
		}
		
		// Submit
		WebUI.click(submitButton)
		
		if (expectedResult == 'Success') {
			WebUI.verifyElementNotPresent(doctorField, 10)
			WebUI.navigateToUrl(GlobalVariable.baseUrl+'tai-lieu/lap-phieu-hen')
		} else {
			// Check if the required validation alert is shown
			boolean isValidationAlertShown = WebUI.getAttribute(doctorField, 'validationMessage') != '' || WebUI.getAttribute(nameField, 'validationMessage') != '' || WebUI.getAttribute(phoneField, 'validationMessage') != '' || WebUI.getAttribute(emailField, 'validationMessage') != '' || WebUI.getAttribute(dobField, 'validationMessage') != '' || WebUI.getAttribute(dateField, 'validationMessage') != '' || WebUI.getAttribute(timeField, 'validationMessage') != ''
			// Verify if the validation alert is shown
			WebUI.verifyEqual(isValidationAlertShown, true, FailureHandling.STOP_ON_FAILURE)
		}
		
		
	} catch (Exception e) {
		println "Error: " + e.message
	}
}


