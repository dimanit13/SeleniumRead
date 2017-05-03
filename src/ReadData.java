
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ReadData {

		public WebDriver driver;
		public void readData() throws Exception, IOException{
			System.setProperty("webdriver.chrome.driver", "E:\\Selenium_PDC\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.get("http://checkpointlearning.thomsonreuters.com/");
		File file=new File("E:/Selenium_Test/testdata/users.xls");
		Workbook wb = Workbook.getWorkbook(file);
		Sheet sh = wb.getSheet(0);
		/*for (int i = 0; i < sh.getColumns(); i++) {
			for (int j = 1; j < sh.getRows(); j++) {
				System.out.println(sh.getCell(i, j).getContents());
			}
		}*/
		
		for (int i = 1; i < sh.getRows(); i++) {
			driver.findElement(By.id("UserNameHtmlCtl")).sendKeys(sh.getCell(0, i).getContents());
			driver.findElement(By.name("Password")).sendKeys(sh.getCell(1, i).getContents());
			driver.findElement(By.id("cplLoginButton")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//img[contains(@src,'/images/sign-off-button')]")).click();;
			
		}
		
		
		}
	public static void main(String[] args) throws Exception, Exception {
		ReadData r= new ReadData();
		r.readData();
		System.out.println("test completed");
	}

}
