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

// Click the 'Chỉnh sửa' link
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PHNG KHM GROUP21/a_Nav_1'), 10)
WebUI.click(findTestObject('Object Repository/Page_PHNG KHM GROUP21/a_Nav_1'))

// Click the 'Số bệnh nhân tối đa' link
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PHNG KHM GROUP21/a_S bnh nhn ti                             _439605'), 10)
WebUI.click(findTestObject('Object Repository/Page_PHNG KHM GROUP21/a_S bnh nhn ti                             _439605'))

// Click the button to edit
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PHNG KHM GROUP21/button_button'), 10)
WebUI.click(findTestObject('Object Repository/Page_PHNG KHM GROUP21/button_button'))

// Set text in the input field
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PHNG KHM GROUP21/input_Thay i s bnh nhn ti a trong ngy_max'), 10)
WebUI.setText(findTestObject('Object Repository/Page_PHNG KHM GROUP21/input_Thay i s bnh nhn ti a trong ngy_max'), '0')

// Click the confirm button
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PHNG KHM GROUP21/button_Xc nhn'), 10)
WebUI.click(findTestObject('Object Repository/Page_PHNG KHM GROUP21/button_Xc nhn'))

// Check if the required validation alert is shown
boolean isValidationAlertShown = WebUI.getAttribute(findTestObject('Object Repository/Page_PHNG KHM GROUP21/input_Thay i s bnh nhn ti a trong ngy_max'), 'validationMessage') != ''

// Verify if the validation alert is shown
WebUI.verifyEqual(isValidationAlertShown, true, FailureHandling.STOP_ON_FAILURE)

