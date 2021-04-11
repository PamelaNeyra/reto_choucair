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
import org.openqa.selenium.support.ui.Select;

import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.nio.file.Paths;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class TestCreateSteps {
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

    @Given("Navigate to Page Sign up")
    public void navigateToPageSignIn() {
        driver.navigate().to("http://automationpractice.com");
        driver.findElement(By.className("login")).click();
    }

    @When("A User enters an invalid email to create")
    public void aUserEntersANInvalidEmail(){
        driver.findElement(By.id("email_create")).sendKeys("pamela.neyra96");
    }

    @When("A User enters a valid email to create")
    public void aUsersAValidEmailToCreate(){
        driver.findElement(By.id("email_create")).sendKeys("pamela.neyra96@gmail.com");
    }

    @When("A User enters an existing email to create")
    public void aUserEntersAnExistingEmailToCreate(){
        driver.findElement(By.id("email_create")).sendKeys("pamela.neyra96@gmail.com");
    }

    @And("A User clicks on Create an Account button")
    public void aUserClicksOnCreateAnAccountButton() throws InterruptedException {
        driver.findElement(By.id("SubmitCreate")).click();
        Thread.sleep(5000);
    }

    @And("A User clicks on Register")
    public void aUserClicksOnRegister()  throws InterruptedException{
        driver.findElement(By.id("submitAccount")).click();
        Thread.sleep(5000);
    }

    @And("A User enters values to register")
    public void aUserEntersValuesToRegister() throws InterruptedException{
        driver.findElement(By.id("customer_firstname")).sendKeys("Pamela");
        driver.findElement(By.id("customer_lastname")).sendKeys("Neyra");
        driver.findElement(By.id("passwd")).sendKeys("Prueba2021");
        Select dia = new Select(driver.findElement(By.id("days")));
        dia.selectByValue("29");
        Select mes = new Select(driver.findElement(By.id("months")));
        mes.selectByValue("10");
        Select ano = new Select(driver.findElement(By.id("years")));
        ano.selectByValue("1996");
        driver.findElement(By.id("company")).sendKeys("UNMSM");
        driver.findElement(By.id("address1")).sendKeys("Lima-Peru");
        driver.findElement(By.id("city")).sendKeys("Lima");
        Select state = new Select(driver.findElement(By.id("id_state")));
        state.selectByValue("52");
        driver.findElement(By.id("postcode")).sendKeys("00000");
        Select country = new Select(driver.findElement(By.id("id_country")));
        country.selectByValue("21");
        driver.findElement(By.id("phone_mobile")).sendKeys("960758094");
        driver.findElement(By.id("alias")).sendKeys("Mi cuenta");
    }

    @Then("Application shows an error message to create")
    public void applicationShowsAnErrorMessage() {
        String actualMessage = driver.findElement(By.id("create_account_error")).getText();
        System.out.println("Message : " + actualMessage);
        assertThat(actualMessage.trim(), is("Invalid email address."));
    }

    @Then("Application shows an error message to register")
    public void applicationShowThePageToCreateAnAccount(){
        String actualMessage = driver.findElement(By.className("alert-danger")).getText();
        System.out.println("Message : " + actualMessage);
        assertThat(actualMessage.trim(), is("There are 8 errors\n" +
                "You must register at least one phone number.\n" +
                "lastname is required.\n" +
                "firstname is required.\n" +
                "passwd is required.\n" +
                "address1 is required.\n" +
                "city is required.\n" +
                "The Zip/Postal code you've entered is invalid. It must follow this format: 00000\n" +
                "This country requires you to choose a State."));
    }

    @Then("Application shows the page My account")
    public void applicationShowsThePageMyAccount(){
        String actualMessage = driver.findElement(By.className("page-heading")).getText();
        System.out.println("Message : " + actualMessage);
        assertThat(actualMessage.trim(), is("MY ACCOUNT"));
    }

    @Then("Application shows an error to an existing email")
    public void applicationShowsAnErrorToAnExistingEmail(){
        String actualMessage = driver.findElement(By.id("create_account_error")).getText();
        System.out.println("Message : " + actualMessage);
        assertThat(actualMessage.trim(), is("An account using this email address has already been registered. Please enter a valid password or request a new one."));
    }
}