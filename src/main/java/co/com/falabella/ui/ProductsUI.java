package co.com.falabella.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ProductsUI {

    public static final Target NAME_PRODUCT = Target.the("Product NAME")
            .locatedBy("//*[@class='jsx-1576191951 title2 primary  jsx-2889528833 bold       pod-subTitle subTitle-rebrand' or @class='jsx-1833870204 copy2 primary  jsx-2889528833 normal       pod-subTitle subTitle-rebrand' ]");
}

