package pom.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class PoManager {

	private WebDriver driver;

	private AddUser ad;

	private LoginPage lp;

	private NewUserPage nup;

	public PoManager(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public AddUser getAd() {
		ad=new AddUser(driver);
		return ad;
	}

	public LoginPage getLp() {
		lp=new LoginPage(driver);
		return lp;
	}

	public NewUserPage getNup() {
		nup=new NewUserPage(driver);
		return nup;
	}

}
