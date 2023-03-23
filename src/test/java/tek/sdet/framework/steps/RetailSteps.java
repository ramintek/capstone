package tek.sdet.framework.steps;


import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.StaleElementReferenceException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.sdet.framework.pages.POMFactory;
import tek.sdet.framework.utilities.CommonUtility;
import tek.sdet.framework.utilities.DataGeneratorUtility;

public class RetailSteps extends CommonUtility {

	 POMFactory factory = new POMFactory();
	

	@Given("User is on retail website")
	public void userIsOnRetailWebsite() {
		String actualTitle = getTitle();
		String expectedTitle = "React App";
		Assert.assertEquals(actualTitle, expectedTitle);
		Assert.assertTrue(isElementDisplayed(factory.homePage().tekSchoolLogo));
		logger.info("user is on retail website");
		logger.info("Actual Title " + actualTitle + " Equals " + " ExpectedTitle " + expectedTitle);

	}

	@When("User search for {string} product")
	public void userSearchForProduct(String productValue) {
		sendText(factory.homePage().searchBar, productValue);
		click(factory.homePage().searchButton);
		logger.info("user searched for product " + productValue);
	}

	@Then("The product should be displayed")
	public void theProductShouldBeDisplayed() {
		Assert.assertTrue(isElementDisplayed(factory.homePage().pokemanProductImage));
		logger.info("the Product is displayed on home page");

	}

	@When("User click on All section")
	public void userClickOnAllSection() {
		click(factory.homePage().allIcon);
		logger.info("user clicked on All section");

	}

	@Then("below options are present in shop by department sidebar")
	public void belowOptionsArePresentInShopByDepartmentSidebar(DataTable dataTable) {
		List<List<String>> expectedSideBar = dataTable.asLists(String.class);

		List<WebElement> actualSideBar = factory.homePage().sideBarElements;

		for (int i = 0; i < expectedSideBar.get(0).size(); i++) {
			Assert.assertEquals(actualSideBar.get(i).getText(), expectedSideBar.get(0).get(i));
			logger.info(actualSideBar.get(i).getText() + " is equal to " + expectedSideBar.get(0).get(i));
		}

	}

	@When("User on {string}")
	public void userOnElectronics(String department) {
		List<WebElement> sideBarOptions = factory.homePage().sideBarElements;
		for (WebElement option : sideBarOptions) {
			if (option.getText().equals(department)) {
				click(option);
				try {
					logger.info(option.getText() + " is present ");
				} catch (StaleElementReferenceException e) {

				}
				break;
			}
		}

	}

	@Then("below options are present in department")
	public void belowOptionsArePresentInDepartment(DataTable dataTable) {

		List<List<String>> expectedDepartmentOptions = dataTable.asLists(String.class);
		List<WebElement> actualDepartmentOptions = factory.homePage().sideBarOptionElements;

		for (int i = 0; i < expectedDepartmentOptions.get(0).size(); i++) {
			for (WebElement dept : actualDepartmentOptions) {
				if (dept.getText().equals(expectedDepartmentOptions.get(0).get(i))) {
					Assert.assertTrue(isElementDisplayed(dept));
					logger.info(dept.getText() + " is present ");
				}
				
				}
			}

		}
	@Given("User change the category to {string}")
	public void userChangeTheCategoryTo(String string)  {
        click(factory.homePage().allDepartmentDropDown);
        Select select = new Select(factory.homePage().allDepartmentDropDown);
		select.selectByVisibleText("Smart Home");
		
	  

	}
	
	@Given("User search for an item {string}")
	public void userSearchForAnItem(String string) throws InterruptedException {
		sendText(factory.homePage().searchBar,string);

	
	}
	@Given("User click on Search icon")
	public void userClickOnSearchIcon() throws InterruptedException {
		 click(factory.homePage().searchButton);
		 logger.info("user clicked on Search icon");
		
	}
	@Given("User click on item")
	public void userClickOnItem() throws InterruptedException {
	   click(factory.homePage().kasaOutdoorSmartPlug);
	   logger.info("user clicked Kasa Outdoor Smart Plug");
	   
	}
	@Given("User select quantity {string}")
	public void userSelectQuantity(String count) {
	   sendText(factory.homePage().selectQuantity, count);
	}
	@Given("User click add to Cart button")
	public void userClickAddToCartButton() throws InterruptedException {
	   click(factory.homePage().addToCartBtn);
	   
	}
	@Then("the cart icon quantity should change to {string}")
	public void theCartIconQuantityShouldChangeTo(String count) throws InterruptedException {
		click(factory.homePage().cartButton);
		Assert.assertEquals(count,factory.homePage().checkOutQuantity.getText());
		
	
	}
		
