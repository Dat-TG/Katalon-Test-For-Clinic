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

// Wait for the navigation item "Tài liệu" to be visible and click it
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PHNG KHM GROUP21/a_Nav_2'), 10)
WebUI.click(findTestObject('Object Repository/Page_PHNG KHM GROUP21/a_Nav_2'))

// Wait for the "Lập báo cáo thuốc" to be visible and click it
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PHNG KHM GROUP21/a_LapBaoCaoThuoc'), 10)
WebUI.click(findTestObject('Object Repository/Page_PHNG KHM GROUP21/a_LapBaoCaoThuoc'))

// Click "+"
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_PHNG KHM GROUP21/button_add_drug_report'), 10)
WebUI.click(findTestObject('Object Repository/Page_PHNG KHM GROUP21/button_add_drug_report'))

// Helper function to create dynamic test objects
TestObject createDynamicTestObject(String xpath) {
	TestObject to = new TestObject()
	to.addProperty("xpath", ConditionType.EQUALS, xpath)
	return to
}

String drug='Alcool 70°'

// Create dynamic test objects
TestObject monthField = createDynamicTestObject('/html/body/div[1]/div/div[1]/input')
TestObject yearField = createDynamicTestObject('/html/body/div[1]/div/div[2]/input')
TestObject nameField = createDynamicTestObject('//*[@id="Name1"]')
TestObject quantityField = createDynamicTestObject('//*[@id="Quantity1"]')
TestObject usedField = createDynamicTestObject('//*[@id="Used1"]')

// Click on the input field to bring it into focus
WebUI.click(nameField)

// Type the desired value
WebUI.setText(nameField, drug)

WebUI.setText(monthField, '12')
WebUI.setText(yearField, '2024')
WebUI.setText(quantityField, '100')
WebUI.setText(usedField, '10')

// Submit
TestObject submit_button = createDynamicTestObject('/html/body/div[2]/div[1]/button')
WebUI.click(submit_button)

// Verify success
TestObject title = createDynamicTestObject('/html/body/div/h3/b')
WebUI.verifyElementText(title, 'CÁC BÁO CÁO SỬ DỤNG THUỐC')



