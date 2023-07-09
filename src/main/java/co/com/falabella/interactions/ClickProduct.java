package co.com.falabella.interactions;

import co.com.falabella.utils.EscrituraExcel;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;


import java.util.List;
import java.util.Random;

import static co.com.falabella.ui.ProductsUI.NAME_PRODUCT;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ClickProduct implements Interaction {


    @Override
    public <T extends Actor> void performAs(T actor) {
        List<WebElementFacade> listProducts = NAME_PRODUCT.resolveAllFor(actor);
        Random random = new Random();
        int indexRandom = random.nextInt(listProducts.size());

        String productName = listProducts.get(indexRandom).getText();
        actor.remember("Product_name_initial", productName);
        System.out.print("Product_name_initial: ");
        System.out.println(productName);
        //EscrituraExcel.escrituraExcel("src/test/resources/Data/Data.xlsx", productName, 1, 2);
        listProducts.get(indexRandom).click();

    }

    public static Performable click() {
        return instrumented(ClickProduct.class);
    }

    public static String ProductNameBefore(Actor actor){
        return actor.recall("Product_name_initial");
    }
}





