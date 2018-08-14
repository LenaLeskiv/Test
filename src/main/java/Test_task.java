import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test_task {
    public static void main(String[] args) {
        WebDriver driver = initChromeDriver();
        driver.get("https://rozetka.com.ua/");
        WebElement citylist = driver.findElement(By.name("city"));

        Actions find = new Actions(driver);
        find.moveToElement(citylist).build().perform();
        waittime();
        citylist.click();

        WebElement city = driver.findElement(By.xpath("//*[@id=\"city-chooser\"]/div[1]/div/div[2]/div[1]/div[1]/div[2]/a"));
        waittime();
        city.click();

        WebElement search = driver.findElement(By.name("text"));
        search.sendKeys("кондиционеры");
        WebElement button = driver.findElement(By.xpath("//*[@id=\"rz-search\"]/form/span/span/button"));
        waittime();
        button.submit();
        waittime();

        WebElement cond1 = driver.findElement(By.xpath("//*[@id=\"catalog_goods_block\"]/div/div[1]/div[1]/div/div/div/div[3]/a"));
        cond1.click();
        waittime();
        WebElement text1 = driver.findElement(By.xpath("//*[@id=\"tab_content\"]/div/div[1]/div[3]/ul/li[1]/span[2]/span/a"));
        System.out.println(" "+text1.getText());
driver.navigate().back();
        WebElement cond2 = driver.findElement(By.xpath("//*[@id=\"catalog_goods_block\"]/div/div[2]/div[1]/div/div/div/div[3]/a"));
        cond2.click();
        waittime();

        WebElement text2 = driver.findElement(By.xpath("//*[@id=\"tab_content\"]/div/div[1]/div[3]/ul[1]/li[1]/span[2]/span/a"));
        System.out.println(" "+text2.getText());
        waittime();
driver.quit();

    }

    public static WebDriver initChromeDriver() {
        System.setProperty("webdriver.chrome.driver",Test_task.class.getResource("chromedriver.exe").getPath());
        return new ChromeDriver();
    }
    public static void waittime() {   //создание метода время ожидания загрузки
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
