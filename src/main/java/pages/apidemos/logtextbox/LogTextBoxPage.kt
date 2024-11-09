package pages.apidemos.logtextbox

import core.page.BasePage
import io.appium.java_client.AppiumDriver
import org.openqa.selenium.By
import org.openqa.selenium.WebElement

class LogTextBoxPage(driver: AppiumDriver<WebElement>) : BasePage(driver) {
    private val addButton = By.id("io.appium.android.apis:id/add")
    private val logTextButtonArea = By.id("io.appium.android.apis:id/text")

    fun tapOnAddButton(): LogTextBoxPage {
        click(getElement(addButton))
        return this
    }

    fun getLogText(): String {
        return getText(getElement(logTextButtonArea)!!)!!.trim { it <= ' ' }
    }
}
