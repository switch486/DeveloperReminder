package com.apuchals.DR.infoGetter;

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
	
	public Map<CommitInformation, CheckedFileList> getNewestRevisions () {
		computeKeywords();
		return parseOutput (svnlogCommand.execute(mKeywords));
	}

	private void computeKeywords() {
		mKeywords = parser.parse(tr(CONFIGURATION_FILE));
		mKeywords.addKeywords(parser.parse(tr(SVN_STATE)));
	}

	private Map<CommitInformation, CheckedFileList> parseOutput(List<String> execute) {
		String oneString = toOneString(execute);
		LogMessageTransformer messageTransformer = new LogMessageTransformer();
		Log l = (Log) messageTransformer.getObject(oneString);
		
		Map<CommitInformation, CheckedFileList> result = new HashMap<CommitInformation, CheckedFileList>();
		for (LogEntry le : l.getLogEntry()) {
			result.put(new CommitInformation(le), getFileList(le));
		}
		return result;
	}

	private CheckedFileList getFileList(LogEntry le) {
		CheckedFileList resultList = new CheckedFileList();
		String StringReplace = (String) mKeywords
				.get(Keywords.SVN_FOLER_TO_REPLACE);
		String exec = (String) mKeywords.get(Keywords.PATH_KEYWORD);
		for (Path p : le.getPaths().getPath()) {
			CheckedFile cf = new CheckedFile();
			cf.setLocation(p.getValue().replace(StringReplace, exec));
			cf.setKind(p.getKind());
			cf.setAction(p.getAction());
			resultList.add(cf);
		}
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
