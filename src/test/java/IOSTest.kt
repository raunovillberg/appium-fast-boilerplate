import constants.TestGroups
import org.testng.Assert
import org.testng.annotations.Test
import pages.testapp.home.HomePage

class IOSTest : BaseTest() {
    @Test(groups = [TestGroups.IOS])
    fun addNumbers() {
        val actualSum = HomePage(this.driver)
            .enterTwoNumbersAndCompute("5", "5")
            .sum

        Assert.assertEquals(actualSum, "10")
    }
}
