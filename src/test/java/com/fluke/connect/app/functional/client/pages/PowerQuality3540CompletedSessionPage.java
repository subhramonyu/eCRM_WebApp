package com.fluke.connect.app.functional.client.pages;

import java.time.temporal.ChronoUnit;
import java.util.List;
import org.openqa.selenium.WebElement;

import com.fluke.connect.app.utils.CommonUtils;
import com.fluke.connect.app.utils.Gestures;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.WithTimeout;
import io.appium.java_client.pagefactory.iOSFindBy;

public class PowerQuality3540CompletedSessionPage {

	//@AndroidFindBy(xpath=("//*[@text='V, A, Hz']"))
	/*@AndroidFindBy(xpath="//android.widget.TextView[@text='V, A, Hz']")
	private WebElement graphViewDropdown;
	
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Active Power']")
	private WebElement activePower;
	*/
	
	//private CompletedSessionPage completedSessionPage = new CompletedSessionPage();
	
	public static String[] voltageValues = {"176.5 V", "176.5 V", "194.4 V", "194.3 V", "269.8 V", "269.6 V"};
	
	@AndroidFindBy(id = "max_column1")
	private List<WebElement> firstColumnValue;
	
	@AndroidFindBy(id = "max_column2")
	private List<WebElement> secondColumnValue;
	
	@AndroidFindBy(id = "max_column3")
	private List<WebElement> thirdColumnValue;
	
	@AndroidFindBy(id = "gateway_name")
	private WebElement gateway3540name;
	
	@WithTimeout(time = 20, chronoUnit = ChronoUnit.SECONDS)
	@iOSFindBy(accessibility="backBarButton")
	@AndroidFindBy(id="com.fluke.deviceApp:id/action_bar_item_left")
	public static WebElement backButton;
	
	
private Gestures gesture;
	
	public PowerQuality3540CompletedSessionPage()
	{
		CommonUtils.initElements(this);
		gesture = new Gestures();
	}
	
	public void switchingBetweenGraphView()
	{
		
		CommonUtils.wait(5);
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();
		//graphViewDropdown.click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Active Power").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Active Power").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Power Overview").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Power Overview").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("THD/THC").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("THD/THC").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();
		CommonUtils.wait(1);
	}
	
	public void switchingBetweenVAHzView()
	{
		
		CommonUtils.wait(3);
		//CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();
		//graphViewDropdown.click();
		//CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Voltage (A, B, C)").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Voltage (A, B, C)").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Voltage (A, B, C)").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Current (A, B, C)").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Current (A, B, C)").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Frequency").click();
		CommonUtils.wait(1);
	}
	
	
	public void switchingBetweenActivePowerView()
		{
			
			CommonUtils.wait(3);
			CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();
			CommonUtils.wait(1);
			CommonUtils.getElementByUsingVisibleText("Active Power").click();
			//graphViewDropdown.click();
			CommonUtils.wait(2);
			CommonUtils.getElementByUsingVisibleText("Active Power (A, B, C, Total)").click();
			CommonUtils.wait(1);
			CommonUtils.getElementByUsingVisibleText("Active Power (A, B, C, Total)").click();
			CommonUtils.wait(1);
			CommonUtils.getElementByUsingVisibleText("Active Power (A, B, C, Total)").click();
			CommonUtils.wait(1);
			CommonUtils.getElementByUsingVisibleText("Power Factor (A, B, C, Total)").click();
			CommonUtils.wait(1);
			CommonUtils.getElementByUsingVisibleText("Active Power").click();
			CommonUtils.wait(1);
			CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();
			CommonUtils.wait(1);
		}
	
