package co.com.falabella.stepDefinitions;

import co.com.falabella.interactions.ClickCartProduct;
import co.com.falabella.questions.ValidationProduct;
import co.com.falabella.questions.ValidationQuantity;
import co.com.falabella.tasks.HomeFalabellaTask;
import co.com.falabella.tasks.ProductsTask;
import co.com.falabella.tasks.QuantityTask;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.hamcrest.Matchers;


import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class buyStepDefinitions {
    @Before
    public void setStage() {

        setTheStage(new OnlineCast());
    }

    @Given("that user open page falabella and search any product")
    public void that_user_open_page_falabella_and_search_any_product() {
        theActorCalled("Usuario").wasAbleTo(
                Open.url("https://www.falabella.com.co/")
        );
    }

    @When("user clicks on the product title and chooses to add three of the product")
    public void user_clicks_on_the_product_title_and_chooses_to_add_three_of_the_product() {
        theActorInTheSpotlight().attemptsTo(
                HomeFalabellaTask.fromHome(),
                ProductsTask.products(),
                QuantityTask.num(),
                ClickCartProduct.name()
        );
    }

    @Then("user will confirm that it is the product and quantity chosen in the cart")
    public void user_will_confirm_that_it_is_the_product_and_quantity_chosen_in_the_cart() {
        theActorInTheSpotlight().should(
                seeThat(ValidationProduct.inCart(), Matchers.equalTo(true)
                ),
                seeThat(ValidationQuantity.numers(), Matchers.equalTo(true)
                ));
    }
}