		@Then("User click on Cart option")
		public void userClickOnCartOption() {
		    click(factory.homePage().cartButton);
		    logger.info("cart button should be selected");
		}
		@Then("User click on Proceed to Checkout button")
		public void userClickOnProceedToCheckoutButton() {
		    click(factory.homePage().proceedToCheckOutBtn);
		    logger.info("customer taken to checkout page");
		}
		@Then("User clicks Add a new address link for shipping address")
		public void userClicksAddANewAddressLinkForShippingAddress(DataTable dataTable) throws InterruptedException {
		   click(factory.homePage().addAdressButton);
		 
		   List<List<String>> addressInfo2 = dataTable.asLists(String.class);
			selectByVisibleText(factory.homePage().country,DataGeneratorUtility.data(addressInfo2.get(0).get(0)));
			sendText(factory.homePage().fullNameField,DataGeneratorUtility.data(addressInfo2.get(0).get(1)));
			sendText(factory.homePage().phoneNumberField,DataGeneratorUtility.data(addressInfo2.get(0).get(2)));
			sendText(factory.homePage().streetAddressField, DataGeneratorUtility.data(addressInfo2.get(0).get(3)));
			sendText(factory.homePage().apartmentNumber, DataGeneratorUtility.data(addressInfo2.get(0).get(4)));
			sendText(factory.homePage().cityField,DataGeneratorUtility.data(addressInfo2.get(0).get(5)));
			selectByVisibleText(factory.homePage().stateDropDown,DataGeneratorUtility.data(addressInfo2.get(0).get(6)));
			sendText(factory.homePage().zipCodeField,DataGeneratorUtility.data(addressInfo2.get(0).get(7)));
			click(factory.homePage().addAdressButton);
			logger.info("user filled the new address form with information provided in data table");
		
		}

		@Then("User click Add a credit card or Debit Card for Payment method")
		public void userClickAddACreditCardOrDebitCardForPaymentMethod(DataTable dataTable) {
		   click(factory.homePage().addACreditCard);
		   List<List<String>> newCreditCardInfo = dataTable.asLists(String.class);
			sendText(factory.homePage().cardNumberInput,(newCreditCardInfo.get(1).get(0)));
			sendText(factory.homePage().nameOnCardInput,(newCreditCardInfo.get(1).get(1)));
			selectByVisibleText(factory.homePage().expirationMonthInput,(newCreditCardInfo.get(1).get(2)));
			selectByVisibleText(factory.homePage().expirationYearInput,(newCreditCardInfo.get(1).get(3)));
			sendText(factory.homePage().securityCodeInput,(newCreditCardInfo.get(1).get(4)));
		}
		@Then("User click on Place Your Order")
		public void userClickOnPlaceYourOrder() {
		     click(factory.homePage().placeOrderButton);
		     
		}
        @Then("order message should be displayed {string}")
        public void orderPlacedMessage (String orderPlaced) {
        	waitTillPresence(factory.homePage().yourOrderPlacedMsg);
        	Assert.assertEquals(orderPlaced, factory.homePage().yourOrderPlacedMsg.getText());
        	logger.info("order placed Message displayed");
        }

@When("User changes category to {string}")
public void userChangeTheCategoryToElectronics(String string) throws InterruptedException {
	 click(factory.homePage().allDepartmentDropDown);
	 Select select = new Select(factory.homePage().allDepartmentDropDown);
		select.selectByVisibleText("Electronics");
		
		
}
//@Given("User search for item {string}")
//public void userSearchsForItem(String string) throws InterruptedException {
//	sendText(factory.homePage().searchBar,string);
//Thread.sleep(5000);
//}
//@When("User selects quantity {string}")
//public void userSelectsQuantity(String string) throws InterruptedException {
//	 sendText(factory.homePage().selectQuantity, string);
//	 Thread.sleep(5000);
//}
//@Given("User clicks add to Cart button")
//public void userClicksAddToCartButton() throws InterruptedException {
//   click(factory.homePage().addToCartBtn);
//   Thread.sleep(5000);
//}
//@Then("the cart icon quantity should change to {int}")
//public void theCartIconQuantityShouldChangeTo(Integer int1) {
//   
}
//@Then("the message should be displayed {string}")
//public void aMessageShouldBeDisplayedOrderPlacedThanks(String yourOrderPlaced) {
//	 {
//    	waitTillPresence(factory.homePage().yourOrderPlacedMsg);
//    	Assert.assertEquals(yourOrderPlaced, factory.homePage().yourOrderPlacedMsg.getText());
//    	logger.info("order placed Message displayed");
//    }
//}



//	}

