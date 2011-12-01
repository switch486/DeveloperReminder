package com.apuchals.DR.infoGetter.beans;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name="logentry")
public class LogEntry {

	@Attribute(name="revision")
	private int revision;
	
	@Element(name="author")
	private String author;
	
	@Element(name="date")
	private String date;
	
	@Element(name="paths")
	private Paths paths;
	
	@Element(name="msg")
	private String message;

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Paths getPaths() {
		return paths;
	}

	public void setPaths(Paths paths) {
		this.paths = paths;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setRevision(int revision) {
		this.revision = revision;
	}

	public int getRevision() {
		return revision;
	}
	
	

}
