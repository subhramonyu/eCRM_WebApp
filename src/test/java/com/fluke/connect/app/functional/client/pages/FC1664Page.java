package com.fluke.connect.app.functional.client.pages;

import org.testng.AssertJUnit;

import com.fluke.connect.app.utils.CommonUtils;
import com.fluke.connect.app.utils.DriverManager;
import com.fluke.connect.app.utils.ElementUtils;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
//import org.openqa.selenium.support.PageFactory;

//import com.connect.fluke.web.utils.SeleniumFactory;
//import com.connect.fluke.web.utils.WebUtils;

//import junit.framework.Assert;

public class FC1664Page 
{

	@FindBy(how=How.CSS,using=".hudsonPrimaryTestName > .hudsonTestName")
	private List<WebElement> fc1664_testnames;
	
	@FindBy(how=How.XPATH,using="//*[contains(@class,'hudsonTestName') and contains(text(),'Voltage')]/../../preceding-sibling::*[@class='hudsonConfigurationDetail']//*[@class='hudsonTestView']")
	private List<WebElement> fc1664_voltage_testviews;
	
	@FindBy(how=How.XPATH,using="//*[contains(@class,'hudsonTestName') and contains(text(),'Insulation')]/../../preceding-sibling::*[@class='hudsonConfigurationDetail']//*[@class='hudsonTestView']")
	private List<WebElement> fc1664_insulation_testviews;
	
	@FindBy(how=How.XPATH,using="//*[contains(@class,'hudsonTestName') and contains(text(),'Continuity')]/../../preceding-sibling::*[@class='hudsonConfigurationDetail']//*[@class='hudsonTestView']")
	private List<WebElement> fc1664_continuity_testviews;
	
	@FindBy(how=How.CSS,using=".polarityIconView")
	private List<WebElement> fc1664_continuity_test_polarityviews;
	
	@FindBy(how=How.CSS,using=".testCurrent")
	private List<WebElement> fc1664_continuity_tests_testcurrent;
	
	@FindBy(how=How.CSS,using=".pretest")
	private List<WebElement> fc1664_insulation_tests_pretest;
	
	@FindBy(how=How.CSS,using=".testVoltage")
	private List<WebElement> fc1664_insulation_tests_testvoltage;
	
	@FindBy(how=How.XPATH,using="//*[contains(@class,'hudsonTestName') and contains(text(),'Insulation Test')]/following-sibling::*[@class='primaryTest']//*[@class='superTest']")
	private List<WebElement> fc1664_insulationtest_primaryMeasurements_superparameter;
	
	@FindBy(how=How.XPATH,using="//*[contains(@class,'hudsonTestName') and contains(text(),'Insulation Test')]/following-sibling::*[@class='primaryTest']//*[@class='subTest']")
	private List<WebElement> fc1664_insulationtest_primaryMeasurements_subparameter;
	
	@FindBy(how=How.XPATH,using="//*[contains(@class,'hudsonTestName') and contains(text(),'Insulation Test')]/../../following-sibling::*//*[@class='superTest']")
	private List<WebElement> fc1664_insulationtest_secondaryMeasurements_superparameter;
	
	@FindBy(how=How.XPATH,using="//*[contains(@class,'hudsonTestName') and contains(text(),'Insulation Test')]/../../following-sibling::*//*[@class='subTest']")
	private List<WebElement> fc1664_insulationtest_secondaryMeasurements_subparameter;
	
	@FindBy(how=How.XPATH,using="//*[contains(@class,'hudsonTestName') and contains(text(),' Continuity Test')]/following-sibling::*//*[@class='superTest']")
	private List<WebElement> fc1664_continuitytest_primaryreadings_superparameter;
	
	@FindBy(how=How.XPATH,using="//*[contains(@class,'hudsonTestName') and contains(text(),' Continuity Test')]/following-sibling::*//*[@class='subTest']")
	private List<WebElement> fc1664_continuitytest_primaryreadings_subparameter;
	
	@FindBy(how=How.XPATH,using="//*[contains(@class,'hudsonTestName') and contains(text(),'High-Current Loop Test')]")
	private List<WebElement> fc1664_highloopcurrenttests;
	
	@FindBy(how=How.XPATH,using="//*[contains(@class,'hudsonTestName') and contains(text(),'High-Current Loop Test')]/../../preceding-sibling::*[@class='hudsonConfigurationDetail']/div[@class='hudsonConfiguration']//*[@class='hudsonTestView']")
	private List<WebElement> fc1664_highloopcurrenttest_hudsontestviews;
	
	@FindBy(how=How.XPATH,using="//*[contains(@class,'hudsonTestName') and contains(text(),'High-Current Loop Test')]/../../preceding-sibling::*[@class='hudsonConfigurationDetail']/div[@class='hudsonConfiguration']//*[@class='zMaxText']")
	private List<WebElement> fc1664_highloopcurrenttest_zmax;
	
	@FindBy(how=How.XPATH,using="//*[contains(@class,'hudsonTestName') and contains(text(),'High-Current Loop Test')]/../../preceding-sibling::*[@class='hudsonConfigurationDetail']/div[@class='hudsonConfiguration']//*[@class='loopTripResolution']")
	private List<WebElement> fc1664_highloopcurrenttest_looptripsolution;
	
	
    @FindBy(how=How.XPATH,using="//*[contains(@class,'hudsonTestName') and contains(text(),'High-Current Loop Test')]/../../preceding-sibling::*[@class='hudsonConfigurationDetail']/div[@class='hudsonConfiguration']//*[@class='configUlv']")
    private List<WebElement> fc1664_highloopcurrenttest_voltagecofig;
    
    @FindBy(how=How.XPATH,using="//*[contains(@class,'hudsonTestName') and contains(text(),'High-Current Loop Test')]/following-sibling::*//*[@class='superTest']")
   	private List<WebElement> fc1664_highcurrentlooptest_primaryMeasurements_superparameter;
       
    @FindBy(how=How.XPATH,using="//*[contains(@class,'hudsonTestName') and contains(text(),'High-Current Loop Test')]/following-sibling::*//*[@class='subTest']")
     private List<WebElement> fc1664_highcurrentlooptest_primaryMeasurements_subparameter;
       
    @FindBy(how=How.XPATH,using="//*[contains(@class,'hudsonTestName') and contains(text(),'High-Current Loop Test')]/../../following-sibling::*[contains(@class,'hudsonSecondaryReading')]//*[@class='superTest']")
   	private List<WebElement> fc1664_highcurrentlooptest_secondaryMeasurements_superparameter;
       
    @FindBy(how=How.XPATH,using="//*[contains(@class,'hudsonTestName') and contains(text(),'High-Current Loop Test')]/../../following-sibling::*[contains(@class,'hudsonSecondaryReading')]//*[@class='subTest']")
   	private List<WebElement> fc1664_highcurrentlooptest_secondaryMeasurements_subparameter;
	
    
    @FindBy(how=How.XPATH,using="//*[contains(@class,'hudsonTestName') and contains(text(),'No Trip Loop Test')]")
    private List<WebElement> fc1664_nolooptriptests;
    
    
    @FindBy(how=How.XPATH,using="//*[contains(@class,'hudsonTestName') and contains(text(),'No Trip Loop Test')]/../../preceding-sibling::*[@class='hudsonConfigurationDetail']/div[@class='hudsonConfiguration']//*[@class='configUlv']")
    private List<WebElement> fc1664_nolooptriptest_voltagecofig;
    
    @FindBy(how=How.XPATH,using="//*[contains(@class,'hudsonTestName') and contains(text(),'No Trip Loop Test')]/../../preceding-sibling::*[@class='hudsonConfigurationDetail']/div[@class='hudsonConfiguration']//*[@class='zMaxText']")
	private List<WebElement> fc1664_nolooptriptest_zmax;
    
    @FindBy(how=How.XPATH,using="//*[@class='hudsonTestView' and contains(text(),'No Trip Loop Test')]/ancestor::*[@class='measurement-header']/..")
    private List<WebElement> fc1664_nolooptriptests_headers;
    
    @FindBy(how=How.XPATH,using="//*[contains(@class,'hudsonTestName') and contains(text(),'No Trip Loop Test')]/../../preceding-sibling::*[@class='hudsonConfigurationDetail']/div[@class='hudsonConfiguration']//*[@class='hudsonTestView']")
	private List<WebElement> fc1664_nolooptriptest_hudsontestviews;
    
    @FindBy(how=How.XPATH,using="//*[contains(@class,'hudsonTestName') and contains(text(),' No Trip Loop Test')]/following-sibling::*//*[@class='superTest']")
	private List<WebElement> fc1664_notriplooptest_primaryMeasurements_superparameter;
    
    @FindBy(how=How.XPATH,using="//*[contains(@class,'hudsonTestName') and contains(text(),' No Trip Loop Test')]/following-sibling::*//*[@class='subTest']")
   	private List<WebElement> fc1664_notriplooptest_primaryMeasurements_subparameter;
    
    @FindBy(how=How.XPATH,using="//*[contains(@class,'hudsonTestName') and contains(text(),'No Trip Loop Test')]/../../following-sibling::*//*[contains(@class,'hudsonSecondaryReading')]//*[@class='superTest']")
	private List<WebElement> fc1664_notriplooptest_secondaryMeasurements_superparameter;
    
    @FindBy(how=How.XPATH,using="//*[contains(@class,'hudsonTestName') and contains(text(),'No Trip Loop Test')]/../../following-sibling::*[contains(@class,'hudsonSecondaryReading')]//*[@class='subTest']")
	private List<WebElement> fc1664_notriplooptest_secondaryMeasurements_subparameter;
      
    @FindBy(how=How.XPATH,using="//*[contains(@class,'hudsonTestName') and contains(text(),'RCD Tripping Time Test')]")
	private List<WebElement> fc1664_rcdtriptimetests;
    
    @FindBy(how=How.XPATH,using="//*[contains(@class,'hudsonTestName') and contains(text(),'RCD Tripping Time Test')]/../../preceding-sibling::*[@class='hudsonConfigurationDetail']/div[@class='hudsonConfiguration']//*[@class='configDegreeView']")
    private List<WebElement> fc1664_rcdtriptimetests_degreeview;
    
    @FindBy(how=How.XPATH,using="//*[contains(@class,'hudsonTestName') and contains(text(),'RCD Tripping Time Test')]/../../preceding-sibling::*[@class='hudsonConfigurationDetail']/div[@class='hudsonConfiguration']//*[@class='configXMultiplier']")
    private List<WebElement> fc1664_rcdtriptimetests_multiplier;
    
    @FindBy(how=How.XPATH,using="//*[contains(@class,'hudsonTestName') and contains(text(),'RCD Tripping Time Test')]/../../preceding-sibling::*[@class='hudsonConfigurationDetail']/div[@class='hudsonConfiguration']//*[@class='testCurrent']")
    private List<WebElement> fc1664_rcdtriptimetests_testcurrent;
    
    @FindBy(how=How.XPATH,using="//*[contains(@class,'hudsonTestName') and contains(text(),'RCD Tripping Time Test')]/../../preceding-sibling::*[@class='hudsonConfigurationDetail']/div[@class='hudsonConfiguration']//*[@class='configUlv']")
    private List<WebElement> fc1664_rcdtriptimetests_testvoltage;
    
    @FindBy(how=How.XPATH,using="//*[contains(@class,'hudsonTestName') and contains(text(),'RCD Tripping Time Test')]/following-sibling::*//*[@class='superTest']")
   	private List<WebElement> fc1664_rcdtrippingtimetest_primaryMeasurements_superparameter;
       
    @FindBy(how=How.XPATH,using="//*[contains(@class,'hudsonTestName') and contains(text(),'RCD Tripping Time Test')]/../../following-sibling::*[contains(@class,'hudsonSecondaryReading')]//*[@class='superTest']")
   	private List<WebElement> fc1664_rcdtrippingtimetest_secondaryMeasurements_superparameter;
       
    @FindBy(how=How.XPATH,using="//*[contains(@class,'hudsonTestName') and contains(text(),'RCD Tripping Time Test')]/../../following-sibling::*[contains(@class,'hudsonSecondaryReading')]//*[@class='subTest']")
   	private List<WebElement> fc1664_rcdtrippingtimetest_secondaryMeasurements_subparameter;
    
    @FindBy(how=How.XPATH,using="//*[contains(@class,'hudsonTestName') and contains(text(),'RCD Tripping Current Test')]")
	private List<WebElement> fc1664_rcdtripcurrenttests;
    
    @FindBy(how=How.XPATH,using="//*[contains(@class,'hudsonTestName') and contains(text(),'RCD Tripping Current Test')]/../../preceding-sibling::*[@class='hudsonConfigurationDetail']/div[@class='hudsonConfiguration']//*[@class='configUlv']")
    private List<WebElement> fc1664_rcdtripcurrenttests_testvoltage;
    
    @FindBy(how=How.XPATH,using="//*[contains(@class,'hudsonTestName') and contains(text(),'RCD Tripping Current Test')]/../../preceding-sibling::*[@class='hudsonConfigurationDetail']/div[@class='hudsonConfiguration']//*[@class='testCurrent']")
    private List<WebElement> fc1664_rcdtripcurrenttests_testcurrent;
    
    @FindBy(how=How.XPATH,using="//*[contains(@class,'hudsonTestName') and contains(text(),'RCD Tripping Current Test')]/../../preceding-sibling::*[@class='hudsonConfigurationDetail']/div[@class='hudsonConfiguration']//*[@class='configDegreeView']")
    private List<WebElement> fc1664_rcdtripcurrenttests_degreeview;
    
    @FindBy(how=How.XPATH,using="//*[contains(@class,'hudsonTestName') and contains(text(),'RCD Tripping Current Test')]/../../preceding-sibling::*[@class='hudsonConfigurationDetail']/div[@class='hudsonConfiguration']//*[@class='hudsonF3Sign']")
    private List<WebElement> fc1664_rcdtripcurrenttests_sign;
    
    @FindBy(how=How.XPATH,using="//*[contains(@class,'hudsonTestName') and contains(text(),'RCD Tripping Current Test')]/following-sibling::*//*[@class='superTest']")
   	private List<WebElement> fc1664_rcdtrippingcurrenttest_primaryMeasurements_superparameter;
       
    @FindBy(how=How.XPATH,using="//*[contains(@class,'hudsonTestName') and contains(text(),'RCD Tripping Current Test')]/../../following-sibling::*[contains(@class,'hudsonSecondaryReading')]//*[@class='superTest']")
   	private List<WebElement> fc1664_rcdtrippingcurrenttest_secondaryMeasurements_superparameter;
       
