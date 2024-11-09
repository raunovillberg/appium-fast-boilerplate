package core.driver

import constants.Target
import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import org.openqa.selenium.remote.DesiredCapabilities
import java.net.URI

class DriverManager {
    fun getInstance(target: Target): AppiumDriver<MobileElement> {
        println("Getting instance of: " + target.name)
        return when (target) {
            Target.ANDROID -> getAndroidDriver()
            Target.IOS -> getIOSDriver()
        }
    }

    private fun getAndroidDriver(): AppiumDriver<MobileElement> = getDriver(
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

    private fun getIOSDriver(): AppiumDriver<MobileElement> = getDriver(
        mapOf(
            "platformName" to "iOS",
            "automationName" to "XCUITest",
            "deviceName" to "iPhone 13",
            "app" to "src/test/resources/TestApp.app"
        )
    )

    private fun getDriver(map: Map<String, *>): AppiumDriver<MobileElement> {
        val url = URI("http://127.0.0.1:4723").toURL()
        return AppiumDriver<MobileElement>(url, DesiredCapabilities(map))
    }
}


