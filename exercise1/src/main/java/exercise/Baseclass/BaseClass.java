package exercise.Baseclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.DriverManager;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.DiscoveryStrategy.Explicit;

public class BaseClass {

	public static WebDriver driver;

	public static String value;

	public static WebDriver findBrowser(String type) {

		if (type.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver","C:\\Users\\gowtham\\eclipse-workspace\\exercise1\\Driver\\chromedriver105.exe");

			driver = new ChromeDriver();
		} else if (type.equalsIgnoreCase("firefox")) {

			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\Driver\\chromedriver.exe");

			driver = new FirefoxDriver();
		}
		return driver;
	}

	public static void clickda(WebElement element) {

		element.click();
	}

	public static void sendKeysda(WebElement element, String keyValue) {

		element.sendKeys(keyValue);
	}

	public static void closeMe() {

		driver.close();
	}

	public static void quitMe() {

		driver.quit();
	}

	public static void GetUrl(String urlValue) {

		driver.get(urlValue);
	}

	public static void navigateMethod(String WebSite) {

		driver.navigate().to(WebSite);
	}

	public static void navigteBack() {

		driver.navigate().back();
	}

	public static void navigateForward() {

		driver.navigate().forward();
	}

	public static void maximiseBrowser() {

		driver.manage().window().maximize();
	}

	public static void alertSimple() {

		driver.switchTo().alert().accept();
	}

	public static void alertAccept(String type) {

		if (type.equalsIgnoreCase("ok")) {

			driver.switchTo().alert().accept();
		} else if (type.equalsIgnoreCase("cancel")) {

			driver.switchTo().alert().dismiss();
		}
	}

	public static void alertwithSendKeys(String clickButton, String type) {

		if (type.equalsIgnoreCase("sendkeys")) {

			driver.switchTo().alert().sendKeys(clickButton);
		} else if (type.equalsIgnoreCase("gettext")) {
			driver.switchTo().alert().getText();
		}

	}

	public static void implicitTimeOut(int time) {

		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}

//	private void ExplicitTimeout(long value) {
//
//WebDriverWait wait=new WebDriverWait(driver,value);
//		
//		wait.until(element, ;
//	}

	public static void getTextHere(WebElement element) {

		System.out.println(element.getText());
	}

	public static void currentUrl(WebDriver element) {

		driver.getCurrentUrl();
		System.out.println(element.getCurrentUrl());
	}

	public static void currentUrl2() {

		System.out.println(driver.getCurrentUrl());
	}

	public static Boolean SelectedOption(WebElement element) {

		System.out.println(element.isSelected());
		return false;
	}

	public static Boolean enableOptionda(WebElement element) {

		System.out.println(element.isEnabled());
		return null;
	}

	public static Boolean displayOption(WebElement element) {

		System.out.println(element.isDisplayed());
		return null;
	}

	public static void framesOptions(WebElement element, String type1) {

		if (type1.equalsIgnoreCase("Frame")) {

			driver.switchTo().frame(element);
		}

		else if (type1.equalsIgnoreCase("noframe")) {

			driver.switchTo().defaultContent();
		}
	}

	public static void windowUpDown(int a, int b) {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(" + a + " ," + b + ")");

//		js.executeScript("s");	
	}

	public static void dragAndDrop(WebElement element) {

		Actions a = new Actions(driver);

//		a.dragAndDrop(element, element);

		a.clickAndHold(element).build().perform();
		a.moveToElement(element).build().perform();
		a.release(element).build().perform();
	}

	public static void radioButton(WebElement element) {
		element.click();

	}

	public static void attributeValue(WebElement element) {
		String value = null;
		value = element.getAttribute(value);

	}

	public static void screenShot(String s) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;

		File shot1 = ts.getScreenshotAs(OutputType.FILE);

		File saveas = new File(s);

		FileUtils.copyFile(shot1, saveas);

	}

	public static String read_Data(String path, String sheetstory, int rowindex, int cellindex) throws IOException {

		File f = new File(path);

		FileInputStream fis = new FileInputStream(f);

		Workbook wb = new XSSFWorkbook(fis);

		Sheet sheet = wb.getSheet(sheetstory);

		Row r = sheet.getRow(rowindex);

		Cell cell = r.getCell(cellindex);

		CellType celltype = cell.getCellType();

		if (celltype.equals(celltype.STRING)) {

			value = cell.getStringCellValue();

		} else if (celltype.equals(celltype.NUMERIC)) {

			double numericcellvalue = cell.getNumericCellValue();
			int data = (int) numericcellvalue;
			value = String.valueOf(data);

		}

		return value;
	}

	public static void multipledropdown(WebElement element, String type, String Value) {
		Select s = new Select(element);

		if (type.equalsIgnoreCase("Selectbyindex")) {
			int parseInt = Integer.parseInt(Value);
			s.selectByIndex(parseInt);
		} else if (type.equalsIgnoreCase("selectbyvalue")) {
			s.selectByValue(Value);

		} else if (type.equalsIgnoreCase("SelectByvisibleText")) {

			s.selectByVisibleText(Value);
		}
	}
}

//		else if(element1.equalsIgnoreCase("DeSelectByindex")) {
//			int parseInt=Integer.parseInt(Value);
//			s.deselectByIndex(parseInt);
//		}
//		else if (element1.equalsIgnoreCase("deselectbyvalue")) {
//		
//			s.deselectByValue(Value);
//		}
//		else if (element1.equalsIgnoreCase("deselectbyvisibletext")) {
//			s.deselectByVisibleText(Value);
//		}
//		else if (element1.equalsIgnoreCase("Deselectall")) {
//			s.deselectAll();
//		}
//		else if (element1.equalsIgnoreCase("getoptions")) {
//			List<WebElement> selected=s.getOptions();
//			for (WebElement webEle : selected) {
//				System.out.println("get all options are:"+webEle.getText());
//			}
//			}
//		else if (element1.equalsIgnoreCase("getselectedoptions")) {
//			List<WebElement> selection=s.getAllSelectedOptions();
//			for (WebElement webElement : selection) {
//				System.out.println("get Selected Options"+webElement.getText());
//			}
//		}
//		else if (element1.equalsIgnoreCase("getfirstSelected")) {
//			WebElement firstoption=s.getFirstSelectedOption();
//				System.out.println(firstoption);
//		}
//	}
