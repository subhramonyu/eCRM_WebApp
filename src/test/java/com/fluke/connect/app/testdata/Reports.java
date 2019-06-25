package com.fluke.connect.app.testdata;

import com.fluke.connect.app.utils.CommonUtils;

public class Reports 
{
	
	public enum ReportsOptions{
		FILTER_ALL, FILTER_MY_REPORTS, SORT_BY_DATE, SORT_CREATED_BY
	}
	
	public enum ReportsAttribute
	{
		BASIC_REPORT_TITLE("BASIC TITLE - BIG_MOTORS_DEMO_REPORT"),
		BASIC_REPORT_SUBTITLE("BASIC SUBTITLE: Session 5.1, 6.3 & 8 MEASUREMENTS!"),
		BASIC_REPORT_ADDITIONAL_INFORMATION("BASIC ADDITIONAL INFORMATION: MEASUREMENTS THEIR VALUES & CORRESPONDING IMAGES"),
		BASIC_REPORT_COMPANY_INFORMATION("BASIC COMPANY INFORMATION: TEST AND MEASUREMENT COMPANY, 6920 Seaway Blvd Everett, WA USA 98203"),
		BASIC_REPORT_COMPANY_NAME("BASIC COMPANY NAME: FLUKE INC."),
		
		BASIC_EDIT_REPORT_TITLE("BASIC EDIT TITLE - BIG_MOTORS_DEMO_REPORT"),
		BASIC_EDIT_REPORT_SUBTITLE("BASIC EDIT SUBTITLE: Session 5.1, 6.3 & 8 MEASUREMENTS!"),
		BASIC_EDIT_REPORT_ADDITIONAL_INFORMATION("BASIC EDIT ADDITIONAL INFORMATION: MEASUREMENTS THEIR VALUES & CORRESPONDING IMAGES"),
		BASIC_EDIT_REPORT_COMPANY_INFORMATION("BASIC EDIT COMPANY INFORMATION: TEST AND MEASUREMENT COMPANY, 6920 Seaway Blvd Everett, WA USA 98203"),
		BASIC_EDIT_REPORT_COMPANY_NAME("BASIC EDIT COMPANY NAME: FLUKE INC."),
		
		THERMAL_REPORT_TITLE("THERMAL TITLE"),
		THERMAL_REPORT_SUBTITLE("THERMAL SUBTITLE"),
		THERMAL_REPORT_ADDITIONAL_INFORMATION("THERMAL ADDITIONAL INFORMATION: MEASUREMENTS THEIR VALUES & CORRESPONDING IMAGES"),
		THERMAL_REPORT_COMPANY_INFORMATION("THERMAL COMPANY INFORMATION: TEST AND MEASUREMENT COMPANY, 6920 Seaway Blvd Everett, WA USA 98203"),
		THERMAL_REPORT_COMPANY_NAME("THERMAL COMPANY NAME: FLUKE INC."),
		
		THERMAL_EDIT_REPORT_TITLE("THERMAL EDIT TITLE"),
		THERMAL_EDIT_REPORT_SUBTITLE("THERMAL EDIT SUBTITLE"),
		THERMAL_EDIT_REPORT_ADDITIONAL_INFORMATION("THERMAL EDIT ADDITIONAL INFORMATION: MEASUREMENTS THEIR VALUES & CORRESPONDING IMAGES"),
		THERMAL_EDIT_REPORT_COMPANY_INFORMATION("THERMAL EDIT COMPANY INFORMATION: TEST AND MEASUREMENT COMPANY, 6920 Seaway Blvd Everett, WA USA 98203"),
		THERMAL_EDIT_REPORT_COMPANY_NAME("THERMAL EDIT COMPANY NAME: FLUKE INC."),
		
		ASSET_REPORT_TITLE("ASSET TITLE"),  // - BIG_MOTORS_DEMO_REPORT"),
		ASSET_REPORT_SUBTITLE("ASSET SUBTITLE"), //: Session 5.1, 6.3 & 8 MEASUREMENTS!"),
		ASSET_REPORT_ADDITIONAL_INFORMATION("ASSET ADDITIONAL"),  // INFORMATION: EXPORTED ASSETS HAVING MEASUREMENTS & CORRESPONDING IMAGES"),
		ASSET_REPORT_COMPANY_INFORMATION("ASSET COMPANY"), // INFORMATION: TEST AND MEASUREMENT COMPANY, 6920 Seaway Blvd Everett, WA USA 98203"),
		ASSET_REPORT_COMPANY_NAME("ASSET COMPANY NAME"),  //: FLUKE INC."),
		ASSET_REPORT_HEADER_LOGO(CommonUtils.getUserHomeDirectoryPath() + "/UAF/images/logo.jpg"),
		ASSET_REPORT_NORMAL_LOGO(CommonUtils.getUserHomeDirectoryPath() + "/UAF/images/logo.jpg"),
		ASSET_REPORT_CUSTOM_HEADER("ASSET HEADER: Fluke INC."),
		ASSET_REPORT_CUSTOM_FOOTER("ASSET FOOTER: Fluke INC."),
		
