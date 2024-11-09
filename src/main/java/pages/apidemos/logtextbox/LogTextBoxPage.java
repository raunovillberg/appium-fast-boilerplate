package pages.apidemos.logtextbox;

import org.openqa.selenium.By;

import core.page.BasePage;
import io.appium.java_client.AppiumDriver;

public class LogTextBoxPage extends BasePage {
    private final By addButton = By.id("io.appium.android.apis:id/add");
    private final By logTextButtonArea = By.id("io.appium.android.apis:id/text");

    public LogTextBoxPage(AppiumDriver driver) {
        super(driver);
    }

    public LogTextBoxPage tapOnAddButton() {
        click(getElement(addButton));
        return this;
    }

    public String getLogText() {
        return getText(getElement(logTextButtonArea)).trim();
    }
}
