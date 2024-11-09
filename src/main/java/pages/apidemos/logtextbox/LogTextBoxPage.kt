package pages.apidemos.logtextbox

import core.page.BasePage
import io.appium.java_client.AppiumDriver
import org.openqa.selenium.By

class LogTextBoxPage(driver: AppiumDriver<*>) : BasePage(driver) {
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
