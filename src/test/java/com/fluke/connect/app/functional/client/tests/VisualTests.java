package com.fluke.connect.app.functional.client.tests;
 
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.testng.Assert;
import org.testng.annotations.Test;
//import com.connect.fluke.app.utils.OCRUtils;

import com.lyncode.xliff.XLIFF;
import com.lyncode.xliff.XLiffUtils;
import com.lyncode.xliff.XliffException;

public class VisualTests 
{
	
	
	@Test(groups = {"xliff"})
	public void workOrderHomeScreenVisualTest() throws FileNotFoundException, XliffException
	{
		/*System.out.println(new OCRUtils().getOCRData("./sikuli_images/img2.jpg"));
			System.out.println("*********************************************************");
			System.out.println(new OCRUtils().getOCRData("./sikuli_images/img3.jpg"));
			System.out.println("*********************************************************");
			System.out.println(new OCRUtils().getOCRData("./sikuli_images/img4.jpg"));
			System.out.println("*********************************************************");
			System.out.println(new OCRUtils().getOCRData("./sikuli_images/img5.jpg"));
			*/
			
			
			 InputStream is = new FileInputStream("./localization/de1.xliff");
			    XLIFF x = XLiffUtils.read(is);
			    System.out.println(x.getTarget("Label"));
		
	}
	
	
}