		EXISTING_ASSET_REPORT_TITLE("EXISTING ASSET TITLE - BIG_MOTORS_DEMO_REPORT"),
		EXISTING_ASSET_REPORT_SUBTITLE("EXISTING ASSET SUBTITLE: Session 5.1, 6.3 & 8 MEASUREMENTS!"),
		EXISTING_ASSET_REPORT_ADDITIONAL_INFORMATION("EXISTING ASSET ADDITIONAL INFORMATION: EXPORTED ASSETS HAVING MEASUREMENTS & CORRESPONDING IMAGES"),
		EXISTING_ASSET_REPORT_COMPANY_INFORMATION("EXISTING ASSET COMPANY INFORMATION: TEST AND MEASUREMENT COMPANY, 6920 Seaway Blvd Everett, WA USA 98203"),
		EXISTING_ASSET_REPORT_COMPANY_NAME("EXISTING ASSET COMPANY NAME: FLUKE INC."),
		EXISTING_ASSET_REPORT_HEADER_LOGO(CommonUtils.getUserHomeDirectoryPath() + "/UAF/images/logo.jpg"),
		EXISTING_ASSET_REPORT_NORMAL_LOGO(CommonUtils.getUserHomeDirectoryPath() + "/UAF/images/logo.jpg"),
		EXISTING_ASSET_REPORT_CUSTOM_HEADER("EXISTING ASSET HEADER: Fluke INC."),
		EXISTING_ASSET_REPORT_CUSTOM_FOOTER("EXISTING ASSET FOOTER: Fluke INC."),
		
		ASSET_EDIT_REPORT_TITLE("ASSET EDIT TITLE"),  // - BIG_MOTORS_DEMO_REPORT"),
		ASSET_EDIT_REPORT_SUBTITLE("ASSET EDIT SUBTITLE"),  //: Session 5.1, 6.3 & 8 MEASUREMENTS!"),
		ASSET_EDIT_REPORT_ADDITIONAL_INFORMATION("ASSET EDIT ADDITIONAL"),  // INFORMATION: EXPORTED ASSETS HAVING MEASUREMENTS & CORRESPONDING IMAGES"),
		ASSET_EDIT_REPORT_COMPANY_INFORMATION("ASSET EDIT COMP"),  // INFORMATION: TEST AND MEASUREMENT COMPANY, 6920 Seaway Blvd Everett, WA USA 98203"),
		ASSET_EDIT_REPORT_COMPANY_NAME("ASSET EDIT NAME"), // COMPANY NAME: FLUKE INC."),
		
		BASIC_REPORT("Basic Report"),
		THERMAL_REPORT("Thermal Image Report"),
		THERMAL_REPORT_ANDROID("Thermal Report"),
		ASSET_REPORT("Asset Report"),
		
		REPORTS_SEARCH_KEYWORD("Admin"),
		
		REPORTS_FILTER("Filter"),
		REPORTS_SORT("Sort"),
		
		ASSET_REPORT_CONTENT_PREPROD("Web ASSET COMPANY\n" + 
				"Web ASSET COMPANY NAME\n" + 
				"Web ASSET ADDITIONAL\n" + 
				"Web ASSET SUBTITLE\n" + 
				"Date\n" + 
				"Asset Report\n" + 
				"Asset Name Motor\n" + 
				"Asset Organization Ungrouped Assets\n" + 
				"Asset Type Motor\n" + 
				"Asset Status Normal\n" + 
				"Work Order No WorkOrders\n" + 
				"Measurement\n" + 
				"Reading Timestamp Value Unit\n" + 
				"1 25-05-2018 18:05:00 112.04 °F\n" + 
				"2 08-08-2018 18:08:00 97.44 °F\n" + 
				"3 08-08-2018 18:08:00 105.36 °F\n" + 
				"IR_00133.IS2\n" + 
				"25-05-2018 18:05:00\n" + 
				"112.04\n" + 
				"Min Avg Max Unit\n" + 
				"°F\n" + 
				"IR_00141.IS2\n" + 
				"08-08-2018 18:08:00\n" + 
				"97.44\n" + 
				"Min Avg Max Unit\n" + 
				"°F\n" + 
				"IR_00152.IS2\n" + 
				"08-08-2018 18:08:00\n" + 
				"105.36\n" + 
				"Min Avg Max Unit\n" + 
				"°F\n" + 
				"Reading Timestamp Value Unit\n" + 
				"1 25-05-2018 18:05:431 5.3 A AC\n" + 
				"2 08-08-2018 18:08:431 5.6 A AC\n" + 
				"3 07-10-2018 18:10:431 7.3 A AC"),
		
