import constants.Target
import core.driver.DriverManager
import core.utils.PropertiesReader
import io.appium.java_client.AppiumDriver
import org.openqa.selenium.WebElement
import org.testng.ITestContext
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod
import java.io.IOException

open class BaseTest {
    @JvmField
    protected var driver: AppiumDriver<WebElement>? = null
    protected var reader: PropertiesReader = PropertiesReader()

    @BeforeMethod(alwaysRun = true)
    fun setup(context: ITestContext) {
        context.setAttribute("target", reader.target)

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