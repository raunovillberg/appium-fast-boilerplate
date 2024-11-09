package core.driver;

import static core.utils.CapabilitiesHelper.readAndMakeCapabilities;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import constants.Target;
import exceptions.PlatformNotSupportException;
import io.appium.java_client.AppiumDriver;

public class DriverManager {
    private static AppiumDriver driver;
    // For Appium < 2.0, append /wd/hub to the APPIUM_SERVER_URL
    final String APPIUM_SERVER_URL = "http://127.0.0.1:4723";

    public AppiumDriver getInstance(Target target) throws IOException {
        System.out.println("Getting instance of: " + target.name());
        return switch (target) {
            case ANDROID -> getAndroidDriver();
            case IOS -> getIOSDriver();
        };
    }

    private AppiumDriver getAndroidDriver() throws IOException {
        var map = readAndMakeCapabilities("android-caps.json");
        return getDriver(map);
    }

    private AppiumDriver getIOSDriver() throws IOException {
        HashMap map = readAndMakeCapabilities("ios-caps.json");
        return getDriver(map);
    }

    private AppiumDriver getDriver(HashMap map) {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities(map);

        try {
            driver = new AppiumDriver(
                    new URL(APPIUM_SERVER_URL), desiredCapabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return driver;
    }
}


