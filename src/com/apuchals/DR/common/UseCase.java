package com.apuchals.DR.common;

import java.io.File;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import com.apuchals.DR.common.XMLConfiguration.CommandConfig;
import com.apuchals.DR.common.XMLConfiguration.Configuration;
import com.apuchals.DR.toRemove.NotImplementedException;

public class UseCase {
	
	private CommandConfig mCommandConfigs;
	private Configuration mConfig;
	
	public UseCase() {
		initConfiguration();
	}
	
	private void initConfiguration () {
		if (mConfig == null) {
			File f = new File(UseCase.class.getResource("configuration.xml").getPath());
			
			Serializer serializer = new Persister();

			try {
				mConfig = serializer.read(Configuration.class, f);
			} catch (Exception e) {
				throw new NotImplementedException();
				// TODO 02.12.2011 apuchals > handle Exception somehow
			}
		}
	}

	public CommandConfig getCommandConfig(CommandConfig c) {
		if (mCommandConfigs == null) {
			mCommandConfigs = mConfig.getCommand(c);
		}
		return mCommandConfigs;
	}

	public void setCommandConfig(CommandConfig commandConfigs) {
		this.mCommandConfigs = commandConfigs;
	}

}