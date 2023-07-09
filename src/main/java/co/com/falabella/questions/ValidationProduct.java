package co.com.falabella.questions;

import co.com.falabella.interactions.ClickCartProduct;
import co.com.falabella.interactions.ClickProduct;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidationProduct implements Question<Boolean> {
    private String productNameInitial;
    private String productNameFinal;

    @Override
    public Boolean answeredBy(Actor actor) {
        productNameInitial = ClickProduct.ProductNameBefore(actor);
        productNameFinal = ClickCartProduct.ProductNameAfter(actor);
        return productNameInitial.equals(productNameFinal);
    }
    public static Question<Boolean> inCart(){
        return new ValidationProduct();
    }

    }
