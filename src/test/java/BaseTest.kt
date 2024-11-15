import constants.Target
import io.appium.java_client.AppiumDriver
import io.appium.java_client.android.options.UiAutomator2Options
import io.appium.java_client.service.local.AppiumDriverLocalService
import org.openqa.selenium.remote.DesiredCapabilities
import org.testng.ITestContext
import org.testng.annotations.AfterClass
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeClass
import org.testng.annotations.BeforeMethod
import java.net.URI

open class BaseTest {
    private val target = Target.ANDROID
    protected lateinit var driver: AppiumDriver
    protected lateinit var service: AppiumDriverLocalService

    @BeforeClass
    fun setup(context: ITestContext) {
        context.setAttribute("target", target)
        println("Test target: $target")
        service = AppiumDriverLocalService.buildDefaultService()
        service.start()
    }

    @AfterClass
    fun teardown() {
        service.stop()
    }

    @BeforeMethod(alwaysRun = true)
    fun setupBeforeMethod() {
        val capabilities =
            when (target) {
                Target.ANDROID ->
                    mapOf(
                        "platformName" to "android",
                        "automationName" to "uiautomator2",
                        "platformVersion" to "15",
                        "deviceName" to "Automation",
                        "app" to "src/main/resources/app-debug.apk",
                        "appPackage" to "io.appium.android.apis",
                        "appActivity" to "io.appium.android.apis.ApiDemos",
                    )

                Target.IOS ->
                    mapOf(
                        "platformName" to "iOS",
                        "automationName" to "XCUITest",
                        "deviceName" to "iPhone 13",
                        "app" to "src/test/resources/TestApp.app",
                    )
            }

        val url = URI("http://127.0.0.1:4723").toURL()
        val options = UiAutomator2Options(DesiredCapabilities(capabilities))
        driver = AppiumDriver(url, options)
    }

    @AfterMethod(alwaysRun = true)
    fun teardownAfterMethod() {
        driver.quit()
    }
}
