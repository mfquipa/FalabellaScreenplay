package co.com.falabella.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class QuantityUI {

    public static Target INP_QUAN=Target.the("Product quantity")
            .located(By.xpath("//input[@id='quantity-selector-increment-input']"));
    public static Target BTN_ADD = Target.the("Add to cart")
            .located(By.xpath("//button[@id='add-to-cart-button']"));
    public static Target BTN_GO_CART=Target.the("Go to cart")
            .located(By.xpath("//a[@id='linkButton']"));
}
