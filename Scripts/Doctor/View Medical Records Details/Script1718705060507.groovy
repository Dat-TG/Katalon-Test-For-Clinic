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

// Click on the "Tìm kiếm" link
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PHNG KHM GROUP21/a_Nav_3'), 10)
WebUI.click(findTestObject('Object Repository/Page_PHNG KHM GROUP21/a_Nav_3'))

// Click on the "Hồ sơ bệnh án" link
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PHNG KHM GROUP21/a_H s bnh n'), 10)
WebUI.click(findTestObject('Object Repository/Page_PHNG KHM GROUP21/a_H s bnh n'))

// Click on the first link in the first cell in the table
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PHNG KHM GROUP21/a_First Link In First Cell In Table'), 10)
WebUI.click(findTestObject('Object Repository/Page_PHNG KHM GROUP21/a_First Link In First Cell In Table'))

// Verify the text of the element
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PHNG KHM GROUP21/p_PHIU KHM BNH'), 10)
WebUI.verifyElementText(findTestObject('Object Repository/Page_PHNG KHM GROUP21/p_PHIU KHM BNH'), 'PHIẾU KHÁM BỆNH', FailureHandling.STOP_ON_FAILURE)

