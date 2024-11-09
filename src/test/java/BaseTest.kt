
import constants.Target
import core.driver.DriverManager
import io.appium.java_client.AppiumDriver
import org.openqa.selenium.WebElement
import org.testng.ITestContext
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod

open class BaseTest {
    protected lateinit var driver: AppiumDriver<WebElement>

    @BeforeMethod(alwaysRun = true)
    fun setup(context: ITestContext) {
        val target = Target.ANDROID
        // Do we actually need to set this attribute? Don't think so.
        context.setAttribute("target", target)
        // Forced unwrap - we *should* catastrophically fail if we can't even create a Driver.
        driver = DriverManager().getInstance(target)!!
    }

    @AfterMethod(alwaysRun = true)
    fun teardown() {
        driver.quit()
    }
}
