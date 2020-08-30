import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class write_read_file {

	public static void main(String[] args) throws IOException {
	
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\srigo\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get(" https://www.imdb.com/chart/top/");
		WebElement table=driver.findElement(By.xpath("//table[@class=\"chart full-width\"]"));
		int count=table.findElements(By.xpath("//table[@class=\"chart full-width\"]//tr//td[@class=\"posterColumn\"]")).size();
		System.out.println("the number of rows present are "+count);
		ArrayList <String> titles=new ArrayList <String> ();
		ArrayList <String> ratings=new ArrayList <String> ();
		ArrayList <String> comb=new ArrayList <String> ();
		ArrayList <String> releasedate=new ArrayList <String> ();
		 File file1=new File("Movies.txt");
		 FileWriter fw=new FileWriter(file1);
		 BufferedWriter bufferedWriter = new BufferedWriter(fw);

		 for(count=0;count<=49;count++)
		{
			
			String title=table.findElements(By.cssSelector("div[class=\"lister\"] td:nth-child(2)")).get(count).getText();
			String title1=title.substring(3, title.length()-6);
			titles.add(title1);
			String rating=table.findElements(By.cssSelector("div[class=\"lister\"] td:nth-child(3)")).get(count).getText();
			ratings.add(rating);
			String yearofrelease=title.substring(title.length()-5, title.length()-1);
			releasedate.add(yearofrelease);
			String combined= "The title of the movie is " +titles.get(count) +", Rating of this movie is " +ratings.get(count) +", Year of release is " +releasedate.get(count);
//			System.out.println(combined); 
			comb.add(combined);
			bufferedWriter.write(comb.get(count));
			bufferedWriter.newLine();
		}
		 bufferedWriter.close();
		 FileReader fr = new FileReader("Movies.txt");//Creating FileReader Class object fr for file1
		 String str=null;
	     BufferedReader  br = new BufferedReader(fr);
	     System.out.println(br.read());
	     while((str=br.readLine())!=null)
	     {
	      System.out.println(str);
	     }
		driver.close();
		
	}
		
}
