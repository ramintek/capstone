package tek.sdet.framework.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.sdet.framework.base.BaseSetup;

public class RetailHomePage extends BaseSetup {

	public RetailHomePage() {
		PageFactory.initElements(getDriver(), this);
	}

	// syntax for finding UI elements and storing them in POM classes
	/**
	 * @FindBy(locatorType = "value") public WebElement nameOfElement
	 */

	@FindBy(xpath = "//a[text()='TEKSCHOOL']")
	public WebElement tekSchoolLogo;

	@FindBy(id = "search")
	public WebElement allDepartmentDropDown;

	@FindBy(css = "#searchInput")
	public WebElement searchBar;

	@FindBy(xpath = "//button[@id='searchBtn']")
	public WebElement searchButton;

	@FindBy(linkText = "Sign in")
	public WebElement signInButton;

	@FindBy(id = "cartBtn")
	public WebElement cartButton;

	@FindBy(xpath = "//img[contains(@alt, 'Pokemon')]")
	public WebElement pokemanProductImage;

	@FindBy(xpath = "//a[text()='Account']")
	public WebElement accountOption;

	@FindBy(id = "hamburgerBtn")
	public WebElement allIcon;

	@FindBy(xpath = "//div[@class='sidebar_content-item']/span")
	public List<WebElement> sideBarElements;

	@FindBy(xpath = "//span[text()='Electronics']")
	public WebElement electronicsSideBar;

	@FindBy(xpath = "//span[text()='Computers']")
	public WebElement computersSideBar;

	@FindBy(xpath = "//span[text()='Smart Home']")
	public WebElement smartHomeSideBar;

	@FindBy(xpath = "//span[text()='Sports']")
	public WebElement sportsSideBar;

	@FindBy(xpath = "//span[text()='Automative']")
	public WebElement automativeSideBar;

	@FindBy(xpath = "//div[@class='sidebar_content-item']/span")
	public List<WebElement> sideBarOptionElements;

	@FindBy(xpath = "//p[@class='products__name']")

	public WebElement kasaOutdoorSmartPlug;

	@FindBy(xpath = "//*[@id=\"addToCartBtn\"]/span")
	public WebElement addToCartBtn;

	@FindBy(xpath = "//*[@id=\"root\"]/div[1]/div[1]/div[3]/div/div[1]/div[3]/div/div/select")
	public WebElement selectQuantity;
	@FindBy(xpath = "//input[@class='cart__item-quantity']")
	public WebElement cartquantity;
	
	@FindBy(xpath="//*[@id = \"proceedBtn\"]")
	public WebElement proceedToCheckOutBtn;
  
	@FindBy(xpath="//*[@id = 'addAddressBtn']")
	public WebElement addAdressButton;
	@FindBy(xpath = "//select[@id='countryDropdown']")
	public WebElement country;
	
	@FindBy(id = "fullNameInput")
	public WebElement fullNameField;
	
	@FindBy(id = "phoneNumberInput")
	public WebElement phoneNumberField;
	
	@FindBy(id = "streetInput")
	public WebElement streetAddressField;
	
	@FindBy(xpath = "//input[@id='apartmentInput']")
	public WebElement apartmentNumber;
	
	@FindBy(id = "cityInput")
	public WebElement cityField;
	
	@FindBy(xpath = "(//select[@class='account__address-new-dropdown'])[2]")
	public WebElement stateDropDown;
	
	@FindBy(id = "zipCodeInput")
	public WebElement zipCodeField;
	
	@FindBy(xpath="//*[@id=\"addPaymentBtn\"]")
	public WebElement addACreditCard;
	
	@FindBy(xpath="//*[@id=\"placeOrderBtn\"]")
	public WebElement placeOrderButton;
	
	@FindBy(xpath="//p[contains(text(),'Order Placed, Thanks')]")
	public WebElement orderPlacedMessage;
	
	
	@FindBy(xpath=" //input[@id='cardNumberInput']")
	public WebElement cardNumberInput;
	
	@FindBy(xpath=" //input[@id='nameOnCardInput']")
	public WebElement nameOnCardInput;
	
	@FindBy(xpath="//select[@id='expirationMonthInput']")
	public WebElement expirationMonthInput;

	@FindBy(xpath="//select[@id='expirationYearInput']")
	public WebElement expirationYearInput;
	
	@FindBy(xpath="//input[@id='securityCodeInput']")
	public WebElement securityCodeInput;
	
	@FindBy(xpath="//p[text()='Order Placed, Thanks']")
	public WebElement yourOrderPlacedMsg;
   @FindBy(xpath="//*[@id='cartQuantity']")
   public WebElement checkOutQuantity;
   @FindBy (xpath="//*[@id='orderLink']")
   public WebElement orderLink;
   @FindBy(xpath="//*[@id='addressBtn']")
	public WebElement addressbt;
   @FindBy(xpath="//*[@class='cart__item-delete']")
   public WebElement deleteCart;
 @FindBy(xpath="//*[@class='account__btn-submit']")
 public WebElement accountSubmitBtn;
 
}
