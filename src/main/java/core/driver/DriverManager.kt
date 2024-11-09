package core.driver

import constants.Target
import io.appium.java_client.AppiumDriver
import io.appium.java_client.android.options.UiAutomator2Options
import org.openqa.selenium.remote.DesiredCapabilities
import java.net.URI

class DriverManager {
    fun getInstance(target: Target): AppiumDriver? {
        println("Getting instance of: " + target.name)
        return when (target) {
            Target.ANDROID -> getAndroidDriver()
            Target.IOS -> getIOSDriver()
        }
    }

    private fun getAndroidDriver(): AppiumDriver? = getDriver(
        mapOf(
            "platformName" to "android",
            "automationName" to "uiautomator2",
            "platformVersion" to "15",
            "deviceName" to "Automation",
            "app" to "src/main/resources/app-debug.apk",
            "appPackage" to "io.appium.android.apis",
            "appActivity" to "io.appium.android.apis.ApiDemos"
        )
    )

    private fun getIOSDriver(): AppiumDriver? = getDriver(
        mapOf(
            "platformName" to "iOS",
            "automationName" to "XCUITest",
            "deviceName" to "iPhone 13",
            "app" to "src/test/resources/TestApp.app"
        )
    )

    private fun getDriver(map: Map<String, *>): AppiumDriver? {
        val url = URI("http://127.0.0.1:4723").toURL()
        val capabilities = DesiredCapabilities(map)
        val options = UiAutomator2Options(capabilities)
        return AppiumDriver(url, options)
    }
}


