import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class SimpleTest {

    private WebDriver driver=new ChromeDriver();
    private String userName;
    private String userPhone;



    @Test
    public void testMethod(){
        driver.get("http://37.59.228.229:3000/");
        driver.findElement(By.cssSelector("a.add-user ")).click();
        driver.findElement(By.cssSelector("div.main-content input#icon_prefix")).clear();
        driver.findElement(By.cssSelector("div.main-content input#icon_prefix")).sendKeys(userName);
        driver.findElement(By.cssSelector("div.main-content input#icon_telephone")).clear();
        driver.findElement(By.cssSelector("div.main-content input#icon_telephone")).sendKeys(userPhone);
        driver.findElement(By.cssSelector("div.main-content a.save-btn")).click();
        driver.get("http://37.59.228.229:3000/");
        List<WebElement> allUsers = driver.findElements(By.cssSelector("ul#user-list > li"));
        WebElement createUser = allUsers.get(allUsers.size() -1);
        String createUserName = createUser.findElement(By.cssSelector("h4")).getText();
        String createUserPhone = createUser.findElement(By.cssSelector("p")).getText();
        assertEquals(userName,createUserName);
        assertEquals(userPhone, createUserPhone);
}

    @After
    public void afterMethod(){
        driver.quit();
    }

    @Before
    public void beforeMethod(){
        userName = "Fsdr";
        userPhone = "123";
    }
}
