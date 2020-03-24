package Utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowserUtils {
    public static void switchWindow(WebDriver driver, String targetTitle){
        String mainWindow=driver.getWindowHandle();
        Set<String> allWindows=driver.getWindowHandles();
        if (!driver.getTitle().equals(targetTitle)){
            for (String window:allWindows){
                driver.switchTo().window(window);
                if(driver.getTitle().equals(targetTitle)){
                    break;
                }
            }

        }
    }

    public static void verifyBrokenLink(String links) {
        try {
            URL url = new URL(links);
            HttpURLConnection connect = (HttpURLConnection) url.openConnection();
            connect.setConnectTimeout(3000);
            connect.connect();
            if (connect.getResponseCode() >= 400||connect.getResponseCode()>=500) {
                System.out.println(links);
                System.out.println("The links is broken " + connect.getResponseMessage() + " " + connect.getResponseCode());
            }
        }catch (IOException e){
            e.getStackTrace();
        }

    }

    public void hoverOver(WebDriver driver, WebElement element){
        Actions action =new Actions(driver);
        action.moveToElement(element).build().perform();

    }
    public static void dragAndDrop(WebDriver driver, WebElement from,WebElement to){
        Actions action=new Actions(driver);
        action.dragAndDrop(from,to).build().perform();
    }

    public static void visibility(WebDriver  driver,WebElement element,int seconds){
        WebDriverWait wait=new WebDriverWait(driver,seconds);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public static void clickable(WebDriver driver,WebElement element,int seconds){
        WebDriverWait wait=new WebDriverWait(driver,seconds);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public static void takeScreenShot() throws IOException {
        File scr=((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.FILE);
        File destinationFile=new File("ScreenShotFile\\"+System.currentTimeMillis()+".png");
        FileUtils.copyFile(scr,destinationFile);
    }
    /*
    Create the method wich is taking one parameter as list of WebElemts
    This method will return list of String from webElelment
     */
    public static List<String> getText(List<WebElement> elements){
        List<String> textList= new ArrayList();
        for (WebElement element:elements){
            textList.add(element.getText());
        }
        return textList;
    }
}
