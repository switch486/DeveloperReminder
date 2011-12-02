package com.apuchals.DR;

import java.io.File;
import java.util.ArrayList;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import com.apuchals.DR.common.XMLConfiguration.CheckstyleCommandConfig;
import com.apuchals.DR.common.XMLConfiguration.CommandConfig;
import com.apuchals.DR.common.XMLConfiguration.Configuration;
import com.apuchals.DR.common.XMLConfiguration.SVNLogCommandConfig;

public class XMLGenerator {
	public static void main(String[] args) throws Exception {
		// TODO 02.12.2011 apuchals > generate XMLXonfigurationFile

		Serializer serializer = new Persister();
		String path = XMLGenerator.class.getResource("XMLGenerator.class").getPath();
		File f = new File(path);
		File result = new File(f.getParentFile()+File.separator+"configuration.xml");

		serializer.write(getConfiguration(), result);
	}

	private static Configuration getConfiguration() {
		Configuration c = new Configuration();
		c.setCommands(setCommands());

//		c.setNotification(setNotification());
		return c;
	}

//	private static NotificationConfig setNotification() {
//		NotificationConfig notification = new NotificationConfig();
//		// TODO 02.12.2011 apuchals > 
//		return notification;
//	}

	private static ArrayList<CommandConfig> setCommands() {
		ArrayList<CommandConfig> list = new ArrayList<CommandConfig>();
		list.add(setSvnLogCommand());
		list.add(setCheckstyleCommand());
//		list.add(setFindBugsCommand());
		return list;
	}

//	private static CommandConfig setFindBugsCommand() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	private static CommandConfig setCheckstyleCommand() {
		CheckstyleCommandConfig c = new CheckstyleCommandConfig();
		c.setConfigurationFile("C:\\checkstyle.xml");
		c.setJarLocation("\"C:\\checkstyle-5.3-all.jar\"");
		c.setAdditionalClassPathElements(";\"C:\\assitionalLib.jar\"");
		c.setMainClassToRun("com.puppycrawl.tools.checkstyle.Main");
		return c;
	}

	private static SVNLogCommandConfig setSvnLogCommand() {
		SVNLogCommandConfig svnLC = new SVNLogCommandConfig();
		svnLC.setLastRevision(112159);
		svnLC.setRepoFilePath("C:\\SVNROOT\\");
		svnLC.setSvnExecFilePath("C:\\Program Files\\SlikSvn\\bin\\svn.exe");
		svnLC.setSvnFolderToReplace("pathToExchangeINTheSvn");
		return svnLC;
	}
}
