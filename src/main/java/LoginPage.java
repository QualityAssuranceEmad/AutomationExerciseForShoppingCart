import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class LoginPage {
    private SHAFT.GUI.WebDriver driver;

    public LoginPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    By Email_Input = By.xpath("//input[@data-qa='login-email']");
    By Password_Input = By.xpath("//input[@data-qa='login-password']");
    By login_button = By.xpath("//button[@data-qa='login-button']");
    public HomePage login(String UserName,String Password)
    {
        driver.element().type(Email_Input,UserName).and().type(Password_Input,Password).and().click(login_button);
        return new HomePage(driver);
    }


}
