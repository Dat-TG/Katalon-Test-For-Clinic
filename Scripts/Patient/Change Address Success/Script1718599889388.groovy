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

// Click dropdown button at user icon
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PHNG KHM GROUP21/a_Dch v_navbarDropdownMenuAvatar'), 10)
WebUI.click(findTestObject('Object Repository/Page_PHNG KHM GROUP21/a_Dch v_navbarDropdownMenuAvatar'))

// Click Account
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PHNG KHM GROUP21/a_Ti khon'), 10)
WebUI.click(findTestObject('Object Repository/Page_PHNG KHM GROUP21/a_Ti khon'))

// Click Edit button
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PHNG KHM GROUP21/i_L Cng t 123_fas fa-edit'), 10)
WebUI.click(findTestObject('Object Repository/Page_PHNG KHM GROUP21/i_L Cng t 123_fas fa-edit'))

// Set address
WebUI.setText(findTestObject('Object Repository/Page_PHNG KHM GROUP21/input_address_edit_profile'), 'Ho Chi Minh City')

// Click confirm button
WebUI.waitForElementClickable(findTestObject('Object Repository/Page_PHNG KHM GROUP21/button_submit_profile'), 10)
WebUI.click(findTestObject('Object Repository/Page_PHNG KHM GROUP21/button_submit_profile'))

// Verify success message
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PHNG KHM GROUP21/div_Chnh sa thng tin c nhn thnh cng. Bn c t_30e4b4'), 10)
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_PHNG KHM GROUP21/div_Chnh sa thng tin c nhn thnh cng. Bn c t_30e4b4'))

