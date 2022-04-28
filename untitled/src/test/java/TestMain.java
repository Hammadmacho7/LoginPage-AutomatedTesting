import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.*;


public class TestMain {


    private static final String chromeDriverPath = "chromedriver";
    private final String LoginURL = "http://localhost:63342/loginpage-selenium/loginpage.html?_ijt=c9s5gibvs260c6qlm42mfd9sok&_ij_reload=RELOAD_ON_SAVE";
    private final By loginButtonXPath = By.xpath("//button[contains(text(), 'Submit')]");

    private final String validEmail = "hammad@gmail.com";
    private final String validPassword = "KingKhan+78";

    private final String idInputXPath = "//input[@placeholder='Email']";
    private final String passwordInputXPath = "//input[@placeholder='password']";

    static{
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
    }

    private ChromeDriver createInvisibleChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless");
        return new ChromeDriver(options);
    }

    private boolean isTextPresent(String text, ChromeDriver driver){
        try{
            boolean b = driver.getPageSource().contains(text);
            return b;
        }
        catch(Exception e){
            return false;
        }
    }

    @Test
    public void pageResponseWhenPartialUsernameEntered(){
        ChromeDriver driver = createInvisibleChromeDriver();
        driver.get("http://localhost:63342/loginpage-selenium/loginpage.html?_ijt=c9s5gibvs260c6qlm42mfd9sok&_ij_reload=RELOAD_ON_SAVE");

        driver.findElement(By.name("submit"));
        WebElement email = driver.findElement(By.name("email"));
        email.clear();
        email.sendKeys("Hammad@");
        StringBuffer verificationErrors = new StringBuffer();
        driver.findElement(By.name("submit")).click();
        try {
            assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Please enter a part following '@'. 'Hammad@' is incomplete.[\\s\\S]*$"));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    @Test
    public void pageResponseWhenNoAtEntered(){
        ChromeDriver driver = createInvisibleChromeDriver();
        driver.get("http://localhost:63342/loginpage-selenium/loginpage.html?_ijt=c9s5gibvs260c6qlm42mfd9sok&_ij_reload=RELOAD_ON_SAVE");

        driver.findElement(By.name("submit"));
        WebElement email = driver.findElement(By.name("email"));
        email.clear();
        email.sendKeys("Hammad786");

        StringBuffer verificationErrors = new StringBuffer();
        driver.findElement(By.name("submit")).click();
        try {
            assertTrue(driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Please include an '@' in the email address. 'Hammad' is missing an '@'.[\\s\\S]*$"));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    @Test
    public void passwordlengthSmallerThanEight() {
        ChromeDriver driver = createInvisibleChromeDriver();
        driver.get("http://localhost:63342/loginpage-selenium/loginpage.html?_ijt=c9s5gibvs260c6qlm42mfd9sok&_ij_reload=RELOAD_ON_SAVE");

        WebElement email = driver.findElement(By.name("email"));
        WebElement password = driver.findElement(By.name("password"));
        email.clear();
        password.clear();

        email.sendKeys("Hammad786@gmail.com");
        password.sendKeys("Kin78+@");
        driver.findElement(By.name("submit")).click();
        String alertMessage = driver.switchTo().alert().getText();
        System.out.print(alertMessage);
        String check = "password length must be more than 8";
        assertEquals(alertMessage, check);
    }

    @Test
    public void passwordMustHaveLowerCase() {
        ChromeDriver driver = createInvisibleChromeDriver();
        driver.get("http://localhost:63342/loginpage-selenium/loginpage.html?_ijt=c9s5gibvs260c6qlm42mfd9sok&_ij_reload=RELOAD_ON_SAVE");

        WebElement email = driver.findElement(By.name("email"));
        WebElement password = driver.findElement(By.name("password"));
        email.clear();
        password.clear();

        email.sendKeys("Hammad786@gmail.com");
        password.sendKeys("KIN780HKM");
        driver.findElement(By.name("submit")).click();
        String alertMessage = driver.switchTo().alert().getText();
        System.out.print(alertMessage);
        String check = "Password must contain a lower case letter";
        assertEquals(alertMessage, check);
    }

    @Test
    public void passwordMustHaveUpperCase() {
        ChromeDriver driver = createInvisibleChromeDriver();
        driver.get("http://localhost:63342/loginpage-selenium/loginpage.html?_ijt=c9s5gibvs260c6qlm42mfd9sok&_ij_reload=RELOAD_ON_SAVE");

        WebElement email = driver.findElement(By.name("email"));
        WebElement password = driver.findElement(By.name("password"));
        email.clear();
        password.clear();
        email.sendKeys("Hammad786@gmail.com");
        password.sendKeys("kin780hkm");
        driver.findElement(By.name("submit")).click();
        String alertMessage = driver.switchTo().alert().getText();
        String check = "Password must contain an upper case letter";
        assertEquals(alertMessage, check);
    }

    @Test
    public void passwordMustHaveNumericDigit() {
        ChromeDriver driver = createInvisibleChromeDriver();
        driver.get("http://localhost:63342/loginpage-selenium/loginpage.html?_ijt=c9s5gibvs260c6qlm42mfd9sok&_ij_reload=RELOAD_ON_SAVE");

        WebElement email = driver.findElement(By.name("email"));
        WebElement password = driver.findElement(By.name("password"));
        email.clear();
        password.clear();
        email.sendKeys("Hammad786@gmail.com");
        password.sendKeys("Kingkhan++@");
        driver.findElement(By.name("submit")).click();
        String alertMessage = driver.switchTo().alert().getText();
        System.out.print(alertMessage);
        String check = "Password must contain a numeric digit";
        assertEquals(alertMessage, check);
    }

    @Test
    public void passwordMustCanOnlyContainPLusOrAtSpecialChars() {
        ChromeDriver driver = createInvisibleChromeDriver();
        driver.get("http://localhost:63342/loginpage-selenium/loginpage.html?_ijt=c9s5gibvs260c6qlm42mfd9sok&_ij_reload=RELOAD_ON_SAVE");

        WebElement email = driver.findElement(By.name("email"));
        WebElement password = driver.findElement(By.name("password"));
        email.clear();
        password.clear();
        email.sendKeys("Hammad786@gmail.com");
        password.sendKeys("King%khan07_!!!!---");
        driver.findElement(By.name("submit")).click();
        String alertMessage = driver.switchTo().alert().getText();
        System.out.print(alertMessage);
        String check = "Password must contain only '@' and '+' special characters";
        assertEquals(alertMessage, check);
    }

    @Test
    public void passwordMustCannothaveSpaces() {
        ChromeDriver driver = createInvisibleChromeDriver();
        driver.get("http://localhost:63342/loginpage-selenium/loginpage.html?_ijt=c9s5gibvs260c6qlm42mfd9sok&_ij_reload=RELOAD_ON_SAVE");
        WebElement email = driver.findElement(By.name("email"));
        WebElement password = driver.findElement(By.name("password"));
        email.clear();
        password.clear();
        email.sendKeys("Hammad786@gmail.com");
        password.sendKeys("Kingkhan786 +@gahnwe");
        driver.findElement(By.name("submit")).click();
        String alertMessage = driver.switchTo().alert().getText();
        System.out.print(alertMessage);
        String check = "No blank spaces";
        assertEquals(alertMessage, check);
    }

    @Test
    public void successfulLogin() {
        ChromeDriver driver = createInvisibleChromeDriver();
        driver.get("http://localhost:63342/loginpage-selenium/loginpage.html?_ijt=c9s5gibvs260c6qlm42mfd9sok&_ij_reload=RELOAD_ON_SAVE");

        WebElement email = driver.findElement(By.name("email"));
        WebElement password = driver.findElement(By.name("password"));
        email.clear();
        password.clear();

        email.sendKeys("Hammad786@gmail.com");
        password.sendKeys("KingKhan07++bv4321@mn");
        driver.findElement(By.name("submit")).click();
        String alertMessage = driver.switchTo().alert().getText();
        System.out.print(alertMessage);
        String check = "Logged in";
        assertEquals(alertMessage, check);
    }




}