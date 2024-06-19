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
TestData loginData = findTestData('Data Files/Accounts For Login')

for (def index : (0..loginData.getRowNumbers() - 1)) {
    // Get data from each row
    String username = loginData.getValue('Username', index + 1)
    String password = loginData.getValue('Password', index + 1)
    String role = loginData.getValue('Role', index + 1)
    String expectedResult = loginData.getValue('ExpectedResult', index + 1)

    try {
        // Click on the service link
        WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PHNG KHM GROUP21/a_Dch v_navbarDropdownMenuAvatar'), 10)
        WebUI.click(findTestObject('Object Repository/Page_PHNG KHM GROUP21/a_Dch v_navbarDropdownMenuAvatar'))

        // Click on the login link
        WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PHNG KHM GROUP21/a_ng nhp'), 10)
        WebUI.click(findTestObject('Object Repository/Page_PHNG KHM GROUP21/a_ng nhp'))

        // Set username
        WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PHNG KHM GROUP21/input_ng nhp_Username'), 10)
        WebUI.setText(findTestObject('Object Repository/Page_PHNG KHM GROUP21/input_ng nhp_Username'), username)

        // Set password
        WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PHNG KHM GROUP21/input_Username_Password'), 10)
        WebUI.setText(findTestObject('Object Repository/Page_PHNG KHM GROUP21/input_Username_Password'), password)

        // Select role
        WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PHNG KHM GROUP21/select_Bnh nhn                  Bc s'), 10)
        WebUI.selectOptionByValue(findTestObject('Object Repository/Page_PHNG KHM GROUP21/select_Bnh nhn                  Bc s'), role, true)

        // Click login button
        WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PHNG KHM GROUP21/button_ng nhp'), 10)
        WebUI.click(findTestObject('Object Repository/Page_PHNG KHM GROUP21/button_ng nhp'))

        // Verify the expected result
        if (expectedResult == 'Success') {
            WebUI.verifyElementPresent(findTestObject('Object Repository/Page_PHNG KHM GROUP21/div_Xin cho, L Cng t'), 10)
			// Click dropdown button at user icon
			WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PHNG KHM GROUP21/a_Dch v_navbarDropdownMenuAvatar'), 10)
			WebUI.click(findTestObject('Object Repository/Page_PHNG KHM GROUP21/a_Dch v_navbarDropdownMenuAvatar'))
			
			// Click Logout
			WebUI.click(findTestObject('Object Repository/Page_PHNG KHM GROUP21/a_ng xut'))
			
			// Verify the welcome message not present
			WebUI.verifyElementNotPresent(findTestObject('Object Repository/Page_PHNG KHM GROUP21/div_Xin cho, L Cng t'), 10)
        } else {
            WebUI.verifyElementNotPresent(findTestObject('Object Repository/Page_PHNG KHM GROUP21/div_Xin cho, L Cng t'), 10)
        }
    } catch (Exception e) {
        println "Error: " + e.message
    }
}



