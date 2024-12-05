import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage {
    private SHAFT.GUI.WebDriver driver;

    public ProductsPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    By ProductsPrices = By.xpath("//div[@class='productinfo text-center']");
    By clickContinue=By.xpath(" //button[@class='btn btn-success close-modal btn-block']");
    By cartButton=By.xpath("(//a[@href='/view_cart'])[1]");
    @Step("add products to cart")
    public ProductsPage addProductsToCart() {
        // Locate all products

        try {
            List<WebElement> productContainers = driver.getDriver().findElements(ProductsPrices);

            for (int i = 0; i < productContainers.size(); i++) {
                // Find the price element within each product container
                int  productPrice = Integer.parseInt(driver.getDriver().findElement(By.xpath("(//div[@class='productinfo text-center']/h2)["+(i+1)+"]"))
                        .getText().replaceAll("[^0-9]", ""));
                System.out.println("price of product" + (i+1));
                if (productPrice<1000)
                {
                  driver.element().click(By.xpath(" (//div[@class='productinfo text-center'])["+(i+1)+"]/a")).click(clickContinue);
                    System.out.println("added product with price "+productPrice+ "to the cart");
                }

            }
        }
        catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
        return  this;


    }
    @Step("Verify viewCart Project")
    public void checkCart()
    {
        driver.element().scrollToElement(cartButton).click(cartButton).and().browser().captureScreenshot();
    }
}
