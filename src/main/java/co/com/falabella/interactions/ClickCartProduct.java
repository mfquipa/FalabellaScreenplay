package co.com.falabella.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

import static co.com.falabella.ui.ProductsUI.NAME_PRODUCT;
import static co.com.falabella.ui.ValidationUI.INP_QUANTITY_CART;
import static co.com.falabella.ui.ValidationUI.P_NAME_PRODUCT;

public class ClickCartProduct implements Interaction {
    private static String varProductName;

    private static String varProductQuantity;

    @Override
    public <T extends Actor> void performAs(T actor) {
        varProductName = P_NAME_PRODUCT.resolveFor(actor).getText();
        actor.remember("Product_name_final", varProductName);

        varProductQuantity = INP_QUANTITY_CART.resolveFor(actor).getValue();
        actor.remember("Product_quantity_final", varProductQuantity);
    }
    public static ClickCartProduct name() {
        return new ClickCartProduct();
        }
    public static String ProductNameAfter(Actor actor){
        return actor.recall("Product_name_final");
        }
    public static String ProductQuantityAfter(Actor actor){
        return actor.recall("Product_quantity_final");
    }
    }