	public void switchingBetweenPowerOverViewView()
	{
		
		CommonUtils.wait(3);
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Power Overview").click();
		//graphViewDropdown.click();
		CommonUtils.wait(2);
		CommonUtils.getElementByUsingVisibleText("Phase A (kW, kVA, kvar)").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Phase A (kW, kVA, kvar)").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Phase A (kW, kVA, kvar)").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Phase B (kW, kVA, kvar)").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Phase B (kW, kVA, kvar)").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Phase C (kW, kVA, kvar)").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Phase C (kW, kVA, kvar)").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Total (kW, kVA, kvar)").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Total (kW, kVA, kvar)").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("kW (A, B, C, Total)").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("kW (A, B, C, Total)").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("kVA (A, B, C, Total)").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("kVA (A, B, C, Total)").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("kvar (A, B, C, Total)").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Power Overview").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();
		CommonUtils.wait(1);
	}
	
	public void switchingBetweenTHDTHCView()
	{
		
		CommonUtils.wait(3);
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("THD/THC").click();
		//graphViewDropdown.click();
		CommonUtils.wait(2);
		CommonUtils.getElementByUsingVisibleText("THD - V (A, B, C)").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("THD - V (A, B, C)").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("THD - V (A, B, C)").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("THD - A (A, B, C)").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("THD - A (A, B, C)").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("THC - A (A, B, C)").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("THD/THC").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();
		CommonUtils.wait(1);
		gesture.scroll(null,null,null,"1M",-45,-80,null,null);
		CommonUtils.wait(1);
	}

	public Boolean voltage1HourGraphTab()
	{
		CommonUtils.getElementByUsingVisibleText("Voltage (A, B, C)").click();
		CommonUtils.getElementByUsingVisibleText("Voltage (A, B, C)").click();
		CommonUtils.wait(1);
		gesture.scroll(null,null,null,"1H",-45,-60,null,null);
		CommonUtils.getElementByUsingVisibleText("1H").click();
		CommonUtils.wait(2);
		gesture.scroll(null,null, null, "unknown text so that scroll happens till end",-45,-1000, null, null);
		return staleDataCheck(firstColumnValue);
		
	}
	
	
	public Boolean voltage1DGraphTab()
	{
		CommonUtils.getElementByUsingVisibleText("Voltage (A, B, C)").click();
		CommonUtils.getElementByUsingVisibleText("Voltage (A, B, C)").click();
		gesture.scroll(null,null,null,"1D",-45,-60,null,null);
		CommonUtils.getElementByUsingVisibleText("1D").click();
		CommonUtils.wait(2);
		gesture.scroll(null,null, null,"unknown text so that scroll happens till end",-45,-1000, null, null);
		return staleDataCheck(firstColumnValue);
		
	}
	
	public Boolean voltage1WGraphTab()
	{
		CommonUtils.getElementByUsingVisibleText("Voltage (A, B, C)").click();
		CommonUtils.getElementByUsingVisibleText("Voltage (A, B, C)").click();
		gesture.scroll(null,null,null,"1W",-45,-60,null,null);
		CommonUtils.getElementByUsingVisibleText("1W").click();
		CommonUtils.wait(2);
		gesture.scroll(null,null, null, "unknown text so that scroll happens till end",-45,-1000, null, null);
		return staleDataCheck(firstColumnValue);
		
	}
	
	public Boolean voltage1MGraphTab()
	{
		CommonUtils.getElementByUsingVisibleText("Voltage (A, B, C)").click();
		CommonUtils.getElementByUsingVisibleText("Voltage (A, B, C)").click();
		gesture.scroll(null, null, null, "1M",-45, -60, null, null);
		CommonUtils.getElementByUsingVisibleText("1M").click();
		CommonUtils.wait(2);
		gesture.scroll(null,null, null, "unknown text so that scroll happens till end",-45,-1000, null, null);
		return staleDataCheck(firstColumnValue);
		
	}
	
	public Boolean voltageAllGraphTab()
	{
		CommonUtils.getElementByUsingVisibleText("Voltage (A, B, C)").click();
		CommonUtils.getElementByUsingVisibleText("Voltage (A, B, C)").click();
		gesture.scroll(null,null,null,"All",-45,-60,null,null);
		CommonUtils.getElementByUsingVisibleText("All").click();
		CommonUtils.wait(2);
		gesture.scroll(null,null, null, "unknown text so that scroll happens till end",-45, -1000, null, null);
		return staleDataCheck(firstColumnValue);		
	}
	
	
	public Boolean current1HGraphTab()
	{
		CommonUtils.getElementByUsingVisibleText("Voltage (A, B, C)").click();
		CommonUtils.getElementByUsingVisibleText("Current (A, B, C)").click();
		gesture.scroll(null,null,null,"1H",-45,-60,null,null);
		CommonUtils.getElementByUsingVisibleText("1H").click();
		CommonUtils.wait(2);

		gesture.scroll(null,null, null, "unknown text so that scroll happens till end",-45,-1000, null, null);
		Boolean staledatastatus = staleDataCheck(secondColumnValue);
		gesture.scroll(null,null, null,"1M",-45,-60, null, null);
		CommonUtils.getElementByUsingVisibleText("Current (A, B, C)").click();
		CommonUtils.getElementByUsingVisibleText("Voltage (A, B, C)").click();
		return staledatastatus;

	}

	
	public Boolean current1DGraphTab()
	{
		CommonUtils.getElementByUsingVisibleText("Voltage (A, B, C)").click();
		CommonUtils.getElementByUsingVisibleText("Current (A, B, C)").click();
		CommonUtils.getElementByUsingVisibleText("1D").click();
		CommonUtils.wait(2);
		gesture.scroll(null,null, null, "unknown text so that scroll happens till end",-45,-1000, null, null);
		Boolean staledatastatus = staleDataCheck(secondColumnValue);
		gesture.scroll(null,null, null,"1M",-45,-60, null, null);
		CommonUtils.getElementByUsingVisibleText("Current (A, B, C)").click();
		CommonUtils.getElementByUsingVisibleText("Voltage (A, B, C)").click();
		return staledatastatus;

	}
	
	public Boolean current1WGraphTab()
	{
		CommonUtils.getElementByUsingVisibleText("Voltage (A, B, C)").click();
		CommonUtils.getElementByUsingVisibleText("Current (A, B, C)").click();
		CommonUtils.getElementByUsingVisibleText("1W").click();
		CommonUtils.wait(2);
		gesture.scroll(null,null, null, "unknown text so that scroll happens till end",-45,-1000, null, null);
		Boolean staledatastatus = staleDataCheck(secondColumnValue);
		gesture.scroll(null,null, null,"1M",-45,-60, null, null);
		CommonUtils.getElementByUsingVisibleText("Current (A, B, C)").click();
		CommonUtils.getElementByUsingVisibleText("Voltage (A, B, C)").click();
		return staledatastatus;

	}
	
	public Boolean current1MGraphTab()
	{
		CommonUtils.getElementByUsingVisibleText("Voltage (A, B, C)").click();
		CommonUtils.getElementByUsingVisibleText("Current (A, B, C)").click();
		CommonUtils.getElementByUsingVisibleText("1M").click();
		CommonUtils.wait(2);
		gesture.scroll(null,null, null, "unknown text so that scroll happens till end",-45,-1000, null, null);
		Boolean staledatastatus = staleDataCheck(secondColumnValue);
		gesture.scroll(null,null, null,"1M",-45,-60, null, null);
		CommonUtils.getElementByUsingVisibleText("Current (A, B, C)").click();
		CommonUtils.getElementByUsingVisibleText("Voltage (A, B, C)").click();
		return staledatastatus;

	}
	
	public Boolean currentAllGraphTab()
	{
		CommonUtils.getElementByUsingVisibleText("Voltage (A, B, C)").click();
		CommonUtils.getElementByUsingVisibleText("Current (A, B, C)").click();
		CommonUtils.getElementByUsingVisibleText("All").click();
		CommonUtils.wait(2);
		gesture.scroll(null,null, null, "unknown text so that scroll happens till end",-45,-1000, null, null);
		Boolean staledatastatus = staleDataCheck(secondColumnValue);
		gesture.scroll(null,null, null,"1M",-45,-60, null, null);
		CommonUtils.getElementByUsingVisibleText("Current (A, B, C)").click();
		CommonUtils.getElementByUsingVisibleText("Voltage (A, B, C)").click();
		return staledatastatus;

	}
	
	public Boolean frequency1HGraphTab()
	{
		CommonUtils.getElementByUsingVisibleText("Voltage (A, B, C)").click();
		CommonUtils.getElementByUsingVisibleText("Frequency").click();
		CommonUtils.getElementByUsingVisibleText("1H").click();
		CommonUtils.wait(2);
		gesture.scroll(null,null, null, "unknown text so that scroll happens till end",-45,-1000, null, null);
		Boolean staledatastatus = staleDataCheck(secondColumnValue);
		gesture.scroll(null,null, null,"1M",-45,-60, null, null);
		CommonUtils.getElementByUsingVisibleText("Frequency").click();
		CommonUtils.getElementByUsingVisibleText("Voltage (A, B, C)").click();
		return staledatastatus;

	}
	
	public Boolean frequency1DGraphTab()
	{
		CommonUtils.getElementByUsingVisibleText("Voltage (A, B, C)").click();
		CommonUtils.getElementByUsingVisibleText("Frequency").click();
		CommonUtils.getElementByUsingVisibleText("1D").click();
		CommonUtils.wait(2);
		gesture.scroll(null,null, null, "unknown text so that scroll happens till end",-45,-1000, null, null);
		Boolean staledatastatus = staleDataCheck(secondColumnValue);
		gesture.scroll(null,null, null,"1M",-45,-60, null, null);
		CommonUtils.getElementByUsingVisibleText("Frequency").click();
		CommonUtils.getElementByUsingVisibleText("Voltage (A, B, C)").click();
		return staledatastatus;

	}
	
	public Boolean frequency1WGraphTab()
	{
		CommonUtils.getElementByUsingVisibleText("Voltage (A, B, C)").click();
		CommonUtils.getElementByUsingVisibleText("Frequency").click();
		CommonUtils.getElementByUsingVisibleText("1W").click();
		CommonUtils.wait(2);
		gesture.scroll(null,null, null, "unknown text so that scroll happens till end",-45,-1000, null, null);
		Boolean staledatastatus = staleDataCheck(secondColumnValue);
		gesture.scroll(null,null, null,"1M",-45,-60, null, null);
		CommonUtils.getElementByUsingVisibleText("Frequency").click();
		CommonUtils.getElementByUsingVisibleText("Voltage (A, B, C)").click();
		return staledatastatus;

	}
	
	public Boolean frequency1MGraphTab()
	{
		CommonUtils.getElementByUsingVisibleText("Voltage (A, B, C)").click();
		CommonUtils.getElementByUsingVisibleText("Frequency").click();
		CommonUtils.getElementByUsingVisibleText("1M").click();
		CommonUtils.wait(2);
		gesture.scroll(null,null, null, "unknown text so that scroll happens till end",-45,-1000, null, null);
		Boolean staledatastatus = staleDataCheck(secondColumnValue);
		gesture.scroll(null,null, null,"1M",-45,-60, null, null);
		CommonUtils.getElementByUsingVisibleText("Frequency").click();
		CommonUtils.getElementByUsingVisibleText("Voltage (A, B, C)").click();
		return staledatastatus;
	}
	
	public Boolean frequencyAllGraphTab()
	{
		CommonUtils.getElementByUsingVisibleText("Voltage (A, B, C)").click();
		CommonUtils.getElementByUsingVisibleText("Frequency").click();
		CommonUtils.getElementByUsingVisibleText("All").click();
		CommonUtils.wait(2);
		gesture.scroll(null,null, null, "unknown text so that scroll happens till end",-45,-1000, null, null);
		Boolean staledatastatus = staleDataCheck(secondColumnValue);
		gesture.scroll(null,null, null,"1M",-45,-60, null, null);
		CommonUtils.getElementByUsingVisibleText("Frequency").click();
		CommonUtils.getElementByUsingVisibleText("Voltage (A, B, C)").click();
		return staledatastatus;
	}
	
	public Boolean activePower1HGraphTab()
	{
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Active Power").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Active Power (A, B, C, Total)").click();
		CommonUtils.getElementByUsingVisibleText("Active Power (A, B, C, Total)").click();
		CommonUtils.getElementByUsingVisibleText("1H").click();
		CommonUtils.wait(2);
		gesture.scroll(null,null, null, "unknown text so that scroll happens till end",-45,-1000, null, null);
		Boolean staledatastatus = staleDataCheck(firstColumnValue);
		gesture.scroll(null,null, null,"1M",-45,-60, null, null);
		CommonUtils.getElementByUsingVisibleText("Active Power").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();	
		return staledatastatus;
	}
	
	public Boolean activePower1DGraphTab()
	{
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Active Power").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Active Power (A, B, C, Total)").click();
		CommonUtils.getElementByUsingVisibleText("Active Power (A, B, C, Total)").click();
		CommonUtils.getElementByUsingVisibleText("1D").click();
		CommonUtils.wait(2);
		gesture.scroll(null,null, null, "unknown text so that scroll happens till end",-45,-1000, null, null);
		Boolean staledatastatus = staleDataCheck(firstColumnValue);
		gesture.scroll(null,null, null,"1M",-45,-60, null, null);
		CommonUtils.getElementByUsingVisibleText("Active Power").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();	
		return staledatastatus;
	}
	
	public Boolean activePower1WGraphTab()
	{
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Active Power").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Active Power (A, B, C, Total)").click();
		CommonUtils.getElementByUsingVisibleText("Active Power (A, B, C, Total)").click();
		CommonUtils.getElementByUsingVisibleText("1W").click();
		CommonUtils.wait(2);
		gesture.scroll(null,null, null, "unknown text so that scroll happens till end",-45,-1000, null, null);
		Boolean staledatastatus = staleDataCheck(firstColumnValue);
		gesture.scroll(null,null, null,"1M",-45,-60, null, null);
		CommonUtils.getElementByUsingVisibleText("Active Power").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();	
		return staledatastatus;

	}
	
	
	public Boolean activePower1MGraphTab()
	{
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Active Power").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Active Power (A, B, C, Total)").click();
		CommonUtils.getElementByUsingVisibleText("Active Power (A, B, C, Total)").click();
		CommonUtils.getElementByUsingVisibleText("1M").click();
		CommonUtils.wait(2);
		gesture.scroll(null,null, null, "unknown text so that scroll happens till end",-45,-1000, null, null);
		Boolean staledatastatus = staleDataCheck(firstColumnValue);
		gesture.scroll(null,null, null,"1M",-45,-60, null, null);
		CommonUtils.getElementByUsingVisibleText("Active Power").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();	
		return staledatastatus;
	}
	
	public Boolean activePowerAllGraphTab()
	{
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Active Power").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Active Power (A, B, C, Total)").click();
		CommonUtils.getElementByUsingVisibleText("Active Power (A, B, C, Total)").click();
		CommonUtils.getElementByUsingVisibleText("All").click();
		CommonUtils.wait(2);
		gesture.scroll(null,null, null, "unknown text so that scroll happens till end",-45,-1000, null, null);
		Boolean staledatastatus = staleDataCheck(firstColumnValue);
		gesture.scroll(null,null, null,"1M",-45,-60, null, null);
		CommonUtils.getElementByUsingVisibleText("Active Power").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();	
		return staledatastatus;
	}
	
	public Boolean powerFactor1HGraphTab()
	{
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Active Power").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Active Power (A, B, C, Total)").click();
		CommonUtils.getElementByUsingVisibleText("Power Factor (A, B, C, Total)").click();
		CommonUtils.getElementByUsingVisibleText("1H").click();
		CommonUtils.wait(2);
		gesture.scroll(null,null, null, "unknown text so that scroll happens till end",-45,-1000, null, null);
		Boolean staledatastatus = staleDataCheck(secondColumnValue);
		gesture.scroll(null,null, null,"1M",-45,-60, null, null);
		CommonUtils.getElementByUsingVisibleText("Active Power").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();	
		return staledatastatus;
	}
	
	public Boolean powerFactor1DGraphTab()
	{
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Active Power").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Active Power (A, B, C, Total)").click();
		CommonUtils.getElementByUsingVisibleText("Power Factor (A, B, C, Total)").click();
		CommonUtils.getElementByUsingVisibleText("1D").click();
		CommonUtils.wait(2);
		gesture.scroll(null,null, null, "unknown text so that scroll happens till end",-45,-1000, null, null);
		Boolean staledatastatus = staleDataCheck(secondColumnValue);
		gesture.scroll(null,null, null,"1M",-45,-60, null, null);
		CommonUtils.getElementByUsingVisibleText("Active Power").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();	
		return staledatastatus;
	}
	
	
	public Boolean powerFactor1WGraphTab()
	{
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Active Power").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Active Power (A, B, C, Total)").click();
		CommonUtils.getElementByUsingVisibleText("Power Factor (A, B, C, Total)").click();
		CommonUtils.getElementByUsingVisibleText("1W").click();
		CommonUtils.wait(2);
		gesture.scroll(null,null, null, "unknown text so that scroll happens till end",-45,-1000, null, null);
		Boolean staledatastatus = staleDataCheck(secondColumnValue);
		gesture.scroll(null,null, null,"1M",-45,-60, null, null);
		CommonUtils.getElementByUsingVisibleText("Active Power").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();	
		return staledatastatus;
	}
	
	
	public Boolean powerFactor1MGraphTab()
	{
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Active Power").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Active Power (A, B, C, Total)").click();
		CommonUtils.getElementByUsingVisibleText("Power Factor (A, B, C, Total)").click();
		CommonUtils.getElementByUsingVisibleText("1M").click();
		CommonUtils.wait(2);
		gesture.scroll(null,null, null, "unknown text so that scroll happens till end",-45,-1000, null, null);
		Boolean staledatastatus = staleDataCheck(secondColumnValue);
		gesture.scroll(null,null, null,"1M",-45,-60, null, null);
		CommonUtils.getElementByUsingVisibleText("Active Power").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();	
		return staledatastatus;
	}
	
	
	public Boolean powerFactorAllGraphTab()
	{
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Active Power").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Active Power (A, B, C, Total)").click();
		CommonUtils.getElementByUsingVisibleText("Power Factor (A, B, C, Total)").click();
		CommonUtils.getElementByUsingVisibleText("All").click();
		CommonUtils.wait(2);
		gesture.scroll(null,null, null, "unknown text so that scroll happens till end",-45,-1000, null, null);
		Boolean staledatastatus = staleDataCheck(secondColumnValue);
		gesture.scroll(null,null, null,"1M",-45,-60, null, null);
		CommonUtils.getElementByUsingVisibleText("Active Power").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();	
		return staledatastatus;
	}
	
	public Boolean powerOverView_PhaseA_1HGraphTab()
	{
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Power Overview").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Phase A (kW, kVA, kvar)").click();
		CommonUtils.getElementByUsingVisibleText("Phase A (kW, kVA, kvar)").click();
		CommonUtils.getElementByUsingVisibleText("1H").click();
		CommonUtils.wait(2);
		gesture.scroll(null,null, null, "unknown text so that scroll happens till end",-45,-1000, null, null);
		Boolean staledatastatus = staleDataCheck(firstColumnValue);
		gesture.scroll(null,null, null,"1M",-45,-60, null, null);
		CommonUtils.getElementByUsingVisibleText("Power Overview").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();	
		return staledatastatus;
	}
	
	public Boolean powerOverView_PhaseA_1DGraphTab()
	{
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Power Overview").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Phase A (kW, kVA, kvar)").click();
		CommonUtils.getElementByUsingVisibleText("Phase A (kW, kVA, kvar)").click();
		CommonUtils.getElementByUsingVisibleText("1D").click();
		CommonUtils.wait(2);
		gesture.scroll(null,null, null, "unknown text so that scroll happens till end",-45,-1000, null, null);
		Boolean staledatastatus = staleDataCheck(firstColumnValue);
		gesture.scroll(null,null, null,"1M",-45,-60, null, null);
		CommonUtils.getElementByUsingVisibleText("Power Overview").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();	
		return staledatastatus;
	}
	
	
	public Boolean powerOverView_PhaseA_1WGraphTab()
	{
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Power Overview").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Phase A (kW, kVA, kvar)").click();
		CommonUtils.getElementByUsingVisibleText("Phase A (kW, kVA, kvar)").click();
		CommonUtils.getElementByUsingVisibleText("1W").click();
		CommonUtils.wait(2);
		gesture.scroll(null,null, null, "unknown text so that scroll happens till end",-45,-1000, null, null);
		Boolean staledatastatus = staleDataCheck(firstColumnValue);
		gesture.scroll(null,null, null,"1M",-45,-60, null, null);
		CommonUtils.getElementByUsingVisibleText("Power Overview").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();	
		return staledatastatus;
	}
	
	public Boolean powerOverView_PhaseA_1MGraphTab()
	{
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Power Overview").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Phase A (kW, kVA, kvar)").click();
		CommonUtils.getElementByUsingVisibleText("Phase A (kW, kVA, kvar)").click();
		CommonUtils.getElementByUsingVisibleText("1M").click();
		CommonUtils.wait(2);
		gesture.scroll(null,null, null, "unknown text so that scroll happens till end",-45,-1000, null, null);
		Boolean staledatastatus = staleDataCheck(secondColumnValue);
		gesture.scroll(null,null, null,"1M",-45,-60, null, null);
		CommonUtils.getElementByUsingVisibleText("Power Overview").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();	
		return staledatastatus;
	}
	
	public Boolean powerOverView_PhaseA_AllGraphTab()
	{
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Power Overview").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Phase A (kW, kVA, kvar)").click();
		CommonUtils.getElementByUsingVisibleText("Phase A (kW, kVA, kvar)").click();
		CommonUtils.getElementByUsingVisibleText("All").click();
		CommonUtils.wait(2);
		gesture.scroll(null,null, null, "unknown text so that scroll happens till end",-45,-1000, null, null);
		Boolean staledatastatus = staleDataCheck(thirdColumnValue);
		gesture.scroll(null,null, null,"1M",-45,-60, null, null);
		CommonUtils.getElementByUsingVisibleText("Power Overview").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();	
		return staledatastatus;
	}
	
	
	public Boolean powerOverView_PhaseB_1HGraphTab()
	{
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Power Overview").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Phase A (kW, kVA, kvar)").click();
		CommonUtils.getElementByUsingVisibleText("Phase B (kW, kVA, kvar)").click();
		CommonUtils.getElementByUsingVisibleText("1H").click();
		CommonUtils.wait(2);
		gesture.scroll(null,null, null, "unknown text so that scroll happens till end",-45,-1000, null, null);
		Boolean staledatastatus = staleDataCheck(firstColumnValue);
		gesture.scroll(null,null, null,"1M",-45,-60, null, null);
		CommonUtils.getElementByUsingVisibleText("Power Overview").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();	
		return staledatastatus;
	}
	
	
	public Boolean powerOverView_PhaseB_1DGraphTab()
	{
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Power Overview").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Phase A (kW, kVA, kvar)").click();
		CommonUtils.getElementByUsingVisibleText("Phase B (kW, kVA, kvar)").click();
		CommonUtils.getElementByUsingVisibleText("1D").click();
		CommonUtils.wait(2);
		gesture.scroll(null,null, null, "unknown text so that scroll happens till end",-45,-1000, null, null);
		Boolean staledatastatus = staleDataCheck(secondColumnValue);
		gesture.scroll(null,null, null,"1M",-45,-60, null, null);
		CommonUtils.getElementByUsingVisibleText("Power Overview").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();	
		return staledatastatus;
	}
	
	
	public Boolean powerOverView_PhaseB_1WGraphTab()
	{
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Power Overview").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Phase A (kW, kVA, kvar)").click();
		CommonUtils.getElementByUsingVisibleText("Phase B (kW, kVA, kvar)").click();
		CommonUtils.getElementByUsingVisibleText("1W").click();
		CommonUtils.wait(2);
		gesture.scroll(null,null, null, "unknown text so that scroll happens till end",-45,-1000, null, null);
		Boolean staledatastatus = staleDataCheck(secondColumnValue);
		gesture.scroll(null,null, null,"1M",-45,-60, null, null);
		CommonUtils.getElementByUsingVisibleText("Power Overview").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();	
		return staledatastatus;
	}
	
	
	public Boolean powerOverView_PhaseB_1MGraphTab()
	{
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Power Overview").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Phase A (kW, kVA, kvar)").click();
		CommonUtils.getElementByUsingVisibleText("Phase B (kW, kVA, kvar)").click();
		CommonUtils.getElementByUsingVisibleText("1M").click();
		CommonUtils.wait(2);
		gesture.scroll(null,null, null, "unknown text so that scroll happens till end",-45,-1000, null, null);
		Boolean staledatastatus = staleDataCheck(thirdColumnValue);
		gesture.scroll(null,null, null,"1M",-45,-60, null, null);
		CommonUtils.getElementByUsingVisibleText("Power Overview").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();	
		return staledatastatus;
	}
	
	
	public Boolean powerOverView_PhaseB_AllGraphTab()
	{
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Power Overview").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Phase A (kW, kVA, kvar)").click();
		CommonUtils.getElementByUsingVisibleText("Phase B (kW, kVA, kvar)").click();
		CommonUtils.getElementByUsingVisibleText("All").click();
		CommonUtils.wait(2);
		gesture.scroll(null,null, null, "unknown text so that scroll happens till end",-45,-1000, null, null);
		Boolean staledatastatus = staleDataCheck(thirdColumnValue);
		gesture.scroll(null,null, null,"1M",-45,-60, null, null);
		CommonUtils.getElementByUsingVisibleText("Power Overview").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();	
		return staledatastatus;
	}
	
	public Boolean powerOverView_PhaseC_1HGraphTab()
	{
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Power Overview").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Phase A (kW, kVA, kvar)").click();
		CommonUtils.getElementByUsingVisibleText("Phase C (kW, kVA, kvar)").click();
		CommonUtils.getElementByUsingVisibleText("1H").click();
		CommonUtils.wait(2);
		gesture.scroll(null,null, null, "unknown text so that scroll happens till end",-45,-1000, null, null);
		Boolean staledatastatus = staleDataCheck(firstColumnValue);
		gesture.scroll(null,null, null,"1M",-45,-60, null, null);
		CommonUtils.getElementByUsingVisibleText("Power Overview").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();	
		return staledatastatus;
	}
	
	public Boolean powerOverView_PhaseC_1DGraphTab()
	{
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Power Overview").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Phase A (kW, kVA, kvar)").click();
		CommonUtils.getElementByUsingVisibleText("Phase C (kW, kVA, kvar)").click();
		CommonUtils.getElementByUsingVisibleText("1D").click();
		CommonUtils.wait(2);
		gesture.scroll(null,null, null, "unknown text so that scroll happens till end",-45,-1000, null, null);
		Boolean staledatastatus = staleDataCheck(firstColumnValue);
		gesture.scroll(null,null, null,"1M",-45,-60, null, null);
		CommonUtils.getElementByUsingVisibleText("Power Overview").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();	
		return staledatastatus;
	}
	
	
	public Boolean powerOverView_PhaseC_1WGraphTab()
	{
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Power Overview").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Phase A (kW, kVA, kvar)").click();
		CommonUtils.getElementByUsingVisibleText("Phase C (kW, kVA, kvar)").click();
		CommonUtils.getElementByUsingVisibleText("1W").click();
		CommonUtils.wait(2);
		gesture.scroll(null,null, null, "unknown text so that scroll happens till end",-45,-1000, null, null);
		Boolean staledatastatus = staleDataCheck(secondColumnValue);
		gesture.scroll(null,null, null,"1M",-45,-60, null, null);
		CommonUtils.getElementByUsingVisibleText("Power Overview").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();	
		return staledatastatus;
	}
	
	
	public Boolean powerOverView_PhaseC_1MGraphTab()
	{
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Power Overview").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Phase A (kW, kVA, kvar)").click();
		CommonUtils.getElementByUsingVisibleText("Phase C (kW, kVA, kvar)").click();
		CommonUtils.getElementByUsingVisibleText("1M").click();
		CommonUtils.wait(2);
		gesture.scroll(null,null, null, "unknown text so that scroll happens till end",-45,-1000, null, null);
		Boolean staledatastatus = staleDataCheck(thirdColumnValue);
		gesture.scroll(null,null, null,"1M",-45,-60, null, null);
		CommonUtils.getElementByUsingVisibleText("Power Overview").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();	
		return staledatastatus;
	}
	
	
	public Boolean powerOverView_PhaseC_AllGraphTab()
	{
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Power Overview").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Phase A (kW, kVA, kvar)").click();
		CommonUtils.getElementByUsingVisibleText("Phase C (kW, kVA, kvar)").click();
		CommonUtils.getElementByUsingVisibleText("All").click();
		CommonUtils.wait(2);
		gesture.scroll(null,null, null, "unknown text so that scroll happens till end",-45,-1000, null, null);
		Boolean staledatastatus = staleDataCheck(firstColumnValue);
		gesture.scroll(null,null, null,"1M",-45,-60, null, null);
		CommonUtils.getElementByUsingVisibleText("Power Overview").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();	
		return staledatastatus;
	}
	
	public Boolean powerOverView_Total_1HGraphTab()
	{
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Power Overview").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Phase A (kW, kVA, kvar)").click();
		CommonUtils.getElementByUsingVisibleText("Total (kW, kVA, kvar)").click();
		CommonUtils.getElementByUsingVisibleText("1H").click();
		CommonUtils.wait(2);
		gesture.scroll(null,null, null, "unknown text so that scroll happens till end",-45,-1000, null, null);
		Boolean staledatastatus = staleDataCheck(firstColumnValue);
		gesture.scroll(null,null, null,"1M",-45,-60, null, null);
		CommonUtils.getElementByUsingVisibleText("Power Overview").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();	
		return staledatastatus;
	}
	
	
	public Boolean powerOverView_Total_1DGraphTab()
	{
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Power Overview").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Phase A (kW, kVA, kvar)").click();
		CommonUtils.getElementByUsingVisibleText("Total (kW, kVA, kvar)").click();
		CommonUtils.getElementByUsingVisibleText("1D").click();
		CommonUtils.wait(2);
		gesture.scroll(null,null, null, "unknown text so that scroll happens till end",-45,-1000, null, null);
		Boolean staledatastatus = staleDataCheck(secondColumnValue);
		gesture.scroll(null,null, null,"1M",-45,-60, null, null);
		CommonUtils.getElementByUsingVisibleText("Power Overview").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();	
		return staledatastatus;
	}
	
	
	public Boolean powerOverView_Total_1WGraphTab()
	{
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Power Overview").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Phase A (kW, kVA, kvar)").click();
		CommonUtils.getElementByUsingVisibleText("Total (kW, kVA, kvar)").click();
		CommonUtils.getElementByUsingVisibleText("1W").click();
		CommonUtils.wait(2);
		gesture.scroll(null,null, null, "unknown text so that scroll happens till end",-45,-1000, null, null);
		Boolean staledatastatus = staleDataCheck(thirdColumnValue);
		gesture.scroll(null,null, null,"1M",-45,-60, null, null);
		CommonUtils.getElementByUsingVisibleText("Power Overview").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();	
		return staledatastatus;
	}
	
	
	public Boolean powerOverView_Total_1MGraphTab()
	{
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Power Overview").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Phase A (kW, kVA, kvar)").click();
		CommonUtils.getElementByUsingVisibleText("Total (kW, kVA, kvar)").click();
		CommonUtils.getElementByUsingVisibleText("1M").click();
		CommonUtils.wait(2);
		gesture.scroll(null,null, null, "unknown text so that scroll happens till end",-45,-1000, null, null);
		Boolean staledatastatus = staleDataCheck(thirdColumnValue);
		gesture.scroll(null,null, null,"1M",-45,-60, null, null);
		CommonUtils.getElementByUsingVisibleText("Power Overview").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();	
		return staledatastatus;
	}
	
	
	public Boolean powerOverView_Total_AllGraphTab()
	{
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Power Overview").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Phase A (kW, kVA, kvar)").click();
		CommonUtils.getElementByUsingVisibleText("Total (kW, kVA, kvar)").click();
		CommonUtils.getElementByUsingVisibleText("All").click();
		CommonUtils.wait(2);
		gesture.scroll(null,null, null, "unknown text so that scroll happens till end",-45,-1000, null, null);
		Boolean staledatastatus = staleDataCheck(thirdColumnValue);
		gesture.scroll(null,null, null,"1M",-45,-60, null, null);
		CommonUtils.getElementByUsingVisibleText("Power Overview").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();	
		return staledatastatus;
	}
	
	
	public Boolean powerOverView_KW_1HGraphTab()
	{
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Power Overview").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Phase A (kW, kVA, kvar)").click();
		CommonUtils.getElementByUsingVisibleText("kW (A, B, C, Total)").click();
		CommonUtils.getElementByUsingVisibleText("1H").click();
		CommonUtils.wait(2);
		gesture.scroll(null,null, null, "unknown text so that scroll happens till end",-45,-1000, null, null);
		Boolean staledatastatus = staleDataCheck(firstColumnValue);
		gesture.scroll(null,null, null,"1M",-45,-60, null, null);
		CommonUtils.getElementByUsingVisibleText("Power Overview").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();	
		return staledatastatus;
	}
	
	
	public Boolean powerOverView_KW_1DGraphTab()
	{
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Power Overview").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Phase A (kW, kVA, kvar)").click();
		CommonUtils.getElementByUsingVisibleText("kW (A, B, C, Total)").click();
		CommonUtils.getElementByUsingVisibleText("1D").click();
		CommonUtils.wait(2);
		gesture.scroll(null,null, null, "unknown text so that scroll happens till end",-45,-1000, null, null);
		Boolean staledatastatus = staleDataCheck(firstColumnValue);
		gesture.scroll(null,null, null,"1M",-45,-60, null, null);
		CommonUtils.getElementByUsingVisibleText("Power Overview").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();	
		return staledatastatus;
	}
	
	
	public Boolean powerOverView_KW_1WGraphTab()
	{
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Power Overview").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Phase A (kW, kVA, kvar)").click();
		CommonUtils.getElementByUsingVisibleText("kW (A, B, C, Total)").click();
		CommonUtils.getElementByUsingVisibleText("1W").click();
		CommonUtils.wait(2);
		gesture.scroll(null,null, null, "unknown text so that scroll happens till end",-45,-1000, null, null);
		Boolean staledatastatus = staleDataCheck(firstColumnValue);
		gesture.scroll(null,null, null,"1M",-45,-60, null, null);
		CommonUtils.getElementByUsingVisibleText("Power Overview").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();	
		return staledatastatus;
	}
	
	
	public Boolean powerOverView_KW_1MGraphTab()
	{
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Power Overview").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Phase A (kW, kVA, kvar)").click();
		CommonUtils.getElementByUsingVisibleText("kW (A, B, C, Total)").click();
		CommonUtils.getElementByUsingVisibleText("1M").click();
		CommonUtils.wait(2);
		gesture.scroll(null,null, null, "unknown text so that scroll happens till end",-45,-1000, null, null);
		Boolean staledatastatus = staleDataCheck(firstColumnValue);
		gesture.scroll(null,null, null,"1M",-45,-60, null, null);
		CommonUtils.getElementByUsingVisibleText("Power Overview").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();	
		return staledatastatus;
	}
	
	
	public Boolean powerOverView_KW_AllGraphTab()
	{
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Power Overview").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Phase A (kW, kVA, kvar)").click();
		CommonUtils.getElementByUsingVisibleText("kW (A, B, C, Total)").click();
		CommonUtils.getElementByUsingVisibleText("All").click();
		CommonUtils.wait(2);
		gesture.scroll(null,null, null, "unknown text so that scroll happens till end",-45,-1000, null, null);
		Boolean staledatastatus = staleDataCheck(firstColumnValue);
		gesture.scroll(null,null, null,"1M",-45,-60, null, null);
		CommonUtils.getElementByUsingVisibleText("Power Overview").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();	
		return staledatastatus;
	}
	
	
	public Boolean powerOverView_KVA_1HGraphTab()
	{
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Power Overview").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Phase A (kW, kVA, kvar)").click();
		CommonUtils.getElementByUsingVisibleText("kVA (A, B, C, Total)").click();
		CommonUtils.getElementByUsingVisibleText("1H").click();
		CommonUtils.wait(2);
		gesture.scroll(null,null, null, "unknown text so that scroll happens till end",-45,-1000, null, null);
		Boolean staledatastatus = staleDataCheck(secondColumnValue);
		gesture.scroll(null,null, null,"1M",-45,-60, null, null);
		CommonUtils.getElementByUsingVisibleText("Power Overview").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();	
		return staledatastatus;
	}
	
	
	public Boolean powerOverView_KVA_1DGraphTab()
	{
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Power Overview").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Phase A (kW, kVA, kvar)").click();
		CommonUtils.getElementByUsingVisibleText("kVA (A, B, C, Total)").click();
		CommonUtils.getElementByUsingVisibleText("1D").click();
		CommonUtils.wait(2);
		gesture.scroll(null,null, null, "unknown text so that scroll happens till end",-45,-1000, null, null);
		Boolean staledatastatus = staleDataCheck(secondColumnValue);
		gesture.scroll(null,null, null,"1M",-45,-60, null, null);
		CommonUtils.getElementByUsingVisibleText("Power Overview").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();	
		return staledatastatus;
	}
	
	
	public Boolean powerOverView_KVA_1WGraphTab()
	{
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Power Overview").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Phase A (kW, kVA, kvar)").click();
		CommonUtils.getElementByUsingVisibleText("kVA (A, B, C, Total)").click();
		CommonUtils.getElementByUsingVisibleText("1W").click();
		CommonUtils.wait(2);
		gesture.scroll(null,null, null, "unknown text so that scroll happens till end",-45,-1000, null, null);
		Boolean staledatastatus = staleDataCheck(secondColumnValue);
		gesture.scroll(null,null, null,"1M",-45,-60, null, null);
		CommonUtils.getElementByUsingVisibleText("Power Overview").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();	
		return staledatastatus;
	}
	
	
	public Boolean powerOverView_KVA_1MGraphTab()
	{
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Power Overview").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Phase A (kW, kVA, kvar)").click();
		CommonUtils.getElementByUsingVisibleText("kVA (A, B, C, Total)").click();
		CommonUtils.getElementByUsingVisibleText("1M").click();
		CommonUtils.wait(2);
		gesture.scroll(null,null, null, "unknown text so that scroll happens till end",-45,-1000, null, null);
		Boolean staledatastatus = staleDataCheck(secondColumnValue);
		gesture.scroll(null,null, null,"1M",-45,-60, null, null);
		CommonUtils.getElementByUsingVisibleText("Power Overview").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();	
		return staledatastatus;
	}
	
	public Boolean powerOverView_KVA_AllGraphTab()
	{
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Power Overview").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Phase A (kW, kVA, kvar)").click();
		CommonUtils.getElementByUsingVisibleText("kVA (A, B, C, Total)").click();
		CommonUtils.getElementByUsingVisibleText("All").click();
		CommonUtils.wait(2);
		gesture.scroll(null,null, null, "unknown text so that scroll happens till end",-45,-1000, null, null);
		Boolean staledatastatus = staleDataCheck(secondColumnValue);
		gesture.scroll(null,null, null,"1M",-45,-60, null, null);
		CommonUtils.getElementByUsingVisibleText("Power Overview").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();	
		return staledatastatus;
	}
	
	
	public Boolean powerOverView_Kvar_1HGraphTab()
	{
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Power Overview").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Phase A (kW, kVA, kvar)").click();
		CommonUtils.getElementByUsingVisibleText("kvar (A, B, C, Total)").click();
		CommonUtils.getElementByUsingVisibleText("1H").click();
		CommonUtils.wait(2);
		gesture.scroll(null,null, null, "unknown text so that scroll happens till end",-45,-1000, null, null);
		Boolean staledatastatus = staleDataCheck(thirdColumnValue);
		gesture.scroll(null,null, null,"1M",-45,-60, null, null);
		CommonUtils.getElementByUsingVisibleText("Power Overview").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();	
		return staledatastatus;
	}
	
	
	public Boolean powerOverView_Kvar_1DGraphTab()
	{
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Power Overview").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Phase A (kW, kVA, kvar)").click();
		CommonUtils.getElementByUsingVisibleText("kvar (A, B, C, Total)").click();
		CommonUtils.getElementByUsingVisibleText("1D").click();
		CommonUtils.wait(2);
		gesture.scroll(null,null, null, "unknown text so that scroll happens till end",-45,-1000, null, null);
		Boolean staledatastatus = staleDataCheck(thirdColumnValue);
		gesture.scroll(null,null, null,"1M",-45,-60, null, null);
		CommonUtils.getElementByUsingVisibleText("Power Overview").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();	
		return staledatastatus;
	}
	
	
	public Boolean powerOverView_Kvar_1WGraphTab()
	{
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Power Overview").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Phase A (kW, kVA, kvar)").click();
		CommonUtils.getElementByUsingVisibleText("kvar (A, B, C, Total)").click();
		CommonUtils.getElementByUsingVisibleText("1D").click();
		CommonUtils.wait(2);
		gesture.scroll(null,null, null, "unknown text so that scroll happens till end",-45,-1000, null, null);
		Boolean staledatastatus = staleDataCheck(thirdColumnValue);
		gesture.scroll(null,null, null,"1M",-45,-60, null, null);
		CommonUtils.getElementByUsingVisibleText("Power Overview").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();	
		return staledatastatus;
	}
	
	public Boolean powerOverView_Kvar_1MGraphTab()
	{
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Power Overview").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Phase A (kW, kVA, kvar)").click();
		CommonUtils.getElementByUsingVisibleText("kvar (A, B, C, Total)").click();
		CommonUtils.getElementByUsingVisibleText("1M").click();
		CommonUtils.wait(2);
		gesture.scroll(null,null, null, "unknown text so that scroll happens till end",-45,-1000, null, null);
		Boolean staledatastatus = staleDataCheck(thirdColumnValue);
		gesture.scroll(null,null, null,"1M",-45,-60, null, null);
		CommonUtils.getElementByUsingVisibleText("Power Overview").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();	
		return staledatastatus;
	}
	
	public Boolean powerOverView_Kvar_AllGraphTab()
	{
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Power Overview").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("Phase A (kW, kVA, kvar)").click();
		CommonUtils.getElementByUsingVisibleText("kvar (A, B, C, Total)").click();
		CommonUtils.getElementByUsingVisibleText("All").click();
		CommonUtils.wait(2);
		gesture.scroll(null,null, null, "unknown text so that scroll happens till end",-45,-1000, null, null);
		Boolean staledatastatus = staleDataCheck(thirdColumnValue);
		gesture.scroll(null,null, null,"1M",-45,-60, null, null);
		CommonUtils.getElementByUsingVisibleText("Power Overview").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();	
		return staledatastatus;
	}
	
	public Boolean tHDtHc_THDV_1HGraphTab()
	{
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("THD/THC").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("THD - V (A, B, C)").click();
		CommonUtils.getElementByUsingVisibleText("THD - V (A, B, C)").click();
		CommonUtils.getElementByUsingVisibleText("1H").click();
		CommonUtils.wait(2);
		gesture.scroll(null,null, null, "unknown text so that scroll happens till end",-45,-1000, null, null);
		Boolean staledatastatus = staleDataCheck(firstColumnValue);
		gesture.scroll(null,null, null,"1M",-45,-60, null, null);
		CommonUtils.getElementByUsingVisibleText("THD/THC").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();	
		return staledatastatus;
	}
	
	public Boolean tHDtHc_THDV_1DGraphTab()
	{
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("THD/THC").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("THD - V (A, B, C)").click();
		CommonUtils.getElementByUsingVisibleText("THD - V (A, B, C)").click();
		CommonUtils.getElementByUsingVisibleText("1D").click();
		CommonUtils.wait(2);
		gesture.scroll(null,null, null, "unknown text so that scroll happens till end",-45,-1000, null, null);
		Boolean staledatastatus = staleDataCheck(firstColumnValue);
		gesture.scroll(null,null, null,"1M",-45,-60, null, null);
		CommonUtils.getElementByUsingVisibleText("THD/THC").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();	
		return staledatastatus;
	}
	
	
	public Boolean tHDtHc_THDV_1WGraphTab()
	{
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("THD/THC").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("THD - V (A, B, C)").click();
		CommonUtils.getElementByUsingVisibleText("THD - V (A, B, C)").click();
		CommonUtils.getElementByUsingVisibleText("1W").click();
		CommonUtils.wait(2);
		gesture.scroll(null,null, null, "unknown text so that scroll happens till end",-45,-1000, null, null);
		Boolean staledatastatus = staleDataCheck(firstColumnValue);
		gesture.scroll(null,null, null,"1M",-45,-60, null, null);
		CommonUtils.getElementByUsingVisibleText("THD/THC").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();	
		return staledatastatus;
	}
	
	
	public Boolean tHDtHc_THDV_1MGraphTab()
	{
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("THD/THC").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("THD - V (A, B, C)").click();
		CommonUtils.getElementByUsingVisibleText("THD - V (A, B, C)").click();
		CommonUtils.getElementByUsingVisibleText("1M").click();
		CommonUtils.wait(2);
		gesture.scroll(null,null, null, "unknown text so that scroll happens till end",-45,-1000, null, null);
		Boolean staledatastatus = staleDataCheck(firstColumnValue);
		gesture.scroll(null,null, null,"1M",-45,-60, null, null);
		CommonUtils.getElementByUsingVisibleText("THD/THC").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();	
		return staledatastatus;
	}
	
	public Boolean tHDtHc_THDV_AllGraphTab()
	{
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("THD/THC").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("THD - V (A, B, C)").click();
		CommonUtils.getElementByUsingVisibleText("THD - V (A, B, C)").click();
		CommonUtils.getElementByUsingVisibleText("All").click();
		CommonUtils.wait(2);
		gesture.scroll(null,null, null, "unknown text so that scroll happens till end",-45,-1000, null, null);
		Boolean staledatastatus = staleDataCheck(firstColumnValue);
		gesture.scroll(null,null, null,"1M",-45,-60, null, null);
		CommonUtils.getElementByUsingVisibleText("THD/THC").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();	
		return staledatastatus;
	}
	
	public Boolean tHDtHc_THDA_1HGraphTab()
	{
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("THD/THC").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("THD - V (A, B, C)").click();
		CommonUtils.getElementByUsingVisibleText("THD - A (A, B, C)").click();
		CommonUtils.getElementByUsingVisibleText("1H").click();
		CommonUtils.wait(2);
		gesture.scroll(null,null, null, "unknown text so that scroll happens till end",-45,-1000, null, null);
		Boolean staledatastatus = staleDataCheck(secondColumnValue);
		gesture.scroll(null,null, null,"1M",-45,-60, null, null);
		CommonUtils.getElementByUsingVisibleText("THD/THC").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();	
		return staledatastatus;
	}
	
	public Boolean tHDtHc_THDA_1DGraphTab()
	{
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("THD/THC").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("THD - V (A, B, C)").click();
		CommonUtils.getElementByUsingVisibleText("THD - A (A, B, C)").click();
		CommonUtils.getElementByUsingVisibleText("1D").click();
		CommonUtils.wait(2);
		gesture.scroll(null,null, null, "unknown text so that scroll happens till end",-45,-1000, null, null);
		Boolean staledatastatus = staleDataCheck(secondColumnValue);
		gesture.scroll(null,null, null,"1M",-45,-60, null, null);
		CommonUtils.getElementByUsingVisibleText("THD/THC").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();	
		return staledatastatus;
	}
	
	public Boolean tHDtHc_THDA_1WGraphTab()
	{
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("THD/THC").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("THD - V (A, B, C)").click();
		CommonUtils.getElementByUsingVisibleText("THD - A (A, B, C)").click();
		CommonUtils.getElementByUsingVisibleText("1W").click();
		CommonUtils.wait(2);
		gesture.scroll(null,null, null, "unknown text so that scroll happens till end",-45,-1000, null, null);
		Boolean staledatastatus = staleDataCheck(secondColumnValue);
		gesture.scroll(null,null, null,"1M",-45,-60, null, null);
		CommonUtils.getElementByUsingVisibleText("THD/THC").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();	
		return staledatastatus;
	}
	
	public Boolean tHDtHc_THDA_1MGraphTab()
	{
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("THD/THC").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("THD - V (A, B, C)").click();
		CommonUtils.getElementByUsingVisibleText("THD - A (A, B, C)").click();
		CommonUtils.getElementByUsingVisibleText("1M").click();
		CommonUtils.wait(2);
		gesture.scroll(null,null, null, "unknown text so that scroll happens till end",-45,-1000, null, null);
		Boolean staledatastatus = staleDataCheck(secondColumnValue);
		gesture.scroll(null,null, null,"1M",-45,-60, null, null);
		CommonUtils.getElementByUsingVisibleText("THD/THC").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();	
		return staledatastatus;
	}
	
	
	public Boolean tHDtHc_THDA_AllGraphTab()
	{
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("THD/THC").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("THD - V (A, B, C)").click();
		CommonUtils.getElementByUsingVisibleText("THD - A (A, B, C)").click();
		CommonUtils.getElementByUsingVisibleText("All").click();
		CommonUtils.wait(2);
		gesture.scroll(null,null, null, "unknown text so that scroll happens till end",-45,-1000, null, null);
		Boolean staledatastatus = staleDataCheck(secondColumnValue);
		gesture.scroll(null,null, null,"1M",-45,-60, null, null);
		CommonUtils.getElementByUsingVisibleText("THD/THC").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();	
		return staledatastatus;
	}
	
	
	public Boolean tHDtHc_THCA_1HGraphTab()
	{
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("THD/THC").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("THD - V (A, B, C)").click();
		CommonUtils.getElementByUsingVisibleText("THC - A (A, B, C)").click();
		CommonUtils.getElementByUsingVisibleText("1H").click();
		CommonUtils.wait(2);
		gesture.scroll(null,null, null, "unknown text so that scroll happens till end",-45,-1000, null, null);
		Boolean staledatastatus = staleDataCheck(thirdColumnValue);
		gesture.scroll(null,null, null,"1M",-45,-60, null, null);
		CommonUtils.getElementByUsingVisibleText("THD/THC").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();	
		return staledatastatus;
	}
	
	public Boolean tHDtHc_THCA_1DGraphTab()
	{
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("THD/THC").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("THD - V (A, B, C)").click();
		CommonUtils.getElementByUsingVisibleText("THC - A (A, B, C)").click();
		CommonUtils.getElementByUsingVisibleText("1D").click();
		CommonUtils.wait(2);
		gesture.scroll(null,null, null, "unknown text so that scroll happens till end",-45,-1000, null, null);
		Boolean staledatastatus = staleDataCheck(thirdColumnValue);
		gesture.scroll(null,null, null,"1M",-45,-60, null, null);
		CommonUtils.getElementByUsingVisibleText("THD/THC").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();	
		return staledatastatus;
	}
	
	
	public Boolean tHDtHc_THCA_1WGraphTab()
	{
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("THD/THC").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("THD - V (A, B, C)").click();
		CommonUtils.getElementByUsingVisibleText("THC - A (A, B, C)").click();
		CommonUtils.getElementByUsingVisibleText("1W").click();
		CommonUtils.wait(2);
		gesture.scroll(null,null, null, "unknown text so that scroll happens till end",-45,-1000, null, null);
		Boolean staledatastatus = staleDataCheck(thirdColumnValue);
		gesture.scroll(null,null, null,"1M",-45,-60, null, null);
		CommonUtils.getElementByUsingVisibleText("THD/THC").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();	
		return staledatastatus;
	}
	
	
	public Boolean tHDtHc_THCA_1MGraphTab()
	{
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("THD/THC").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("THD - V (A, B, C)").click();
		CommonUtils.getElementByUsingVisibleText("THC - A (A, B, C)").click();
		CommonUtils.getElementByUsingVisibleText("1M").click();
		CommonUtils.wait(2);
		gesture.scroll(null,null, null, "unknown text so that scroll happens till end",-45,-1000, null, null);
		Boolean staledatastatus = staleDataCheck(thirdColumnValue);
		gesture.scroll(null,null, null,"1M",-45,-60, null, null);
		CommonUtils.getElementByUsingVisibleText("THD/THC").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();	
		return staledatastatus;
	}
	
	
	public Boolean tHDtHc_THCA_AllGraphTab()
	{
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("THD/THC").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("THD - V (A, B, C)").click();
		CommonUtils.getElementByUsingVisibleText("THC - A (A, B, C)").click();
		CommonUtils.getElementByUsingVisibleText("All").click();
		CommonUtils.wait(2);
		gesture.scroll(null,null, null, "unknown text so that scroll happens till end",-45,-1000, null, null);
		Boolean staledatastatus = staleDataCheck(thirdColumnValue);
		gesture.scroll(null,null, null,"1M",-45,-60, null, null);
		CommonUtils.getElementByUsingVisibleText("THD/THC").click();
		CommonUtils.wait(1);
		CommonUtils.getElementByUsingVisibleText("V, A, Hz").click();	
		return staledatastatus;
	}
	
	public boolean staleDataCheck(List<WebElement> measurementList)
	{
		boolean returnFlag = false;
		for(int y = 0; y < measurementList.size(); y++)
		{
			if(measurementList.get(y).getText().equals("----"))
			{
				returnFlag = false;
			}
			else
			{
				returnFlag = true;
			}
		}

		gesture.scroll(null,null, null, "unknown text so that scroll happens till end",-45,1000, null, null);
		CommonUtils.wait(1);
		return returnFlag;	
	}
}
