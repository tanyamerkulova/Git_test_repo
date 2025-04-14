package UI;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TextBoxTest {
//инициализация драйвера
    public WebDriver driver;
// подготовка драйверов
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, "eager");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
    }

//закрываем драйвер
    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void checkTextBox(){
        driver.get("https://demoqa.com/text-box");

        WebElement userNameInput = driver.findElement(By.xpath("//input[@id='userName']"));
        userNameInput.sendKeys("Maxim");

        WebElement userEmailInput = driver.findElement(By.xpath("//input[@id='userEmail']"));
        userEmailInput.sendKeys("Maxim@gmail.com");

        WebElement currentAddressTextArea = driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
        currentAddressTextArea.sendKeys("Kursk");

        WebElement permanentAddressTextArea = driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
        permanentAddressTextArea.sendKeys("Kursk");

        WebElement button = driver.findElement(By.xpath("//button[@id='submit']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", button);
        button.click();

        WebElement userNameOutput = driver.findElement(By.xpath("//p[@id='name']"));
        WebElement userEmailOutput = driver.findElement(By.xpath("//p[@id='email']"));
        WebElement currentAddressOutput = driver.findElement(By.xpath("//p[@id='currentAddress']"));
        WebElement permanentAddressOutput = driver.findElement(By.xpath("//p[@id='permanentAddress']"));

        String name = userNameOutput.getText();
        String email = userEmailOutput.getText();
        String currentAddress = currentAddressOutput.getText();
        String permanentAddress = permanentAddressOutput.getText();

        System.out.println(name + " " + email + " " + currentAddress + " " + permanentAddress);

//        Assert.assertTrue(name.contains("Maxim"), "Message");//содержит значения
        Assert.assertEquals(email,"Email:Maxim@gmail.com");//точное значение

//        try {
//            Thread.sleep(4000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

    }

    @Test
    public void checkTitleTextBox(){
        String pageTitle = driver.getTitle();
        System.out.println("Title : " + pageTitle);
    }

}
