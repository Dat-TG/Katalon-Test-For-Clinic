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

// Scroll down the page
WebUI.scrollToElement(findTestObject('Object Repository/Page_PHNG KHM GROUP21/div_2022 Copyright Group21'), 10)

// Verify "Back to Top" button is visible
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_PHNG KHM GROUP21/button_next_btnBTT'))

// Click the "Back to Top" button
WebUI.click(findTestObject('Object Repository/Page_PHNG KHM GROUP21/button_next_btnBTT'))

// Wait for scrolling to complete
WebUI.delay(2) // Adjust the delay as necessary based on the scrolling speed

// Verify that the page has scrolled to the top
// Verify by checking the presence of an element at the top of the page
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_PHNG KHM GROUP21/div_PHNG KHM GROUP21                       _32b7e8'))

