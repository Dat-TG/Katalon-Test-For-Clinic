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

// Click navigation item "Tìm kiếm"
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PHNG KHM GROUP21/a_Nav_2'), 10)
WebUI.click(findTestObject('Object Repository/Page_PHNG KHM GROUP21/a_Nav_2'))

// Wait for the Drug Link to be visible and click it
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PHNG KHM GROUP21/a_Thuoc_Patient'), 10)
WebUI.click(findTestObject('Object Repository/Page_PHNG KHM GROUP21/a_Thuoc_Patient'))

// Wait for the First Cell of the Drug Table to be visible and click it
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PHNG KHM GROUP21/a_First Link In First Cell In Table'), 10)
WebUI.click(findTestObject('Object Repository/Page_PHNG KHM GROUP21/a_First Link In First Cell In Table'))

// Verify the Drug Details Page is loaded
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PHNG KHM GROUP21/div_Alcool 70                Hot cht Cn 70 _481b02'), 10)
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_PHNG KHM GROUP21/div_Alcool 70                Hot cht Cn 70 _481b02'))

