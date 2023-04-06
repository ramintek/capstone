package tek.sdet.framework.steps;

import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.core.logging.Logger;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.sdet.framework.pages.POMFactory;
import tek.sdet.framework.utilities.CommonUtility;

public class RetailOrderSteps extends CommonUtility {
	POMFactory factory = new POMFactory();

	@When("User click on Orders section")
	public void userClickOnOrdersSection() throws InterruptedException {

		click(factory.accountPage().orderbtn);
		logger.info("user clicked on orders button");
		

	}

	@When("User click on first order in list")
	public void userClickOnFirstOrderInList() throws InterruptedException {

		waitTillPresence(factory.accountPage().hideDetails);
		click(factory.orderPage().hideDetails);
		
		click(factory.orderPage().orderDetail);
		logger.info("user clicked on orders detail");
		
	}

   

	@When("User click on Cancel The Order button")
	public void userClickOnCancelTheOrderButton() throws InterruptedException {
		waitTillPresence(factory.orderPage().cancelBtn);
		click(factory.orderPage().cancelBtn);
		
	}
	@When("User select the cancelation Reason {string}")
	public void userSelectTheCancelationReason(String string) throws InterruptedException {

		click(factory.orderPage().cancelReason);
		Select select = new Select(factory.orderPage().cancelReason);
		select.selectByVisibleText(string);
		
	}

	@When("User click on Cancel Order button")
	public void userClickOnCancelOrderButton() {
		click(factory.orderPage().orderCancelSubmitBtn);
	}

	@Then("a cancelation message should be displayed {string}")
	public void aCancelationMessageShouldBeDisplayed(String string) {

		Assert.assertEquals(string, factory.orderPage().confirmationMessage.getText());
		logger.info("cancellation messager was displayed" + string);
		click(factory.orderPage().orderLink);
		click(factory.orderPage().buyAgain);
		click(factory.orderPage().placeOrder);
	}

@When("User click on Return Items button")
public void userClickOnReturnItemsButton() {
//	waitTillPresence(factory.orderPage().returnButton);
    click(factory.orderPage().returnButton);
    logger.info("user clicked on return Button");
    
}
@When("User select the Return Reason {string}")
public void userSelectTheReturnReason(String string) {
   click(factory.orderPage().cancelReason);
   Select select = new Select(factory.orderPage().cancelReason);
   select.selectByVisibleText(string);
   logger.info("user selected reason for cancelation");
}
@When("User select the drop off service {string}")
public void userSelectTheDropOffService(String string) {
     click(factory.orderPage().dropOffLocationBtn);
     Select select = new Select(factory.orderPage().dropOffLocationBtn);
     select.selectByVisibleText(string);
    logger.info("User clicked on dropOff Location");
}
     
@When("User click on Return Order button")
public void userClickOnReturnOrderButton() {
  click(factory.orderPage().orderReturnSubmitBtn);
 logger.info("user clicked on return ");
}
@Then("a return message should be displayed {string}")
public void aReturnMessageShouldBeDisplayed(String string) {

	Assert.assertEquals(string, factory.orderPage().returnMessage.getText());
	logger.info("return message is displayed" + string);
	click(factory.orderPage().orderLink);
	click(factory.orderPage().buyAgain);
	click(factory.orderPage().placeOrder);
}
@When("User click on Review button")
public void userClickOnReviewButton() {
  click(factory.orderPage().reviewButton);
  logger.info("review button clicked");
}
@When("User write Review headline {string} and {string}")
public void userWriteReviewHeadlineAnd(String string, String string2) {
 sendText(factory.orderPage().reviewHeadline,string);
 sendText(factory.orderPage().reviewMessage,string2);

}
@When("User click Add your Review button")
public void userClickAddYourReviewButton() {
click(factory.orderPage().reviewSubmitBtn);
logger.info("user confirms Reivew");
}
@Then("a review message should be displayed {string}")
public void aReviewMessageShouldBeDisplayed(String string)  {
	waitTillPresence(factory.orderPage().reviewAddedSuccessfullyMessage);
	Assert.assertEquals(string, factory.orderPage().reviewAddedSuccessfullyMessage.getText());  
     logger.info("user gets message that review was added");
}
}