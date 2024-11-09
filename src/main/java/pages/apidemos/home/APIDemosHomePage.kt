package pages.apidemos.home

import core.extensions.waitForElementToBeVisible
import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import org.openqa.selenium.By
import pages.apidemos.logtextbox.LogTextBoxPage

class APIDemosHomePage(private val driver: AppiumDriver<MobileElement>) {
    private val textButton = By.xpath("//android.widget.TextView[@content-desc=\"Text\"]")
    private val logTextBoxButton =
        By.xpath("//android.widget.TextView[@content-desc=\"LogTextBox\"]")

    fun openText(): APIDemosHomePage {
        val text = driver.findElement(textButton)
        text?.click()

        return this
    }

    fun tapOnLogTextBox(): LogTextBoxPage {
        val logTextBoxButtonElement = driver.findElement(logTextBoxButton)
        logTextBoxButtonElement?.waitForElementToBeVisible(driver)
        logTextBoxButtonElement?.click()
        return LogTextBoxPage(driver)
    }
}
