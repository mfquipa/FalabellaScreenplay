package co.com.falabella.tasks;

import co.com.falabella.interactions.ClickProduct;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ProductsTask implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ClickProduct.click()
        );
           }
    public static Performable products(){return instrumented(ClickProduct.class);}

    }

