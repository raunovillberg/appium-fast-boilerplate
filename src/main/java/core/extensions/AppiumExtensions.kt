package core.extensions

import io.appium.java_client.AppiumDriver
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration


fun By?.waitForElementToBePresent(driver: AppiumDriver) {
    WebDriverWait(driver, Duration.ofSeconds(10))
        .until<WebElement?>(ExpectedConditions.presenceOfElementLocated(this))
}

fun WebElement?.waitForElementToBeVisible(driver: AppiumDriver) {
    WebDriverWait(driver, Duration.ofSeconds(10))
        .until<WebElement?>(ExpectedConditions.visibilityOf(this))
}