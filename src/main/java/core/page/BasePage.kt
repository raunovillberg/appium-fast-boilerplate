package core.page

import io.appium.java_client.AppiumDriver
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

open class BasePage(protected val driver: AppiumDriver<*>) {

    fun click(elem: WebElement?) {
        elem?.click()
    }

    fun getElement(by: By?): WebElement? = driver.findElement(by)

    fun getElements(by: By?): MutableList<WebElement>? = driver.findElements(by) as MutableList<WebElement>?

    // TODO: do we really want this wrapper function? Why not call .text directly?
    fun getText(elem: WebElement): String? = elem.text

    fun waitForElementToBeVisible(elem: WebElement?) {
        WebDriverWait(driver, 10)
            .until<WebElement?>(ExpectedConditions.visibilityOf(elem))
    }

    fun waitForElementToBePresent(by: By?) {
        WebDriverWait(driver, 10)
            .until<WebElement?>(ExpectedConditions.presenceOfElementLocated(by))
    }

    fun type(elem: WebElement, text: String) {
        elem.sendKeys(text)
    }
}
