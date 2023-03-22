package tek.sdet.framework.pages;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.sdet.framework.base.BaseSetup;

public class RetailAccountPage extends BaseSetup {
	
	public RetailAccountPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath="//img[@id='profileImage']")
	public WebElement profileImage;
	
	@FindBy(id ="nameInput")
	public WebElement profileNameInputField;
	
	@FindBy(id="personalPhoneInput")
	public WebElement profilePhoneNumberField;
	
	@FindBy(xpath ="//button[text()='Update']")
	public WebElement profileUpdateButton;
	
	@FindBy(xpath="//div[text()='Personal Information Updated Successfully']")
	public WebElement personalInfoUpdateSuccessMessage;
	
	@FindBy(xpath = "//div[@class='account__address-new']")
	public WebElement addAddressOption;
	
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
	
	@FindBy(id = "addressBtn")
	public WebElement addYourAddressButton;
	
	@FindBy(xpath = "//div[text()='Address Added Successfully']")
	public WebElement addressAddedSuccessfullyMessage;
	
	@FindBy(xpath ="//*[@id=\"previousPasswordInput\"]")
	public WebElement previousPassword;
	
	@FindBy(xpath ="//*[@id=\"newPasswordInput\"]")
	public WebElement newPassword;
	
	@FindBy(xpath ="//*[@id=\"confirmPasswordInput\"]")
	public WebElement confirmPassword;
	
	@FindBy(xpath ="//*[@id=\"credentialsSubmitBtn\"]")
	public WebElement changePasswordBtn;
	
	
	@FindBy(xpath="//div[text()='Password Updated Successfully']")
	public WebElement passwordUpdatedSuccessfully;
	
	@FindBy(xpath="//p[contains(text(),'Add a payment method')]")
	public WebElement addAPaymentMethod;
	
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
	
	@FindBy(xpath="//button[@id='paymentSubmitBtn']")
	public WebElement addYourCard;
	
	@FindBy(xpath="//div[@class='Toastify']")
	public WebElement cardAddedSuccessfully;
	
	@FindBy(xpath="//*[@id=\"root\"]/div[1]/div[1]/div[3]/div/div[2]/div/div[1]/div/div[1]/div[1]")
	public WebElement currentCreditCard;
	
	@FindBy(xpath="(//button[text()='Edit'])[1]")
	public WebElement editCardButton;
	
	@FindBy(xpath="//button[@id='paymentSubmitBtn']")
	public WebElement updateYourCard;
	
	@FindBy(xpath="//div[text()='Payment Method updated Successfully']")
     public WebElement paymentMethodUpdateValidation;
	
	@FindBy(xpath="//img[@src='/images/master_card.png'][1]")
	public WebElement masterCard;

	@FindBy(xpath=" //p[contains(text(),'TekSchool accepts most major credit and debit card')]")
	public WebElement cardsThatAreAccepted;
	@FindBy(xpath="//img[@alt='add payment method']")
	public WebElement cardRemovalValidation;
	
	@FindBy(xpath="(//button[text()='Edit'])[1]")
	public WebElement addressEditButton;
	
	@FindBy(xpath="//*[@id='newForm']")
	public WebElement addressform;
	
	@FindBy(xpath="(//*[@class='account__btn-submit'])[4]")
	public WebElement updateAddressButton;

	@FindBy(xpath="//div[contains(text(),'Address Updated Successfully')]")
	public WebElement addressUpdatedSuccessfully;
	
	@FindBy(xpath="//*[@id = \"addAddressBtn\"]")
	public WebElement addAdressButton;
	@FindBy(id ="orderLink")
	 public WebElement orderbtn;
	@FindBy(xpath="(//*[@class='order__header-btn'])[1]")
	public WebElement hideDetails;
	@FindBy(xpath="(//*[@class='order__header-btn'])[1]")
    public WebElement orderDetail;
	@FindBy(xpath ="//*[@id='accountLink']")
	public WebElement accountLink;
}
