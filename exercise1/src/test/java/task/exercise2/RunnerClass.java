package task.exercise2;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import exercise.Baseclass.BaseClass;
import pom.Pages.PoManager;

public class RunnerClass extends BaseClass {

	public static WebDriver driver = BaseClass.findBrowser("chrome");
	public static PoManager pom = new PoManager(driver);

	@Test
	public void FinalClass() throws IOException {

		maximiseBrowser();

		GetUrl("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		implicitTimeOut(20);

		sendKeysda(pom.getLp().getUserName(), "Admin");
		sendKeysda(pom.getLp().getPassword(), "admin123");
		clickda(pom.getLp().getSubmit());

		clickda(pom.getAd().getAdminSelect());
		clickda(pom.getAd().getAddButton());

//		SoftAssert sa=new SoftAssert();
//		sa.assertEquals(pom.getAd().getUserRole(), pom.getAd().getUserRole());

		clickda(pom.getAd().getUserRole());

		sendKeysda(pom.getAd().getEmployeeName(), "Andrew");
		clickda(pom.getAd().getStatus());
		sendKeysda(pom.getAd().getUserName(), "Admin2");
		sendKeysda(pom.getAd().getPassword(), "Hospital@00");
		sendKeysda(pom.getAd().getConfirmPassword(), "Hospital@00");
		clickda(pom.getAd().getSaveButton());
		clickda(pom.getAd().getUserNameClick());
		clickda(pom.getAd().getLogout());

		sendKeysda(pom.getLp().getUserName(), "Admin");
		sendKeysda(pom.getLp().getPassword(), "admin123");
		clickda(pom.getLp().getSubmit());

		clickda(pom.getNup().getMyInfo());
		clickda(pom.getNup().getAttachment());
		sendKeysda(pom.getNup().getBrowseButton(), "D:\\Career\\Paytabs\\Resume_Gowtham.pdf");

		clickda(pom.getNup().getSavePdf());
		screenShot(".\\screenshot.png");
		clickda(pom.getNup().getUserNameLogut());
		clickda(pom.getNup().getLogoutNewUser());

	}
}