    @FindBy(how=How.XPATH,using="//*[contains(@class,'hudsonTestName') and contains(text(),'RCD Tripping Current Test')]/../../following-sibling::*[contains(@class,'hudsonSecondaryReading')]//*[@class='subTest']")
   	private List<WebElement> fc1664_rcdtrippingcurrenttest_secondaryMeasurements_subparameter;
    
  
    @FindBy(how=How.XPATH,using="//*[contains(@class,'hudsonTestName') and contains(text(),'Earth Ground Test')]")
   	private List<WebElement> fc1664_earthgroundtests;
    
    @FindBy(how=How.XPATH,using="//*[contains(@class,'hudsonTestName') and contains(text(),'Earth Ground Test')]/following-sibling::*//*[@class='superTest']")
	private List<WebElement> fc1664_earthgroundtest_primaryMeasurements_superparameter;
    
    @FindBy(how=How.XPATH,using="//*[contains(@class,'hudsonTestName') and contains(text(),'Earth Ground Test')]/following-sibling::*//*[@class='subTest']")
   	private List<WebElement> fc1664_earthgroundtest_primaryMeasurements_subparameter;
    
    @FindBy(how=How.XPATH,using="//*[contains(@class,'hudsonTestName') and contains(text(),'Phase Sequence Test')]")
   	private List<WebElement> fc1664_phasesequencetests;
    
    @FindBy(how=How.XPATH,using="//*[contains(@class,'hudsonTestName') and contains(text(),'Phase Sequence Test')]/following-sibling::*[@class='phaseSequence']")
	private List<WebElement> fc1664_phasesequencetests_sequence;
    
    
	@FindBy(how=How.CSS,using=".hudsonReadings > .hudsonSecondaryReading")
	private List<WebElement> fc1664_test_secondaryreadings_measurementlist;
	
	@FindBy(how=How.CSS,using=".downloadedList")
	private List<WebElement> fc1664_downloadedlist;
	
	@FindBy(how=How.CSS,using=".downloadedHeading")
	private List<WebElement> fc1664_downloadedHeadings;
	
	@FindBy(how=How.CSS,using=".downloadedTestName")
	private List<WebElement> fc1664_downloadedTests;
	
	@FindBy(how=How.CSS,using=".hudsonPrimaryTestName > .hudsonTestName")
	private WebElement fc1664_testname;
	
	@FindBy(how=How.CSS,using=".hudsonTestView")
	private WebElement fc1664_testview;
	
	@FindBy(how=How.CSS,using=".polarityIconView")
	private WebElement fc1664_continuity_test_polarityview;
	
	@FindBy(how=How.CSS,using=".testCurrent")
	private WebElement fc1664_continuity_test_testcurrent;
	
	@FindBy(how=How.CSS,using=".pretest")
	private WebElement fc1664_insulation_test_pretest;
	
	@FindBy(how=How.CSS,using=".testVoltage")
	private WebElement fc1664_insulation_test_testvoltage;
	
	@FindBy(how=How.CSS,using=".hudsonPrimaryReading .primaryTestname > .superTest")
	private WebElement fc1664_test_primaryMeasurement_superparameter;
	
	@FindBy(how=How.CSS,using=".hudsonPrimaryReading .primaryTestname > .subTest")
	private WebElement fc1664_test_primaryMeasurement_subparameter;
	
	@FindBy(how=How.CSS,using=".hudsonSecondaryReading .primaryTestname > .superTest")
	private WebElement fc1664_test_secondaryMeasurement_superparameter;
	
	@FindBy(how=How.CSS,using=".hudsonSecondaryReading .primaryTestname > .subTest")
	private WebElement fc1664_test_secondaryMeasurement_subparameter;
	
	@FindBy(how=How.CSS,using=".hudsonReadings > .hudsonPrimaryReading")
	private WebElement fc1664_test_primaryreading_measurementlist;
	
	@FindBy(how=How.CSS,using=".hudsonReadings > .hudsonSecondaryReading")
	private WebElement fc1664_test_secondaryreading_measurementlist;
	
	@FindBy(how=How.ID,using="meas-detail-link")
	private WebElement backbutton;
	
	@FindBy(how=How.XPATH,using="//*[contains(@class,'hudsonTestName') and contains(text(),'Voltage')]/../following-sibling::*[@class='hudsonPrimaryReading']/*[contains(@class,'scalarValue')]")
    private List<WebElement> fc1664_voltagetest_primaryreading_value;
	
	@FindBy(how=How.XPATH,using="//*[contains(@class,'hudsonTestName') and contains(text(),'Voltage')]/../following-sibling::*[@class='hudsonPrimaryReading']/*[contains(@class,'scalarUnits')]")
    private List<WebElement> fc1664_voltagetest_primaryreading_unit;
		
	@FindBy(how=How.XPATH,using="//*[contains(@class,'hudsonTestName') and contains(text(),'Voltage')]/../../following-sibling::*//*[contains(@class,'hudsonSecondaryReading')]//*[contains(@class,'scalarValue')]")
	private List<WebElement> fc1664_voltagetest_secondaryreading_value;
	
	@FindBy(how=How.XPATH,using="//*[contains(@class,'hudsonTestName') and contains(text(),'Voltage')]/../../following-sibling::*//*[contains(@class,'hudsonSecondaryReading')]//*[contains(@class,'scalarUnits')]")
	private List<WebElement> fc1664_voltagetest_secondaryreading_unit;
	
	@FindBy(how=How.XPATH,using="//*[contains(@class,'hudsonTestName') and contains(text(),'Insulation')]/../following-sibling::*[@class='hudsonPrimaryReading']/*[contains(@class,'scalarValue')]")
	private List<WebElement> fc1664_insulationtest_primaryreading_value;
	
	@FindBy(how=How.XPATH,using="//*[contains(@class,'hudsonTestName') and contains(text(),'Insulation')]/../following-sibling::*[@class='hudsonPrimaryReading']/*[contains(@class,'scalarUnit')]")
	private List<WebElement> fc1664_insulationtest_primaryreading_unit;
	
	@FindBy(how=How.XPATH,using="//*[contains(@class,'hudsonTestName') and contains(text(),'Insulation')]/../../following-sibling::*//*[contains(@class,'hudsonSecondaryReading')]//*[contains(@class,'scalarValue')]")
	private List<WebElement> fc1664_insulationtest_secondaryreading_value;
	
	@FindBy(how=How.XPATH,using="//*[contains(@class,'hudsonTestName') and contains(text(),'Insulation')]/../../following-sibling::*//*[contains(@class,'hudsonSecondaryReading')]//*[contains(@class,'scalarUnits')]")
	private List<WebElement> fc1664_insulationtest_secondaryreading_unit;
	
	@FindBy(how=How.XPATH,using="//*[contains(@class,'hudsonTestName') and contains(text(),'Continuity')]/../following-sibling::*[@class='hudsonPrimaryReading']/*[contains(@class,'scalarValue')]")
	private List<WebElement> fc1664_continuitytest_primaryreading_value;
	
	@FindBy(how=How.XPATH,using="//*[contains(@class,'hudsonTestName') and contains(text(),'Continuity')]/../following-sibling::*[@class='hudsonPrimaryReading']/*[contains(@class,'scalarUnits')]")
	private List<WebElement> fc1664_continuitytest_primaryreading_unit;
	

	@FindBy(how=How.XPATH,using="//*[contains(@class,'hudsonTestName') and contains(text(),'Continuity')]/../../following-sibling::*//*[@class='hudsonSecondaryReading']/*[contains(@class,'scalarValue')]")
	private List<WebElement> fc1664_continuitytest_secondaryreading_value;
	
	@FindBy(how=How.XPATH,using="//*[contains(@class,'hudsonTestName') and contains(text(),'Continuity')]/../../following-sibling::*//*[@class='hudsonSecondaryReading']/*[contains(@class,'scalarUnits')]")
	private List<WebElement> fc1664_continuitytest_secondaryreading_unit;
	
	@FindBy(how=How.XPATH,using="//*[contains(@class,'hudsonTestName') and contains(text(),'RCD Tripping Time Test')]/../following-sibling::*[@class='hudsonPrimaryReading']//*[contains(@class,'scalarValue')]")
	private List<WebElement> fc1664_rcdtrippingtimetest_primaryreading_value;
	
	@FindBy(how=How.XPATH,using="//*[contains(@class,'hudsonTestName') and contains(text(),'RCD Tripping Time Test')]/../following-sibling::*[@class='hudsonPrimaryReading']//*[contains(@class,'scalarUnits')]")
	private List<WebElement> fc1664_rcdtrippingtimetest_primaryreading_unit;
	
	@FindBy(how=How.XPATH,using="//*[contains(@class,'hudsonTestName') and contains(text(),'RCD Tripping Time Test')]/../../following-sibling::*//*[contains(@class,'hudsonSecondaryReading')]//*[contains(@class,'scalarValue')]")
	private List<WebElement> fc1664_rcdtrippingtimetest_secondaryreading_value;
	
	//@FindBy(how=How.XPATH,using="//*[contains(@class,'hudsonTestName') and contains(text(),'RCD Tripping Time Test')]/../../following-sibling::*[contains(@class,'hudsonSecondaryReading')]//*[contains(@class,'scalarValue')]")
	//private List<WebElement> fc1664_rcdtrippingtimetest_secondaryreading_value_listpage;
	
	@FindBy(how=How.XPATH,using="//*[contains(@class,'hudsonTestName') and contains(text(),'RCD Tripping Time Test')]/../../following-sibling::*//*[contains(@class,'hudsonSecondaryReading')]//*[contains(@class,'scalarUnits')]")
	private List<WebElement> fc1664_rcdtrippingtimetest_secondaryreading_unit;
	
	@FindBy(how=How.XPATH,using="//*[contains(@class,'hudsonTestName') and contains(text(),'RCD Tripping Current Test')]/../following-sibling::*[@class='hudsonPrimaryReading']//*[contains(@class,'scalarValue')]")
	private List<WebElement> fc1664_rcdtrippingcurrenttest_primaryreading_value;
	
	
	@FindBy(how=How.XPATH,using="//*[contains(@class,'hudsonTestName') and contains(text(),'RCD Tripping Current Test')]/../following-sibling::*[@class='hudsonPrimaryReading']//*[contains(@class,'scalarUnit')]")
	private List<WebElement> fc1664_rcdtrippingcurrenttest_primaryreading_unit;
	
	@FindBy(how=How.XPATH,using="//*[contains(@class,'hudsonTestName') and contains(text(),'RCD Tripping Current Test')]/../../following-sibling::*//*[contains(@class,'hudsonSecondaryReading')]//*[contains(@class,'scalarValue')]")
	private List<WebElement> fc1664_rcdtrippingcurrentest_secondaryreading_value;
	
	@FindBy(how=How.XPATH,using="//*[contains(@class,'hudsonTestName') and contains(text(),'RCD Tripping Current Test')]/../../following-sibling::*//*[contains(@class,'hudsonSecondaryReading')]//*[contains(@class,'scalarUnits')]")
	private List<WebElement> fc1664_rcdtrippingcurrenttest_secondaryreading_unit;
	
	@FindBy(how=How.XPATH,using="//*[contains(@class,'hudsonTestName') and contains(text(),'High-Current Loop Test')]/../following-sibling::*[@class='hudsonPrimaryReading']//*[contains(@class,'scalarValue')]")
	private List<WebElement> fc1664_highcurrentlooptest_primaryreading_value;
	
	@FindBy(how=How.XPATH,using="//*[contains(@class,'hudsonTestName') and contains(text(),'High-Current Loop Test')]/../following-sibling::*[@class='hudsonPrimaryReading']//*[contains(@class,'scalarUnit')]")
	private List<WebElement> fc1664_highcurrentlooptest_primaryreading_unit;
	
	@FindBy(how=How.XPATH,using="//*[contains(@class,'hudsonTestName') and contains(text(),'High-Current Loop Test')]/../../following-sibling::*//*[contains(@class,'hudsonSecondaryReading')]//*[contains(@class,'scalarValue')]")
	private List<WebElement> fc1664_highcurrenlooptest_secondaryreading_value;
	
	@FindBy(how=How.XPATH,using="//*[contains(@class,'hudsonTestName') and contains(text(),'High-Current Loop Test')]/../../following-sibling::*//*[contains(@class,'hudsonSecondaryReading')]//*[contains(@class,'scalarUnits')]")
	private List<WebElement> fc1664_highcurrentlooptest_secondaryreading_unit;
	
	@FindBy(how=How.XPATH,using="//*[contains(@class,'hudsonTestName') and contains(text(),'No Trip Loop Test')]/../following-sibling::*[@class='hudsonPrimaryReading']//*[contains(@class,'scalarValue')]")
	private List<WebElement> fc1664_nolooptriptest_primaryreading_value;
	
	@FindBy(how=How.XPATH,using="//*[contains(@class,'hudsonTestName') and contains(text(),'No Trip Loop Test')]/../following-sibling::*[@class='hudsonPrimaryReading']//*[contains(@class,'scalarUnit')]")
	private List<WebElement> fc1664_nolooptriptest_primaryreading_unit;
	
	@FindBy(how=How.XPATH,using="//*[contains(@class,'hudsonTestName') and contains(text(),'No Trip Loop Test')]/../../following-sibling::*//*[contains(@class,'hudsonSecondaryReading')]//*[contains(@class,'scalarValue')]")
	private List<WebElement> fc1664_nolooptriptest_secondaryreading_value;
	
	@FindBy(how=How.XPATH,using="//*[contains(@class,'hudsonTestName') and contains(text(),'No Trip Loop Test')]/../../following-sibling::*//*[contains(@class,'hudsonSecondaryReading')]//*[contains(@class,'scalarUnits')]")
	private List<WebElement> fc1664_nolooptriptest_secondaryreading_unit;
	
	@FindBy(how=How.XPATH,using="//*[contains(@class,'hudsonTestName') and contains(text(),'Earth Ground Test')]/../following-sibling::*[@class='hudsonPrimaryReading']//*[contains(@class,'scalarValue')]")
	private List<WebElement> fc1664_earthgroundresistance_primaryreading_value;
	
	@FindBy(how=How.XPATH,using="//*[contains(@class,'hudsonTestName') and contains(text(),'Earth Ground Test')]/../following-sibling::*[@class='hudsonPrimaryReading']//*[contains(@class,'scalarUnits')]")
	private List<WebElement> fc1664_earthgroundresistance_primaryreading_unit;
	
	@FindBy(how=How.XPATH,using="//*[contains(@class,'hudsonTestName') and contains(text(),'Phase Sequence Test')]/../following-sibling::*[@class='hudsonPrimaryReading']//*[contains(@class,'scalarValue')]")
	private List<WebElement> fc1664_phasesequencetest_primaryreading_value;
	

	@FindBy(how=How.XPATH,using="//*[@class='autoTestName' and contains(text(),'RCD Tripping Time Test(Auto)')]")
    private List<WebElement> fc1664_rcdtrippingtime_autotests;	
	
