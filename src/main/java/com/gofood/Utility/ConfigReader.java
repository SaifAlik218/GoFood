package com.gofood.Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfigReader {
	private static Properties property;
	private static final String PATH = "./src/test/resources/config.properties";
	private static Logger log = LoggerFactory.getLogger(ConfigReader.class);
	private static ConfigReader instance;
	 // private constructor - prevents "new ConfigReader()" from outside
	private ConfigReader() {
		loadConfig();
	}
	 // controlled access point to the single instance
	public static synchronized ConfigReader getInstance()
	{
		if(instance == null)
		{
			instance = new ConfigReader();
		}
		return instance;
	}

	private void loadConfig() {
		log.info("Loading config file from path: {}", PATH);
		try(FileInputStream fis = new FileInputStream(PATH)){
			property = new Properties();
			property.load(fis);
			fis.close();
			log.info("Config file loaded successfully");
		}
		catch (IOException e) {
		log.error("Failed to create the confif file",PATH,e);
		throw new RuntimeException("Failed to load config file: " + PATH, e);
		}
	}

	public static String getConfig(String key) throws Exception {
		String value = property.getProperty(key);
		if (value == null) {
			throw new RuntimeException("Key not found in config.properties: " + key);
		}
		return value;
	}

}
