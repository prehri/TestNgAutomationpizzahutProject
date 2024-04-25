package PageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class HomePage {
	public WebDriver driver;
	By Location = By.xpath("//input[@placeholder='Enter your location for delivery']");
	By firstSelect = By.xpath("//button[2]");
	By DealTxt = By
			.xpath("//a[contains(@class,'capitalize lg:border-r text-red lg:text-white side-menu__link--active')]");
	By Sidemenu = By.xpath("//a[@data-synth='link--sides--side']");
	By Addbtn = By.xpath("//button[@data-synth='button--cheesy-popcorn-sprinkled-fries-single--one-tap']");
	By checkbtitem = By.xpath("//div[@class='hidden md:flex md:bg-white md:text-black md:font-semibold justify-center sm:pb-5 typography-6']//span[contains(text(),'Minimum cart value for delivery is ₹200')]");
	By itempricevalue=By.xpath("(//span[contains(text(),'Minimum cart value for delivery is ₹200')])[1]");
	By price = By.xpath("//span[contains(@class,'ml-auto text-right')]");
	By drink = By.xpath("//a[contains(@data-synth,'link--drinks--side')]");
	By adddrink1 = By.xpath("//a[3]//div[3]//div[1]//button[1]");
	By adddrink2 = By.xpath("//a[4]//div[3]//div[1]//button[1]");
	By pricemore = By.xpath("//span[@class='ml-auto text-right']");
	By checkbuttonbox = By
			.xpath("//a[contains(@class,'justify-between')]//span[contains(@class,'absolute inset-0 flex-center')]");
	By paymentradiobtn = By.xpath("//input[@id='payment-method--razorpay']");
	By cashradiobtn = By.xpath("//label[@for='payment-method--cash']//span[@class='mr-auto flex items-center']");
	By checkboxagre = By.xpath(" //input[@id='marketingOptIn']");
	By inputname = By.xpath(" //input[@id='checkout__name']");
	By inputmobile = By.xpath(" //input[@id='checkout__phone']");
	By inputemail = By.xpath(" //input[@id='checkout__email']");
	By linkapplygift = By.xpath("//span[normalize-space()='Apply Gift Card']");
	By couponlink = By.xpath("//span[normalize-space()='Coupon']");
	By couponcode = By.xpath("//input[@placeholder='e.g. ABC1234']");
	By codesubmit = By.xpath("//button[@type='submit']");
	By errorcode = By.xpath("//span[contains(text(),'Sorry, we don’t currently support that coupon code')]");
	By popupvoucher = By.xpath("//button[@class='icon-remove-3 absolute top-0 right-0 mr-20 mt-20']");
	By Basketcart = By.xpath("//span[normalize-space()='Your Basket']");

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
/*
	public void takeScreenShot(String testName) {
		try {
			this.takeScreenshot(testName, driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
*/
	public void setLocation(String location) {
		WebElement loc = driver.findElement(Location);

		loc.sendKeys(location);

	//	takeScreenShot("setLocation");
	}

	public void selectfirstItem() {
		WebElement firstitem = driver.findElement(firstSelect);
		firstitem.click();

	//	takeScreenShot("selectfirstItem");
	}

	public void dealurltxt() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebElement dealtxt = driver.findElement(DealTxt);
		System.out.println(dealtxt.getAttribute("href").split("/")[4]);

		Assert.assertEquals(dealtxt.getAttribute("href"), "https://www.pizzahut.co.in/order/deals/");

		//takeScreenShot("dealurltxt");
	}

	public void sidebar() {
		WebElement Sidemenus = driver.findElement(Sidemenu);
		Sidemenus.click();
	}

	public void addbuttonlessvalue() {
		String text = driver.findElement(By.xpath(
				"//button[@data-synth='button--cheesy-popcorn-sprinkled-fries-single--one-tap']//span[@class='w-auto ml-3'][contains(text(),'₹99')]"))
				.getText();

		// System.out.println(text.replaceAll("[₹]",""));
		Integer itemcount = Integer.parseInt(text.replaceAll("[₹]", ""));
		System.out.println(itemcount.toString());
		Assert.assertTrue(itemcount <= 200);
		WebElement add = driver.findElement(Addbtn);
		add.click();

	

	}

	public void checkoutbutton(String stringval)	
	{
		WebElement checkbuttonvalid = driver.findElement(checkbtitem);
		boolean pricetagflag=checkbuttonvalid.isDisplayed();
		System.out.println(pricetagflag);
		String valcheckout=driver.findElement(itempricevalue).getText().trim();
		if(valcheckout.equals(stringval)) {
			System.out.println("price tag is visible");			
		}			
		else {
			System.out.println("price tag is not showing");
	
		}

	}
	

	public void drinksmenu() {
		WebElement drinkbtn = driver.findElement(drink);

		drinkbtn.click();
	}

	public void addbtndrink() {
		WebElement drinkbtn1 = driver.findElement(adddrink1);
		drinkbtn1.click();

		WebElement drinkbtn2 = driver.findElement(adddrink2);
		drinkbtn2.click();

		WebElement totalprice = driver.findElement(pricemore);
		System.out.println((totalprice).getText());

		String price1 = totalprice.getText();
		Float cartprice = Float.parseFloat(price1.replaceAll("[₹]", ""));
		System.out.println((cartprice).floatValue());

		if (cartprice.floatValue() > 200) {
			System.out.println("total cart pricing is more than 200");

		} else {
			System.out.println("total cart pricing is below 200");

		}

		Assert.assertTrue(cartprice.floatValue() > 200);

	}

	public void checkbuttonpvalidate() {
		WebElement checkbtn1 = driver.findElement(checkbuttonbox);
		checkbtn1.click();

		System.out.println("user click on checkout button");

	}

	public void radiobtnpayment() {
		WebElement radiobuttonpayment = driver.findElement(paymentradiobtn);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", radiobuttonpayment);

		boolean selectstate = radiobuttonpayment.isSelected();

		System.out.println("radiobutton is selected");

		Assert.assertTrue(selectstate);
	}

	public void cashradiobtn() {
		WebElement radiobuttoncash = driver.findElement(cashradiobtn);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", radiobuttoncash);
		// radiobuttoncash.click();

		boolean selectstate = radiobuttoncash.isEnabled();

		System.out.println("cashradiobutton is selected: " + selectstate);

		Assert.assertTrue(selectstate);
	}

	public void checkboxagree() {
		WebElement agreecheckbox = driver.findElement(checkboxagre);
		System.out.println("checkboxagree button is selected: " + agreecheckbox.isSelected());
		Assert.assertTrue(agreecheckbox.isSelected());
	}

	public void inputNameMobileEmail(String Name, String Mobile, String EmailID) {

		WebElement inputnamefield = driver.findElement(inputname);
		inputnamefield.sendKeys(Name);
		WebElement inputmobilefield = driver.findElement(inputmobile);
		inputmobilefield.sendKeys(Mobile);
		WebElement inputemailfield = driver.findElement(inputemail);
		inputemailfield.sendKeys(EmailID);
	}

	public void giftlink() {
		WebElement linkgiftapply = driver.findElement(linkapplygift);
		linkgiftapply.click();

	}

	public void couponlink() {
		WebElement linkcoupon = driver.findElement(couponlink);
		linkcoupon.click();

	}

	public void vouchercode() {
		WebElement Inputcoupon = driver.findElement(couponcode);
		Inputcoupon.sendKeys("12345");
		WebElement Submitbtn = driver.findElement(codesubmit);
		Submitbtn.click();

	}

	public void Errorcode() {
		WebElement codeerror = driver.findElement(errorcode);
		System.out.println(codeerror.getText());

		String act = codeerror.getText().toString();

		String exp = "Sorry, we don’t currently support that coupon code.";
		System.out.println("Error message is: " + act);
		// verify error message with Assertion
		boolean b = exp.contentEquals(act);
		Assert.assertTrue(exp.contentEquals(act));
		System.out.println("Error message boolean is: " + b);

	}

	public void popupclose() {
		WebElement closebtn = driver.findElement(popupvoucher);
		closebtn.click();
	}

	public void basketpage() {
		WebElement basketview = driver.findElement(Basketcart);
		System.out.println(basketview.getText());

	}
	

}
