package com.apuchals.DR.infoGetter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.apuchals.DR.command.AbstractCommand;
import com.apuchals.DR.command.SVNLogCommand;
import com.apuchals.DR.common.UseCase;
import com.apuchals.DR.common.XMLConfiguration.SVNLogCommandConfig;
import com.apuchals.DR.infoGetter.XMLBeans.Log;
import com.apuchals.DR.infoGetter.XMLBeans.LogEntry;
import com.apuchals.DR.infoGetter.XMLBeans.Path;

public class SVNSpider extends UseCase implements IVersioningSpider {

	private AbstractCommand svnlogCommand;

	public SVNSpider() {
		svnlogCommand = new SVNLogCommand();
	}

	public Map<CommitInformation, CheckedFileList> getNewestRevisions() {
		return parseOutput(svnlogCommand.execute(getConfig()));
	}

	private Map<CommitInformation, CheckedFileList> parseOutput(
			List<String> execute) {
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
		String StringReplace = getConfig().getSvnFolderToReplace();
		String exec = getConfig().getSvnFolderToReplace();;
		for (Path p : le.getPaths().getPath()) {
			CheckedFile cf = new CheckedFile();
			cf.setLocation(p.getValue().replace(StringReplace, exec));
			cf.setKind(p.getKind());
			cf.setAction(p.getAction());
			resultList.add(cf);
		}
		return resultList;
	}
	
	private SVNLogCommandConfig getConfig() {
		return ((SVNLogCommandConfig) getCommandConfig(new SVNLogCommandConfig()));
	}

	private String toOneString(List<String> execute) {
		StringBuilder sb = new StringBuilder();
		for (String s : execute) {
			sb.append(s + "\n");
		}
		return sb.toString();
	}

}
