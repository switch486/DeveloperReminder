package com.apuchals.DR.infoGetter;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.apuchals.DR.command.AbstractCommand;
import com.apuchals.DR.command.SVNLogCommand;
import com.apuchals.DR.common.Keywords;
import com.apuchals.DR.common.UseCase;
import com.apuchals.DR.infoGetter.beans.Log;
import com.apuchals.DR.infoGetter.beans.LogEntry;
import com.apuchals.DR.infoGetter.beans.Path;

public class SVNSpider extends UseCase implements IVersioningSpider {
	
	public static final String CONFIGURATION_FILE = "svnConfiguration.properties";
	
	public static final String SVN_STATE ="svnState.properties";
	
	private AbstractCommand svnlogCommand;
	
	private Keywords mKeywords;

	public SVNSpider() {
		svnlogCommand = new SVNLogCommand();
	}
	
	// read svn log and get revisions later than in the properties
	// for each revision do>
		// get all files with the absolute paths 
	// export to map of <revision, List<javaFiles>> 
	
	public Map<CommitInformation, List<File>> getNewestRevisions () {
		computeKeywords();
		return parseOutput (svnlogCommand.execute(mKeywords));
	}

	private void computeKeywords() {
		mKeywords = parser.parse(tr(CONFIGURATION_FILE));
		mKeywords.addKeywords(parser.parse(tr(SVN_STATE)));
	}

	private Map<CommitInformation, List<File>> parseOutput(List<String> execute) {
		String oneString = toOneString(execute);
		LogMessageTransformer messageTransformer = new LogMessageTransformer();
		Log l = (Log) messageTransformer.getObject(oneString);
		
		Map<CommitInformation, List<File>> result = new HashMap<CommitInformation, List<File>>();
		for (LogEntry le : l.getLogEntry()) {
			result.put(new CommitInformation(le), getFileList(le));
		}
		return result;
	}

	private List<File> getFileList(LogEntry le) {
		List<File> resultList = new ArrayList<File>();
		String StringReplace = (String) mKeywords
				.get(Keywords.SVN_FOLER_TO_REPLACE);
		String exec = (String) mKeywords.get(Keywords.PATH_KEYWORD);
		// TODO 01.12.2011 apuchals > additional info to get here!
		for (Path p : le.getPaths().getPath()) {
			resultList.add(new File(p.getValue().replace(StringReplace, exec)));
		}
		// TODO Auto-generated method stub
		return resultList;
	}

	private String toOneString(List<String> execute) {
		StringBuilder sb = new StringBuilder();
		for (String s : execute) {
			sb.append(s+ "\n");
		}
		return sb.toString();
	}
	
}
