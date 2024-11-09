package pages.apidemos.logtextbox

import io.appium.java_client.AppiumDriver
import org.openqa.selenium.By
import org.openqa.selenium.WebElement

class LogTextBoxPage(private val driver: AppiumDriver<WebElement>) {
    private val addButton = By.id("io.appium.android.apis:id/add")
    private val logTextButtonArea = By.id("io.appium.android.apis:id/text")

    fun tapOnAddButton(): LogTextBoxPage {
        driver.findElement(addButton)?.click()
        return this
    }

    fun getLogText(): String {
        return driver.findElement(logTextButtonArea)!!.text!!.trim { it <= ' ' }
    }
}
