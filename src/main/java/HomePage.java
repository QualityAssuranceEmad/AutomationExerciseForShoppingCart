import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class HomePage {
    private SHAFT.GUI.WebDriver driver;

    public HomePage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    By MenButton = By.xpath("//a[@href='#Men']");
    By TeshirtsButton = By.xpath("//a[@href='/category_products/3'] [contains(.,'Tshirts ')]");

    public void HomepageTshirtProducts()
    {
        driver.element().click(MenButton).and().click(TeshirtsButton);

    }
}
