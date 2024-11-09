package core.extensions

import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait


fun By?.waitForElementToBePresent(driver: AppiumDriver<MobileElement>) {
    WebDriverWait(driver, 10)
        .until<WebElement>(ExpectedConditions.presenceOfElementLocated(this))
}

fun MobileElement?.waitForElementToBeVisible(driver: AppiumDriver<MobileElement>) {
    WebDriverWait(driver, 10)
        .until<WebElement?>(ExpectedConditions.visibilityOf(this))
}