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
TestData data = findTestData('Data Files/Patient List')

// Wait for the navigation item "Tài liệu" to be visible and click it
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PHNG KHM GROUP21/a_Nav_2'), 10)
WebUI.click(findTestObject('Object Repository/Page_PHNG KHM GROUP21/a_Nav_2'))

// Wait for the 'Danh sách khám bệnh' Link to be visible and click it
a_dskb=createDynamicTestObject("//*[@id=\"navbarSupportedContent\"]/ul/li[2]/ul/li[4]/a")
WebUI.waitForElementVisible(a_dskb, 10)
WebUI.click(a_dskb)

deleteButton=createDynamicTestObject("/html/body/div/table/tbody/tr[1]/td[8]/button/i")

while (WebUI.verifyElementPresent(deleteButton, 1, FailureHandling.OPTIONAL)) {
	// If the element exists, click it
	try {
        // If the element exists, click it
        WebUI.click(deleteButton)
    } catch (Exception e) {
        break // Exit the loop if an error occurs
    }
}

saveButton=createDynamicTestObject("/html/body/div/div/button")

for (def index : (0..data.getRowNumbers() - 1)) {
	// Get data from each row
	String gender = data.getValue('Gender', index + 1)
	String name = data.getValue('Name', index + 1)
	String dob = data.getValue('DOB', index + 1)
	String address = data.getValue('Address', index + 1)

	try {
		// Click the "+" button to add a new row
		addButton=createDynamicTestObject("/html/body/div/button")
		WebUI.click(addButton)
		
		// Construct the dynamic input field XPaths
		String nameXPath = "//*[@id=\"Name${index+1}\"]"
		String genderXPath = "//*[@id=\"Gender${index+1}\"]"
		String dobXPath = "//*[@id=\"DOB${index+1}\"]"
		String addressXPath = "//*[@id=\"Address${index+1}\"]"
		
		// Create dynamic test objects
		TestObject nameField = createDynamicTestObject(nameXPath)
		TestObject genderField = createDynamicTestObject(genderXPath)
		TestObject dobField = createDynamicTestObject(dobXPath)
		TestObject addressField = createDynamicTestObject(addressXPath)
		
		// Set patient details in the respective fields
		WebUI.setText(nameField, name)
		WebUI.setText(genderField, gender)
		WebUI.setText(dobField, dob)
		WebUI.setText(addressField, address)
		
		
	} catch (Exception e) {
		println "Error: " + e.message
	}
}

// Save
WebUI.click(saveButton)

// Verify the saving process: Wait for the save button to finish the animation and become clickable again
WebUI.waitForElementNotPresent(createDynamicTestObject("//button[contains(@class, 'button success animate')]"), 10)
