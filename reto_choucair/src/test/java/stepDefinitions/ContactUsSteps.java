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

public class ContactUsSteps {
    private WebDriver driver;
    Actor actorWeb = Actor.named("actorWeb");

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

    @Given("Navigate to Page Contact Us")
    public void navigateToPageContactUs(){
        driver.navigate().to("http://automationpractice.com");
        driver.findElement(By.id("contact-link")).click();
    }

    @When("A User enters values to send")
    public void aUserEntersValuesToSend(){
        Select contact = new Select(driver.findElement(By.id("id_contact")));
        contact.selectByValue("1");
        driver.findElement(By.id("email")).sendKeys("pamela.neyra96@gmail.com");
        driver.findElement(By.id("id_order")).sendKeys("123");
        driver.findElement(By.id("message")).sendKeys("Mensaje de prueba");
    }

    @When("A User clicks on Send button")
    public void aUserClicksOnSendButton() throws InterruptedException{
        driver.findElement(By.id("submitMessage")).click();
        Thread.sleep(5000);
    }

    @When("A User enters values to send but not a message")
    public void aUserEntersValuesToSendButNotaMessage(){
        Select contact = new Select(driver.findElement(By.id("id_contact")));
        contact.selectByValue("1");
        driver.findElement(By.id("email")).sendKeys("pamela.neyra96@gmail.com");
        driver.findElement(By.id("id_order")).sendKeys("123");
    }

    @When("A User enters values to send but not a subject")
    public void aUserEntersValuesToSendButNotASubject(){
        driver.findElement(By.id("email")).sendKeys("pamela.neyra96@gmail.com");
        driver.findElement(By.id("id_order")).sendKeys("123");
        driver.findElement(By.id("message")).sendKeys("Mensaje de prueba");
    }

    @And("A User clicks on Send button 2")
    public void aUserClicksOnSendButton2() throws InterruptedException{
        driver.findElement(By.id("submitMessage")).click();
        Thread.sleep(5000);
    }

    @Then("Application shows an error message to Send")
    public void applicationShowsAnErrorMessageToSend(){
        String actualMessage = driver.findElement(By.className("alert-danger")).getText();
        System.out.println("Message : " + actualMessage);
        assertThat(actualMessage.trim(), is("There is 1 error\n" +
                "Invalid email address."));
    }

    @Then("Application shows a success message")
    public void applicationShowsASuccessMessage(){
        String actualMessage = driver.findElement(By.className("alert-success")).getText();
        System.out.println("Message : " + actualMessage);
        assertThat(actualMessage.trim(), is("Your message has been successfully sent to our team."));
    }

    @Then("Application shows an error message in blank")
    public void applicationShowsAnErrorMessageInBlank(){
        String actualMessage = driver.findElement(By.className("alert-danger")).getText();
        System.out.println("Message : " + actualMessage);
        assertThat(actualMessage.trim(), is("There is 1 error\n" +
                "The message cannot be blank."));
    }

    @Then("Application shows an error message without a subject")
    public void applicationShowsAnErrorWithoutSubject(){
        String actualMessage = driver.findElement(By.className("alert-danger")).getText();
        System.out.println("Message : " + actualMessage);
        assertThat(actualMessage.trim(), is("There is 1 error\n" +
                "Please select a subject from the list provided."));
    }
}