package framework.webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import stepdefinition.SharedSD;

import java.util.List;

public class darkskyhomepage extends BasePage {

    private By DarkSkyAPI = By.linkText("Dark Sky API");
    private By RegisterButton = By.xpath("//button[contains(text(),'Register')]");
    private By SearchField = By.xpath("//form[@id='searchForm']//input");
    private By SearchIcon = By.xpath("//a[@class='searchButton']//img");
    private By allTempsFromTimeline = By.xpath("//div[@class='temps']//span//span[1]");
    private By getcurrentTemp = By.xpath("//span[@class='summary swap']");
    private By minTempsBeforExpansion = By.xpath("//span[@class='minTemp']");
    private By maxTempsBeforExpansion = By.xpath("//span[@class='maxTemp']");
    private By tempsAfterExpansion = By.xpath("//span[@class='temp']");
    private By timeIntervalsDarkSky = By.xpath("//div[@class=\"hours\"]//span//span");





    public List<WebElement> getAllTemps() {
        return webActions(allTempsFromTimeline);
    }

    public List<WebElement> getMinTempsBeforExapnsion(){
        return webActions(minTempsBeforExpansion);
    }


    public List<WebElement> getMaxTempsBeforExapnsion(){
        return webActions(maxTempsBeforExpansion);
    }



    public List<WebElement> tempsAfterExpansion (){
        return webActions(tempsAfterExpansion);
    }

    public List<WebElement> timeIntervalsDarkSky (){
        return webActions(timeIntervalsDarkSky);
    }




    public String getCurentTemp(){
       return getTextFromElement(getcurrentTemp);
    }







    public void clickOnDarkSkyApi(){
        clickOn(DarkSkyAPI);
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

    public void javaScriptExecutor (String value) throws InterruptedException{
        JavascriptExecutor js= (JavascriptExecutor) SharedSD.getDriver();

        js.executeScript("window.scrollBy(0,"+value+")", "");
        Thread.sleep(2000);
    }









}
