package com.example.Iths;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class RunCucumberTest {

        static WebDriver driver;

    @BeforeEach
    @Given("I am on the IT-Högskolan website")
    public void setup(){
        driver = new ChromeDriver();
        driver.get("https://www.iths.se");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        try {
            WebElement cookieRejectButton = driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll"));
            cookieRejectButton.click();
        }
        catch (NoSuchElementException e) {
            System.out.println("Cookie accept button not found, continue without dismissing");
        }
    }

    @After
    public void tearDown () {
        if (driver != null) {
            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
                wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
            } catch (TimeoutException e) {
                System.out.println("Timeout waiting for page to load.");
            }
            driver.quit();
        }
    }

    @Then("I check the website title , the title should match")
    public void verify_website_title() {
        String websiteTitle = driver.getTitle();
        Assertions.assertEquals("IT-Högskolan – Här startar din IT-karriär!", websiteTitle, "Title does not match");
    }


    @When("I click on spring information meetings")
    public void verify_spring_information_meetings_link() {
        WebElement spring_information = driver.findElement(By.className("banner__text"));
        spring_information.click();
    }

    @Then("I should be navigated to spring information meetings page")
    public void verify_title_of_spring_information_meetings_page() {
        String spring_informationTitle = driver.getTitle();
        Assertions.assertEquals("Välkommen till vårens informationsträffar | IT-Högskolan", spring_informationTitle, "Title does not match");

    }

    @When("I click the previous arrow")
    public void verify_the_previous_arrow() {
        WebElement previous_arrow = driver.findElement(By.className("slick-prev"));
        previous_arrow.click();
    }

    @Then("previous student review should be displayed")
    public void previous_studentReview_displayed() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element_changed = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='qoute-slider']//div[@class='post-slider quotes slick-initialized slick-slider']/div/div[@class='slick-track']/div[contains(@class, 'slick-slide')]")));

        boolean new_element = element_changed.isDisplayed();
        Assertions.assertTrue(new_element);

    }

    @When("I toggle the mobile menu")
    public void verify_mobile_toggle() {
        driver.manage().window().minimize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement menu = driver.findElement(By.id("mobile-toggle"));

        try {
            menu.click();
        } catch (org.openqa.selenium.ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", menu);
        }
    }

    @Then("the primary navigation menu should be displayed")
    public void check_the_primary_navigation_menu_display() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement elementAfterClick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("menu-primary-navigation")));
        assert elementAfterClick.isDisplayed() : "Element did not appear after clicking the button";
    }

    @When("I click the education button")
    public void verify_education_button() {
        WebElement educationbutton = driver.findElement(By.xpath("//*[text()='Alla utbildningar']"));
        educationbutton.click();
    }

    @Then("I should be navigated to education page")
    public void the_title_of_the_education_page_should_match() {
        String educationTitle = driver.getTitle();
        Assertions.assertEquals("Utbildningar | iths.se", educationTitle, "Title does not match");
    }

    @When("I click on the education button")
    public void check_education_button() {
        WebElement educationbutton = driver.findElement(By.xpath("//*[text()='Alla utbildningar']"));
        educationbutton.click();
    }

    @And("I click the form of education button")
    public void form_of_education_button() {
        WebElement dropdown = driver.findElement(By.id("sitesDropdown"));
        dropdown.click();
    }

    @Then("the education dropdown should be displayed")
    public void display_education_dropdown() {
        WebElement dropdown = driver.findElement(By.id("sitesDropdown"));
        boolean Expected_dropdown = dropdown.isDisplayed();
        Assertions.assertTrue(Expected_dropdown);
    }

    @When("I click the application button")
    public void application_button() {
        WebElement apply = driver.findElement(By.id("nav-anskhr"));
        apply.click();
    }

    @Then("I should be navigated to application page")
    public void verify_application_page_title() {
        String applicationTitle = driver.getTitle();
        Assertions.assertEquals("Ansökan | IT-Högskolan", applicationTitle, "Title does not match");
    }

    @When("I click the how to apply button")
    public void about_page_button() {
        WebElement how_to_apply_button = driver.findElement(By.id("nav-hurduansker"));
        how_to_apply_button.click();
    }

    @Then("I should be navigated to how to apply page")
    public void about_page_title() {
        String aboutPageTitle = driver.getTitle();
        Assertions.assertEquals("IT-Högskolan - Om skolan – Här startar din IT-karriär!", aboutPageTitle, "Title does not match");
    }

    @When("I click on the how to apply button")
    public void verify_about_page_button() {
        WebElement aboutPage_button = driver.findElement(By.id("nav-hurduansker"));
        aboutPage_button.click();
    }

    @When("I play the video on that page")
    public void video() {
        WebElement videoplay_button = driver.findElement(By.className("video-link"));
        videoplay_button.click();
    }

    @Then("the video should be played")
    public void play_video() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement elementAfterClick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html//div[@id='page']//a[@href='https://www.youtube.com/embed/W5vzpwbGWJA?rel=0&autoplay=1']")));
        assert elementAfterClick.isDisplayed() : "Element did not appear after clicking the button";
    }

    @When("I click the news button")
    public void news_button() {
        WebElement aboutPage_button = driver.findElement(By.id("nav-nyheter"));
        aboutPage_button.click();
    }

    @Then("the filter options will be displayed, I filter it to gothenberg")
    public void the_filter_options_should_be_displayed() {
        WebElement filter = driver.findElement(By.xpath("/html//section[@id='course-filter-bar']//a[@href='https://www.iths.se/category/goteborg/']"));
        filter.click();
    }

    @Then("i should get gothenberg news")
    public void verify_gothenberg_news_page() {
        String filterTitle = driver.getTitle();
        Assertions.assertEquals("Göteborg-arkiv | IT-Högskolan", filterTitle, "Title does not match");
    }

    @When("I click for Students button")
    public void i_click_for_students_button() {
        WebElement forStudents_button = driver.findElement(By.id("nav-frstuderande"));
        forStudents_button.click();
    }
    @Then("I should be navigated to Your IT career starts here page")
    public void i_should_be_navigated_to_your_it_career_starts_here_page() {
        String forStudentsTitle = driver.getTitle();
        Assertions.assertEquals("Your IT career starts here |  IT University!", forStudentsTitle, "Title does not match");
    }

}
