package com.fluke.connect.app.others;

import java.text.DecimalFormat;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.annotations.Test;
import com.fluke.connect.app.utils.CommonUtils;
import com.fluke.connect.app.utils.DateAndTimeUtils;
import com.fluke.connect.app.utils.DriverManager;
import com.fluke.connect.app.utils.ExcelUtils;

public class SpeedTest {
	
	@FindBy(how = How.CSS, using = ".start-text")
	private WebElement goButton;
	
	@FindBy(how = How.CSS, using = "span[class='result-data-large number result-data-value download-speed']")
	private WebElement downloadSpeedStaticText;
	
	@FindBy(how = How.CSS, using = "span[class='result-data-large number result-data-value upload-speed']")
	private WebElement uploadSpeedStaticText;
	
	public final static String SPEED_TEST = "speed_test";
	private String timestamp;
	private String downloadSpeed;
	private String uploadSpeed;
	private String timeoutMessage = "Page failed to load in 1 min";
	DecimalFormat decimalFormat = new DecimalFormat("#.##");
	
	
	@Test(priority=1, groups= {SPEED_TEST})
	public void startDownloadTest(){
		CommonUtils.initElements(this, 60);
		goButton.click();
		CommonUtils.wait(60);
	}

	@Test(priority=2, groups= {SPEED_TEST})
	public void getDownloadSpeed(){
		timestamp = DateAndTimeUtils.getCurrentTimeStamp("dd-MMM-yyyy HH:mm:ss");
		try {
			downloadSpeed = downloadSpeedStaticText.getText();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority=3, groups= {SPEED_TEST})
	public void getUploadSpeed(){
		try {
			uploadSpeed = uploadSpeedStaticText.getText();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		try {	
			if((downloadSpeed != null & uploadSpeed != null) && !(StringUtils.isBlank(downloadSpeed) || StringUtils.isBlank(uploadSpeed))) {
				ExcelUtils.appendRows("./files/SpeedTest.xlsx", "SpeedTest", new Object[][]{{timestamp, Float.parseFloat(downloadSpeed), Float.parseFloat(uploadSpeed)}});
				System.out.println(Float.parseFloat(decimalFormat.format(downloadSpeed)));
			}
			else {
				ExcelUtils.appendRows("./files/SpeedTest.xlsx", "SpeedTest", new Object[][]{{timestamp, timeoutMessage, timeoutMessage}});
			}
			DriverManager.getDriver().quit();
		}
		catch(Exception e) {
			ExcelUtils.appendRows(System.getProperty("user.home")+"/SpeedTest.xlsx", "SpeedTest", new Object[][]{{timestamp, timeoutMessage, timeoutMessage}});
			DriverManager.getDriver().quit();
		}

	}
}
