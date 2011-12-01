package com.apuchals.DR.infoGetter;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import com.apuchals.DR.infoGetter.beans.Log;
import com.apuchals.DR.toRemove.NotImplementedException;


public class LogMessageTransformer {
	
	private Serializer serializer;

	public LogMessageTransformer() {
		serializer = new Persister();
	}
	
	// from java to xml
	public Object getObject (String xml) {
		Log result = null;
		try {
			result = serializer.read(Log.class, xml);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO 29.11.2011 apuchals > handle exceptions;
			throw new NotImplementedException();
		}
		return result;
	}
	
	
	// from xml to java

}
