package co.com.falabella.questions;

import co.com.falabella.interactions.ClickCartProduct;
import co.com.falabella.utils.Excel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class ValidationQuantity implements Question<Boolean> {
    private  static ArrayList<Map<String, String>> data= new ArrayList<>();
    @Override
    public Boolean answeredBy(Actor actor) {
        String QuantityInitial;
        try {
            data = Excel.leerDatosDeHojaDeExcel("src/test/resources/Data/Data.xlsx", "Search");
            QuantityInitial = data.get(0).get("Quantity");

            String QuantityFinal = ClickCartProduct.ProductQuantityAfter(actor);

            return QuantityInitial.equals(QuantityFinal);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Question <Boolean> numers ()  { return new ValidationQuantity(); }
}