	@FindBy(how=How.XPATH,using="//*[@class='autoTestName' and contains(text(),'RCD Tripping Time Test(Auto)')]/../following-sibling::*[@class='autoTestLayout']//*[@class='primaryVal']")
	private List<WebElement> fc1664_rcdtrippingtime_autotests_configurations_primaryValue;	
	
	@FindBy(how=How.XPATH,using="//*[@class='autoTestName' and contains(text(),'RCD Tripping Time Test(Auto)')]/../following-sibling::*[@class='autoTestLayout']//*[@class='secondaryVal']")
	private List<WebElement> fc1664_rcdtrippingtime_autotests_configurations_secondaryValue;
	
	@FindBy(how=How.CSS,using=".phaseSequenceCSS")
	private List<WebElement> fc1664_phasesequencemeasurement;
	
	@FindBy(how=How.CSS,using=".autoTestName")
	private List<WebElement> fc1664_autotests;
	
	@FindBy(how=How.XPATH,using="//*[contains(@class,'hudsonTestName') and contains(text(),'Voltage')]")
	private List<WebElement> fc1664_voltageTests;
	
	@FindBy(how=How.XPATH,using="//*[contains(@class,'hudsonTestName') and contains(text(),'Insulation')]")
	private List<WebElement> fc1664_insulationTests;
	
	@FindBy(how=How.XPATH,using="//*[contains(@class,'hudsonTestName') and contains(text(),'Continuity')]")
	private List<WebElement> fc1664_continuityTests;
	
	@FindBy(how=How.XPATH,using="//*[contains(@class,'hudsonTestName') and contains(text(),'RCD Tripping Time')]")
	private List<WebElement> fc1664_rcdtrippingtimeTests;
	
	@FindBy(how=How.XPATH,using="//*[contains(@class,'hudsonTestName') and contains(text(),'RCD Tripping Current')]")
	private List<WebElement> fc1664_rcdtrippingcurrentTests;
	
	@FindBy(how=How.XPATH,using="//*[contains(@class,'hudsonTestName') and contains(text(),'No Trip Loop Test')]")
	private List<WebElement> fc1664_notriploopTests;
	
	@FindBy(how=How.XPATH,using="//*[contains(@class,'hudsonTestName') and contains(text(),'High-Loop Current Test')]")
	private List<WebElement> fc1664_highloopcurrentTests;
	
	@FindBy(how=How.XPATH,using="//*[contains(@class,'hudsonTestName') and contains(text(),'Earth')]")
	private List<WebElement> fc1664_earthgroundTests;
	
	private List<String> autotesttypes;
	
	private MeasurementsHistoryPage measurementspage;
	
	
	
	
	public FC1664Page()
	{
		CommonUtils.initElements(this, 10);
		measurementspage = new MeasurementsHistoryPage();
    }
	
	
	
	public void verifyDownloadedDataInMeasurementsListPage()
	{
		int no_of_downloadedmeasurements = fc1664_downloadedlist.size();
		
		if(no_of_downloadedmeasurements > 1)
		{
			for(int i = 0; i<no_of_downloadedmeasurements;i++)
			{
				AssertJUnit.assertTrue(fc1664_downloadedHeadings.get(i).getText().contains("FLUKE 1664FC"));
			    AssertJUnit.assertTrue(fc1664_downloadedTests.get(i).getText().contains("Downloaded Test results:"));
			}
		}
		else
		{
			AssertJUnit.assertTrue(fc1664_downloadedHeadings.get(0).getText().contains("FLUKE 1664FC"));
		    AssertJUnit.assertTrue(fc1664_downloadedTests.get(0).getText().contains("Downloaded Test results:"));	
		}
	}
	
