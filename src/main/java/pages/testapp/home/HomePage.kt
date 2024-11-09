package pages.testapp.home

import core.page.BasePage
import io.appium.java_client.AppiumDriver
import org.openqa.selenium.By
import org.openqa.selenium.WebElement

class HomePage(driver: AppiumDriver<WebElement>) : BasePage(driver) {
    private val firstNumber = By.name("IntegerA")
    private val secondNumber = By.name("IntegerB")
    private val computeSumButton = By.name("ComputeSumButton")
    private val answer = By.name("Answer")

    fun enterTwoNumbersAndCompute(first: String, second: String): HomePage {
        typeFirstNumber(first)
        typeSecondNumber(second)
        compute()
        return this
    }

    fun typeFirstNumber(number: String): HomePage {
        val firstNoElement = getElement(firstNumber)
        type(firstNoElement!!, number)
        return this
    }

    fun typeSecondNumber(number: String): HomePage {
        val secondNoElement = getElement(secondNumber)
        type(secondNoElement!!, number)
        return this
    }

    fun compute(): HomePage {
        val computeBtn = getElement(computeSumButton)
        click(computeBtn)
        return this
    }

    fun getSum(): String? {
        waitForElementToBePresent(answer)
        return getText(getElement(answer)!!)
    }
}

