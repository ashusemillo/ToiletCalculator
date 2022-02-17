package gluecode;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.CalculatorPage;
import utils.ConfigManager;
import utils.Helper;

import java.util.Map;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class CalculatorPageStepDefs {
    private CalculatorPage calculatorPage;
    private WebDriver driver = null;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
    }

    @Given("user navigates to toilet calculator")
    public void user_navigates_to_toilet_calculator() {
        driver.get(ConfigManager.instance().getByKey("APP_URL"));
        driver.manage().window().maximize();

    }

    @Given("user do not know building occupancy")
    public void user_do_not_know_building_occupancy() {
        calculatorPage = new CalculatorPage(driver);
        Helper.scrollIntoView(driver, calculatorPage.calculator_iframe);
        Helper.waitUntilVisibilityOf(driver, calculatorPage.calculator_iframe, 5);
        driver.switchTo().frame(calculatorPage.calculator_iframe);
        calculatorPage.countKnown_no_radio.click();
    }

    @Given("user knows building use is for {string}")
    public void user_knows_building_use_is_for(String building_use) throws InterruptedException {
        calculatorPage.selectBuildingUse(driver, building_use);
        Helper.waitUntilVisibilityOf(driver, calculatorPage.occupantDensities_formArray, 5);
    }

    @When("user enters the space details to calculate occupant densities")
    public void user_enters_the_space_details_to_calculate_occupant_densities(DataTable dataTableForHospital) {
        Map<String, String> columns = dataTableForHospital.asMap(String.class, String.class);
            columns.forEach((fieldLabel,text)->{calculatorPage.inputText(fieldLabel, text);});
    }


    @Then("number of toilet facilities should be calculated")
    public void numberOfToiletFacilitiesShouldBeCalculated() {
        calculatorPage.submit_button.click();
        //calculatorPage.clickButton(driver, calculatorPage.submit_button);
        Helper.waitUntilVisibilityOf(driver, calculatorPage.calculator_result_mat_card, 5);
    }

    @And("one or more options to recommend should be displayed")
    public void oneOrMoreOptionsToRecommendShouldBeDisplayed() {
        assertThat(calculatorPage.calculator_result_mat_card_option.getText(), containsString("Option"));
    }

    @After
    public void tidyUp() {
        if(driver != null)
            driver.close();
    }
}