	public void verify1664fcMeasurementsConfigurationInListPage(String measurementType)
	{
		
		switch(measurementType)
		{
		     case "Voltage":
		    	 
		    	int number_of_voltage_measurements = fc1664_voltage_testviews.size();
		    	
		    	if(number_of_voltage_measurements > 1)
		    	{
		    	 for(int i=0;i<number_of_voltage_measurements;i++)
		    	 {
		    		AssertJUnit.assertTrue(fc1664_voltage_testviews.get(i).getText().equals("L-N") || fc1664_voltage_testviews.get(i).getText().equals("L-PE") || fc1664_voltage_testviews.get(i).getText().equals("N-PE"));
		         }
		    	}
		    	else
		    	{
		    		AssertJUnit.assertTrue(fc1664_voltage_testviews.get(0).getText().equals("L-N") || fc1664_voltage_testviews.get(0).getText().equals("L-PE") || fc1664_voltage_testviews.get(0).getText().equals("N-PE"));
		    	}
		     break;
		     
		     case "Insulation":
		    	 int number_of_insulation_measurements = fc1664_insulation_testviews.size();
		    	 
		    	 if(number_of_insulation_measurements > 1)
		    	 {
		    		 for(int i=0;i<number_of_insulation_measurements;i++)
		    		 {
		    			 AssertJUnit.assertTrue(fc1664_insulation_testviews.get(i).getText().equals("L-N") || fc1664_insulation_testviews.get(i).getText().equals("L-PE") || fc1664_insulation_testviews.get(i).getText().equals("N-PE"));
		    			 AssertJUnit.assertEquals("Pretest off", fc1664_insulation_tests_pretest.get(i).getText());
		    			 AssertJUnit.assertTrue(fc1664_insulation_tests_testvoltage.get(i).getText().equals("50 V") || fc1664_insulation_tests_testvoltage.get(i).getText().equals("100 V") || fc1664_insulation_tests_testvoltage.get(i).getText().equals("250 V") || fc1664_insulation_tests_testvoltage.get(i).getText().equals("500 V") || fc1664_insulation_tests_testvoltage.get(i).getText().equals("1000 V"));
		    		 }
		    	 }
		    	 
		    	 else
		    	 {
		    		 AssertJUnit.assertTrue(fc1664_insulation_testviews.get(0).getText().equals("L-N") || fc1664_insulation_testviews.get(0).getText().equals("L-PE") || fc1664_insulation_testviews.get(0).getText().equals("N-PE"));
	    			 AssertJUnit.assertEquals("Pretest off", fc1664_insulation_tests_pretest.get(0).getText());
	    			 AssertJUnit.assertTrue(fc1664_insulation_tests_testvoltage.get(0).getText().equals("50 V") || fc1664_insulation_tests_testvoltage.get(0).getText().equals("100 V") || fc1664_insulation_tests_testvoltage.get(0).getText().equals("250 V") || fc1664_insulation_tests_testvoltage.get(0).getText().equals("500 V") || fc1664_insulation_tests_testvoltage.get(0).getText().equals("1000 V"));
		    	 }
		    	 
		     break;
		     
		     case "Continuity":
		    	 int number_of_continuity_measurements = fc1664_continuity_testviews.size();
		    	 if(number_of_continuity_measurements > 1)
		    	 {
		    		 for(int i=0;i<number_of_continuity_measurements;i++)
		    		 {
		    		   System.out.println("Views:"+fc1664_continuity_testviews.get(i).getText());
		    		   AssertJUnit.assertTrue(fc1664_continuity_testviews.get(i).getText().contains("L-N") || fc1664_continuity_testviews.get(i).getText().contains("L-PE") || fc1664_continuity_testviews.get(i).getText().contains("N-PE"));
		    		   AssertJUnit.assertTrue(fc1664_continuity_test_polarityviews.get(i).getText().equals("Ω-") || fc1664_continuity_test_polarityviews.get(i).getText().equals("Ω+") || fc1664_continuity_test_polarityviews.get(i).getText().equals("Ω±"));
		    		   AssertJUnit.assertTrue(fc1664_continuity_tests_testcurrent.get(i).getText().equals("10 mA") || fc1664_continuity_tests_testcurrent.get(i).getText().equals("250 mA"));
		    		 }
		    	 }
		    	 else
		    	 {

		    		   AssertJUnit.assertTrue(fc1664_continuity_testviews.get(0).getText().equals("L-N") || fc1664_continuity_testviews.get(0).getText().equals("L-PE") || fc1664_continuity_testviews.get(0).getText().equals("N-PE"));
		    		   AssertJUnit.assertTrue(fc1664_continuity_test_polarityviews.get(0).getText().equals("Ω-") || fc1664_continuity_test_polarityviews.get(0).getText().equals("Ω+") || fc1664_continuity_test_polarityviews.get(0).getText().equals("Ω±"));
		    		   AssertJUnit.assertTrue(fc1664_continuity_tests_testcurrent.get(0).getText().equals("10 mA") || fc1664_continuity_tests_testcurrent.get(0).getText().equals("250 mA")); 
		    	 }
		     break;
		     
		     case "High-Current Loop Test":
		    	 int number_of_highloop_measurements = fc1664_highloopcurrenttest_hudsontestviews.size();
		    	 
		    	 if(number_of_highloop_measurements!=0)
		    	 {
		    	 if(number_of_highloop_measurements > 1)
		    	 {
		    		 for(int i=0;i<number_of_highloop_measurements;i++)
		    		 {
		    		   AssertJUnit.assertTrue(fc1664_highloopcurrenttest_hudsontestviews.get(i).getText().equals("L-N") || fc1664_highloopcurrenttest_hudsontestviews.get(i).getText().equals("L-PE") || fc1664_highloopcurrenttest_hudsontestviews.get(i).getText().equals("N-PE"));
		    		   AssertJUnit.assertTrue(fc1664_highloopcurrenttest_zmax.get(i).getText().equals("Zmax OFF") || fc1664_highloopcurrenttest_zmax.get(i).getText().equals("Zmax ON"));
		    		   AssertJUnit.assertTrue(fc1664_highloopcurrenttest_looptripsolution.get(i).getText().equals("Ω") || fc1664_highloopcurrenttest_looptripsolution.get(i).getText().equals("mΩ"));
		    		   AssertJUnit.assertTrue(fc1664_highloopcurrenttest_voltagecofig.get(i).getText().equals("UL =50 V"));
		    		 }
		    	 }
		    	 else
		    	 {

		    		 AssertJUnit.assertTrue(fc1664_highloopcurrenttest_hudsontestviews.get(0).getText().equals("L-N") || fc1664_highloopcurrenttest_hudsontestviews.get(0).getText().equals("L-PE") || fc1664_highloopcurrenttest_hudsontestviews.get(0).getText().equals("N-PE"));
		    		 AssertJUnit.assertTrue(fc1664_highloopcurrenttest_zmax.get(0).getText().equals("Zmax OFF") || fc1664_highloopcurrenttest_zmax.get(0).getText().equals("Zmax ON"));
		    		 AssertJUnit.assertTrue(fc1664_highloopcurrenttest_looptripsolution.get(0).getText().equals("Ω") || fc1664_highloopcurrenttest_looptripsolution.get(0).getText().equals("mΩ"));
		    		 AssertJUnit.assertTrue(fc1664_highloopcurrenttest_voltagecofig.get(0).getText().equals("UL =50 V"));
		    	 }
		    	 }
		     break;
		     case "No Trip Loop Test":
		    	 int number_of_nolooptrip_measurements = fc1664_nolooptriptest_hudsontestviews.size();
		    	 if(number_of_nolooptrip_measurements!=0)
		    	 {
		    	 if(number_of_nolooptrip_measurements > 1)
		    	 {
		    		 for(int i=0;i<number_of_nolooptrip_measurements;i++)
		    		 {
		    		   AssertJUnit.assertTrue(fc1664_nolooptriptest_hudsontestviews.get(i).getText().equals("L-N") || fc1664_highloopcurrenttest_hudsontestviews.get(i).getText().equals("L-PE") || fc1664_highloopcurrenttest_hudsontestviews.get(i).getText().equals("N-PE"));
		    		   AssertJUnit.assertTrue(fc1664_nolooptriptest_zmax.get(i).getText().equals("Zmax OFF") || fc1664_nolooptriptest_zmax.get(i).getText().equals("Zmax ON"));
		    		   AssertJUnit.assertTrue(fc1664_nolooptriptest_voltagecofig.get(i).getText().equals("UL =50 V"));
		    		 }
		    	 }
		    	 else
		    	 {

		    		 AssertJUnit.assertTrue(fc1664_nolooptriptest_hudsontestviews.get(0).getText().equals("L-N") || fc1664_highloopcurrenttest_hudsontestviews.get(0).getText().equals("L-PE") || fc1664_highloopcurrenttest_hudsontestviews.get(0).getText().equals("N-PE"));
		    		 AssertJUnit.assertTrue(fc1664_nolooptriptest_zmax.get(0).getText().equals("Zmax OFF") || fc1664_nolooptriptest_zmax.get(0).getText().equals("Zmax ON"));
		    		 AssertJUnit.assertTrue(fc1664_nolooptriptest_voltagecofig.get(0).getText().equals("UL =50 V"));
		    	 }
		    	 }
		     break;
		     case "RCD Tripping Time Test":
		    	 int number_of_rcdtriptimetests = fc1664_rcdtriptimetests.size();
		    	 if(number_of_rcdtriptimetests!=0)
		    	 {
		    	 for(int i=0;i<number_of_rcdtriptimetests;i++)
		    	 {
		    		 AssertJUnit.assertTrue(fc1664_rcdtriptimetests_degreeview.get(i).getText().equals("180°") || fc1664_rcdtriptimetests_degreeview.get(i).getText().equals("0°"));
		    		 AssertJUnit.assertTrue(!fc1664_rcdtriptimetests_multiplier.get(i).getText().equals(""));
		    		 AssertJUnit.assertTrue(!fc1664_rcdtriptimetests_multiplier.get(i).getText().equals("null"));
		    		 AssertJUnit.assertNotNull(fc1664_rcdtriptimetests_multiplier.get(i).getText());
		    		 AssertJUnit.assertTrue(fc1664_rcdtriptimetests_testcurrent.get(i).getText().equals("10 mA") || fc1664_rcdtriptimetests_testcurrent.get(i).getText().equals("30 mA") || fc1664_rcdtriptimetests_testcurrent.get(i).getText().equals("100 mA") || fc1664_rcdtriptimetests_testcurrent.get(i).getText().equals("300 mA") || fc1664_rcdtriptimetests_testcurrent.get(i).getText().equals("500 mA"));
		    		 AssertJUnit.assertTrue( fc1664_rcdtriptimetests_testvoltage.get(i).getText().equals("UL =50 V"));
		    	}
		    	}
		     break;
		     case "RCD Tripping Current Test":
		    	 int number_of_rcdtripcurrenttests = fc1664_rcdtripcurrenttests.size();
		    	 
		    	 if(number_of_rcdtripcurrenttests!=0)
		    	 {
		    	 for(int i=0;i<number_of_rcdtripcurrenttests;i++)
		    	 {
		    		 AssertJUnit.assertTrue(fc1664_rcdtripcurrenttests_degreeview.get(i).getText().equals("180°") || fc1664_rcdtriptimetests_degreeview.get(i).getText().equals("0°"));
		    		 AssertJUnit.assertTrue(!fc1664_rcdtriptimetests_multiplier.get(i).getText().equals("null"));
		    		 AssertJUnit.assertNotNull(fc1664_rcdtriptimetests_multiplier.get(i).getText());
		    		 AssertJUnit.assertTrue(fc1664_rcdtripcurrenttests_testcurrent.get(i).getText().equals("10 mA") || fc1664_rcdtripcurrenttests_testcurrent.get(i).getText().equals("30 mA") || fc1664_rcdtripcurrenttests_testcurrent.get(i).getText().equals("100 mA") || fc1664_rcdtripcurrenttests_testcurrent.get(i).getText().equals("300 mA") || fc1664_rcdtripcurrenttests_testcurrent.get(i).getText().equals("500 mA"));
		    		 AssertJUnit.assertTrue( fc1664_rcdtriptimetests_testvoltage.get(i).getText().equals("UL =50 V"));
		    	}
		    	} 
		     break;
		    	 
		    	 
		}
	}
	
	
	public void verify1664fcMeasurementParametersInListPage(String measurementType)
	{
		
		switch(measurementType)
		{
		     
		     
		     case "Insulation":
		    	 int number_of_insulation_measurements = fc1664_insulation_testviews.size();
		    	 
		    	 if(number_of_insulation_measurements > 1)
		    	 {
		    		 for(int i=0;i<number_of_insulation_measurements;i++)
		    		 {
		    			 AssertJUnit.assertTrue(fc1664_insulationtest_primaryMeasurements_superparameter.get(i).getText().equals("R"));
		    			 AssertJUnit.assertTrue(fc1664_insulationtest_primaryMeasurements_subparameter.get(i).getText().equals("ISO"));
		    			 AssertJUnit.assertTrue(fc1664_insulationtest_secondaryMeasurements_superparameter.get(i).getText().equals("U"));
		    			 AssertJUnit.assertTrue(fc1664_insulationtest_secondaryMeasurements_subparameter.get(i).getText().equals("N"));
		    		 }
		    	 }
		    	 
		    	 else
		    	 {
		    		 AssertJUnit.assertTrue(fc1664_insulationtest_primaryMeasurements_superparameter.get(0).getText().equals("R"));
	    			 AssertJUnit.assertTrue(fc1664_insulationtest_primaryMeasurements_subparameter.get(0).getText().equals("ISO"));
	    			 AssertJUnit.assertTrue(fc1664_insulationtest_secondaryMeasurements_superparameter.get(0).getText().equals("U"));
	    			 AssertJUnit.assertTrue(fc1664_insulationtest_secondaryMeasurements_subparameter.get(0).getText().equals("N"));		
		    	 }
		    	 
		     break;
		     
		     case "Continuity":
		    	 int number_of_continuity_measurements = fc1664_continuity_testviews.size();
		    	 if(number_of_continuity_measurements > 1)
		    	 {
		    		 for(int i=0;i<number_of_continuity_measurements;i++)
		    		 {
		    			 AssertJUnit.assertTrue(fc1664_continuitytest_primaryreadings_superparameter.get(i).getText().equals("R"));
		    			 AssertJUnit.assertTrue(fc1664_continuitytest_primaryreadings_subparameter.get(i).getText().equals("LO"));
		    		 }
		    	 }
		    	 else
		    	 {
		    		 AssertJUnit.assertTrue(fc1664_continuitytest_primaryreadings_superparameter.get(0).getText().equals("R"));
	    			 AssertJUnit.assertTrue(fc1664_continuitytest_primaryreadings_subparameter.get(0).getText().equals("LO"));
		    	 }
		     break;
		     
		     case "No Trip Loop Test":
		    	 int number_of_nolooptrip_measurements = fc1664_nolooptriptests_headers.size();
		    	 if(number_of_nolooptrip_measurements!=0)
		    	 {
		    	 if(number_of_nolooptrip_measurements > 1)
		    	 {
		    		 for(int i=0;i<number_of_nolooptrip_measurements;i++)
		    		 {
		    			 String zMaxText = DriverManager.getDriver().findElement(By.xpath("(//*[contains(@class,'hudsonTestName') and contains(text(),'No Trip Loop Test')]/ancestor::*[contains(@class,'measurement-header')])["+i+1+"]//*[@class='zMaxText']")).getText();
		    			
		    			 List<WebElement> secondaryparameters_supertest = DriverManager.getDriver().findElements(By.xpath("(//*[@class='hudsonTestView' and contains(text(),'No Trip Loop Test')]/ancestor::*[@class='measurement-header']/..)["+i+1+"]//*[contains(@class,'hudsonSecondaryReading')]//*[@class='superTest']"));
		    			 List<WebElement> secondaryparameters_subtest = DriverManager.getDriver().findElements(By.xpath("(//*[@class='hudsonTestView' and contains(text(),'No Trip Loop Test')]/ancestor::*[@class='measurement-header']/..)["+i+1+"]//*[contains(@class,'hudsonSecondaryReading')]//*[@class='subTest']"));
		    			 
		    			 if(zMaxText.contains("ON"))
		    			 {
		    				 
		    			   AssertJUnit.assertTrue(DriverManager.getDriver().findElement(By.xpath("(//*[@class='hudsonTestView' and contains(text(),'No Trip Loop Test')]/ancestor::*[@class='measurement-header']/..)["+i+1+"]//*[contains(@class,'hudsonPrimaryReading')]//*[@class='superTest']")).getText().equals("Z"));
		    			   AssertJUnit.assertTrue(DriverManager.getDriver().findElement(By.xpath("(//*[@class='hudsonTestView' and contains(text(),'No Trip Loop Test')]/ancestor::*[@class='measurement-header']/..)["+i+1+"]//*[contains(@class,'hudsonPrimaryReading')]//*[@class='subTest']")).getText().equals("L"));
		    			   
		    			   for(WebElement element:secondaryparameters_supertest)
		    			   {
		    			      AssertJUnit.assertTrue(element.getText().equals("PEFC I") || element.getText().equals("Z") || element.getText().equals("R") || element.getText().equals("PSC I"));
		    			   }
		    			   
		    			   for(WebElement e:secondaryparameters_subtest)
		    			   {
		    			     AssertJUnit.assertTrue(e.getText().equals("k") || e.getText().equals("E") || e.getText().equals("L max") || e.getText().equals("i max"));
		    			   }
		    			 }
		    			 
		    			 else if(zMaxText.contains("OFF"))
		    			 {
		    			   AssertJUnit.assertTrue(DriverManager.getDriver().findElement(By.xpath("(//*[@class='hudsonTestView' and contains(text(),'No Trip Loop Test')]/ancestor::*[@class='measurement-header']/..)["+i+1+"]//*[contains(@class,'hudsonPrimaryReading')]//*[@class='superTest']")).getText().equals("Z"));
		    			   AssertJUnit.assertTrue(DriverManager.getDriver().findElement(By.xpath("(//*[@class='hudsonTestView' and contains(text(),'No Trip Loop Test')]/ancestor::*[@class='measurement-header']/..)["+i+1+"]//*[contains(@class,'hudsonPrimaryReading')]//*[@class='subTest']")).getText().equals("L"));
		    			   
		    			   //List<WebElement> secondaryparameters_supertest = DriverManager.getDriver().findElements(By.xpath("(//*[@class='hudsonTestView' and contains(text(),'No Trip Loop Test')]/ancestor::*[@class='measurement-header']/..)["+i+1+"]//*[contains(@class,'hudsonSecondaryReading')]//*[@class='superTest']"));
		    			   //List<WebElement> secondaryparameters_subtest = DriverManager.getDriver().findElements(By.xpath("(//*[@class='hudsonTestView' and contains(text(),'No Trip Loop Test')]/ancestor::*[@class='measurement-header']/..)["+i+1+"]//*[contains(@class,'hudsonSecondaryReading')]//*[@class='subTest']"));
		    			   
		    			   for(WebElement e:secondaryparameters_subtest)
		    			   {
		    			     AssertJUnit.assertTrue(e.getText().equals("k") || e.getText().equals("E"));
		    			     AssertJUnit.assertTrue(!e.getText().contains("L max"));
		    			     AssertJUnit.assertTrue(!e.getText().contains("i max"));
		    			   }
		    			   
		    			 }
		    	     }  
		    		 
		    	 }
		    	 else
		    	 {
		    		 String zMaxText = DriverManager.getDriver().findElement(By.xpath("(//*[contains(@class,'hudsonTestName') and contains(text(),'No Trip Loop Test')]/ancestor::*[contains(@class,'measurement-header')])[1]//*[@class='zMaxText']")).getText();
		    		 
		    		 List<WebElement> secondaryparameters_supertest = DriverManager.getDriver().findElements(By.xpath("(//*[@class='hudsonTestView' and contains(text(),'No Trip Loop Test')]/ancestor::*[@class='measurement-header']/..)[1]//*[contains(@class,'hudsonSecondaryReading')]//*[@class='superTest']"));
	    			 List<WebElement> secondaryparameters_subtest = DriverManager.getDriver().findElements(By.xpath("(//*[@class='hudsonTestView' and contains(text(),'No Trip Loop Test')]/ancestor::*[@class='measurement-header']/..)[1]//*[contains(@class,'hudsonSecondaryReading')]//*[@class='subTest']"));
		    		 if(zMaxText.contains("ON"))
	    			 {
	    				 
	    			
	    			   AssertJUnit.assertTrue(DriverManager.getDriver().findElement(By.xpath("(//*[@class='hudsonTestView' and contains(text(),'No Trip Loop Test')]/ancestor::*[@class='measurement-header']/..)[1]//*[contains(@class,'hudsonPrimaryReading')]//*[@class='superTest']")).getText().equals("Z"));
	    			   AssertJUnit.assertTrue(DriverManager.getDriver().findElement(By.xpath("(//*[@class='hudsonTestView' and contains(text(),'No Trip Loop Test')]/ancestor::*[@class='measurement-header']/..)[1]//*[contains(@class,'hudsonPrimaryReading')]//*[@class='subTest']")).getText().equals("L"));
	    			   
	    			   for(WebElement element:secondaryparameters_supertest)
	    			   {
	    			      AssertJUnit.assertTrue(element.getText().equals("PEFC I") || element.getText().equals("Z") || element.getText().equals("R") || element.getText().equals("PSC I"));
	    			   }
	    			   
	    			   for(WebElement e:secondaryparameters_subtest)
	    			   {
	    			     AssertJUnit.assertTrue(e.getText().equals("k") || e.getText().equals("E") || e.getText().equals("L max") || e.getText().equals("i max"));
	    			   }
	    			 }
	    			 
	    			 if(zMaxText.contains("OFF"))
	    			 {
	    			   AssertJUnit.assertTrue(DriverManager.getDriver().findElement(By.xpath("(//*[@class='hudsonTestView' and contains(text(),'No Trip Loop Test')]/ancestor::*[@class='measurement-header']/..)[1]//*[contains(@class,'hudsonPrimaryReading')]//*[@class='superTest']")).getText().equals("Z"));
	    			   AssertJUnit.assertTrue(DriverManager.getDriver().findElement(By.xpath("(//*[@class='hudsonTestView' and contains(text(),'No Trip Loop Test')]/ancestor::*[@class='measurement-header']/..)[1]//*[contains(@class,'hudsonPrimaryReading')]//*[@class='subTest']")).getText().equals("L"));
	    			   
	    			   //List<WebElement> secondaryparameters_supertest = DriverManager.getDriver().findElements(By.xpath("(//*[@class='hudsonTestView' and contains(text(),'No Trip Loop Test')]/ancestor::*[@class='measurement-header']/..)[1]//*[contains(@class,'hudsonSecondaryReading')]//*[@class='superTest']"));
	    			   //List<WebElement> secondaryparameters_subtest = DriverManager.getDriver().findElements(By.xpath("(//*[@class='hudsonTestView' and contains(text(),'No Trip Loop Test')]/ancestor::*[@class='measurement-header']/..)[1]//*[contains(@class,'hudsonSecondaryReading')]//*[@class='subTest']"));
	    			 
	    			   for(WebElement e:secondaryparameters_subtest)
	    			   {
	    			     AssertJUnit.assertTrue(e.getText().equals("k") || e.getText().equals("E"));
	    			     AssertJUnit.assertTrue(!e.getText().contains("L max"));
	    			     AssertJUnit.assertTrue(!e.getText().contains("i max"));
	    			   }
	    			   }
	    			   
	    			  }
		    		     
	             }
	
		    	break;
		    	 
		     case "High-Current Loop Test":
		    	 int number_of_highloopcurrent_measurements = fc1664_highloopcurrenttests.size();
		    	 
		    	 if(number_of_highloopcurrent_measurements!=0)
		    	 {
		    	 if(number_of_highloopcurrent_measurements > 1)
		    	 {
		    		 for(int i=0;i<number_of_highloopcurrent_measurements;i++)
		    		 {
		    			 String zMaxText = DriverManager.getDriver().findElement(By.xpath("(//*[@class='hudsonTestView' and contains(text(),'High-Current Loop Test')]/ancestor::*[@class='measurement-header']/..)["+i+1+"]//*[@class='zMaxText']")).getText();
		    			 
		    			 if(zMaxText.contains("ON"))
		    			 {
		    			   AssertJUnit.assertTrue(fc1664_highcurrentlooptest_primaryMeasurements_superparameter.get(i).getText().equals("Z"));
		    			   AssertJUnit.assertTrue(fc1664_highcurrentlooptest_primaryMeasurements_subparameter.get(i).getText().equals("L") || fc1664_highcurrentlooptest_primaryMeasurements_subparameter.get(i).getText().equals("i"));
		    			   //AssertJUnit.assertTrue(fc1664_highcurrentlooptest_secondaryMeasurements_superparameter.get(i).getText().equals("PEFC I") || fc1664_highcurrentlooptest_secondaryMeasurements_superparameter.get(i).getText().equals("PSC I"));
		    			   //AssertJUnit.assertTrue(fc1664_highcurrentlooptest_secondaryMeasurements_subparameter.get(i).getText().equals("k"));
		    			 
		    			   //AssertJUnit.assertTrue(DriverManager.getDriver().findElement(By.xpath("(//*[@class='hudsonTestView' and contains(text(),'High-Current Loop Test')]/ancestor::*[@class='measurement-header']/..)["+i+1+"]//*[contains(@class,'hudsonSecondaryReading')]//*[@class='superTest']")).getText().equals("PEFC I") || DriverManager.getDriver().findElement(By.xpath("(//*[@class='hudsonTestView' and contains(text(),'High-Current Loop Test')]/ancestor::*[@class='measurement-header']/..)["+i+1+"]//*[contains(@class,'hudsonSecondaryReading')]//*[@class='superTest']")).getText().equals("Z") || DriverManager.getDriver().findElement(By.xpath("(//*[@class='hudsonTestView' and contains(text(),'High-Current Loop Test')]/ancestor::*[@class='measurement-header']/..)["+i+1+"]//*[contains(@class,'hudsonSecondaryReading')]//*[@class='superTest']")).getText().equals("PSC I") || DriverManager.getDriver().findElement(By.xpath("(//*[@class='hudsonTestView' and contains(text(),'High-Current Loop Test')]/ancestor::*[@class='measurement-header']/..)["+i+1+"]//*[contains(@class,'hudsonSecondaryReading')]//*[@class='superTest']")).getText().equals("PEFC I") || DriverManager.getDriver().findElement(By.xpath("(//*[@class='hudsonTestView' and contains(text(),'High-Current Loop Test')]/ancestor::*[@class='measurement-header']/..)["+i+1+"]//*[contains(@class,'hudsonSecondaryReading')]//*[@class='superTest']")).getText().equals("PSC I"));
		    			   //AssertJUnit.assertTrue(DriverManager.getDriver().findElement(By.xpath("(//*[@class='hudsonTestView' and contains(text(),'High-Current Loop Test')]/ancestor::*[@class='measurement-header']/..)["+i+1+"]//*[contains(@class,'hudsonSecondaryReading')]//*[@class='subTest']")).getText().equals("k") || DriverManager.getDriver().findElement(By.xpath("(//*[@class='hudsonTestView' and contains(text(),'High-Current Loop Test')]/ancestor::*[@class='measurement-header']/..)["+i+1+"]//*[contains(@class,'hudsonSecondaryReading')]//*[@class='subTest']")).getText().equals("E"));
		    			   
		    			   List<WebElement> secondaryparameters_supertest = DriverManager.getDriver().findElements(By.xpath("(//*[@class='hudsonTestView' and contains(text(),'High-Current Loop Test')]/ancestor::*[@class='measurement-header']/..)["+i+1+"]//*[contains(@class,'hudsonSecondaryReading')]//*[@class='superTest']"));
		    			   List<WebElement> secondaryparameters_subtest = DriverManager.getDriver().findElements(By.xpath("(//*[@class='hudsonTestView' and contains(text(),'High-Current Loop Test')]/ancestor::*[@class='measurement-header']/..)["+i+1+"]//*[contains(@class,'hudsonSecondaryReading')]//*[@class='subTest']"));
		    			   
		    			   for(WebElement element:secondaryparameters_supertest)
		    			   {
		    			      AssertJUnit.assertTrue(element.getText().equals("PEFC I") || element.getText().equals("Z") || element.getText().equals("PSC I"));
		    			   }
		    			   
		    			   for(WebElement e:secondaryparameters_subtest)
		    			   {
		    			     AssertJUnit.assertTrue(e.getText().equals("k") ||  e.getText().equals("L max") || e.getText().equals("i max"));
		    			   } 
		    			 }
		    			 if(zMaxText.contains("OFF"))
		    			 {
		    			   AssertJUnit.assertTrue(fc1664_highcurrentlooptest_primaryMeasurements_superparameter.get(i).getText().equals("Z"));
		    			   AssertJUnit.assertTrue(fc1664_highcurrentlooptest_primaryMeasurements_subparameter.get(i).getText().equals("L") || fc1664_highcurrentlooptest_primaryMeasurements_subparameter.get(i).getText().equals("i"));
		    			   //AssertJUnit.assertTrue(fc1664_highcurrentlooptest_secondaryMeasurements_superparameter.get(i).getText().equals("PEFC I") || fc1664_highcurrentlooptest_secondaryMeasurements_superparameter.get(i).getText().equals("PSC I"));
		    			   //AssertJUnit.assertTrue(fc1664_highcurrentlooptest_secondaryMeasurements_subparameter.get(i).getText().equals("k"));
		    			 
		    			   //AssertJUnit.assertTrue(DriverManager.getDriver().findElement(By.xpath("(//*[@class='hudsonTestView' and contains(text(),'High-Current Loop Test')]/ancestor::*[@class='measurement-header']/..)["+i+1+"]//*[contains(@class,'hudsonSecondaryReading')]//*[@class='superTest']")).getText().equals("PEFC I") || DriverManager.getDriver().findElement(By.xpath("(//*[@class='hudsonTestView' and contains(text(),'High-Current Loop Test')]/ancestor::*[@class='measurement-header']/..)["+i+1+"]//*[contains(@class,'hudsonSecondaryReading')]//*[@class='superTest']")).getText().equals("Z") || DriverManager.getDriver().findElement(By.xpath("(//*[@class='hudsonTestView' and contains(text(),'High-Current Loop Test')]/ancestor::*[@class='measurement-header']/..)["+i+1+"]//*[contains(@class,'hudsonSecondaryReading')]//*[@class='superTest']")).getText().equals("PSC I") || DriverManager.getDriver().findElement(By.xpath("(//*[@class='hudsonTestView' and contains(text(),'High-Current Loop Test')]/ancestor::*[@class='measurement-header']/..)["+i+1+"]//*[contains(@class,'hudsonSecondaryReading')]//*[@class='superTest']")).getText().equals("PEFC I") || DriverManager.getDriver().findElement(By.xpath("(//*[@class='hudsonTestView' and contains(text(),'High-Current Loop Test')]/ancestor::*[@class='measurement-header']/..)["+i+1+"]//*[contains(@class,'hudsonSecondaryReading')]//*[@class='superTest']")).getText().equals("PSC I"));
		    			   //AssertJUnit.assertTrue(DriverManager.getDriver().findElement(By.xpath("(//*[@class='hudsonTestView' and contains(text(),'High-Current Loop Test')]/ancestor::*[@class='measurement-header']/..)["+i+1+"]//*[contains(@class,'hudsonSecondaryReading')]//*[@class='subTest']")).getText().equals("k") || DriverManager.getDriver().findElement(By.xpath("(//*[@class='hudsonTestView' and contains(text(),'High-Current Loop Test')]/ancestor::*[@class='measurement-header']/..)["+i+1+"]//*[contains(@class,'hudsonSecondaryReading')]//*[@class='subTest']")).getText().equals("E"));
		    			   
		    			   List<WebElement> secondaryparameters_supertest = DriverManager.getDriver().findElements(By.xpath("(//*[@class='hudsonTestView' and contains(text(),'High-Current Loop Test')]/ancestor::*[@class='measurement-header']/..)["+i+1+"]//*[contains(@class,'hudsonSecondaryReading')]//*[@class='superTest']"));
		    			   List<WebElement> secondaryparameters_subtest = DriverManager.getDriver().findElements(By.xpath("(//*[@class='hudsonTestView' and contains(text(),'High-Current Loop Test')]/ancestor::*[@class='measurement-header']/..)["+i+1+"]//*[contains(@class,'hudsonSecondaryReading')]//*[@class='subTest']"));
		    			   
		    			   for(WebElement element:secondaryparameters_supertest)
		    			   {
		    			      AssertJUnit.assertTrue(element.getText().equals("PEFC I") || element.getText().equals("Z") || element.getText().equals("PSC I"));
		    			   }
		    			   
		    			   for(WebElement e:secondaryparameters_subtest)
		    			   {
		    			     AssertJUnit.assertTrue(e.getText().equals("k"));
		    			     AssertJUnit.assertTrue(!e.getText().equals("L max"));
		    			     AssertJUnit.assertTrue(!e.getText().equals("i max"));
		    			   } 
		    			 }
		    			 
		    			 
		    			 
		    		 }
		    	 }
		    	else
		    	{
		    		 String zMaxText = DriverManager.getDriver().findElement(By.xpath("(//*[@class='hudsonTestView' and contains(text(),'High-Current Loop Test')]/ancestor::*[@class='measurement-header']/..)[1]//*[@class='zMaxText']")).getText();
	    			 
	    			
	    			   AssertJUnit.assertTrue(fc1664_highcurrentlooptest_primaryMeasurements_superparameter.get(0).getText().equals("Z"));
	    			   AssertJUnit.assertTrue(fc1664_highcurrentlooptest_primaryMeasurements_subparameter.get(0).getText().equals("L") || fc1664_highcurrentlooptest_primaryMeasurements_subparameter.get(0).getText().equals("i"));
	    			   //AssertJUnit.assertTrue(fc1664_highcurrentlooptest_secondaryMeasurements_superparameter.get(i).getText().equals("PEFC I") || fc1664_highcurrentlooptest_secondaryMeasurements_superparameter.get(i).getText().equals("PSC I"));
	    			   //AssertJUnit.assertTrue(fc1664_highcurrentlooptest_secondaryMeasurements_subparameter.get(i).getText().equals("k"));
	    			 
	    			   //AssertJUnit.assertTrue(DriverManager.getDriver().findElement(By.xpath("(//*[@class='hudsonTestView' and contains(text(),'High-Current Loop Test')]/ancestor::*[@class='measurement-header']/..)["+i+1+"]//*[contains(@class,'hudsonSecondaryReading')]//*[@class='superTest']")).getText().equals("PEFC I") || DriverManager.getDriver().findElement(By.xpath("(//*[@class='hudsonTestView' and contains(text(),'High-Current Loop Test')]/ancestor::*[@class='measurement-header']/..)["+i+1+"]//*[contains(@class,'hudsonSecondaryReading')]//*[@class='superTest']")).getText().equals("Z") || DriverManager.getDriver().findElement(By.xpath("(//*[@class='hudsonTestView' and contains(text(),'High-Current Loop Test')]/ancestor::*[@class='measurement-header']/..)["+i+1+"]//*[contains(@class,'hudsonSecondaryReading')]//*[@class='superTest']")).getText().equals("PSC I") || DriverManager.getDriver().findElement(By.xpath("(//*[@class='hudsonTestView' and contains(text(),'High-Current Loop Test')]/ancestor::*[@class='measurement-header']/..)["+i+1+"]//*[contains(@class,'hudsonSecondaryReading')]//*[@class='superTest']")).getText().equals("PEFC I") || DriverManager.getDriver().findElement(By.xpath("(//*[@class='hudsonTestView' and contains(text(),'High-Current Loop Test')]/ancestor::*[@class='measurement-header']/..)["+i+1+"]//*[contains(@class,'hudsonSecondaryReading')]//*[@class='superTest']")).getText().equals("PSC I"));
	    			   //AssertJUnit.assertTrue(DriverManager.getDriver().findElement(By.xpath("(//*[@class='hudsonTestView' and contains(text(),'High-Current Loop Test')]/ancestor::*[@class='measurement-header']/..)["+i+1+"]//*[contains(@class,'hudsonSecondaryReading')]//*[@class='subTest']")).getText().equals("k") || DriverManager.getDriver().findElement(By.xpath("(//*[@class='hudsonTestView' and contains(text(),'High-Current Loop Test')]/ancestor::*[@class='measurement-header']/..)["+i+1+"]//*[contains(@class,'hudsonSecondaryReading')]//*[@class='subTest']")).getText().equals("E"));
	    			  
	    			   
	    			   List<WebElement> secondaryparameters_supertest = DriverManager.getDriver().findElements(By.xpath("(//*[@class='hudsonTestView' and contains(text(),'High-Current Loop Test')]/ancestor::*[@class='measurement-header']/..)[1]//*[contains(@class,'hudsonSecondaryReading')]//*[@class='superTest']"));
	    			   List<WebElement> secondaryparameters_subtest = DriverManager.getDriver().findElements(By.xpath("(//*[@class='hudsonTestView' and contains(text(),'High-Current Loop Test')]/ancestor::*[@class='measurement-header']/..)[1]//*[contains(@class,'hudsonSecondaryReading')]//*[@class='subTest']"));
	    			   if(zMaxText.contains("ON"))
		    		   {
	    			  
	    			   
	    			   for(WebElement element:secondaryparameters_supertest)
	    			   {
	    			      AssertJUnit.assertTrue(element.getText().equals("PEFC I") || element.getText().equals("Z") || element.getText().equals("PSC I"));
	    			   }
	    			   
	    			   for(WebElement e:secondaryparameters_subtest)
	    			   {
	    			     AssertJUnit.assertTrue(e.getText().equals("k") ||  e.getText().equals("L max") || e.getText().equals("i max"));
	    			   } 
	    			 }
	    			 if(zMaxText.contains("OFF"))
	    			 {
	    			   AssertJUnit.assertTrue(fc1664_highcurrentlooptest_primaryMeasurements_superparameter.get(0).getText().equals("Z"));
	    			   AssertJUnit.assertTrue(fc1664_highcurrentlooptest_primaryMeasurements_subparameter.get(0).getText().equals("L") || fc1664_highcurrentlooptest_primaryMeasurements_subparameter.get(0).getText().equals("i"));
	    			   //AssertJUnit.assertTrue(fc1664_highcurrentlooptest_secondaryMeasurements_superparameter.get(i).getText().equals("PEFC I") || fc1664_highcurrentlooptest_secondaryMeasurements_superparameter.get(i).getText().equals("PSC I"));
	    			   //AssertJUnit.assertTrue(fc1664_highcurrentlooptest_secondaryMeasurements_subparameter.get(i).getText().equals("k"));
	    			 
	    			   //AssertJUnit.assertTrue(DriverManager.getDriver().findElement(By.xpath("(//*[@class='hudsonTestView' and contains(text(),'High-Current Loop Test')]/ancestor::*[@class='measurement-header']/..)["+i+1+"]//*[contains(@class,'hudsonSecondaryReading')]//*[@class='superTest']")).getText().equals("PEFC I") || DriverManager.getDriver().findElement(By.xpath("(//*[@class='hudsonTestView' and contains(text(),'High-Current Loop Test')]/ancestor::*[@class='measurement-header']/..)["+i+1+"]//*[contains(@class,'hudsonSecondaryReading')]//*[@class='superTest']")).getText().equals("Z") || DriverManager.getDriver().findElement(By.xpath("(//*[@class='hudsonTestView' and contains(text(),'High-Current Loop Test')]/ancestor::*[@class='measurement-header']/..)["+i+1+"]//*[contains(@class,'hudsonSecondaryReading')]//*[@class='superTest']")).getText().equals("PSC I") || DriverManager.getDriver().findElement(By.xpath("(//*[@class='hudsonTestView' and contains(text(),'High-Current Loop Test')]/ancestor::*[@class='measurement-header']/..)["+i+1+"]//*[contains(@class,'hudsonSecondaryReading')]//*[@class='superTest']")).getText().equals("PEFC I") || DriverManager.getDriver().findElement(By.xpath("(//*[@class='hudsonTestView' and contains(text(),'High-Current Loop Test')]/ancestor::*[@class='measurement-header']/..)["+i+1+"]//*[contains(@class,'hudsonSecondaryReading')]//*[@class='superTest']")).getText().equals("PSC I"));
	    			   //AssertJUnit.assertTrue(DriverManager.getDriver().findElement(By.xpath("(//*[@class='hudsonTestView' and contains(text(),'High-Current Loop Test')]/ancestor::*[@class='measurement-header']/..)["+i+1+"]//*[contains(@class,'hudsonSecondaryReading')]//*[@class='subTest']")).getText().equals("k") || DriverManager.getDriver().findElement(By.xpath("(//*[@class='hudsonTestView' and contains(text(),'High-Current Loop Test')]/ancestor::*[@class='measurement-header']/..)["+i+1+"]//*[contains(@class,'hudsonSecondaryReading')]//*[@class='subTest']")).getText().equals("E"));
	    			   
	    			   //List<WebElement> secondaryparameters_supertest = DriverManager.getDriver().findElements(By.xpath("(//*[@class='hudsonTestView' and contains(text(),'High-Current Loop Test')]/ancestor::*[@class='measurement-header']/..)[1]//*[contains(@class,'hudsonSecondaryReading')]//*[@class='superTest']"));
	    			   //List<WebElement> secondaryparameters_subtest = DriverManager.getDriver().findElements(By.xpath("(//*[@class='hudsonTestView' and contains(text(),'High-Current Loop Test')]/ancestor::*[@class='measurement-header']/..)[1]//*[contains(@class,'hudsonSecondaryReading')]//*[@class='subTest']"));
	    			   
	    			   for(WebElement element:secondaryparameters_supertest)
	    			   {
	    			      AssertJUnit.assertTrue(element.getText().equals("PEFC I") || element.getText().equals("Z") || element.getText().equals("PSC I"));
	    			   }
	    			   
	    			   for(WebElement e:secondaryparameters_subtest)
	    			   {
	    			     AssertJUnit.assertTrue(e.getText().equals("k"));
	    			     AssertJUnit.assertTrue(!e.getText().equals("L max"));
	    			     AssertJUnit.assertTrue(!e.getText().equals("i max"));
	    			     
	    			   } 
	    			 }
	    			 
		    		     /*AssertJUnit.assertTrue(fc1664_highcurrentlooptest_primaryMeasurements_superparameter.get(0).getText().equals("Z"));
			    		 AssertJUnit.assertTrue(fc1664_highcurrentlooptest_primaryMeasurements_subparameter.get(0).getText().equals("L") || fc1664_highcurrentlooptest_primaryMeasurements_subparameter.get(0).getText().equals("i"));
			    		 AssertJUnit.assertTrue(fc1664_highcurrentlooptest_secondaryMeasurements_superparameter.get(0).getText().equals("PEFC I") || fc1664_highcurrentlooptest_secondaryMeasurements_superparameter.get(0).getText().equals("PSC I"));
			    		 AssertJUnit.assertTrue(fc1664_highcurrentlooptest_secondaryMeasurements_subparameter.get(0).getText().equals("k"));*/
	            }
		    	 }
		       break;
		       
		     case "RCD Tripping Time Test":
		    	 int number_of_rcdtrippingtime_measurements = fc1664_rcdtriptimetests.size();
		    	 
		    	 if(number_of_rcdtrippingtime_measurements!=0)
		    	 {
		    	 if(number_of_rcdtrippingtime_measurements > 1)
		    	 {
		    		 for(int i=0;i<number_of_rcdtrippingtime_measurements;i++)
		    		 {
		    			 AssertJUnit.assertTrue(fc1664_rcdtrippingtimetest_primaryMeasurements_superparameter.get(i).getText().equals("ΔT"));
		    			 AssertJUnit.assertTrue(fc1664_rcdtrippingtimetest_secondaryMeasurements_superparameter.get(i).getText().equals("U"));
		    			 AssertJUnit.assertTrue(fc1664_rcdtrippingtimetest_secondaryMeasurements_subparameter.get(i).getText().equals("F"));
		    		 }
		    	 }
		    	 else
		    	 {
		    		     AssertJUnit.assertTrue(fc1664_rcdtrippingtimetest_primaryMeasurements_superparameter.get(0).getText().equals("ΔT"));
			    		 AssertJUnit.assertTrue(fc1664_rcdtrippingtimetest_secondaryMeasurements_superparameter.get(0).getText().equals("U"));
			    		 AssertJUnit.assertTrue(fc1664_rcdtrippingtimetest_secondaryMeasurements_subparameter.get(0).getText().equals("F"));
	             }
		    	 }
		       break;
		       
		     case "RCD Tripping Current Test":
		    	 int number_of_rcdtrippingcurrent_measurements = fc1664_rcdtripcurrenttests.size();
		    	 
		    	 if(number_of_rcdtrippingcurrent_measurements!=0)
		    	 {
		    	 if(number_of_rcdtrippingcurrent_measurements > 1)
		    	 {
		    		 for(int i=0;i<number_of_rcdtrippingcurrent_measurements;i++)
		    		 {
		    			 AssertJUnit.assertTrue(fc1664_rcdtrippingcurrenttest_primaryMeasurements_superparameter.get(i).getText().equals("IΔ"));
		    			 //AssertJUnit.assertTrue(fc1664_rcdtrippingcurrenttest_secondaryMeasurements_superparameter.get(i).getText().equals("U"));
		    			 //AssertJUnit.assertTrue(fc1664_rcdtrippingcurrenttest_secondaryMeasurements_subparameter.get(i).getText().equals("F"));
		    			 
		    			 List<WebElement> secondary_parameters_supertest = DriverManager.getDriver().findElements(By.xpath("(//*[@class='hudsonTestView' and contains(text(),'RCD Tripping Current Test')]/ancestor::*[contains(@class,'measDetail')]/..)["+i+1+"]//*[contains(@class,'hudsonSecondaryReading')]//*[@class='superTest']"));
		    			 List<WebElement> secondary_parameters_subtest = DriverManager.getDriver().findElements(By.xpath("(//*[@class='hudsonTestView' and contains(text(),'RCD Tripping Current Test')]/ancestor::*[contains(@class,'measDetail')]/..)["+i+1+"]//*[contains(@class,'hudsonSecondaryReading')]//*[@class='superTest']"));
		    			 
		    			 for(WebElement element:secondary_parameters_supertest)
		    			 {
		    			    AssertJUnit.assertTrue(element.getText().equals("U") || element.getText().equals("ΔT"));
		    			 }
		    			 
		    			 for(WebElement e:secondary_parameters_subtest)
		    			 {
		    				 AssertJUnit.assertTrue(e.getText().equals("F"));
		    			 }
		    			 
		    		 }
		    	 }
		    	 else
		    	 {
		    		     AssertJUnit.assertTrue(fc1664_rcdtrippingcurrenttest_primaryMeasurements_superparameter.get(0).getText().equals("IΔ"));
			    		 //AssertJUnit.assertTrue(fc1664_rcdtrippingcurrenttest_secondaryMeasurements_superparameter.get(0).getText().equals("U"));
			    		 //AssertJUnit.assertTrue(fc1664_rcdtrippingcurrenttest_secondaryMeasurements_subparameter.get(0).getText().equals("F"));
		    		     
		    		     //AssertJUnit.assertTrue(fc1664_rcdtrippingcurrenttest_primaryMeasurements_superparameter.get(0).getText().equals("IΔ"));
		    			 //AssertJUnit.assertTrue(fc1664_rcdtrippingcurrenttest_secondaryMeasurements_superparameter.get(i).getText().equals("U"));
		    			 //AssertJUnit.assertTrue(fc1664_rcdtrippingcurrenttest_secondaryMeasurements_subparameter.get(i).getText().equals("F"));
		    			 
		    			 List<WebElement> secondary_parameters_supertest = DriverManager.getDriver().findElements(By.xpath("(//*[@class='hudsonTestView' and contains(text(),'RCD Tripping Current Test')]/ancestor::*[contains(@class,'measDetail')]/..)[1]//*[contains(@class,'hudsonSecondaryReading')]//*[@class='superTest']"));
		    			 List<WebElement> secondary_parameters_subtest = DriverManager.getDriver().findElements(By.xpath("(//*[@class='hudsonTestView' and contains(text(),'RCD Tripping Current Test')]/ancestor::*[contains(@class,'measDetail')]/..)[1]//*[contains(@class,'hudsonSecondaryReading')]//*[@class='superTest']"));
		    			 
		    			 for(WebElement element:secondary_parameters_supertest)
		    			 {
		    			    AssertJUnit.assertTrue(element.getText().equals("U") || element.getText().equals("ΔT"));
		    			 }
		    			 
		    			 for(WebElement e:secondary_parameters_subtest)
		    			 {
		    				 AssertJUnit.assertTrue(e.getText().equals("F"));
		    			 }
	             }
		    	 }
		       break;
		       
		     case "Earth Ground Test":
		    	 int number_of_earthground_measurements = fc1664_earthgroundtests.size();
		    	 
		    	 if(number_of_earthground_measurements!=0)
		    	 {
		    	 if(number_of_earthground_measurements > 1)
		    	 {
		    		 for(int i=0;i<number_of_earthground_measurements;i++)
		    		 {
		    			 AssertJUnit.assertTrue(fc1664_earthgroundtest_primaryMeasurements_superparameter.get(i).getText().equals("R"));
		    			 AssertJUnit.assertTrue(fc1664_earthgroundtest_primaryMeasurements_subparameter.get(i).getText().equals("E"));
		    			 
		    		 }
		    	 }
		    	 else
		    	 {
		    		 AssertJUnit.assertTrue(fc1664_earthgroundtest_primaryMeasurements_superparameter.get(0).getText().equals("R"));
	    			 AssertJUnit.assertTrue(fc1664_earthgroundtest_primaryMeasurements_subparameter.get(0).getText().equals("E"));
	    			 
	             }
		    	 }
		       break;
		       
		     case "Phase Sequence Test":
		    	 int number_of_phasesequence_measurements = fc1664_phasesequencetests.size();
		    	 
		    	 if(number_of_phasesequence_measurements!=0)
		    	 {
		    	 if(number_of_phasesequence_measurements > 1)
		    	 {
		    		 for(int i=0;i<number_of_phasesequence_measurements;i++)
		    		 {
		    			 AssertJUnit.assertTrue(ElementUtils.isDisplayed(fc1664_phasesequencetests_sequence.get(i)));
		    		 }
		    	 }
		    	 else
		    	 {
		    		 AssertJUnit.assertTrue(ElementUtils.isDisplayed(fc1664_phasesequencetests_sequence.get(0)));
	    			 
	             }
		    	 }	 
		   }
		
		
		
		
	}
	
