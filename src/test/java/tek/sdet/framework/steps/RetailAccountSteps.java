package tek.sdet.framework.steps;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.sdet.framework.pages.POMFactory;
import tek.sdet.framework.utilities.CommonUtility;
import tek.sdet.framework.utilities.DataGeneratorUtility;

public class RetailAccountSteps extends CommonUtility {

	POMFactory factory = new POMFactory();

	@When("User click on Account option")
	public void userClickOnAccountOption() {
		click(factory.homePage().accountOption);
		logger.info("user clicked on Account option");
	}


@When("User update Name and Phone")
	public void userUpdateNameAndPhone(DataTable dataTable) throws InterruptedException {
		List<List<String>> updatedName = dataTable.asLists(String.class);
		clearTextUsingSendKeys(factory.accountPage().profileNameInputField);
		clearTextUsingSendKeys(factory.accountPage().profilePhoneNumberField);
		sendText(factory.accountPage().profileNameInputField,DataGeneratorUtility.data(updatedName.get(0).get(0))) ;
//		clearTextUsingSendKeys(factory.accountPage().profilePhoneNumberField);
		sendText(factory.accountPage().profilePhoneNumberField,DataGeneratorUtility.data(updatedName.get(0).get(1))) ;
		logger.info("user updated Name and Phone values ");
		Thread.sleep(2000);
//	@When("User update Name {string} and Phone {string}")
//	public void userUpdateNameAndPhone(String nameValue, String phoneValue) {
//		clearTextUsingSendKeys(factory.accountPage().profileNameInputField);
//		sendText(factory.accountPage().profileNameInputField, nameValue);
//		clearTextUsingSendKeys(factory.accountPage().profilePhoneNumberField);
//		sendText(factory.accountPage().profilePhoneNumberField, phoneValue);
//		logger.info("user updated Name and Phone values ");
	}

	@When("User click on Update button")
	public void userClickOnUpdateButton() {
		waitTillPresence(factory.accountPage().profileUpdateButton);
		click(factory.accountPage().profileUpdateButton);
		logger.info("user clicked on Update button");
	}

	@Then("User profile information should be updated")
	public void userProfileInformationShouldBeUpdated() {
		waitTillPresence(factory.accountPage().personalInfoUpdateSuccessMessage);
		Assert.assertTrue(isElementDisplayed(factory.accountPage().personalInfoUpdateSuccessMessage));
		logger.info("user profile information updated");
	}

	@When("User click on  Add address option")
	public void userClickOnAddAddressOption() {
		click(factory.accountPage().addAddressOption);
		logger.info("user clicked on Add address option");

	}

	@When("User fill new address form with below information")
	public void userFllNewAddressFormWithBelowInformation(DataTable dataTable) throws InterruptedException {
		List<List<String>> addressInfo = dataTable.asLists(String.class);
		selectByVisibleText(factory.accountPage().country, DataGeneratorUtility.data(addressInfo.get(0).get(0)));
		sendText(factory.accountPage().fullNameField, DataGeneratorUtility.data(addressInfo.get(0).get(1)));

		sendText(factory.accountPage().phoneNumberField, DataGeneratorUtility.data(addressInfo.get(0).get(2)));

		sendText(factory.accountPage().streetAddressField, DataGeneratorUtility.data(addressInfo.get(0).get(3)));

		sendText(factory.accountPage().apartmentNumber, DataGeneratorUtility.data(addressInfo.get(0).get(4)));
		sendText(factory.accountPage().cityField, DataGeneratorUtility.data(addressInfo.get(0).get(5)));
		selectByVisibleText(factory.accountPage().stateDropDown, DataGeneratorUtility.data(addressInfo.get(0).get(6)));
		sendText(factory.accountPage().zipCodeField, DataGeneratorUtility.data(addressInfo.get(0).get(7)));
		logger.info("user filled the new address form with information provided in data table");
		
	}

	@When("User click Add Your Address button")
	public void userClickAddYourAddressButton() {
		click(factory.accountPage().addYourAddressButton);
		logger.info("user clicked on Add your Address button");
	}

