package com.apuchals.DR.common;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.apuchals.DR.toRemove.NotImplementedException;

public class PropertiesParser extends Parser {
	
	private Map<String, Properties> propertiesMap;
	
	public PropertiesParser() {
		propertiesMap = new HashMap<String, Properties> ();
	}

	@Override
	public Keywords parse(URL propertiesFile) {
		return new Keywords(getNewestProperties(propertiesFile));
	}
	
	public Properties getNewestProperties(URL propertiesFile) {
		Properties readProperties = propertiesMap.get(propertiesFile.getPath());
		if (readProperties == null) {
			readProperties = readProperties(propertiesFile);
			propertiesMap.put(propertiesFile.getPath(), readProperties);
		}
		return readProperties;
	}
	
	public Properties readProperties (URL propertiesFile) {
		Properties properties = new Properties();
		try {
		    properties.load(new FileInputStream(propertiesFile.getPath()));
		} catch (IOException e) {
			// TODO 29.11.2011 apuchals > handle exception
			throw new NotImplementedException();
		}
		return properties;
	}

	public void updateProperties (String s, String value) {
		Properties properties = propertiesMap.get(s);
		properties.put(s, value);
		try {
			properties.store(new FileOutputStream(s), null);
		} catch (IOException e) {
			// TODO 29.11.2011 apuchals > handle exception
			throw new NotImplementedException();
		}
	}
	
}
