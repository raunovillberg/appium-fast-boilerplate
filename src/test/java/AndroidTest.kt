import constants.TestGroups
import core.extensions.waitForElementToBePresent
import core.extensions.waitForElementToBeVisible
import io.appium.java_client.AppiumBy
import org.testng.Assert
import org.testng.annotations.Test
import pages.apidemos.home.APIDemosHomePage

class AndroidTest : BaseTest() {
    @Test(groups = [TestGroups.ANDROID])
    fun test_TapAddButton_LogShowsText() {
        val logText = APIDemosHomePage(driver)
            .openText()
            .tapOnLogTextBox()
            .tapOnAddButton()
            .getLogText()

        Assert.assertEquals(logText, "This is a test")
    }

    @Test(groups = [TestGroups.ANDROID])
    fun test_TapDoNothingButton_LogStaysEmpty() {
        val logText = APIDemosHomePage(driver)
            .openText()
            .tapOnLogTextBox()
            .tapOnDoNothingButton()
            .getLogText()

        Assert.assertTrue(logText.isNullOrEmpty())
    }

    @Test(groups = [TestGroups.ANDROID])
    fun test_OpenDialog_TapOkButton_DialogCloses() {
        driver.findElement(AppiumBy.ByAccessibilityId("App"))
            .click()
        driver.findElement(AppiumBy.ByAccessibilityId("Alert Dialogs"))
            .click()

        val openDialogBy = AppiumBy.ByAccessibilityId("OK Cancel dialog with a message")
        driver.findElement(openDialogBy)
            .click()

        val dialogBy = AppiumBy.id("android:id/buttonPanel")
        dialogBy.waitForElementToBePresent(driver)
        val dialogElement = driver.findElement(dialogBy)
        dialogElement.waitForElementToBeVisible(driver)

        driver.findElement(AppiumBy.id("android:id/button1")).click()

        openDialogBy.waitForElementToBePresent(driver)
        Assert.assertNotNull(driver.findElement(openDialogBy))
    }
}
