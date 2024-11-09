import constants.Target
import core.driver.DriverManager
import io.appium.java_client.AppiumDriver
import org.openqa.selenium.WebElement
import org.testng.ITestContext
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod
import java.io.IOException

open class BaseTest {
    @JvmField
    protected var driver: AppiumDriver<WebElement>? = null

    @BeforeMethod(alwaysRun = true)
    fun setup(context: ITestContext) {
        context.setAttribute("target", Target.ANDROID)

        try {
            val target = context.getAttribute("target") as Target
            driver = DriverManager().getInstance(target)
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    @AfterMethod(alwaysRun = true)
    fun teardown() {
        driver?.quit()
    }
}
