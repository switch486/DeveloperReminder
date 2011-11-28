package com.apuchals.DR.infoGetter;

import java.io.File;
import java.util.List;
import java.util.Map;

public interface IVersioningSpider {
	
	public Map<CommitInformation, List<File>> getNewestRevisions ();

	// TODO 28.11.2011 apuchals > remove!
	public void dumy();
	
}
