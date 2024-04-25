package testcase;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import PageObject.HomePage;
import base.Base;
import utilities.ExcelDataSupplier;

@Listeners(listeners.MyListerners.class)

public class HomeTest  extends Base {
	public WebDriver driver;
	Base b=new Base();

	@BeforeSuite
	public void setup() throws IOException {

		driver = initializeBrowser();	

		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@AfterSuite
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 1, dataProvider = "urlData", dataProviderClass = ExcelDataSupplier.class)
	public void seturl(String testname, String testvalue) {

		driver.get(testvalue);
		

	//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@Test(priority = 2)
	public void setuserlocation() throws IOException {
		HomePage homepage = new HomePage(driver);

		homepage.setLocation(prop.getProperty("location"));
		homepage.selectfirstItem();
		b.takeScreenshot("setLocation",driver);
	}

	@Test(priority = 3)

	public void dealpagetxt() throws IOException {
		HomePage homepage = new HomePage(driver);
		homepage.dealurltxt();
		b.takeScreenshot("dealpagetxt",driver);
	}

	@Test(priority = 4)

	public void sidemenubar() throws IOException {
		HomePage homepage = new HomePage(driver);
		homepage.sidebar();
		b.takeScreenshot("sidemenubar",driver);
	}

	@Test(priority = 5)

	public void comparevalue() throws IOException {
		HomePage homepage = new HomePage(driver);
		homepage.addbuttonlessvalue();
		b.takeScreenshot("comparevalue",driver);

	}

	@Test(priority = 6)
	public void checkoutbtn() throws IOException {
		HomePage homepage = new HomePage(driver);
		homepage.checkoutbutton(prop.getProperty("stringval"));
		b.takeScreenshot("checkoutbtn",driver);

	}

	@Test(priority = 7)
	public void drinksbtn() throws IOException {
		HomePage homepage = new HomePage(driver);
		homepage.drinksmenu();
		b.takeScreenshot("drinksbtn",driver);

	}

	@Test(priority = 8)
	public void addtwodrink() throws IOException {
		HomePage homepage = new HomePage(driver);
		homepage.addbtndrink();
		b.takeScreenshot("addtwodrink",driver);

	}

	@Test(priority = 9)
	public void checkoutbuttonvalidation() throws IOException {
		HomePage homepage = new HomePage(driver);
		homepage.checkbuttonpvalidate();
		b.takeScreenshot("checkoutbuttonvalidation",driver);

	}

	@Test(priority = 10)
	public void paymentbutton() throws IOException {
		HomePage homepage = new HomePage(driver);
		homepage.radiobtnpayment();

		b.takeScreenshot("paymentbutton",driver);


	}

	@Test(priority = 11)
	public void paymentcash() throws IOException {
		HomePage homepage = new HomePage(driver);
		homepage.cashradiobtn();
		b.takeScreenshot("paymentcash",driver);

	}

	@Test(priority = 12)
	public void agreecheckbox() throws IOException {
		HomePage homepage = new HomePage(driver);
		homepage.checkboxagree();
		b.takeScreenshot("agreecheckbox",driver);

	}

	@Test(priority = 13)
	public void nameemailinput() throws IOException {
		HomePage homepage = new HomePage(driver);
		homepage.inputNameMobileEmail(prop.getProperty("nameText"), prop.getProperty("mobileNo"),
				prop.getProperty("emailid"));
		b.takeScreenshot("nameemailinput",driver);

	}

	@Test(priority = 14)
	public void Applygiftlink() throws IOException {
		HomePage homepage = new HomePage(driver);
		homepage.giftlink();
		b.takeScreenshot("Applygiftlink",driver);


	}

	@Test(priority = 15)
	public void Voucherlink() throws IOException {
		HomePage homepage = new HomePage(driver);
		homepage.couponlink();
		b.takeScreenshot("Voucherlink",driver);


	}

	@Test(priority = 16)
	public void VoucherInputcode() throws IOException {
		HomePage homepage = new HomePage(driver);
		homepage.vouchercode();
		b.takeScreenshot("VoucherInputcode",driver);


	}

	@Test(priority = 17)
	public void ErrorMessage() throws IOException {
		HomePage homepage = new HomePage(driver);
		homepage.Errorcode();
		b.takeScreenshot("ErrorMessage",driver);


	}

	@Test(priority = 18)
	public void closepopupvoucher() throws IOException {
		HomePage homepage = new HomePage(driver);
		homepage.popupclose();
		b.takeScreenshot("closepopupvoucher",driver);

		
	}

	@Test(priority = 19)
	public void basket() throws IOException {
		HomePage homepage = new HomePage(driver);
		homepage.basketpage();
		b.takeScreenshot("basket",driver);


	}

}
