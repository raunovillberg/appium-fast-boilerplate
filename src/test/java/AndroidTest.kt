import constants.TestGroups
import org.testng.Assert
import org.testng.annotations.Test
import pages.apidemos.home.APIDemosHomePage

class AndroidTest : BaseTest() {
    @Test(groups = [TestGroups.ANDROID])
    fun testLogText() {
        val logText = APIDemosHomePage(driver!!)
            .openText()
            .tapOnLogTextBox()
            .tapOnAddButton()
            .getLogText()

        Assert.assertEquals(logText, "This is a test")
    }
}
