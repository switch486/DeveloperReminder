package com.apuchals.DR.command;

import com.apuchals.DR.common.XMLConfiguration.CommandConfig;
import com.apuchals.DR.common.XMLConfiguration.SVNLogCommandConfig;

public class SVNLogCommand extends AbstractCommand {

	@Override
	public String[] buildCommand(CommandConfig c) {
		SVNLogCommandConfig config = getConfig(c);
		String path = config.getRepoFilePath();
		String exec = config.getSvnExecFilePath();
		int revisions = config.getLastRevision();
		return new String[] { exec, "log", "-v", "--xml", path, "-r",
				revisions + ":HEAD" };
	}
	
	private SVNLogCommandConfig getConfig(CommandConfig config) {
		return ((SVNLogCommandConfig) config);
	}

}
