package framework.webPages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import stepdefinition.SharedSD;

import java.util.List;

public class HotelsHomePage extends BasePage    {

    private By popupclose = By.linkText("Continue to Hotels.com");
    private By destinationfield = By.id("qf-0q-destination");
    private By fivestarbutton = By.xpath("//input[@id='f-star-rating-5']");
    private By fourstarbutton = By.xpath("//input[@id='f-star-rating-4']");
    private By threestarbutton = By.xpath("//input[@id='f-star-rating-3']");
    private By infofooter = By.linkText("See all available hotels in New York, New York, United States Of America");
    private By hotelnames = By.xpath("//h3[@class='p-name']");
    private By hotelstarsinfo = By.xpath("//span[@class='star-rating-text star-rating-text-strong']");
    private By hotelstarsinfo3star = By.xpath("//span[@class='star-rating-text']");

    //Why is selenium not allowing moveactions By?
    //Why does selenium run if Webelement is defined here?

    //private By element = By.linkText("Distance");
    //private WebElement element = SharedSD.getDriver().findElement(By.linkText("Distance"));



    private By airport = By.linkText("John F. Kennedy International Airport (JFK)");
    private By airportafterClick = By.xpath("//a[@class='menu-trigger'][contains(text(),'John F. Kennedy International Airport (JFK)')]");
    private By hoteldistance = By.xpath("//div[@class='location-info resp-module distance-sort-applied']//ul[@class='property-landmarks']//li[1]");




    public void popupclose() throws InterruptedException{
//        try {
//            isElementDisplayed(popupclose);
            //clickOn(popupclose);
            //clickOn3(popupclose);
//        } catch (NoSuchElementException e){
//
//        }


    }


    public void searchDestinationField (){
        setValue(destinationfield, "New York City");
    }

    public void pressEnterForSearch(){
        pressEnter(destinationfield);
    }

    public void clickOn5Star(){
        clickOn(fivestarbutton);
    }

    public void clickOn4Star(){
        clickOn(fourstarbutton);
    }

    public void clickOn3Star(){
        clickOn(threestarbutton);
    }

    public void checkIfInfoFooterIsShown() throws InterruptedException{

        while (true){
            try{
                clickOn2(infofooter);
                break;
            } catch (NoSuchElementException e) {
                JavascriptExecutor js= (JavascriptExecutor) SharedSD.getDriver();
                js.executeScript("window.scrollBy(0,1500)");
                js.executeScript("window.scrollBy(0,-300)");

            }
        }






    }


    public void javaScriptExecutor (String value) throws InterruptedException{
        JavascriptExecutor js= (JavascriptExecutor) SharedSD.getDriver();

        //js.executeScript("window.scrollBy(0,"+value+")", "");
        js.executeScript("window.scrollBy(0,"+value+")");
        //Thread.sleep(2000);
    }


    public List<WebElement> gethotelnames() {
        return webActions(hotelnames);
    }

    public List<WebElement> gethotelstarinfo() {
        return webActions(hotelstarsinfo);
    }


    public List<WebElement> gethotel3starinfo() {
        return webActions(hotelstarsinfo3star);
    }


    public void actionsMoveToElement() {
        WebElement element = SharedSD.getDriver().findElement(By.linkText("Distance"));
        Actions actions = new Actions(SharedSD.getDriver());
        actions.moveToElement(element).build().perform();
        webAction(airport).click();


    }


//    public void clickOnJFKAirport (){


//                webAction(airport).click();
//                while(true) {
//                    try{
//                        String x = getTextFromElement(airportafterClick);
//                        if (x.equals("John F. Kennedy International Airport (JFK)")){
//                            break;
//                        }
//                    } catch (Exception e){

//                    }
                //}

//
//
      //  }





    public List<WebElement> gethoteldistance() {
        return webActions(hoteldistance);
    }




}
