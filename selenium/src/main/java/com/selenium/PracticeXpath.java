package com.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class PracticeXpath {

	public static void main(String[] args) throws InterruptedException {
	    
		
		//System.setProperty("WebDriver.chrome.driver","C:\\Users\\Tanay Chawla\\Desktop\\selenium\\Browser Testing\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		driver.findElement(By.id("src")).click();
		driver.findElement(By.id("src")).sendKeys("Pune");
		Thread.sleep(5000);
		int c=driver.findElements(By.cssSelector("#search div div.fl.search-box.clearfix div ul li")).size();
		for(int j=1;j<=c;j++){
			System.out.println(driver.findElement(By.xpath(".//*[@id='search']/div/div[1]/div/ul/li["+j+"]")).getText());
			if(driver.findElement(By.xpath(".//*[@id='search']/div/div[1]/div/ul/li["+j+"]")).getText().equals("Pune Darshan")){
				driver.findElement(By.xpath(".//*[@id='search']/div/div[1]/div/ul/li["+j+"]")).click();
				break;
			}
		}
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='dest']")).click();
		driver.findElement(By.xpath(".//*[@id='dest']")).sendKeys("delhi");
		Thread.sleep(3000);
		int d=driver.findElements(By.xpath("//*[@id='search']/div/div[2]/div/ul/li")).size();
		for(int k=1;k<=d;k++){
			System.out.println(driver.findElement(By.xpath("//*[@id='search']/div/div[2]/div/ul/li["+k+"]")).getText());
			if(driver.findElement(By.xpath("//*[@id='search']/div/div[2]/div/ul/li["+k+"]")).getText().equals("Delhi Darshan")){
				driver.findElement(By.xpath("//*[@id='search']/div/div[2]/div/ul/li["+k+"]")).click();
				break;
			}
		}
		
		
		driver.findElement(By.xpath(".//*[@id='search']/div/div[3]/div/label")).click();
		
		
//		String month = driver.findElement(By.xpath(".//*[@id='rb-calendar_onward_cal']/table/tbody/tr[1]/td[2]")).getText();
//        System.out.println(month);					
        
//        String month = driver.findElement(By.cssSelector("#rb-calendar_onward_cal td.monthTitle")).getText();
//        System.out.println(month);						  
        
        while(!(driver.findElement(By.cssSelector("#rb-calendar_onward_cal td.monthTitle")).getText()).equals("Oct 2018")){
        	Thread.sleep(2000);
        	
        	driver.findElement(By.xpath(".//*[@id='rb-calendar_onward_cal']/table/tbody/tr[1]/td[3]/button")).click();
        	
        	System.out.println(driver.findElement(By.cssSelector("#rb-calendar_onward_cal td.monthTitle")).getText());
        	
        }
        int rowCount= driver.findElements(By.cssSelector("#rb-calendar_onward_cal table tbody tr")).size();
        for(int r=3;r<=rowCount;r++){
        	for(int col=1;col<=7;col++){
        		
        		String date =driver.findElement(By.cssSelector("#rb-calendar_onward_cal table tbody tr:nth-child("+r+") td:nth-child("+col+")")).getText();
        		if(date.equals("14")){
        			driver.findElement(By.cssSelector("#rb-calendar_onward_cal table tbody tr:nth-child("+r+") td:nth-child("+col+")")).click();
        			
        		}
        		
        	}
        }
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#search div.fl.search-box.date-box.gtm-returnCalendar label")).click();
        
        Thread.sleep(3000);
        while(!(driver.findElement(By.cssSelector("#rb-calendar_return_cal table tbody tr td:nth-child(2)")).getText()).equals("Nov 2018")){
        	Thread.sleep(2000);
        	
        	driver.findElement(By.cssSelector("#rb-calendar_return_cal table td:nth-child(3) button")).click();
        	
        	System.out.println(driver.findElement(By.cssSelector("#rb-calendar_return_cal table tbody tr td:nth-child(2)")).getText());
        }	
        int rowCount1= driver.findElements(By.cssSelector("#rb-calendar_return_cal table tbody tr")).size();
        for(int r=3;r<=rowCount1;r++){
        	for(int col=1;col<=7;col++){
        		
        		String date =driver.findElement(By.cssSelector("#rb-calendar_return_cal table tbody tr:nth-child("+r+") td:nth-child("+col+")")).getText();
        		if(date.equals("15")){
        			driver.findElement(By.cssSelector("rb-calendar_return_cal table tbody tr:nth-child("+r+") td:nth-child("+col+")")).click();
        			
        		}
        		
        	}
        }
        
        

	}

}
