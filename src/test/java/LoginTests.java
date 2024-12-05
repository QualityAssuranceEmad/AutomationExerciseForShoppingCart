import com.shaft.driver.SHAFT;
import io.qameta.allure.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTests {
    private SHAFT.GUI.WebDriver driver;
    private SHAFT.TestData.JSON testdata;
    SHAFT.TestData.JSON testData;
    SHAFT.TestData.EXCEL excelData;

    @Test(description = "Login User Testt")
    @Description("Given that I am a login as a user, When I click in Login button, " +
            "And I entered valid email and valid password, And I clicked on Login button," +
            " Then I should be logged in successfully to the system homepage")
    public void loginAndAddProduct() {
        new LoginPage(driver).login(excelData.getCellData("userName"),excelData.getCellData("password")).
                HomepageTshirtProducts();

    }


    @BeforeClass
    public void OpenBrowser() {
        driver = new SHAFT.GUI.WebDriver();
        driver.browser().navigateToURL("https://automationexercise.com/login");
        testData = new SHAFT.TestData.JSON(SHAFT.Properties.paths.testData() + "testData.json");
        excelData=new SHAFT.TestData.EXCEL(SHAFT.Properties.paths.testData() + "testExcel.xlsx");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
