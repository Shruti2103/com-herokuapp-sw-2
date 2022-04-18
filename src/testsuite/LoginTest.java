package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseurl = "http://the-internet.herokuapp.com/login";

    // click on login link
    @Before
    public void set() {
        openbrowser(baseurl);
    }

    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials() {
        // find login click and click on login click
     //   WebElement loginlink = driver.findElement(By.xpath("//i[contains(text(),'Login')]"));
      //  loginlink.click();
        // find emailfield
        WebElement emailfield = driver.findElement(By.xpath("//input[@id='username']"));
        emailfield.sendKeys("tomsmith");
        //find password field
        WebElement passwordfield = driver.findElement(By.xpath("//input[@id='password']"));
        passwordfield.sendKeys("SuperSecretPassword!");
        //click on login button
        WebElement loginbtn = driver.findElement(By.xpath("//i[contains(text(),'Login')]"));
        loginbtn.click();
        // varify login button
        String expectedMessage = "Secure Area";
        WebElement actualMessage = driver.findElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/h2[1]"));
        String actualMessage1 = actualMessage.getText();
        //varify
        Assert.assertEquals("login sucessful", expectedMessage, actualMessage1);


    }
    @Test
    public void verifyTheUsernameErrorMessage(){
        //user name enter
        WebElement username=driver.findElement(By.xpath("//input[@id='username']"));
        username.sendKeys("tomsmith1");
        //password enter
        WebElement password=driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("SuperSecretPassword!");
        //login button
        WebElement loginbtn=driver.findElement(By.xpath("//i[contains(text(),'Login')]"));
        loginbtn.click();
        // varify assert message
        String expextedmessage="Your username is invalid!\n" +
                "×";

        WebElement actualmessage=driver.findElement(By.xpath("//div[@id='flash']"));
        actualmessage.getText();
        String actualmessage1=actualmessage.getText();
        //ascerting actual and expected
        Assert.assertEquals("Your userNmae is invalid",expextedmessage,actualmessage1);

    }
    @Test
    public void verifyThePasswordErrorMessage(){

      // user name
        WebElement username= driver.findElement(By.xpath("//input[@id='username']"));
        username.sendKeys("tomsmith");
        // invalid password field
        WebElement passwordfield=driver.findElement(By.xpath("//input[@id='password']"));
        passwordfield.sendKeys("SuperSecretPassword");
        //log in button
        WebElement loginbtn=driver.findElement(By.xpath("//i[contains(text(),'Login')]"));
        loginbtn.click();
        // varify error message
        String expextederrormsg="Your password is invalid!\n" +
                "×";
        WebElement actualmessage=driver.findElement(By.xpath("//div[@id='flash']"));
        String actualmessage1=actualmessage.getText();
        //varify actual and expected message
        Assert.assertEquals("Your password is invalid",expextederrormsg,actualmessage1);





    }
    @After
    public void testdown(){
        closebrowser();
    }


}