		ASSET_EDIT_REPORT_CONTENT_PREPROD("Web ASSET EDIT COMP\n" + 
				"Web ASSET EDIT NAME\n" + 
				"Web ASSET EDIT ADDITIONAL\n" + 
				"Web ASSET EDIT SUBTITLE\n" + 
				"Date\n" + 
				"Asset Report\n" + 
				"Asset Name Motor\n" + 
				"Asset Organization Ungrouped Assets\n" + 
				"Asset Type Motor\n" + 
				"Asset Status Normal\n" + 
				"Work Order No WorkOrders\n" + 
				"Measurement\n" + 
				"Reading Timestamp Value Unit\n" + 
				"1 25-05-2018 18:05:00 112.04 °F\n" + 
				"2 08-08-2018 18:08:00 97.44 °F\n" + 
				"3 08-08-2018 18:08:00 105.36 °F\n" + 
				"IR_00133.IS2\n" + 
				"25-05-2018 18:05:00\n" + 
				"112.04\n" + 
				"Min Avg Max Unit\n" + 
				"°F\n" + 
				"IR_00141.IS2\n" + 
				"08-08-2018 18:08:00\n" + 
				"97.44\n" + 
				"Min Avg Max Unit\n" + 
				"°F\n" + 
				"IR_00152.IS2\n" + 
				"08-08-2018 18:08:00\n" + 
				"105.36\n" + 
				"Min Avg Max Unit\n" + 
				"°F\n" + 
				"Reading Timestamp Value Unit\n" + 
				"1 25-05-2018 18:05:431 5.3 A AC\n" + 
				"2 08-08-2018 18:08:431 5.6 A AC\n" + 
				"3 07-10-2018 18:10:431 7.3 A AC\n" + 
				"Asset Name Distribution Panel\n" + 
				"Asset Organization Ungrouped Assets\n" + 
				"Asset Type Electrical Panel\n" + 
				"Asset Status Normal\n" + 
				"Work Order No WorkOrders\n" + 
				"Measurement\n" + 
				"Reading Timestamp Value Unit\n" + 
				"1 25-07-2018 18:07:00 111.0 °F\n" + 
				"2 25-09-2018 18:09:00 193.99 °F\n" + 
				"IR_00129.IS2\n" + 
				"25-07-2018 18:07:00\n" + 
				"111.0\n" + 
				"Min Avg Max Unit\n" + 
				"°F\n" + 
				"IR_00123.IS2\n" + 
				"25-09-2018 18:09:00\n" + 
				"193.99\n" + 
				"Min Avg Max Unit\n" + 
				"°F\n" + 
				"Test Point Name L2\n" + 
				"Test Point Distribution Panel > L2\n" + 
				"Work Order No WorkOrders\n" + 
				"Asset Organisation Ungrouped Assets\n" + 
				"No image\n" + 
				"Measurement\n" + 
				"No measurements Assigned.\n" + 
				"Test Point Name L3\n" + 
				"Test Point Distribution Panel > L3\n" + 
				"Work Order No WorkOrders\n" + 
				"Asset Organisation Ungrouped Assets\n" + 
				"No image\n" + 
				"Measurement\n" + 
				"No measurements Assigned.\n" + 
				"Test Point Name L1\n" + 
				"Test Point Distribution Panel > L1\n" + 
				"Work Order No WorkOrders\n" + 
				"Asset Organisation Ungrouped Assets\n" + 
				"No image\n" + 
				"Measurement\n" + 
				"No measurements Assigned."),
		
