package com.eCRM.client.core;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.FileBasedConfiguration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;

public class FileUtil 
{
	private static Properties properties = new Properties();
	private static OutputStream outputStream;
	private static InputStream inputStream;
	private static File file;
	private static FileWriter fileWriter;
	private static BufferedWriter bufferedWriter;
	private static Parameters parameters;
	private static FileBasedConfigurationBuilder<FileBasedConfiguration> builder;
	private static Configuration configuration;

	public static void writeToPropertyFile(String propertyFilePath, String propertyName, String propertyValue)
	{
		try
		{
			outputStream = new FileOutputStream(propertyFilePath);
			properties.setProperty(propertyName, propertyValue);
			properties.store(outputStream, null);
			outputStream.close();
		} 
		catch (IOException io)
		{
			io.printStackTrace();
		}
	}

	public static void updatePropertyFile(String propertyFilePath, String propertyName, String propertyValue)
	{
		try
		{
			inputStream = new FileInputStream(propertyFilePath);
			properties.load(inputStream);
			inputStream.close();
			outputStream = new FileOutputStream(propertyFilePath);
			properties.setProperty(propertyName, propertyValue);
			properties.store(outputStream, null);
			outputStream.close();
		} 
		catch (IOException io)
		{
			io.printStackTrace();
		}
	}

	public static String readFromPropertyFile(String propertyFilePath, String propertyName)
	{
		try
		{
		    inputStream = new FileInputStream(propertyFilePath);
			properties.load(inputStream);
			return properties.getProperty(propertyName);
		} 
		catch (IOException io)
		{
			io.printStackTrace();
		}
		return null;
	}
	

	public static void writeOnFile(String filePath, int startCount, int endCount, String data)
	{
		file = new File(filePath);
		try
		{
			fileWriter = new FileWriter(file);
			bufferedWriter = new BufferedWriter(fileWriter);
			for(int i = startCount; i<endCount; i++)
			{
				bufferedWriter.write(data+" "+i+System.getProperty("line.separator"));
			}
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				bufferedWriter.close();
				fileWriter.close();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
	}
	
	public static void initPropertiesFile(String fileName)
	{
		try
		{
			parameters = new Parameters();
			builder = new FileBasedConfigurationBuilder<FileBasedConfiguration>(PropertiesConfiguration.class)
					.configure(parameters.properties()
			        .setFileName(fileName));
			configuration = builder.getConfiguration();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static String readProperty(String fileName, String propertyName)
	{
		initPropertiesFile(fileName);
		return configuration.getString(propertyName);
	}
	
	public static void writeProperty(String fileName, String propertyName, String propertyValue)
	{
		try
		{
			initPropertiesFile(fileName);
			configuration.setProperty(propertyName, propertyValue);
			builder.save();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
}
