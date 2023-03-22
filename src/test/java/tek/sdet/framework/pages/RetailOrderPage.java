package tek.sdet.framework.pages;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.sdet.framework.base.BaseSetup;



public class RetailOrderPage extends BaseSetup {
	public RetailOrderPage() {
		
		PageFactory.initElements(getDriver(), this);
	}
	@FindBy (xpath="//*[@id='orderLink']")
		public WebElement orderLink;
	@FindBy(xpath="(//*[@class='order__header-btn'])[1]")
	    public WebElement orderDetail;
	@FindBy(xpath="//*[@id='cancelBtn']")
	    public WebElement cancelBtn;
	@FindBy(id ="orderLink")
	 public WebElement orderbtn;
	@FindBy(xpath="//*[@id='reasonInput']")
	public WebElement cancelReason;
	@FindBy(xpath="(//*[@class='order__header-btn'])[1]")
	public WebElement hideDetails;
	@FindBy(xpath="//*[@id='orderSubmitBtn']")
	public WebElement orderCancelSubmitBtn;
	@FindBy(xpath="//p[contains(text(),'Your Order Has Been Cancelled')]")
	public WebElement confirmationMessage;
	@FindBy(xpath="//*[@id='returnBtn']")
	public WebElement returnButton;
	@FindBy(xpath="//*[@id='dropOffInput']")
	public WebElement dropOffLocationBtn;
	@FindBy(xpath="//*[@class='order__cancel-submit']")
	public WebElement orderReturnSubmitBtn;
	@FindBy(xpath="//p[contains (text(),\"Return was successfull\")]")
	public WebElement returnMessage;
	@FindBy(xpath="//*[@id='reviewBtn']")
	public WebElement reviewButton;
	@FindBy(xpath="//input[@name='headline']")
	public WebElement reviewHeadline;
	@FindBy(xpath="//textarea[@name='comment']")
	public WebElement reviewMessage;
	@FindBy(xpath="//button[@type='submit']")
	public WebElement reviewSubmitBtn;
	
}
    