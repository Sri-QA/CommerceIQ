import java.util.ArrayList;
import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class sorting {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\srigo\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get(" https://www.imdb.com/chart/top/");
		WebElement table=driver.findElement(By.xpath("//table[@class=\"chart full-width\"]"));
		int count=table.findElements(By.xpath("//table[@class=\"chart full-width\"]//tr//td[@class=\"posterColumn\"]")).size();
		ArrayList <String> ratings=new ArrayList <String> ();
		ArrayList <String> movie=new ArrayList <String> ();
		ArrayList <String> releasedate=new ArrayList <String> ();
		ArrayList <String> combined=new ArrayList <String> ();
		for(int counts=0;counts<count-1;counts++)// Adding the list of movies, ratings,year of release to an array list
		{
			String title=table.findElements(By.cssSelector("div[class=\"lister\"] td:nth-child(2)")).get(counts).getText();
			String titles=title.substring(3, title.length()-6);
			movie.add(titles);
			String rating=table.findElements(By.cssSelector("div[class=\"lister\"] td:nth-child(3)")).get(counts).getText();
			ratings.add(rating);
			String yearofrelease=title.substring(title.length()-5, title.length()-1);
			releasedate.add(yearofrelease);
			String comb=movie.get(counts)+"*"+releasedate.get(counts)+"*"+ratings.get(counts);
			combined.add(comb);
		}
		driver.findElement(By.xpath("//select[@name=\"sort\"]")).click();
		Thread.sleep(3000);
		//Sorting the list according to movie release date
		driver.findElement(By.xpath("//select[@name=\"sort\"]//option[3]")).click();
		Thread.sleep(3000);
		ArrayList <String> ratings_aftersort=new ArrayList <String> ();
		ArrayList <String> movie_aftersort=new ArrayList <String> ();
		ArrayList <String> releasedate_aftersort=new ArrayList <String> ();
		ArrayList <String> combined_aftersort=new ArrayList <String> ();
		
		for(int count1=0;count1<count;count1++)
		{
			String title1=table.findElements(By.cssSelector("div[class=\"lister\"] td:nth-child(2)")).get(count1).getText();
			String titles=title1.substring(3, title1.length()-6);
			movie_aftersort.add(titles);
			String rating=table.findElements(By.cssSelector("div[class=\"lister\"] td:nth-child(3)")).get(count1).getText();
			ratings_aftersort.add(rating);
			String yearofrelease=title1.substring(title1.length()-5, title1.length()-1);
			releasedate_aftersort.add(yearofrelease);
			String comb2=movie_aftersort.get(count1)+"*"+releasedate_aftersort.get(count1)+"*"+ratings_aftersort.get(count1);
			combined_aftersort.add(comb2);
		}
		Collections.sort(combined);
		Collections.sort(combined_aftersort);
		System.out.println(combined);
		System.out.println(combined_aftersort);
		if (combined_aftersort.containsAll(combined))
		{
			System.out.println("The movie names are also sorted according to the IMDB rating");
		}
		else
		{
			System.out.println("Something is missing");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