		ASSET_REPORT_CONTENT("Asset Report\n" + 
				"Asset Name Distribution Panel\n" + 
				"Asset Organization Ungrouped Assets\n" + 
				"Asset Type Electrical Panel\n" + 
				"Asset Status Normal\n" + 
				"Work Order No WorkOrders\n" + 
				"Measurement\n" + 
				"Reading Timestamp Value Unit\n" + 
				"1 24-07-2018 15:07:00 111.0 °F\n" + 
				"2 24-09-2018 15:09:00 193.99 °F\n" + 
				"IR_00129.IS2\n" + 
				"24-07-2018 15:07:00\n" + 
				"111.0\n" + 
				"Min Avg Max Unit\n" + 
				"°F\n" + 
				"IR_00123.IS2\n" + 
				"24-09-2018 15:09:00\n" + 
				"193.99\n" + 
				"Min Avg Max Unit\n" + 
				"°F\n" + 
				"Test Point Name L2\n" + 
				"Test Point Distribution Panel > L2\n" + 
				"Work Order No WorkOrders\n" + 
				"Asset Organisation Ungrouped Assets\n" + 
				"No image\n" + 
				"Measurement\n" + 
				"No measurements Assigned.\n" + 
				"Test Point Name L3\n" + 
				"Test Point Distribution Panel > L3\n" + 
				"Work Order No WorkOrders\n" + 
				"Asset Organisation Ungrouped Assets\n" + 
				"No image\n" + 
				"Measurement\n" + 
				"No measurements Assigned.\n" + 
				"Test Point Name L1\n" + 
				"Test Point Distribution Panel > L1\n" + 
				"Work Order No WorkOrders\n" + 
				"Asset Organisation Ungrouped Assets\n" + 
				"No image\n" + 
				"Measurement\n" + 
				"No measurements Assigned."),
		
		ASSET_EDIT_REPORT_CONTENT("Asset Report\n" + 
				"Asset Name Distribution Panel\n" + 
				"Asset Organization Ungrouped Assets\n" + 
				"Asset Type Electrical Panel\n" + 
				"Asset Status Normal\n" + 
				"Work Order No WorkOrders\n" + 
				"Measurement\n" + 
				"Reading Timestamp Value Unit\n" + 
				"1 24-07-2018 15:07:00 111.0 °F\n" + 
				"2 24-09-2018 15:09:00 193.99 °F\n" + 
				"IR_00129.IS2\n" + 
				"24-07-2018 15:07:00\n" + 
				"111.0\n" + 
				"Min Avg Max Unit\n" + 
				"°F\n" + 
				"IR_00123.IS2\n" + 
				"24-09-2018 15:09:00\n" + 
				"193.99\n" + 
				"Min Avg Max Unit\n" + 
				"°F\n" + 
				"Test Point Name L2\n" + 
				"Test Point Distribution Panel > L2\n" + 
				"Work Order No WorkOrders\n" + 
				"Asset Organisation Ungrouped Assets\n" + 
				"No image\n" + 
				"Measurement\n" + 
				"No measurements Assigned.\n" + 
				"Test Point Name L3\n" + 
				"Test Point Distribution Panel > L3\n" + 
				"Work Order No WorkOrders\n" + 
				"Asset Organisation Ungrouped Assets\n" + 
				"No image\n" + 
				"Measurement\n" + 
				"No measurements Assigned.\n" + 
				"Test Point Name L1\n" + 
				"Test Point Distribution Panel > L1\n" + 
				"Work Order No WorkOrders\n" + 
				"Asset Organisation Ungrouped Assets\n" + 
				"No image\n" + 
				"Measurement\n" + 
				"No measurements Assigned.\n" + 
				"Asset Name Motor\n" + 
				"Asset Organization Ungrouped Assets\n" + 
				"Asset Type Motor\n" + 
				"Asset Status Normal\n" + 
				"Work Order No WorkOrders\n" + 
				"Measurement\n" + 
				"Reading Timestamp Value Unit\n" + 
				"1 24-05-2018 15:05:00 112.04 °F\n" + 
				"2 07-08-2018 15:08:00 97.44 °F\n" + 
				"3 07-08-2018 15:08:00 105.36 °F\n" + 
				"IR_00133.IS2\n" + 
				"24-05-2018 15:05:00\n" + 
				"112.04\n" + 
				"Min Avg Max Unit\n" + 
				"°F\n" + 
				"IR_00141.IS2\n" + 
				"07-08-2018 15:08:00\n" + 
				"97.44\n" + 
				"Min Avg Max Unit\n" + 
				"°F\n" + 
				"IR_00152.IS2\n" + 
				"07-08-2018 15:08:00\n" + 
				"105.36\n" + 
				"Min Avg Max Unit\n" + 
				"°F\n" + 
				"Reading Timestamp Value Unit\n" + 
				"1 24-05-2018 15:05:352 5.3 A AC\n" + 
				"2 07-08-2018 15:08:352 5.6 A AC\n" + 
				"3 06-10-2018 15:10:352 7.3 A AC"),
		