	@Then("a message should be displayed for added address {string}")
	public void aMessageShouldBeDisplayed(String expectedMessage) {
		waitTillPresence(factory.accountPage().addressAddedSuccessfullyMessage);
		Assert.assertEquals(expectedMessage, factory.accountPage().addressAddedSuccessfullyMessage.getText());
		logger.info("message for added adress is displayed ");

	}

	@When("User enter below information")
	public void userEnterBelowInformation(DataTable dataTable) {
		List<List<String>> passwordInfo = dataTable.asLists(String.class);
		sendText(factory.accountPage().previousPassword, (passwordInfo.get(1).get(0)));
		sendText(factory.accountPage().newPassword, (passwordInfo.get(1).get(1)));
		sendText(factory.accountPage().confirmPassword, (passwordInfo.get(1).get(2)));
		logger.info("user updated entered information in the fields");

	}

	@When("User click on Change Password button")
	public void userClickOnChangePasswordButton() throws InterruptedException {
		click(factory.accountPage().changePasswordBtn);
		logger.info("user clicked on change password button");

	}

	@Then("another message should be displayed {string}")
	public void anotherMessageShouldBeDisplayed(String expectedUpdateMessage) {
		waitTillPresence(factory.accountPage().passwordUpdatedSuccessfully);
		Assert.assertEquals(expectedUpdateMessage, factory.accountPage().passwordUpdatedSuccessfully.getText());
		logger.info("message displayed ");
	}

	@When("User click on Add a payment method link")
	public void userClickOnAddAPaymentMethodLink() {
//		click(factory.accountPage().removeBtn);
		click(factory.accountPage().addAPaymentMethod);
		logger.info("user clicked on Add a payment method link");
	}

	@When("User fill Debit or credit card information")
	public void userFillDebitOrCreditCardInformation(DataTable dataTable) {
		List<List<String>> creditCardInfo = dataTable.asLists(String.class);
		sendText(factory.accountPage().cardNumberInput, (creditCardInfo.get(1).get(0)));
		sendText(factory.accountPage().nameOnCardInput, (creditCardInfo.get(1).get(1)));
		selectByVisibleText(factory.accountPage().expirationMonthInput, (creditCardInfo.get(1).get(2)));
		selectByVisibleText(factory.accountPage().expirationYearInput, (creditCardInfo.get(1).get(3)));
		sendText(factory.accountPage().securityCodeInput, (creditCardInfo.get(1).get(4)));
		logger.info("account updated ");

	}

	@When("User click on Add your card button")
	public void userClickOnAddYourCardButton() {
		click(factory.accountPage().addYourCard);
		logger.info("user enterd new card information");

	}

	@Then("A message should be displayed for added payment {string}")
	public void verificationMessage(String expectedMessage) {
		waitTillPresence(factory.accountPage().cardAddedSuccessfully);
		Assert.assertEquals(expectedMessage, factory.accountPage().cardAddedSuccessfully.getText());
		logger.info("message is displayed");

	}

	@When("User click on Edit option of card section")
	public void userClickOnEditOptionOfCardSection() throws InterruptedException {
		click(factory.accountPage().oldCreditCard);
		click(factory.accountPage().editCardButton);
		clearTextUsingSendKeys(factory.accountPage().cardNumberInput);

		clearTextUsingSendKeys(factory.accountPage().nameOnCardInput);
		clearTextUsingSendKeys(factory.accountPage().expirationMonthInput);
		clearTextUsingSendKeys(factory.accountPage().expirationYearInput);
		clearTextUsingSendKeys(factory.accountPage().securityCodeInput);
		logger.info("user clicked on edit your card");
		
	}

	@When("user edit information with below data")
	public void userEditInformationWithBelowData(DataTable dataTable) {
		List<List<String>> newCreditCardInfo = dataTable.asLists(String.class);
		sendText(factory.accountPage().cardNumberInput, (newCreditCardInfo.get(1).get(0)));
		sendText(factory.accountPage().nameOnCardInput, (newCreditCardInfo.get(1).get(1)));
		selectByVisibleText(factory.accountPage().expirationMonthInput, (newCreditCardInfo.get(1).get(2)));
		selectByVisibleText(factory.accountPage().expirationYearInput, (newCreditCardInfo.get(1).get(3)));
		sendText(factory.accountPage().securityCodeInput, (newCreditCardInfo.get(1).get(4)));

	}

