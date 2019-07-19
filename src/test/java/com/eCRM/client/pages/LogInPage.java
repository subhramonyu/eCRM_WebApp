package com.eCRM.client.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.eCRM.client.core.DriverManager;

public class LogInPage 
{	
	@FindBy(how = How.CSS, using = ".store-button #signIn")
	private WebElement webSignInLink;
	
	
	public LogInPage() 
	{
		PageFactory.initElements(DriverManager.getDriver(), this);
	}
	
	
	
	
	
	
	
	
}
