package com.apuchals.DR.infoGetter;

import java.io.File;
import java.util.List;
import java.util.Map;

import com.apuchals.DR.command.AbstractCommand;
import com.apuchals.DR.command.SVNCommand;
import com.apuchals.DR.common.Keywords;
import com.apuchals.DR.common.UseCase;

public class SVNSpider extends UseCase implements IVersioningSpider {
	
	public static final String CONFIGURATION_FILE = "svnConfiguration.properties";
	
	public static final String SVN_STATE ="svnState.properties";
	
	private AbstractCommand svnCommand;

	public SVNSpider() {
		svnCommand = new SVNCommand();
	}
	
	// read svn log and get revisions later than in the properties
	// for each revision do>
		// get all files with the absolute paths 
	// export to map of <revision, List<javaFiles>> 
	
	public Map<CommitInformation, List<File>> getNewestRevisions () {
		Keywords keywordz = parser.parse(tr(CONFIGURATION_FILE));
		keywordz.addKeywords(parser.parse(tr(SVN_STATE)));
		
		return parseOutput (svnCommand.execute(keywordz));
	}

	private Map<CommitInformation, List<File>> parseOutput(List<String> execute) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
