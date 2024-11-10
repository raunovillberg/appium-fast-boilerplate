package core.extensions

import io.appium.java_client.AppiumDriver
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration


fun By?.waitForElementToBePresent(driver: AppiumDriver, seconds: Long = 2) {
    WebDriverWait(driver, Duration.ofSeconds(seconds))
        .until<WebElement?>(ExpectedConditions.presenceOfElementLocated(this))
}

fun WebElement?.waitForElementToBeVisible(driver: AppiumDriver, seconds: Long = 2) {
    WebDriverWait(driver, Duration.ofSeconds(seconds))
        .until<WebElement?>(ExpectedConditions.visibilityOf(this))
}