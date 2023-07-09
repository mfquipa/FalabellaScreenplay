package co.com.falabella.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ValidationUI {

    public static Target P_NAME_PRODUCT=Target.the("Product name")
            .located(By.xpath("//p[@data-testid='name']"));
    public static Target INP_QUANTITY_CART=Target.the("Product quantity Cart")
            .located(By.xpath("//input[@class='chakra-input css-1hzo6s2']"));
}
