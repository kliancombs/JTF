import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserTest {
    public static void main(String[] args) throws InterruptedException {
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver",
projectPath+"//drivers/chromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        Thread.sleep(3000);
        driver.close();
}
}