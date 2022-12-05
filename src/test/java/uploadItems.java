import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class uploadItems {
    public static void main(String[] args) throws InterruptedException, IOException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.ilovepdf.com/pdf_to_jpg");
        driver.findElement(By.id("pickfiles")).click();
        Thread.sleep(3000);
//        Call the exe file
        String location = "X:\\Self improvement\\Selenium Udemy\\Code\\Advanced_Selenium_Features\\AutoItScript\\FileUpload.exe";
        Runtime.getRuntime().exec(location);

    }
}
