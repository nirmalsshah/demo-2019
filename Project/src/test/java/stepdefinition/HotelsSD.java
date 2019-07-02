package stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.webPages.HotelsHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.*;

public class HotelsSD {


    private HotelsHomePage hotels = new HotelsHomePage();


    @Given("^I am on default locations search result screen$")
    public void iAmOnDefaultLocationsPage() throws InterruptedException {
        //hotels.popupclose();
        hotels.searchDestinationField();
        hotels.pressEnterForSearch();
    }


    @When("^I select property class (.+)$")
    public void selectHotelStar(String hotelstar) throws InterruptedException {


        switch (hotelstar) {
            case "5 stars":
                hotels.clickOn5Star();
                break;


            case "4 stars":
                hotels.clickOn4Star();
                break;

            case "3 stars":
                hotels.clickOn3Star();
                break;

        }

    }


    @Then("^I verify system displays only (.+) hotels on search result$")
    public void checkingOnlySelectedStarHotelIsDisplayed(String hotelstar) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) SharedSD.getDriver();

        switch (hotelstar) {

            case "5 stars":

                hotels.checkIfInfoFooterIsShown();


                ArrayList<Integer> tests = new ArrayList<>();
//                Set<Integer>tests = new HashSet<>();


                List<WebElement> hotelstars = hotels.gethotelstarinfo();


                for (int i = 0; i < hotelstars.size(); i++) {
                    String x = hotelstars.get(i).getText();
                    int y = x.indexOf("-");
                    int z = Integer.parseInt(x.substring(0, y));
                    tests.add(z);


                }


                for (int test : tests) {
                    Assert.assertTrue(test == 5);

                }

                break;


            case "4 stars":


                hotels.checkIfInfoFooterIsShown();

                ArrayList<Double> tests2 = new ArrayList<Double>();
//                Set<Double>tests2 = new HashSet<>();
//
                List<WebElement> hotelstars2 = hotels.gethotelstarinfo();


                for (int i = 0; i < hotelstars2.size(); i++) {
                    String x = hotelstars2.get(i).getText();
                    int y = x.indexOf("-");
                    double z = Double.parseDouble(x.substring(0, y));
                    tests2.add(z);


                }

                System.out.println(tests2);

                for (double test : tests2) {

                    Assert.assertTrue(test >= 4 || test <= 4.9);


                }

                break;


            case "3 stars":


                hotels.checkIfInfoFooterIsShown();

                ArrayList<Double> tests3 = new ArrayList<Double>();
//                Set<Double>tests3 = new HashSet<>();

                List<WebElement> hotelstars3 = hotels.gethotel3starinfo();


                for (int i = 0; i < hotelstars3.size(); i++) {
                    String x = hotelstars3.get(i).getText();
                    int y = x.indexOf("-");
                    double z = Double.parseDouble(x.substring(0, y));
                    tests3.add(z);
                }


                System.out.println(tests3);

                for (double test : tests3) {

                    Assert.assertTrue(test >= 3 || test <= 3.9);

                }

                break;


        }


    }


    Set<String> hotels10milesfromairport = new HashSet<>();

    @Then("^I verify system displays all hotels within (.+) miles radius of airport$")
    public void verifying10MileRadius(double value) throws InterruptedException {

        hotels.actionsMoveToElement();
        //hotels.clickOnJFKAirport();
        hotels.checkIfInfoFooterIsShown();

        List<WebElement> hoteldistance = hotels.gethoteldistance();
        List<WebElement> hotelnames = hotels.gethotelnames();
        //Set<String> hotels10milesfromairport = new HashSet<>();

        for (int i = 0; i < hoteldistance.size(); i++) {


            String x = hoteldistance.get(i).getText();
            int getindexofspace = x.indexOf(" ");
            double y = Double.parseDouble(x.substring(0, getindexofspace));

            if (y <= value) {
                hotels10milesfromairport.add(hotelnames.get(i).getText());
            }


        }

        if (hotels10milesfromairport.size() == 0) {
            System.out.println("There are no 5 stars hotels within 10 miles of the airport");
        } else {
            System.out.println("List of Hotels within " + value + " miles of Airport :");
            System.out.println(hotels10milesfromairport);
        }


    }


    @And("^I verify Hilton Hotel is within radius$")
    public void verifyIfHiltonIsPartOfList() {


        for (String z : hotels10milesfromairport) {
            if (hotels10milesfromairport.size() == 0) {
                System.out.println("There are no 5 stars hotels within requested mile range of the airport and therefore there is no list created.");
            } if (z.contains("Hilton")) {
                System.out.println("Hilton hotel is part of the list");
            }
//            else {
//                System.out.println("Hilton is not part of the list");
//            }

        }




    }
}
