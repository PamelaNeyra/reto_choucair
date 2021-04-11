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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class TestPurchaseOrderSteps {
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

    @Given("Navigate to Page Shop")
    public void navigateToPageShop(){
        driver.navigate().to("http://automationpractice.com");
    }

    @When("A User Sign in")
    public void aUserSignIn() throws InterruptedException{
        driver.findElement(By.className("login")).click();
        driver.findElement(By.id("email")).sendKeys("elva.neyra96@gmail.com");
        driver.findElement(By.id("passwd")).sendKeys("Prueba2021");
        driver.findElement(By.id("SubmitLogin")).click();
        Thread.sleep(5000);
    }

    @And("A User adds an item to cart")
    public void aUserAddsAnItemToCart() throws InterruptedException{
        driver.navigate().to("http://automationpractice.com/index.php?id_product=1&controller=product");
        Thread.sleep(5000);
        driver.navigate().to("http://automationpractice.com/index.php?controller=order");
        driver.findElement(By.className("continue")).click();
        driver.findElement((By.className("standard-checkout"))).click();
    }
}