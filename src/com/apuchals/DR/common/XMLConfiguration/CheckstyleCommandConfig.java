package com.apuchals.DR.common.XMLConfiguration;

import org.simpleframework.xml.Attribute;

public class CheckstyleCommandConfig extends CommandConfig {

	@Attribute(name = "jarLocation")
	private String jarLocation;

	@Attribute(name = "additionalClassPathElements")
	private String additionalClassPathElements;

	@Attribute(name = "mainClassToRun")
	private String mainClassToRun;

	@Attribute(name = "configurationFile")
	private String configurationFile;

	public String getJarLocation() {
		return jarLocation;
	}

	public void setJarLocation(String jarLocation) {
		this.jarLocation = jarLocation;
	}

	public String getAdditionalClassPathElements() {
		return additionalClassPathElements;
	}

	public void setAdditionalClassPathElements(
			String additionalClassPathElements) {
		this.additionalClassPathElements = additionalClassPathElements;
	}

	public String getMainClassToRun() {
		return mainClassToRun;
	}

	public void setMainClassToRun(String mainClassToRun) {
		this.mainClassToRun = mainClassToRun;
	}

	public String getConfigurationFile() {
		return configurationFile;
	}

	public void setConfigurationFile(String configurationFile) {
		this.configurationFile = configurationFile;
	}

}
