package com.apuchals.DR.infoGetter.beans;

import java.util.List;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name="log")
public class Log {
	@ElementList(name="logentry")
	private List<LogEntry> logEntry;

	public Log() {
		super ();
	}
	
	public Log(List<LogEntry> logEntry) {
		this.logEntry = logEntry;
	}

	public List<LogEntry> getLogEntry() {
		return logEntry;
	}

	public void setLogEntry(List<LogEntry> logEntry) {
		this.logEntry = logEntry;
	}
}
