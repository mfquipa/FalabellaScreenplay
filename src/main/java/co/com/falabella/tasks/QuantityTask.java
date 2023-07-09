package co.com.falabella.tasks;

import co.com.falabella.utils.Excel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import org.openqa.selenium.Keys;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import static co.com.falabella.ui.QuantityUI.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class QuantityTask implements Task {
   private static ArrayList<Map<String, String>> data=new ArrayList<>();
    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            data = Excel.leerDatosDeHojaDeExcel("src/test/resources/Data/Data.xlsx", "Search");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        actor.attemptsTo(
                Scroll.to(INP_QUAN),
                Clear.field(INP_QUAN),
                Enter.theValue(data.get(0).get("Quantity")).into(INP_QUAN).thenHit(Keys.ENTER),
                Click.on(BTN_ADD),
                Click.on(BTN_GO_CART)
        );

    }
    public static Performable num(){
        return instrumented(QuantityTask.class);
    }
}










