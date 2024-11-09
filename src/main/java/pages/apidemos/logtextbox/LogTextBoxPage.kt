package pages.apidemos.logtextbox

import io.appium.java_client.AppiumDriver
import org.openqa.selenium.By

class LogTextBoxPage(private val driver: AppiumDriver) {
    private val addButton = By.id("io.appium.android.apis:id/add")
    private val logTextButtonArea = By.id("io.appium.android.apis:id/text")
    private val doNothingButton = By.xpath("//android.widget.Button[@content-desc=\"Do nothing\"]")

    fun tapOnAddButton(): LogTextBoxPage {
        driver.findElement(addButton)?.click()
        return this
    }

    fun getLogText(): String? {
        return driver.findElement(logTextButtonArea)?.text?.trim { it <= ' ' }
    }

    fun tapOnDoNothingButton(): LogTextBoxPage {
        val element = driver.findElement(doNothingButton)!!
        element.click()
        return this
    }
}
