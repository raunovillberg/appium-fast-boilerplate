
import constants.Target
import core.driver.DriverManager
import io.appium.java_client.AppiumDriver
import org.openqa.selenium.WebElement
import org.testng.ITestContext
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod

open class BaseTest {
    @JvmField
    protected var driver: AppiumDriver<WebElement>? = null

    @BeforeMethod(alwaysRun = true)
    fun setup(context: ITestContext) {
        val target = Target.ANDROID
        // Do we actually need to set this attribute? Don't think so.
        context.setAttribute("target", target)
        driver = DriverManager().getInstance(target)
    }

    @AfterMethod(alwaysRun = true)
    fun teardown() {
        driver?.quit()
    }
}
