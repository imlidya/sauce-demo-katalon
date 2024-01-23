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

WebUI.openBrowser('')

WebUI.navigateToUrl('https://www.saucedemo.com/')

//Login Flow
lblUsername = WebUI.getAttribute(findTestObject('Object Repository/Page_Swag Labs/input_user-name'), "placeholder")
assert lblUsername.equals("Username")
WebUI.setText(findTestObject('Object Repository/Page_Swag Labs/input_user-name'), 'standard_user')

lblPassword = WebUI.getAttribute(findTestObject('Object Repository/Page_Swag Labs/input_password'), "placeholder")
assert lblPassword.equals("Password")
WebUI.setEncryptedText(findTestObject('Object Repository/Page_Swag Labs/input_password'), 'qcu24s4901FyWDTwXGr6XA==')

WebUI.click(findTestObject('Object Repository/Page_Swag Labs/input_login-button'))

//Choose Products
lblProductsTitle = WebUI.getText(findTestObject('Object Repository/Page_Swag Labs/div_product_name'))
assert lblProductsTitle.equals("Sauce Labs Bolt T-Shirt")

lblProductsDesc = WebUI.findWebElement(findTestObject('Object Repository/Page_Swag Labs/div_product_description'), 10)

WebUI.click(findTestObject('Object Repository/Page_Swag Labs/button_Add to cart'))
WebUI.click(findTestObject('Object Repository/Page_Swag Labs/button_Click cart icon'))

//Assert Cart Page
lblProductsTitle = WebUI.getText(findTestObject('Object Repository/Page_Swag Labs/div_product_name'))
assert lblProductsTitle.equals("Sauce Labs Bolt T-Shirt")

WebUI.findWebElement(findTestObject('Object Repository/Page_Swag Labs/div_product_description'), 10)
WebUI.findWebElement(findTestObject('Object Repository/Page_Swag Labs/div_quantity_in_cart'), 10)
WebUI.findWebElement(findTestObject('Object Repository/Page_Swag Labs/div_price_in_cart'), 10)

WebUI.click(findTestObject('Object Repository/Page_Swag Labs/button_Checkout'))

//Assert Checkout Page
lblFirstName = WebUI.getAttribute(findTestObject('Object Repository/Page_Swag Labs/input_firstName'), "placeholder")
assert lblFirstName.equals("First Name")

lblLastName = WebUI.getAttribute(findTestObject('Object Repository/Page_Swag Labs/input_lastName'), "placeholder")
assert lblLastName.equals("Last Name")

lblPostalCode = WebUI.getAttribute(findTestObject('Object Repository/Page_Swag Labs/input_postalCode'), "placeholder")
assert lblPostalCode.equals("Zip/Postal Code")

WebUI.closeBrowser()