	public void verify1664FCReadings(String measurementtype)
	{
		
      switch(measurementtype)
      {
	   case "Voltage":
   	     int number_of_voltage_measurements = fc1664_voltagetest_primaryreading_value.size();
   	 
   	     if(number_of_voltage_measurements > 1)
   	    {
   		   for(int i=0;i<number_of_voltage_measurements;i++)
   		   {
   			 AssertJUnit.assertTrue(!fc1664_voltagetest_primaryreading_value.get(i).getText().equals(""));
   			 AssertJUnit.assertTrue(!fc1664_voltagetest_primaryreading_value.get(i).getText().equalsIgnoreCase("null"));
   			 AssertJUnit.assertNotNull(fc1664_voltagetest_primaryreading_value.get(i).getText());
   			 //AssertJUnit.assertTrue(!fc1664_voltagetest_primaryreading_value.get(i).getText().equals("----"));
   			 AssertJUnit.assertTrue(fc1664_voltagetest_primaryreading_unit.get(i).getText().equals("V AC"));
   			 AssertJUnit.assertTrue(!fc1664_voltagetest_secondaryreading_value.get(i).getText().equals(""));
  			 AssertJUnit.assertTrue(!fc1664_voltagetest_secondaryreading_value.get(i).getText().equalsIgnoreCase("null"));
  			 AssertJUnit.assertNotNull(fc1664_voltagetest_secondaryreading_value.get(i).getText());
  			 //AssertJUnit.assertTrue(!fc1664_voltagetest_secondaryreading_value.get(i).getText().equals("----"));
  			 AssertJUnit.assertTrue(fc1664_voltagetest_secondaryreading_unit.get(i).getText().equals("Hz"));
   			
   		   }
   	    }
   	    else
   	    {
   	         AssertJUnit.assertTrue(!fc1664_voltagetest_primaryreading_value.get(0).getText().equals(""));
			 AssertJUnit.assertTrue(!fc1664_voltagetest_primaryreading_value.get(0).getText().equalsIgnoreCase("null"));
			 AssertJUnit.assertNotNull(fc1664_voltagetest_primaryreading_value.get(0).getText());
			 AssertJUnit.assertTrue(!fc1664_voltagetest_primaryreading_value.get(0).getText().equals("----"));
			 AssertJUnit.assertTrue(fc1664_voltagetest_primaryreading_unit.get(0).getText().equals("V AC"));
			 AssertJUnit.assertTrue(!fc1664_voltagetest_secondaryreading_value.get(0).getText().equals(""));
			 AssertJUnit.assertTrue(!fc1664_voltagetest_secondaryreading_value.get(0).getText().equalsIgnoreCase("null"));
			 AssertJUnit.assertNotNull(fc1664_voltagetest_secondaryreading_value.get(0).getText());
			 //AssertJUnit.assertTrue(!fc1664_voltagetest_secondaryreading_value.get(i).getText().equals("----"));
			 AssertJUnit.assertTrue(fc1664_voltagetest_secondaryreading_unit.get(0).getText().equals("Hz"));
   	    }
   	 
        break;
        
	   case "Insulation":
	   	     int number_of_insulation_measurements = fc1664_insulationtest_primaryreading_value.size();
	   	 
	   	     if(number_of_insulation_measurements > 1)
	   	    {
	   		   for(int i=0;i<number_of_insulation_measurements;i++)
	   		   {
	   			 AssertJUnit.assertTrue(!fc1664_insulationtest_primaryreading_value.get(i).getText().equals(""));
	   			 AssertJUnit.assertTrue(!fc1664_insulationtest_primaryreading_value.get(i).getText().equalsIgnoreCase("null"));
	   			 AssertJUnit.assertNotNull(fc1664_insulationtest_primaryreading_value.get(i).getText());
	   			 AssertJUnit.assertTrue(!fc1664_insulationtest_primaryreading_value.get(i).getText().equals("----"));
	   			 AssertJUnit.assertTrue(fc1664_insulationtest_primaryreading_unit.get(i).getText().equals("MΩ"));
	   			 AssertJUnit.assertTrue(!fc1664_insulationtest_secondaryreading_value.get(i).getText().equals(""));
	  			 AssertJUnit.assertTrue(!fc1664_insulationtest_secondaryreading_value.get(i).getText().equalsIgnoreCase("null"));
	  			 AssertJUnit.assertNotNull(fc1664_insulationtest_secondaryreading_value.get(i).getText());
	  			 AssertJUnit.assertTrue(!fc1664_insulationtest_secondaryreading_value.get(i).getText().equals("----"));
	  			 AssertJUnit.assertTrue(fc1664_insulationtest_secondaryreading_unit.get(i).getText().equals("V DC"));
	   			
	   		   }
	   	    }
	   	    else
	   	    {
	   	     AssertJUnit.assertTrue(!fc1664_insulationtest_primaryreading_value.get(0).getText().equals(""));
   			 AssertJUnit.assertTrue(!fc1664_insulationtest_primaryreading_value.get(0).getText().equalsIgnoreCase("null"));
   			 AssertJUnit.assertNotNull(fc1664_insulationtest_primaryreading_value.get(0).getText());
   			 AssertJUnit.assertTrue(!fc1664_insulationtest_primaryreading_value.get(0).getText().equals("----"));
   			 AssertJUnit.assertTrue(fc1664_insulationtest_primaryreading_unit.get(0).getText().equals("MΩ"));
   			 AssertJUnit.assertTrue(!fc1664_insulationtest_secondaryreading_value.get(0).getText().equals(""));
  			 AssertJUnit.assertTrue(!fc1664_insulationtest_secondaryreading_value.get(0).getText().equalsIgnoreCase("null"));
  			 AssertJUnit.assertNotNull(fc1664_insulationtest_secondaryreading_value.get(0).getText());
  			 AssertJUnit.assertTrue(!fc1664_insulationtest_secondaryreading_value.get(0).getText().equals("----"));
  			 AssertJUnit.assertTrue(fc1664_insulationtest_secondaryreading_unit.get(0).getText().equals("V DC"));
	   	    }
	   	 break;
	   	 
	   case "Continuity":
	   	     int number_of_continuity_measurements = fc1664_continuitytest_primaryreading_value.size();
	   	 

	   	     if(number_of_continuity_measurements > 1)
	   	    {
	   		   for(int i=0;i<number_of_continuity_measurements;i++)
	   		   {
	   			 AssertJUnit.assertTrue(!fc1664_continuitytest_primaryreading_value.get(i).getText().equals(""));
	   			 AssertJUnit.assertTrue(!fc1664_continuitytest_primaryreading_value.get(i).getText().equalsIgnoreCase("null"));
	   			 AssertJUnit.assertNotNull(fc1664_continuitytest_primaryreading_value.get(i).getText());
	   			 AssertJUnit.assertTrue(!fc1664_continuitytest_primaryreading_value.get(i).getText().equals("----"));
	   			 AssertJUnit.assertTrue(fc1664_continuitytest_primaryreading_unit.get(i).getText().contains("Ω+") || fc1664_continuitytest_primaryreading_unit.get(i).getText().contains("Ω-") || fc1664_continuitytest_primaryreading_unit.get(i).getText().contains("Ω±"));
	   		   }
	   	    }
	   	    else
	   	    {
	   	    	 AssertJUnit.assertTrue(!fc1664_continuitytest_primaryreading_value.get(0).getText().equals(""));
	   			 AssertJUnit.assertTrue(!fc1664_continuitytest_primaryreading_value.get(0).getText().equalsIgnoreCase("null"));
	   			 AssertJUnit.assertNotNull(fc1664_continuitytest_primaryreading_value.get(0).getText());
	   			 AssertJUnit.assertTrue(!fc1664_continuitytest_primaryreading_value.get(0).getText().equals("----"));
	   			 AssertJUnit.assertTrue(fc1664_continuitytest_primaryreading_unit.get(0).getText().contains("Ω+") || fc1664_continuitytest_primaryreading_unit.get(0).getText().contains("Ω-") || fc1664_continuitytest_primaryreading_unit.get(0).getText().contains("Ω±"));
	   	    }
	   	     
	   	     
	   	     int no_of_continuity_secondary_values = fc1664_continuitytest_secondaryreading_value.size();
	   	     
	   	    for(int i=0;i<no_of_continuity_secondary_values;i++)
	   	    {
	   	        AssertJUnit.assertTrue(!fc1664_continuitytest_secondaryreading_value.get(i).getText().equals(""));
			    AssertJUnit.assertTrue(!fc1664_continuitytest_secondaryreading_value.get(i).getText().equalsIgnoreCase("null"));
			    AssertJUnit.assertNotNull(fc1664_continuitytest_secondaryreading_value.get(i).getText());
			    //AssertJUnit.assertTrue(!fc1664_nolooptriptest_secondaryreading_value.get(i).getText().equals("----"));
	   	    }
	   	    
	   	 int no_of_continuity_secondary_units = fc1664_continuitytest_secondaryreading_unit.size();
	   	 
	   	 for(int j=0;j<no_of_continuity_secondary_units;j++)
	   	 {
			    AssertJUnit.assertTrue(fc1664_continuitytest_secondaryreading_unit.get(j).getText().equals("Ω+") || fc1664_continuitytest_secondaryreading_unit.get(j).getText().equals("Ω-"));
	   	 }
	   	 break;
	   	 
	   case "No Trip Loop Test":
	   	     int number_of_notriploop_measurements = fc1664_nolooptriptest_primaryreading_value.size();
	   	 
	   	     if(number_of_notriploop_measurements != 0)
	   	     {
	   	       if(number_of_notriploop_measurements > 1)
	   	      {
	   		   for(int i=0;i<number_of_notriploop_measurements;i++)
	   		   {
	   			 AssertJUnit.assertTrue(!fc1664_nolooptriptest_primaryreading_value.get(i).getText().equals(""));
	   			 AssertJUnit.assertTrue(!fc1664_nolooptriptest_primaryreading_value.get(i).getText().equalsIgnoreCase("null"));
	   			 AssertJUnit.assertNotNull(fc1664_nolooptriptest_primaryreading_value.get(i).getText());
	   			 AssertJUnit.assertTrue(!fc1664_nolooptriptest_primaryreading_value.get(i).getText().equals("----"));
	   			 AssertJUnit.assertTrue(fc1664_nolooptriptest_primaryreading_unit.get(i).getText().equals("Ω"));
	   			 AssertJUnit.assertTrue(!fc1664_nolooptriptest_secondaryreading_value.get(i).getText().equals(""));
	  			 AssertJUnit.assertTrue(!fc1664_nolooptriptest_secondaryreading_value.get(i).getText().equalsIgnoreCase("null"));
	  			 AssertJUnit.assertNotNull(fc1664_nolooptriptest_secondaryreading_value.get(i).getText());
	  			 //AssertJUnit.assertTrue(!fc1664_nolooptriptest_secondaryreading_value.get(i).getText().equals("----"));
	  			 AssertJUnit.assertTrue(fc1664_nolooptriptest_secondaryreading_unit.get(i).getText().equals("A AC") || fc1664_nolooptriptest_secondaryreading_unit.get(i).getText().equals("Ω"));
	   			
	   		   }
	   	    }
	   	    else
	   	    {
	   	    	 AssertJUnit.assertTrue(!fc1664_nolooptriptest_primaryreading_value.get(0).getText().equals(""));
	   			 AssertJUnit.assertTrue(!fc1664_nolooptriptest_primaryreading_value.get(0).getText().equalsIgnoreCase("null"));
	   			 AssertJUnit.assertNotNull(fc1664_nolooptriptest_primaryreading_value.get(0).getText());
	   			 AssertJUnit.assertTrue(!fc1664_nolooptriptest_primaryreading_value.get(0).getText().equals("----"));
	   			 AssertJUnit.assertTrue(fc1664_nolooptriptest_primaryreading_unit.get(0).getText().equals("Ω"));
	   			 AssertJUnit.assertTrue(!fc1664_nolooptriptest_secondaryreading_value.get(0).getText().equals(""));
	  			 AssertJUnit.assertTrue(!fc1664_nolooptriptest_secondaryreading_value.get(0).getText().equalsIgnoreCase("null"));
	  			 AssertJUnit.assertNotNull(fc1664_nolooptriptest_secondaryreading_value.get(0).getText());
	  			 AssertJUnit.assertTrue(!fc1664_nolooptriptest_secondaryreading_value.get(0).getText().equals("----"));
	  			 AssertJUnit.assertTrue(fc1664_nolooptriptest_secondaryreading_unit.get(0).getText().equals("A AC") || fc1664_nolooptriptest_secondaryreading_unit.get(0).getText().equals("Ω"));
	   	    }
	   	  }
	   	 break;
	   	 
	   case "High Current Loop Test":
	   	     int number_of_highcurrentloop_measurements = fc1664_nolooptriptest_primaryreading_value.size();
	   	 
	   	     if(number_of_highcurrentloop_measurements != 0)
	   	     {
	   	     if(number_of_highcurrentloop_measurements > 1)
	   	    {
	   		   for(int i=0;i<number_of_highcurrentloop_measurements;i++)
	   		   {
	   			 AssertJUnit.assertTrue(!fc1664_highcurrentlooptest_primaryreading_value.get(i).getText().equals(""));
	   			 AssertJUnit.assertTrue(!fc1664_highcurrentlooptest_primaryreading_value.get(i).getText().equalsIgnoreCase("null"));
	   			 AssertJUnit.assertNotNull(fc1664_highcurrentlooptest_primaryreading_value.get(i).getText());
	   			 AssertJUnit.assertTrue(!fc1664_highcurrentlooptest_primaryreading_value.get(i).getText().equals("----"));
	   			 AssertJUnit.assertTrue(fc1664_highcurrentlooptest_primaryreading_unit.get(i).getText().equals("Ω") || fc1664_highcurrentlooptest_primaryreading_unit.get(i).getText().equals("mΩ"));
	   			 AssertJUnit.assertTrue(!fc1664_highcurrenlooptest_secondaryreading_value.get(i).getText().equals(""));
	  			 AssertJUnit.assertTrue(!fc1664_highcurrenlooptest_secondaryreading_value.get(i).getText().equalsIgnoreCase("null"));
	  			 AssertJUnit.assertNotNull(fc1664_highcurrenlooptest_secondaryreading_value.get(i).getText());
	  			 AssertJUnit.assertTrue(!fc1664_highcurrenlooptest_secondaryreading_value.get(i).getText().equals("----"));
	  			 AssertJUnit.assertTrue(fc1664_highcurrentlooptest_secondaryreading_unit.get(i).getText().equals("A AC") || fc1664_highcurrentlooptest_secondaryreading_unit.get(i).getText().equals("Ω"));
	   			
	   		   }
	   	    }
	   	    else
	   	    {
	   	    	 AssertJUnit.assertTrue(!fc1664_highcurrentlooptest_primaryreading_value.get(0).getText().equals(""));
	   			 AssertJUnit.assertTrue(!fc1664_highcurrentlooptest_primaryreading_value.get(0).getText().equalsIgnoreCase("null"));
	   			 AssertJUnit.assertNotNull(fc1664_highcurrentlooptest_primaryreading_value.get(0).getText());
	   			 AssertJUnit.assertTrue(!fc1664_highcurrentlooptest_primaryreading_value.get(0).getText().equals("----"));
	   			 AssertJUnit.assertTrue(fc1664_highcurrentlooptest_primaryreading_unit.get(0).getText().equals("Ω") || fc1664_highcurrentlooptest_primaryreading_unit.get(0).getText().equals("mΩ"));
	   			 AssertJUnit.assertTrue(!fc1664_highcurrenlooptest_secondaryreading_value.get(0).getText().equals(""));
	  			 AssertJUnit.assertTrue(!fc1664_highcurrenlooptest_secondaryreading_value.get(0).getText().equalsIgnoreCase("null"));
	  			 AssertJUnit.assertNotNull(fc1664_highcurrenlooptest_secondaryreading_value.get(0).getText());
	  			 AssertJUnit.assertTrue(!fc1664_highcurrenlooptest_secondaryreading_value.get(0).getText().equals("----"));
	  			 AssertJUnit.assertTrue(fc1664_highcurrentlooptest_secondaryreading_unit.get(0).getText().equals("A AC") || fc1664_highcurrentlooptest_secondaryreading_unit.get(0).getText().equals("Ω"));
	   	    }
	   	  }
	   	 break;
	   	 
	   case "RCD Tripping Time Test":
	   	     int number_of_rcdtrippingtime_measurements = fc1664_rcdtrippingtimetest_primaryreading_value.size();
	   	 
	   	     if(number_of_rcdtrippingtime_measurements!=0)
	   	     {
	   	     if(number_of_rcdtrippingtime_measurements > 1)
	   	    {
	   		   for(int i=0;i<number_of_rcdtrippingtime_measurements;i++)
	   		   {
	   			 AssertJUnit.assertTrue(!fc1664_rcdtrippingtimetest_primaryreading_value.get(i).getText().equals(""));
	   			 AssertJUnit.assertTrue(!fc1664_rcdtrippingtimetest_primaryreading_value.get(i).getText().equalsIgnoreCase("null"));
	   			 AssertJUnit.assertNotNull(fc1664_rcdtrippingtimetest_primaryreading_value.get(i).getText());
	   			 AssertJUnit.assertTrue(!fc1664_rcdtrippingtimetest_primaryreading_value.get(i).getText().equals("----"));
	   			 AssertJUnit.assertTrue(fc1664_highcurrentlooptest_primaryreading_unit.get(i).getText().equals("msec"));
	   			 AssertJUnit.assertTrue(!fc1664_rcdtrippingtimetest_secondaryreading_value.get(i).getText().equals(""));
	  			 AssertJUnit.assertTrue(!fc1664_rcdtrippingtimetest_secondaryreading_value.get(i).getText().equalsIgnoreCase("null"));
	  			 AssertJUnit.assertNotNull(fc1664_rcdtrippingtimetest_secondaryreading_value.get(i).getText());
	  			 AssertJUnit.assertTrue(!fc1664_rcdtrippingtimetest_secondaryreading_value.get(i).getText().equals("----"));
	  			 AssertJUnit.assertTrue(fc1664_rcdtrippingtimetest_secondaryreading_unit.get(i).getText().equals("V AC"));
	   			
	   		   }
	   	    }
	   	    else
	   	    {
	   	    	 AssertJUnit.assertTrue(!fc1664_rcdtrippingtimetest_primaryreading_value.get(0).getText().equals(""));
	   			 AssertJUnit.assertTrue(!fc1664_rcdtrippingtimetest_primaryreading_value.get(0).getText().equalsIgnoreCase("null"));
	   			 AssertJUnit.assertNotNull(fc1664_rcdtrippingtimetest_primaryreading_value.get(0).getText());
	   			 AssertJUnit.assertTrue(!fc1664_rcdtrippingtimetest_primaryreading_value.get(0).getText().equals("----"));
	   			 AssertJUnit.assertTrue(fc1664_highcurrentlooptest_primaryreading_unit.get(0).getText().equals("msec"));
	   			 AssertJUnit.assertTrue(!fc1664_rcdtrippingtimetest_secondaryreading_value.get(0).getText().equals(""));
	  			 AssertJUnit.assertTrue(!fc1664_rcdtrippingtimetest_secondaryreading_value.get(0).getText().equalsIgnoreCase("null"));
	  			 AssertJUnit.assertNotNull(fc1664_rcdtrippingtimetest_secondaryreading_value.get(0).getText());
	  			 AssertJUnit.assertTrue(!fc1664_rcdtrippingtimetest_secondaryreading_value.get(0).getText().equals("----"));
	  			 AssertJUnit.assertTrue(fc1664_rcdtrippingtimetest_secondaryreading_unit.get(0).getText().equals("V AC"));
	   	    }
	   	   }
	   	 break;
	   	 
	   case "RCD Tripping Current Test":
	   	     int number_of_rcdtrippingcurrent_measurements = fc1664_rcdtrippingcurrenttest_primaryreading_value.size();
	   	 
	   	     if(number_of_rcdtrippingcurrent_measurements!=0)
	   	     {
	   	     if(number_of_rcdtrippingcurrent_measurements > 1)
	   	    {
	   		   for(int i=0;i<number_of_rcdtrippingcurrent_measurements;i++)
	   		   {
	   			 AssertJUnit.assertTrue(!fc1664_rcdtrippingcurrenttest_primaryreading_value.get(i).getText().equals(""));
	   			 AssertJUnit.assertTrue(!fc1664_rcdtrippingcurrenttest_primaryreading_value.get(i).getText().equalsIgnoreCase("null"));
	   			 AssertJUnit.assertNotNull(fc1664_rcdtrippingcurrenttest_primaryreading_value.get(i).getText());
	   			 AssertJUnit.assertTrue(!fc1664_rcdtrippingcurrenttest_primaryreading_value.get(i).getText().equals("----"));
	   			 AssertJUnit.assertTrue(fc1664_rcdtrippingcurrenttest_primaryreading_unit.get(i).getText().equals("mA AC"));
	   			 AssertJUnit.assertTrue(!fc1664_rcdtrippingcurrentest_secondaryreading_value.get(i).getText().equals(""));
	  			 AssertJUnit.assertTrue(!fc1664_rcdtrippingcurrentest_secondaryreading_value.get(i).getText().equalsIgnoreCase("null"));
	  			 AssertJUnit.assertNotNull(fc1664_rcdtrippingcurrentest_secondaryreading_value.get(i).getText());
	  			 //AssertJUnit.assertTrue(!fc1664_rcdtrippingtimetest_secondaryreading_value.get(i).getText().equals("----"));
	  			 AssertJUnit.assertTrue(fc1664_rcdtrippingcurrenttest_secondaryreading_unit.get(i).getText().equals("V AC") || fc1664_rcdtrippingcurrenttest_secondaryreading_unit.get(i).getText().equals("msec"));
	   			
	   		   }
	   	    }
	   	    else
	   	    {
	   	     AssertJUnit.assertTrue(!fc1664_rcdtrippingcurrenttest_primaryreading_value.get(0).getText().equals(""));
   			 AssertJUnit.assertTrue(!fc1664_rcdtrippingcurrenttest_primaryreading_value.get(0).getText().equalsIgnoreCase("null"));
   			 AssertJUnit.assertNotNull(fc1664_rcdtrippingcurrenttest_primaryreading_value.get(0).getText());
   			 AssertJUnit.assertTrue(!fc1664_rcdtrippingcurrenttest_primaryreading_value.get(0).getText().equals("----"));
   			 AssertJUnit.assertTrue(fc1664_rcdtrippingcurrenttest_primaryreading_unit.get(0).getText().equals("mA AC"));
   			 AssertJUnit.assertTrue(!fc1664_rcdtrippingcurrentest_secondaryreading_value.get(0).getText().equals(""));
  			 AssertJUnit.assertTrue(!fc1664_rcdtrippingcurrentest_secondaryreading_value.get(0).getText().equalsIgnoreCase("null"));
  			 AssertJUnit.assertNotNull(fc1664_rcdtrippingcurrentest_secondaryreading_value.get(0).getText());
  			 //AssertJUnit.assertTrue(!fc1664_rcdtrippingtimetest_secondaryreading_value.get(i).getText().equals("----"));
  			 AssertJUnit.assertTrue(fc1664_rcdtrippingcurrenttest_secondaryreading_unit.get(0).getText().equals("V AC") || fc1664_rcdtrippingcurrenttest_secondaryreading_unit.get(0).getText().equals("msec"));
	   	    }
	   	    }
	   	 break;
	   	 
	   	 
	   case "Earth Ground Test":
	   	     int number_of_earthgroundresistance_measurements = fc1664_earthgroundresistance_primaryreading_value.size();
	   	 
	   	     if(number_of_earthgroundresistance_measurements!=0)
	   	     {
	   	     if(number_of_earthgroundresistance_measurements > 1)
	   	    {
	   		   for(int i=0;i<number_of_earthgroundresistance_measurements;i++)
	   		   {
	   			 AssertJUnit.assertTrue(!fc1664_earthgroundresistance_primaryreading_value.get(i).getText().equals(""));
	   			 AssertJUnit.assertTrue(!fc1664_earthgroundresistance_primaryreading_value.get(i).getText().equalsIgnoreCase("null"));
	   			 AssertJUnit.assertNotNull(fc1664_earthgroundresistance_primaryreading_value.get(i).getText());
	   			 AssertJUnit.assertTrue(!fc1664_earthgroundresistance_primaryreading_value.get(i).getText().equals("----"));
	   			 AssertJUnit.assertTrue(fc1664_earthgroundresistance_primaryreading_unit.get(i).getText().equals("Ω"));
	   		 }
	   	    }
	   	    else
	   	    {
	   	    	 AssertJUnit.assertTrue(!fc1664_earthgroundresistance_primaryreading_value.get(0).getText().equals(""));
	   			 AssertJUnit.assertTrue(!fc1664_earthgroundresistance_primaryreading_value.get(0).getText().equalsIgnoreCase("null"));
	   			 AssertJUnit.assertNotNull(fc1664_earthgroundresistance_primaryreading_value.get(0).getText());
	   			 AssertJUnit.assertTrue(!fc1664_earthgroundresistance_primaryreading_value.get(0).getText().equals("----"));
	   			 AssertJUnit.assertTrue(fc1664_earthgroundresistance_primaryreading_unit.get(0).getText().equals("Ω"));
	   	    }
	   	     }
	   	 break;
	   	 
	   case "Phase Sequence Test":
	   	     int number_of_phasesequence_measurements = fc1664_phasesequencetest_primaryreading_value.size();
	   	 
	   	     if(number_of_phasesequence_measurements!=0)
	   	     {
	   	     if(number_of_phasesequence_measurements > 1)
	   	    {
	   		   for(int i=0;i<number_of_phasesequence_measurements;i++)
	   		   {
	   			  AssertJUnit.assertTrue(!fc1664_phasesequencetest_primaryreading_value.get(i).getText().equals(""));
	   			  AssertJUnit.assertTrue(!fc1664_phasesequencetest_primaryreading_value.get(i).getText().equalsIgnoreCase("null"));
	   			  AssertJUnit.assertNotNull(fc1664_phasesequencetest_primaryreading_value.get(i).getText());
	   			  AssertJUnit.assertTrue(fc1664_phasesequencetest_primaryreading_value.get(i).getText().equals("123") || fc1664_phasesequencetest_primaryreading_value.get(i).getText().equals("321"));
	   			 //AssertJUnit.assertTrue(!fc1664_earthgroundresistance_primaryreading_value.get(i).getText().equals("----"));
	   			 //AssertJUnit.assertTrue(fc1664_earthgroundresistance_primaryreading_unit.get(i).getText().equals("Ω"));
	   		 }
	   	    }
	   	    else
	   	    {
	   	    	 AssertJUnit.assertTrue(!fc1664_phasesequencetest_primaryreading_value.get(0).getText().equals(""));
	   			 AssertJUnit.assertTrue(!fc1664_phasesequencetest_primaryreading_value.get(0).getText().equalsIgnoreCase("null"));
	   			 AssertJUnit.assertNotNull(fc1664_phasesequencetest_primaryreading_value.get(0).getText());
	   			 AssertJUnit.assertTrue(fc1664_phasesequencetest_primaryreading_value.get(0).getText().equals("123") || fc1664_phasesequencetest_primaryreading_value.get(0).getText().equals("321"));
	   	    }
	   	    }
	   	 break;
	   	 
	   	 
	}
	}	
	
