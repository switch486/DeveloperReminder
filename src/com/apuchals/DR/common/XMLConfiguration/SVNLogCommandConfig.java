package com.apuchals.DR.common.XMLConfiguration;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

@Root(name = "SVNLogCommandConfig")
public class SVNLogCommandConfig extends CommandConfig {
	
	@Attribute(name = "repoFilePath")
	private String repoFilePath;
	
	@Attribute(name = "svnExecFilePath")
	private String svnExecFilePath;
	
	@Attribute(name = "svnFolderToReplace")
	private String svnFolderToReplace;
	
	@Attribute(name = "lastRevision")
	private int lastRevision;

	public String getRepoFilePath() {
		return repoFilePath;
	}

	public void setRepoFilePath(String repoFilePath) {
		this.repoFilePath = repoFilePath;
	}

	public String getSvnExecFilePath() {
		return svnExecFilePath;
	}

	public void setSvnExecFilePath(String svnExecFilePath) {
		this.svnExecFilePath = svnExecFilePath;
	}

	public String getSvnFolderToReplace() {
		return svnFolderToReplace;
	}

	public void setSvnFolderToReplace(String svnFolderToReplace) {
		this.svnFolderToReplace = svnFolderToReplace;
	}

	public int getLastRevision() {
		return lastRevision;
	}

	public void setLastRevision(int lastRevision) {
		this.lastRevision = lastRevision;
	}
	
	

}
