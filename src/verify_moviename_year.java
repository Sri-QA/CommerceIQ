import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class verify_moviename_year {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\srigo\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get(" https://www.imdb.com/chart/top/");
		driver.manage().window().maximize();
		
		 WebElement table = driver.findElement(By.xpath("//table"));
		    List<WebElement> allRows = table.findElements(By.tagName("tr"));
		    System.out.println(allRows.size());

		    // And iterate over them, getting the cells

		    for(int i=1;i<3;i++)
		    {

		        WebElement table1 = driver.findElement(By.xpath(".//table"));
		        List<WebElement> allRows1 = table1.findElements(By.tagName("tr"));
		        String title=allRows1.get(i).findElement(By.xpath(".//td[@class=\"titleColumn\"]")).getText();
		        System.out.println(title);
		        allRows1.get(i).findElement(By.xpath(".//td[@class=\"titleColumn\"]/a")).click();
		        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		        String stitle=driver.findElement(By.cssSelector("div[class=\"title_wrapper\"] h1")).getText();
		        System.out.println(stitle);
		        driver.navigate().back();
		        if(title.contains(stitle))
		        {
		        	System.out.println("The movie name and year are matching " +stitle);
		        }

		    }
	}

}
