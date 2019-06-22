package stepdefinition;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.webPages.darkskyhomepage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.text.SimpleDateFormat;
import java.util.*;


public class darkskySD {

    private darkskyhomepage ds = new darkskyhomepage();

    @Given("^I am on Darksky Home Page$")
    public void iAmOnDarkSkyPage(){
        Assert.assertTrue(SharedSD.getDriver().getCurrentUrl().contains("https://darksky.net/"));
    }


    @Given("^I am on the darksky Register page$")
    public void verifyIamOnDarkSkyPage() throws InterruptedException{
        ds.clickOnDarkSkyApi();
        Thread.sleep(2000);
        ds.clickOnSignUp();
        Thread.sleep(2000);
    }


    @When("^I click on Register button$")
    public void IClickOnRegisterButton(){
        ds.clickOnRegister();
    }

    @Then("^I verify error message \"please fill out this field\"$")
    public void IVerifyErrorMessage(){
        Assert.assertEquals(SharedSD.getDriver().getTitle(), "Dark Sky API: Register");

    }


    @Then("^I verify current temp is not greater or less then temps from daily timeline$")
    public void iVerifyCurrentTempIsNotGreaterOrLessThenTempsFromDailyTimeline(){

        //List<WebElement> temps = SharedSD.getDriver().findElements(By.xpath("//div[@class='temps']//span//span[1]"));
        List<WebElement> temps = ds.getAllTemps();


        ArrayList<String> listString = new ArrayList<String>();
        ArrayList<Integer> listInt = new ArrayList<Integer>();

        for (int i =0; i<12; i++){
            //System.out.println(temps.get(i).getText());temps.get(i).getText()
            String tempStr = temps.get(i).getText();
            //listString.add(tempStr.substring(0, tempStr.length()-1));
            listInt.add(Integer.valueOf(tempStr.substring(0, tempStr.length()-1)));
            //7 - 0 ** 2  (0,2-1) (0,1) 0
            //77 - 0,1 ** 3 (0,3-1) (0,2) 0,1
            //100 - 0,1,2 ** 4 (0,4-1) (0,3) 0,1,2
            //-1 - 0,1 ** 3 (0,3-1) (0,2) 0,1

        }



        for  (int i=0; i<listString.size();i++){
            listInt.add(Integer.parseInt(listString.get(i)));
        }

        System.out.println("Temperature range displayed on screen : " +listInt);

        System.out.println("Minimum value of Temperature Range: " + Collections.min(listInt));
        System.out.println("Maximum value of Temperature Range: " + Collections.max(listInt));

        WebElement getcurrentTemp = SharedSD.getDriver().findElement(By.xpath("//span[@class='summary swap']"));

        int currentTemp = Integer.parseInt(getcurrentTemp.getText().substring(0,2));

        System.out.println("Current Temp is: " +currentTemp);


        Assert.assertTrue(currentTemp>=Collections.min(listInt));
        Assert.assertTrue(currentTemp<=Collections.max(listInt));

    }



    @When("^I expand today's timeline$")
    public void iExpandTimeLine() throws InterruptedException{

        JavascriptExecutor js= (JavascriptExecutor) SharedSD.getDriver();

        js.executeScript("window.scrollBy(0,800)", "");
        Thread.sleep(2000);

        List<WebElement> minTempBefore = SharedSD.getDriver().findElements(By.xpath("//span[@class='minTemp']"));

        minTempBefore.get(0).click();
        Thread.sleep(2000);

        }




    @Then("^I verify lowest and highest temp is displayed correctly$")
    public void verifyLowestHighestTemp(){

        List<WebElement> minTempBeforeList = SharedSD.getDriver().findElements(By.xpath("//span[@class='minTemp']"));

        String minTempBeforeExpansion = minTempBeforeList.get(0).getText();
        System.out.println("Min before expansion :" + minTempBeforeExpansion);

        List<WebElement> maxTempBeforeList = SharedSD.getDriver().findElements(By.xpath("//span[@class='maxTemp']"));
        String maxTempBeforeExpansion = maxTempBeforeList.get(0).getText();
        System.out.println("Max before expansion :" + maxTempBeforeExpansion);



        List<WebElement> tempAfterExpansion = SharedSD.getDriver().findElements(By.xpath("//span[@class='temp']"));

        String minTempAfter = tempAfterExpansion.get(0).getText();
        System.out.println("Min after expansion :" +minTempAfter);

        String maxTempAfter = tempAfterExpansion.get(1).getText();
        System.out.println("Max after expansion:" +maxTempAfter);

        Assert.assertEquals(minTempBeforeExpansion,minTempAfter);
        Assert.assertEquals(maxTempBeforeExpansion,maxTempAfter);



    }


    @Then("^I verify timeline is displayed with (\\d+) hours incremented for (NewYork|LosAngeles)$")
    public void verifyTwoHourIncrement(int hourdiff, String cityname) throws InterruptedException{

        //Date date = new Date();
        Date date;
        SimpleDateFormat formatter = new SimpleDateFormat("ha");
        Calendar cl = Calendar.getInstance();

        switch (cityname) {

            case "NewYork":



                date = cl.getTime();
                String currentTime = formatter.format(date).toLowerCase();
                System.out.println("Current hour in " +cityname + " is " + currentTime);

                break;


            case "LosAngeles":


                formatter.setTimeZone(TimeZone.getTimeZone("America/Los_Angeles"));
                //cl = Calendar.getInstance();
                date = cl.getTime();
                currentTime = formatter.format(date).toLowerCase();
                System.out.println("Current hour in " +cityname + " is " + currentTime);

                ds.searchForCity() ;
                ds.clickOnSearchIcon();
                Thread.sleep(2000);
                break;

        }


        ArrayList<String> timeInterval = new ArrayList<String>();
        timeInterval.add("Now");

        for (int i = 0; i <= 10; i++) {
            cl.add(Calendar.HOUR_OF_DAY, hourdiff);
            date = cl.getTime();
            String TimeAfterTwoHours = formatter.format(date).toLowerCase();
            timeInterval.add(TimeAfterTwoHours);
            //System.out.println("Time After 2 hour is " +TimeAfterTwoHours);

        }

        System.out.println("Array 1: From Calendar : " +timeInterval);




        List<WebElement> timeIntervalsDarkSky = SharedSD.getDriver().findElements(By.xpath("//div[@class=\"hours\"]//span//span"));

        ArrayList<String> timeIntervalWebsite = new ArrayList<String>();

        for (int i =0; i<=11; i++){
            timeIntervalWebsite.add(timeIntervalsDarkSky.get(i).getText());
        }

        System.out.println("Array 2: From DarkSky  : " +timeIntervalWebsite);

        boolean areTwoArraysEqual = timeInterval.equals(timeIntervalWebsite);
        Assert.assertTrue(areTwoArraysEqual, "Timeline is not as expected");
        System.out.println("Are both arrays equal ? " +areTwoArraysEqual);

        if (areTwoArraysEqual){
            System.out.println("Since 2 arrays are equal, we can confirm timeline is incremented at 2 hour interval");
        }





    }





}














