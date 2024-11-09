package pages.apidemos.home

import core.page.BasePage
import io.appium.java_client.AppiumDriver
import org.openqa.selenium.By
import pages.apidemos.logtextbox.LogTextBoxPage

class APIDemosHomePage(driver: AppiumDriver<*>?) : BasePage(driver) {
    private val textButton = By.xpath("//android.widget.TextView[@content-desc=\"Text\"]")
    private val logTextBoxButton = By.xpath("//android.widget.TextView[@content-desc=\"LogTextBox\"]")

    fun openText(): APIDemosHomePage {
        val text = getElement(textButton)
        click(text)

        return this
    }

    fun tapOnLogTextBox(): LogTextBoxPage {
        val logTextBoxButtonElement = getElement(logTextBoxButton)
        waitForElementToBeVisible(logTextBoxButtonElement)

        click(logTextBoxButtonElement)

        return LogTextBoxPage(driver)
    }
}
