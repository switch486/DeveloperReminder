package com.apuchals.DR.infoGetter;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.apuchals.DR.common.UseCase;

public class SVNSpider extends UseCase implements IVersioningSpider {

	// read svn log and get revisions later than in the properties
	// for each revision do>
		// get all files with the absolute paths 
	// export to map of <revision, List<javaFiles>> 
	
	public Map<CommitInformation, List<File>> getNewestRevisions () {
		
		// TODO 28.11.2011 apuchals > 
		
		return new HashMap<CommitInformation, List<File>>();
	}

	@Override
	public void dumy() {
		System.out.println(parser.parse());
	}
	
	
}
