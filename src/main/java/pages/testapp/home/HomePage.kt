package pages.testapp.home

import core.extensions.waitForElementToBePresent
import io.appium.java_client.AppiumDriver
import org.openqa.selenium.By

class HomePage(private val driver: AppiumDriver) {
    private val firstNumber = By.name("IntegerA")
    private val secondNumber = By.name("IntegerB")
    private val computeSumButton = By.name("ComputeSumButton")
    private val answer = By.name("Answer")

    fun enterTwoNumbersAndCompute(
        first: String,
        second: String,
    ): HomePage {
        typeFirstNumber(first)
        typeSecondNumber(second)
        compute()
        return this
    }

    fun typeFirstNumber(number: String): HomePage {
        val firstNoElement = driver.findElement(firstNumber)
        firstNoElement!!.sendKeys(number)
        return this
    }

    fun typeSecondNumber(number: String): HomePage {
        val secondNoElement = driver.findElement(secondNumber)
        secondNoElement!!.sendKeys(number)
        return this
    }

    fun compute(): HomePage {
        val computeBtn = driver.findElement(computeSumButton)
        computeBtn?.click()
        return this
    }

    fun getSum(): String? {
        answer.waitForElementToBePresent(driver)
        return driver.findElement(answer)!!.text
    }
}