	public void verifyAutoTestInMeasurementsListPage()
	{
		int no_of_auto_test_measurements = fc1664_autotests.size();
		
		if(no_of_auto_test_measurements!=0)
		{
		for(int i=0;i<no_of_auto_test_measurements;i++)
		{
			Assert.assertTrue(fc1664_autotests.get(i).getText().equals("Auto Test"));
			
		   List<WebElement> autotestmeasurements = DriverManager.getDriver().findElements(By.xpath("//*[contains(@class,'hudsonAutoTest')]/../..)["+i+1+"]//div[@class='autoTestValue']"));
		   
		   for(WebElement autotestmeasurement:autotestmeasurements)
		   {
			   autotesttypes.add(autotestmeasurement.getText());
		   }
			
		
		}
		
		for(int i=0;i<autotesttypes.size();i++)
		{
			Assert.assertTrue(autotesttypes.get(i).contains("No Trip Loop Test") || autotesttypes.get(i).contains("RCD Tripping Time Test") || autotesttypes.get(i).contains("RCD Tripping Time Test(Auto)") || autotesttypes.get(i).contains("Insulation Test (L-N)") || autotesttypes.get(i).contains("Insulation Test (L-PE)") || autotesttypes.get(i).contains("Insulation Test (N-PE)"));
		}
		
		}		
	}
	
	
	public void verifyRCDTrippingTimeAutoTestInMeasurementsListPage()
	{
		int no_of_rcd_tripping_time_auto_tests = fc1664_rcdtrippingtime_autotests.size();
		
		
		if(no_of_rcd_tripping_time_auto_tests > 1)
		{
		 for(int i=0;i<no_of_rcd_tripping_time_auto_tests;i++)
		 {
			 int no_of_rcd_tripping_time_auto_tests_primary_value = fc1664_rcdtrippingtime_autotests_configurations_primaryValue.size();
				
				for(int j=0;j<no_of_rcd_tripping_time_auto_tests_primary_value;j++)
				{
					Assert.assertTrue(fc1664_rcdtrippingtime_autotests_configurations_primaryValue.get(j).getText().equals("1/2x") || fc1664_rcdtrippingtime_autotests_configurations_primaryValue.get(j).getText().equals("1/2x") || fc1664_rcdtrippingtime_autotests_configurations_primaryValue.get(j).getText().equals("1/2x") || fc1664_rcdtrippingtime_autotests_configurations_primaryValue.get(j).getText().equals("1x") || fc1664_rcdtrippingtime_autotests_configurations_primaryValue.get(j).getText().equals("1/2x") || fc1664_rcdtrippingtime_autotests_configurations_primaryValue.get(j).getText().equals("5x"));
					Assert.assertTrue(fc1664_rcdtrippingtime_autotests_configurations_secondaryValue.get(j).getText().equals("0°") || fc1664_rcdtrippingtime_autotests_configurations_secondaryValue.get(j).getText().equals("180°"));
				}
		 }
		}
		else
		{
			int no_of_rcd_tripping_time_auto_tests_primary_value = fc1664_rcdtrippingtime_autotests_configurations_primaryValue.size();
			
			for(int j=0;j<no_of_rcd_tripping_time_auto_tests_primary_value;j++)
			{
				Assert.assertTrue(fc1664_rcdtrippingtime_autotests_configurations_primaryValue.get(j).getText().equals("1/2x") || fc1664_rcdtrippingtime_autotests_configurations_primaryValue.get(j).getText().equals("1/2x") || fc1664_rcdtrippingtime_autotests_configurations_primaryValue.get(j).getText().equals("1/2x") || fc1664_rcdtrippingtime_autotests_configurations_primaryValue.get(j).getText().equals("1x") || fc1664_rcdtrippingtime_autotests_configurations_primaryValue.get(j).getText().equals("1/2x") || fc1664_rcdtrippingtime_autotests_configurations_primaryValue.get(j).getText().equals("5x"));
				Assert.assertTrue(fc1664_rcdtrippingtime_autotests_configurations_secondaryValue.get(j).getText().equals("0°") || fc1664_rcdtrippingtime_autotests_configurations_secondaryValue.get(j).getText().equals("180°"));
			}
		}
		
	}
	
