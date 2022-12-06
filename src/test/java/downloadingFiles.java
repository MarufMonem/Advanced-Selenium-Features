import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

public class downloadingFiles {
    public static void main(String[] args) throws InterruptedException, IOException {

//Setting the user defined download directory
        String downloadPath = System.getProperty("user.dir");
        System.out.println(downloadPath);
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", downloadPath);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);


        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get("https://www.ilovepdf.com/pdf_to_jpg");
        driver.findElement(By.id("pickfiles")).click();
        Thread.sleep(3000);
//        Call the exe file
        String location = "X:\\Self improvement\\Selenium Udemy\\Code\\Advanced_Selenium_Features\\AutoItScript\\FileUpload.exe";
        Runtime.getRuntime().exec(location);

//        Uploading completed
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("processTask")));
//      Convert
        driver.findElement(By.id("processTask")).click();
//        Waiting for the element to appear for a maximum of 20s

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pickfiles")));

//        Download button
        driver.findElement(By.id("pickfiles")).click();
//        verify the file is downloaded
        File f = new File(downloadPath+"\\TestFile_page-0001.jpg");

//        waiting for the download to complete
        Thread.sleep(10000);
//        By default the downloaded files go to the download directory
//        But we are sending the project path
//        To make sure the downloads are stored in the user defined location we need to tell chrome to do so. Which we have done initially

        if(f.exists()){
            System.out.println("Downloaded");
        }else{
            System.out.println("Something went wrong");
        }

        if(f.delete()){
            System.out.println("File scucessfully deleted to save space");
        }

    }
}


