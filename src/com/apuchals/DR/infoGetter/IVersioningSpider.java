package com.apuchals.DR.infoGetter;

import java.util.Map;


public interface IVersioningSpider {
	
	public Map<CommitInformation, CheckedFileList> getNewestRevisions ();

}