	public void clickMeasurement(String measurementtype)
	{
		
		measurementspage.loadallmeasurements();
		
		switch(measurementtype)
		{
		    case "Voltage":
		    	fc1664_voltageTests.get(0).click();
		    	break;
		    
		    case "Insulation":
		    	fc1664_insulationTests.get(0).click();
		    	break;
		    	
		    case "Continuity":
		    	if(fc1664_continuityTests.size()!=0)
		    	fc1664_continuityTests.get(0).click();
		    	break;
		    
		    case "No Trip Loop Test":
		    	if(fc1664_notriploopTests.size()!=0)
		    	fc1664_notriploopTests.get(0).click();
		    	break;
		    	
		    case "High-Loop Current Test":
		    	if(fc1664_highloopcurrentTests.size()!=0)
		    	fc1664_highloopcurrentTests.get(0).click();
		    	break;
		    	
		    case "RCD Tripping Time Test":
		    	if(fc1664_rcdtrippingtimeTests.size()!=0)
		    	fc1664_rcdtrippingtimeTests.get(0).click();
		    	
		    case "RCD Tripping Current Test":
		    	if(fc1664_rcdtrippingcurrentTests.size()!=0)
		    	fc1664_rcdtrippingcurrentTests.get(0).click();
		    	
		    case "Earth Ground Test":
		    	if(fc1664_earthgroundTests.size()!=0)
		    	fc1664_earthgroundTests.get(0).click();
		    	
		    case "Phase Sequence Test":
		    	if(fc1664_phasesequencemeasurement.size()!=0)
		    	fc1664_phasesequencemeasurement.get(0).click();
		    	
		    case "Downloaded":
		    	fc1664_downloadedlist.get(0).click();
		    	
		 }
		
		CommonUtils.wait(15);
	}
	
	public void backtoMeasurementsPage()
	{
		if(ElementUtils.isDisplayed(backbutton))
		backbutton.click();
	}
}
