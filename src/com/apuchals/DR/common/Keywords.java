package com.apuchals.DR.common;

import java.util.Hashtable;
import java.util.Properties;

import com.apuchals.DR.toRemove.NotImplementedException;

public class Keywords {

	public static final String PATH_KEYWORD = "path";
	public static final String EXEC_FILE = "execFile";
	public static final String LAST_REVISION = "last.svn.revision";
	public static final String SVN_FOLER_TO_REPLACE = "svnFolderToReplace";
	
	
	private Hashtable<Object, Object> table;
	
	public Keywords (Properties properties) {
		this ();
		table.putAll(properties);
	}
	
	public Keywords() {
		table = new Hashtable<Object, Object>();
	}
	
	public Keywords(Object... objects) {
		this();
		addKeywords(objects);
	}
	
	public Keywords(Keywords k, Object... objects) {
		table = k.table;
		addKeywords(objects);
	}
	
	public void addKeywords (Object... objects) {
		if (objects.length%2 !=0 )
			// TODO 29.11.2011 apuchals > handle exception somehow
			throw new NotImplementedException();
		for (int i=0; i< objects.length; i+=2) {
			table.put(objects[i], objects[i+1]);
		}
	}
	
	public void addKeywords (Keywords k) {
		table.putAll(k.table);
	}
	
	public boolean containsKeyword (Object key) {
		return table.containsKey(key);
	}
	
	public Object get(Object key) {
		return table.get(key);
	}
	
}
