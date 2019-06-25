package com.fluke.connect.app.functional.client.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.fluke.connect.app.utils.CommonUtils;
import com.fluke.connect.app.utils.Config;
import com.fluke.connect.app.utils.DriverManager;
import com.fluke.connect.app.utils.ElementUtils;
import com.fluke.connect.app.utils.GestureUtils;
import com.fluke.connect.app.utils.IOSUtils;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class TeamPage 
{
	@FindBy(how = How.CSS, using = "#inviteTeamButton")
	@AndroidFindBy(id="com.fluke.deviceApp:id/invite_button")
	@iOSFindBy(accessibility = "Add Equipment")
	private WebElement inviteButton;
	
	@AndroidFindBy(id="com.fluke.deviceApp:id/add_user")
	@iOSFindBy(accessibility = "Show Contacts")
	private WebElement showContactsButton;
	
	@AndroidFindBy(id = "dialog_ok")
	private WebElement addContactsPermissionOkButton;
	
	@AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
	private WebElement addContactsPermissionAllowButton;
	
	@FindBy(how = How.CSS, using = "#inviteeEmail")
	@AndroidFindBy(id="com.fluke.deviceApp:id/user_names")
	@iOSFindBy(accessibility = "Invitees")
	private WebElement inviteesTextField;
	
	@FindBy(how = How.CSS, using = "#team-send-invite-button")
	@AndroidFindBy(id="com.fluke.deviceApp:id/invite")
	@iOSFindBy(accessibility = "Send")
	private WebElement sendButton;
	
	@iOSFindBy(accessibility = "Pending Invitations (2)")
	private WebElement pendingInvitationCountText;
	
	@AndroidFindBy(id="com.fluke.deviceApp:id/item_right_arrow")
	@iOSXCUITFindBy(iOSNsPredicate = "name == 'Email' OR name == 'email'")
	private WebElement removeContactEmailTextField;
	
	@iOSXCUITFindBy(iOSNsPredicate = "name CONTAINS '.com'")
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\".com\")")
	private WebElement pendingInvitee;
	
	@FindBy(how = How.CSS, using = "li[data-event='click:invite-revoke']")
	@AndroidFindBy(id="com.fluke.deviceApp:id/revoke_invitation_button")
	@iOSXCUITFindBy(iOSNsPredicate = "name = 'REVOKE INVITATION' OR name = 'Revoke Invitation'")  
	private WebElement revokeInvitationButton;
	
	@AndroidFindBy(id="android:id/button1")
	@iOSFindBy(accessibility = "Revoke")
	private WebElement revokeButton;
	
	@iOSXCUITFindBy(iOSNsPredicate = "name == 'Ok' OR name == 'OK'")
	private WebElement okButton;
	
	@AndroidFindBy(id = "license_info")
	private WebElement licenseInfoTextField;
	
	@AndroidFindBy(id = "android:id/button2")
	@iOSXCUITFindBy(accessibility = "OK")
	private WebElement subscriptionExpirationOkButton;
	
	@FindBy(how = How.CSS, using = ".invite-actions .down-pointer")
	private WebElement downPointerWebElement;
	
	@iOSXCUITFindBy(accessibility = "Back")
	private WebElement backButton;
	
	@FindBy(how = How.CSS, using = ".store-header-tabs [data-feature-desc='Team']")
	private WebElement teamPage;
	
	private Switcher mSwitcher;
	
	public TeamPage()
	{
		CommonUtils.initElements(this, 10);
		mSwitcher = new Switcher();
	}
	
	public enum TeamPageObjectList
	{
		OK_BUTTON, LICENSE_INFO, SUBSCRIPTION_EXPIRATION_OK_BUTTON
	}
	
	public WebElement getElement(TeamPageObjectList objectName)
	{
		switch(objectName)
		{
		case OK_BUTTON:
			return okButton;
		case LICENSE_INFO:
			return licenseInfoTextField;
		case SUBSCRIPTION_EXPIRATION_OK_BUTTON:
			return subscriptionExpirationOkButton;
		default:
				return null;
		}
	}
	
	public void clickOnInviteButton() throws Exception
	{
		ElementUtils.clickIfDisplayedAndEnabled(inviteButton);
	}
	
	public void addContacts(String contact1)
	{
		ElementUtils.sendKeys(inviteesTextField, contact1);
	}
	
	public void clickOnSendButton() throws Exception
	{
		ElementUtils.clickIfDisplayedAndEnabled(sendButton);
	}
	
	public void removeInvitees(int inviteesCount) throws Exception
	{
		for(int i=0; i<inviteesCount; i++)
		{
			if(DriverManager.getDriverName().equals(Config.ANDROID_DRIVER) || DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
				if(DriverManager.getDriverName().equals(Config.IOS_DRIVER)) {
					for(int j = 0; j < 3; j++)
					{
						mSwitcher.switchToWorkOrdersPage();
						CommonUtils.wait(1);
						mSwitcher.switchToTeamPage();
					}
				}
				CommonUtils.wait(2, 5, 1); 
				IOSUtils.isPageLoaded(15, "Data...");
				ElementUtils.reliableClick(1, pendingInvitee, revokeInvitationButton, 5);
				ElementUtils.reliableClick(1, revokeInvitationButton, revokeButton, 5);
				ElementUtils.reliableClick(1, revokeButton, inviteButton, 5);
			}
			else if(DriverManager.getDriverName().equals(Config.WEB_DRIVER)) {
				CommonUtils.wait(10);
				GestureUtils.moveAndClickElement(downPointerWebElement);
				revokeInvitationButton.click();
				DriverManager.getDriver().switchTo().alert().accept();
			}
			
		}
	}
	
	public String getPendingInviteesText()
	{
		return pendingInvitationCountText.getText();
	}
	
	public void inviteMember(String userID) throws Exception
	{
		CommonUtils.wait(10);
		if(DriverManager.getDriverName().equals(Config.WEB_DRIVER))
			ElementUtils.click(5, teamPage);
		ElementUtils.click(5, inviteButton);
		ElementUtils.sendKeys(inviteesTextField, userID);
		sendButton.click();
	}
}
