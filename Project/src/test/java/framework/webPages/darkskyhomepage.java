package framework.webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import stepdefinition.SharedSD;

import java.util.List;

public class darkskyhomepage extends BasePage {

    private By DarkSkyAPI = By.linkText("Dark Sky API");
    private By SignUpButton = By.partialLinkText("Sign");
    private By RegisterButton = By.xpath("//button[contains(text(),'Register')]");
    private By SearchField = By.xpath("//form[@id='searchForm']//input");
    private By SearchIcon = By.xpath("//a[@class='searchButton']//img");
    private By allTempsFromTimeline = By.xpath("//div[@class='temps']//span//span[1]");




    public List<WebElement> getAllTemps() {
        return webActions(allTempsFromTimeline);
    }

    public void clickOnDarkSkyApi(){
        clickOn(DarkSkyAPI);
    }

    public void clickOnSignUp(){
        clickOn(SignUpButton);
    }

    public void clickOnRegister(){
        clickOn(RegisterButton);
    }

    public void searchForCity() {
        clearSearchField(SearchField);
        setValue(SearchField, "LosAngeles");

    }

    public void clickOnSearchIcon(){
        clickOn(SearchIcon);
    }









}