	@When("user click on Update Your Card button")
	public void userClickOnUpdateYourCardButton() {

		click(factory.accountPage().updateYourCard);
		logger.info("user clicked on update your card");
	}

	@Then("a message should be displayed for payment update {string}")
	public void aMessageShouldBeDisplayedPaymentMethodUpdatedSuccessfully(String updateValidation) {
		waitTillPresence(factory.accountPage().paymentMethodUpdateValidation);
		Assert.assertEquals(updateValidation, factory.accountPage().paymentMethodUpdateValidation.getText());
		logger.info("message payment method updated successfully");
	}

	@When("User click on remove option of card section")
	public void userClickOnRemoveOptionOfCardSection() {
		click(factory.accountPage().oldCreditCard);
		logger.info("credit card removed and data empth");
	}

	@Then("payment details should be removed")
	public void paymentDetailsShouldBeRemoved() {
		waitTillPresence(factory.accountPage().cardRemovalValidation);
		Assert.assertTrue(isElementDisplayed(factory.accountPage().cardRemovalValidation));
		logger.info("card has been Removed");

	}

	@When("User click on edit address option")
	public void userClickOnEditAddressOption() throws InterruptedException {
		click(factory.accountPage().addressEditButton);
		
		clearTextUsingSendKeys(factory.accountPage().fullNameField);
		clearTextUsingSendKeys(factory.accountPage().phoneNumberField);
		clearTextUsingSendKeys(factory.accountPage().streetAddressField);
		clearTextUsingSendKeys(factory.accountPage().apartmentNumber);
		clearTextUsingSendKeys(factory.accountPage().cityField);
		clearTextUsingSendKeys(factory.accountPage().stateDropDown);
		clearTextUsingSendKeys(factory.accountPage().zipCodeField);
		logger.info("all account fields have been cleared");

		
	}

	@When("user fill new address form with below information")
	public void userFillNewAddressFormWithBelowInformation(DataTable dataTable) throws InterruptedException {
		List<List<String>> newAddressInfo = dataTable.asLists(String.class);
		selectByVisibleText(factory.accountPage().country, DataGeneratorUtility.data(newAddressInfo.get(0).get(0)));
		sendText(factory.accountPage().fullNameField, DataGeneratorUtility.data(newAddressInfo.get(0).get(1)));
		sendText(factory.accountPage().phoneNumberField, DataGeneratorUtility.data(newAddressInfo.get(0).get(2)));
		
		sendText(factory.accountPage().streetAddressField, DataGeneratorUtility.data(newAddressInfo.get(0).get(3)));
		
		sendText(factory.accountPage().apartmentNumber, DataGeneratorUtility.data(newAddressInfo.get(0).get(4)));
		sendText(factory.accountPage().cityField, DataGeneratorUtility.data(newAddressInfo.get(0).get(5)));
		selectByVisibleText(factory.accountPage().stateDropDown,
				DataGeneratorUtility.data(newAddressInfo.get(0).get(6)));
		sendText(factory.accountPage().zipCodeField, DataGeneratorUtility.data(newAddressInfo.get(0).get(7)));
		logger.info("user filled the new address form with information provided in data table");
		
	}

	@When("User click update Your Address button")
	public void userClickUpdateYourAddressButton() {
		click(factory.accountPage().updateAddressButton);
		logger.info("user clicked updated your address button");

	}

	@Then("a message should be displayed {string}")
	public void addressUpdatedShouldBeDisplayed(String addressUpdatedValidation) {
		waitTillPresence(factory.accountPage().addressUpdatedSuccessfully);
		Assert.assertEquals(addressUpdatedValidation, (factory.accountPage().addressUpdatedSuccessfully).getText());
		logger.info("address updated validation message displayed");

	}

}
