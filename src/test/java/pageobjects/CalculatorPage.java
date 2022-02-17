package pageobjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Helper;

public class CalculatorPage {

    public CalculatorPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//section//p//iframe")
    public WebElement calculator_iframe;

    @FindBy(xpath = "//mat-radio-button[@id='countKnownYes']")
    public WebElement countKnown_yes_radio;

    @FindBy(xpath = "//mat-radio-button[@id='countKnownNo']")
    public WebElement countKnown_no_radio;

    @FindBy(xpath = "//*[@role='listbox' and @id='buildingUse-panel']")
    public WebElement buildingUse_list;

    @FindBy(xpath = "//mat-select[@id='buildingUse']")
    public WebElement buildingUse_select;

    @FindBy(xpath = "//input[@id='occupantCount']")
    public WebElement occupantCount_input;

    @FindBy(xpath = "//*[@formarrayname='occupantDensities']")
    public WebElement occupantDensities_formArray;

    @FindBy(xpath = "//button[@id='reset']")
    public WebElement reset_button;

    @FindBy(xpath = "//button[@id='submit']")
    public WebElement submit_button;

    @FindBy(xpath = "//app-calculator/app-calculation-result")
    public WebElement calculator_result_mat_card;

    @FindBy(xpath = "//mat-card/div/div[contains(text(),'Option')]")
    public WebElement calculator_result_mat_card_option;

    public void inputText(String fieldLabel, String text){
        try{
            WebElement element = occupantDensities_formArray.findElement(By.xpath(".//span/label/mat-label[contains(text(),'"+fieldLabel+"')]//ancestor::div[contains(@class,'mat-form-field-infix')]//input"));
            element.click();
            element.sendKeys(new CharSequence[]{text});
        }
        catch(NoSuchElementException e){
            throw new NoSuchElementException("Input Field: '" + fieldLabel + "' not found!");
        }
    }

    public void selectBuildingUse(WebDriver driver, String building_use) throws InterruptedException {
        buildingUse_select.click();
        Helper.waitUntilVisibilityOf(driver, buildingUse_list, 1);
        WebElement element = buildingUse_list.findElement(By.xpath("//span[contains(text(),'" + building_use + "')]"));
        Helper.waitUntilVisibilityOf(driver, element, 3);
        element.click();
    }

    public void clickButton(WebDriver driver, WebElement element){
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }
}
