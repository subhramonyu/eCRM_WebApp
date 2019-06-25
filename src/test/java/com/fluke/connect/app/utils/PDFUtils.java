package com.fluke.connect.app.utils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.pdmodel.graphics.PDXObject;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.text.PDFTextStripper;

public class PDFUtils 
{
	private static PDDocument pdfDocument;

	public static String getText(File pdfFile) throws IOException 
	{
	    pdfDocument = PDDocument.load(pdfFile);
	    return new PDFTextStripper().getText(pdfDocument);
	}

	public static String getText(String inputStreamSource) throws IOException 
	{
		pdfDocument = PDDocument.load(new URL(inputStreamSource).openStream());
	    return new PDFTextStripper().getText(pdfDocument);
	}

	public static void getImages(File pdfFile, String pathToSaveImages) throws Exception 
	{
		pdfDocument = PDDocument.load(pdfFile);
	    PDFUtils.getImages(pathToSaveImages);
	}

	public static void getImages(String inputStreamSource, String pathToSaveImages) throws Exception 
	{
		pdfDocument = PDDocument.load(new URL(inputStreamSource).openStream());
		PDFUtils.getImages(pathToSaveImages);
	}

	public static void getImages(String pathToSaveImages) throws IOException
	{
		int imageCountIterator = 0;
		PDPageTree list = pdfDocument.getPages();
	    for (PDPage pdPage : list) 
	    {
	        PDResources pdResources = pdPage.getResources();
	        for (COSName cosName : pdResources.getXObjectNames()) 
	        {
	            PDXObject pdxObject = pdResources.getXObject(cosName);
	            if (pdxObject instanceof PDImageXObject)
	            {
	               File file = new File(pathToSaveImages+ imageCountIterator + ".png");
	               ImageIO.write(((PDImageXObject)pdxObject).getImage(), "png", file);
	               imageCountIterator++;
	            }
	        }
	    }
	}
	
	public static int getPageCount(File pdfFile) throws InvalidPasswordException, IOException
	{
		return PDDocument.load(pdfFile).getPages().getCount();
	}
	
	public static int getPageCount(String inputStreamSource) throws InvalidPasswordException, IOException
	{
		return PDDocument.load(new URL(inputStreamSource).openStream()).getPages().getCount();
	}
	
	public static boolean visuallyCompareFiles(File pdfFile1, File pdfFile2, String pathToSaveDeviatedImages) throws InvalidPasswordException, IOException
	{
		boolean returnFlag = false;
		PDFRenderer pdfRenderFile1 = new PDFRenderer(PDDocument.load(pdfFile1));
		PDFRenderer pdfRenderFile2 = new PDFRenderer(PDDocument.load(pdfFile2));
        if(getPageCount(pdfFile1) != getPageCount(pdfFile2))
        {
        	   return false;
        }
        for(int i = 0; i < getPageCount(pdfFile2); i++)
        {
        		returnFlag = VisualUtils.compareImages(pdfRenderFile1.renderImage(i), pdfRenderFile2.renderImage(i), pathToSaveDeviatedImages+i+".png");
        		if(!returnFlag)
        		{
        			return returnFlag;
        		}
        }
		return returnFlag;
	}
	
	public static boolean visuallyCompareFiles(File pdfFile1, String inputStreamSource, String pathToSaveDeviatedImages) throws InvalidPasswordException, IOException
	{
		boolean returnFlag = false;
		PDFRenderer pdfRenderFile1 = new PDFRenderer(PDDocument.load(pdfFile1));
		PDFRenderer pdfRenderFile2 = new PDFRenderer(PDDocument.load(new URL(inputStreamSource).openStream()));
        if(getPageCount(pdfFile1) != getPageCount(inputStreamSource))
        {
        	   return false;
        }
        for(int i = 0; i < getPageCount(inputStreamSource); i++)
        {
        		returnFlag = VisualUtils.compareImages(pdfRenderFile1.renderImage(i), pdfRenderFile2.renderImage(i), pathToSaveDeviatedImages+i+".png");
        		if(!returnFlag)
        		{
        			return returnFlag;
        		}
        }
		return returnFlag;
	}
	
	public static boolean compareText(File pdfFile1, String inputStreamSource) throws IOException
	{
		return getText(pdfFile1).equals(getText(inputStreamSource));
	}
	
	public static boolean compareImages(File pdfFile1, String directoryPathToSaveExpectedImages, String inputStreamSource, String directoryPathToSaveActualImages, String directoryPathToSaveDeviatedImages) throws Exception
	{
		boolean returnFlag = false;
		FileUtils.cleanDirectory(new File(directoryPathToSaveExpectedImages));
		FileUtils.cleanDirectory(new File(directoryPathToSaveActualImages));
		FileUtils.cleanDirectory(new File(directoryPathToSaveDeviatedImages));
		getImages(pdfFile1, directoryPathToSaveExpectedImages+"img");
		getImages(inputStreamSource, directoryPathToSaveActualImages+"img");
		File[] expectedImageFiles = new File(directoryPathToSaveExpectedImages).listFiles();
		File[] actualImageFiles = new File(directoryPathToSaveActualImages).listFiles();
		if(expectedImageFiles.length != actualImageFiles.length)
		{
			return false;
		}
		for(int i = 0; i < expectedImageFiles.length; i++)
		{
			returnFlag = VisualUtils.compareVisuals(expectedImageFiles[i].getPath(), actualImageFiles[i].getPath(), directoryPathToSaveDeviatedImages+expectedImageFiles[i].getName());
			if(!returnFlag)
			{
				return returnFlag;
			}
		}
		return returnFlag;
	}

}
