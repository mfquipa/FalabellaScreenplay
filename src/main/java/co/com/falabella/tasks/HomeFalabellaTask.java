package co.com.falabella.tasks;


import co.com.falabella.utils.Excel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import static co.com.falabella.ui.HomeFalabellaUI.TXT_SEARCH;
import static net.serenitybdd.screenplay.Tasks.instrumented;


public class HomeFalabellaTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        ArrayList<Map<String, String>> data;
        try {
        data = Excel.leerDatosDeHojaDeExcel("src/test/resources/Data/Data.xlsx", "Search");
            } catch (IOException e) {
        throw new RuntimeException(e);
    }
    actor.attemptsTo(
            Enter.theValue(data.get(0).get("Search")).into(TXT_SEARCH).thenHit(Keys.ENTER)
    );
    }
    public static Performable fromHome(){
        return instrumented(HomeFalabellaTask.class);
    }

}
