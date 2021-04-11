package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.nio.file.Paths;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class TestLoginSteps {
    private WebDriver driver;
    Actor actorWeb =  Actor.named("actorWeb");

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                Paths.get("src/test/resources/driver2/chromedriver.exe").toString());
        if (driver == null) {
            driver = new ChromeDriver();
        }
        actorWeb.can(BrowseTheWeb.with(driver));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }

    @Given("Navigate to Page Sign in")
    public void navigateToPageSignIn() {
        driver.navigate().to("http://automationpractice.com");
        driver.findElement(By.className("login")).click();
    }

    @When("A User enters a valid email")
    public void aUserEntersAValidEmailId() {
        driver.findElement(By.id("email")).sendKeys("elva.neyra96@gmail.com");

    }

    @When("A User enters an invalid email")
    public void aUserEntersANInvalidEmail(){
        driver.findElement(By.id("email")).sendKeys("pamela.neyra96@gmail.com");
    }

    @When("A User enters an email")
    public void aUserEntersAnEmail(){
        driver.findElement(By.id("email")).sendKeys("pamela.neyra96@gmail.com");
    }

    @When("A User enters a password")
    public void aUserEntersAPassword(){
        driver.findElement(By.id("passwd")).sendKeys("123456");
    }

    @And("A User enters an invalid password")
    public void aUserEntersAnInvalidPassword(){
        driver.findElement(By.id("passwd")).sendKeys("123456");
    }

    @And("A User enters a valid password")
    public void aUserEntersAValidPassword(){
        driver.findElement(By.id("passwd")).sendKeys("Prueba2021");
    }

    @And("A User clicks on Sign in button")
    public void aUserClicksOnSinInButton() throws InterruptedException {
        driver.findElement(By.id("SubmitLogin")).click();
        Thread.sleep(5000);
    }

    @Then("Application shows an error message")
    public void applicationShowsAnErrorMessage() {
        String actualMessage = driver.findElement(By.className("alert-danger")).getText();
        System.out.println("Message : " + actualMessage);
        assertThat(actualMessage.trim(), is("There is 1 error\n" +
                "Authentication failed."));
    }

    @Then("Application shows an required email message")
    public void applicationShowsAnRequiredEmailMessage(){
        String actualMessage = driver.findElement(By.className("alert-danger")).getText();
        System.out.println("Message : " + actualMessage);
        assertThat(actualMessage.trim(), is("There is 1 error\n" +
                "An email address required."));
    }

    @Then("Application shows an required password message")
    public void applicationShowsAnRequiredPasswordMessage(){
        String actualMessage = driver.findElement(By.className("alert-danger")).getText();
        System.out.println("Message : " + actualMessage);
        assertThat(actualMessage.trim(), is("There is 1 error\n" +
                "Password is required."));
    }

    @Then("Application shows the user's account")
    public void applicationShowsTheUsersAccount() {
        String actualMessage = driver.findElement(By.className("page-heading")).getText();
        System.out.println("Message : " + actualMessage);
        assertThat(actualMessage.trim(), is("MY ACCOUNT"));
    }
}