import constants.Target
import core.driver.DriverManager
import core.utils.PropertiesReader
import exceptions.PlatformNotSupportException
import io.appium.java_client.AppiumDriver
import org.testng.ITestContext
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod
import java.io.IOException

open class BaseTest {
    @kotlin.jvm.JvmField
    protected var driver: AppiumDriver<*>? = null
    protected var reader: PropertiesReader = PropertiesReader()

    @BeforeMethod(alwaysRun = true)
    fun setup(context: ITestContext) {
        context.setAttribute("target", reader.target)

        try {
            val target = context.getAttribute("target") as Target
            driver = DriverManager().getInstance(target)
        } catch (e: IOException) {
            e.printStackTrace()
        } catch (e: PlatformNotSupportException) {
            e.printStackTrace()
        }
    }

    @AfterMethod(alwaysRun = true)
    fun teardown() {
        driver!!.quit()
    }
}
