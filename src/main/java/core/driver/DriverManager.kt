package core.driver

import constants.Target
import core.utils.CapabilitiesHelper
import io.appium.java_client.AppiumDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.remote.DesiredCapabilities
import java.io.IOException
import java.net.MalformedURLException
import java.net.URI

class DriverManager {
    @Throws(IOException::class)
    fun getInstance(target: Target): AppiumDriver<WebElement>? {
        println("Getting instance of: " + target.name)
        return when (target) {
            Target.ANDROID -> getAndroidDriver()
            Target.IOS -> getIOSDriver()
        }
    }

    @Throws(IOException::class)
    private fun getAndroidDriver(): AppiumDriver<WebElement>? = getDriver(
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

    @Throws(IOException::class)
    private fun getIOSDriver(): AppiumDriver<WebElement>? {
        val map = CapabilitiesHelper.readAndMakeCapabilities("ios-caps.json")
        return getDriver(map)
    }

    private fun getDriver(map: Map<String, *>): AppiumDriver<WebElement>? {
        val desiredCapabilities = DesiredCapabilities(map)

        try {
            val url = URI("http://127.0.0.1:4723").toURL()
            driver = AppiumDriver<WebElement>(url, desiredCapabilities)
        } catch (e: MalformedURLException) {
            e.printStackTrace()
        }

        return driver
    }

    companion object {
        private var driver: AppiumDriver<WebElement>? = null
    }
}


