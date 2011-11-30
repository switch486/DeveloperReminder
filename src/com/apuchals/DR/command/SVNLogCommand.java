package com.apuchals.DR.command;

import com.apuchals.DR.common.Keywords;

public class SVNLogCommand extends AbstractCommand {
	
	@Override
	public String[] buildCommand(Keywords keywords) {
		String path = (String) keywords.get(Keywords.PATH_KEYWORD);
		String exec = (String) keywords.get(Keywords.EXEC_FILE);
		String revisions = (String) keywords.get(Keywords.LAST_REVISION);
		return new String[] { exec, "log",  "-v", "--xml", path, "-r", revisions+":HEAD" };
	}
	
//	@Override
//	public String[] buildCommand(Keywords keywords) {
//		String path = (String) keywords.get(Keywords.PATH_KEYWORD);
//		String exec = (String) keywords.get(Keywords.EXEC_FILE);
//		String revisions = (String) keywords.get(Keywords.LAST_REVISION);
//		return new String[] { exec, "log", path, "-r", revisions+":HEAD" };
//	}

}