		EXISTING_ASSET_REPORT_CONTENT("EXISTING ASSET HEADER: Fluke INC.\n" + 
				"EXISTING ASSET TITLE -\n" + 
				"11/24/2018\n" + 
				"EXISTING ASSET\n" + 
				"EXISTING ASSET COMPANY\n" + 
				"EXISTING ASSET ADDITIONAL\n" + 
				"EXISTING ASSET SUBTITLE: Session 5.1, 6.3 & 8\n" + 
				"Date\n" + 
				"EXISTING ASSET HEADER: Fluke INC.\n" + 
				"Asset Report\n" +
				"Asset Name Distribution Panel\n" + 
				"Asset Organization Ungrouped Assets\n" + 
				"Asset Type Electrical Panel\n" + 
				"Asset Status Normal\n" + 
				"Work Order No WorkOrders\n" + 
				"Measurement\n" + 
				"Reading Timestamp Value Unit\n" + 
				"1 24-07-2018 15:07:00 111.0 °F\n" + 
				"2 24-09-2018 15:09:00 193.99 °F\n" + 
				"Reptests@yopmail.com null\n" + 
				"EXISTING ASSET HEADER: Fluke INC.\n" + 
				"IR_00129.IS2\n" + 
				"24-07-2018 15:07:00\n" + 
				"111.0\n" + 
				"Min Avg Max Unit\n" + 
				"°F\n" + 
				"IR_00123.IS2\n" + 
				"24-09-2018 15:09:00\n" + 
				"193.99\n" + 
				"Min Avg Max Unit\n" + 
				"°F\n" + 
				"Reptests@yopmail.com null\n" + 
				"EXISTING ASSET HEADER: Fluke INC.\n" + 
				"Test Point Name L2\n" + 
				"Test Point Distribution Panel > L2\n" + 
				"Work Order No WorkOrders\n" + 
				"Asset Organisation Ungrouped Assets\n" + 
				"No image\n" + 
				"Measurement\n" + 
				"No measurements Assigned.\n" + 
				"Test Point Name L3\n" + 
				"Test Point Distribution Panel > L3\n" + 
				"Work Order No WorkOrders\n" + 
				"Asset Organisation Ungrouped Assets\n" + 
				"No image\n" + 
				"Measurement\n" + 
				"No measurements Assigned.\n" + 
				"Reptests@yopmail.com null\n" + 
				"EXISTING ASSET HEADER: Fluke INC.\n" + 
				"Test Point Name L1\n" + 
				"Test Point Distribution Panel > L1\n" + 
				"Work Order No WorkOrders\n" + 
				"Asset Organisation Ungrouped Assets\n" + 
				"No image\n" + 
				"Measurement\n" + 
				"No measurements Assigned.\n" + 
				"Asset Name Motor\n" + 
				"Asset Organization Ungrouped Assets\n" + 
				"Asset Type Motor\n" + 
				"Asset Status Normal\n" + 
				"Work Order No WorkOrders\n" + 
				"Measurement\n" + 
				"Reptests@yopmail.com null\n" + 
				"EXISTING ASSET HEADER: Fluke INC.\n" + 
				"Reading Timestamp Value Unit\n" + 
				"1 24-05-2018 15:05:00 112.04 °F\n" + 
				"2 07-08-2018 15:08:00 97.44 °F\n" + 
				"3 07-08-2018 15:08:00 105.36 °F\n" + 
				"IR_00133.IS2\n" + 
				"24-05-2018 15:05:00\n" + 
				"112.04\n" + 
				"Min Avg Max Unit\n" + 
				"°F\n" + 
				"Reptests@yopmail.com null\n" + 
				"EXISTING ASSET HEADER: Fluke INC.\n" + 
				"IR_00141.IS2\n" + 
				"07-08-2018 15:08:00\n" + 
				"97.44\n" + 
				"Min Avg Max Unit\n" + 
				"°F\n" + 
				"IR_00152.IS2\n" + 
				"07-08-2018 15:08:00\n" + 
				"105.36\n" + 
				"Min Avg Max Unit\n" + 
				"°F\n" + 
				"Reptests@yopmail.com null\n" + 
				"EXISTING ASSET HEADER: Fluke INC.\n" + 
				"Reading Timestamp Value Unit\n" + 
				"1 24-05-2018 15:05:352 5.3 A AC\n" + 
				"2 07-08-2018 15:08:352 5.6 A AC\n" + 
				"3 06-10-2018 15:10:352 7.3 A AC\n" + 
				"Reptests@yopmail.com null\n" + 
				"EXISTING ASSET HEADER: Fluke INC.\n" + 
				"Reptests@yopmail.com null");
		
		private String attributeValue;

	    ReportsAttribute(String attributeValue) 
	    {
	        this.attributeValue = attributeValue;
	    }

	    public String getAttributeValue() 
	    {
	        return attributeValue;
	    }
	}

}
