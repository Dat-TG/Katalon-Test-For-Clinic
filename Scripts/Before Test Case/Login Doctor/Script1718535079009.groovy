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

// Wait for and click the user icon
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PHNG KHM GROUP21/svg_Dch v_bi bi-person-circle me-2'), 10)
WebUI.click(findTestObject('Object Repository/Page_PHNG KHM GROUP21/svg_Dch v_bi bi-person-circle me-2'))

// Wait for and click the "Login" link
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PHNG KHM GROUP21/a_ng nhp'), 10)
WebUI.click(findTestObject('Object Repository/Page_PHNG KHM GROUP21/a_ng nhp'))

// Wait for and set the username
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PHNG KHM GROUP21/input_ng nhp_Username'), 10)
WebUI.setText(findTestObject('Object Repository/Page_PHNG KHM GROUP21/input_ng nhp_Username'), 'vtn_02')

// Wait for and set the password
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PHNG KHM GROUP21/input_Username_Password'), 10)
WebUI.setEncryptedText(findTestObject('Object Repository/Page_PHNG KHM GROUP21/input_Username_Password'), 'aeHFOx8jV/A=')

// Wait for and select the role "doctor"
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PHNG KHM GROUP21/select_Bnh nhn                  Bc s'), 10)
WebUI.selectOptionByValue(findTestObject('Object Repository/Page_PHNG KHM GROUP21/select_Bnh nhn                  Bc s'), 'doctor', true)

// Wait for and click the "Login" button
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PHNG KHM GROUP21/button_ng nhp'), 10)
WebUI.click(findTestObject('Object Repository/Page_PHNG KHM GROUP21/button_ng nhp'))

// Verify the presence of the welcome message
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_PHNG KHM GROUP21/div_Xin cho, L Cng t'), 10)

