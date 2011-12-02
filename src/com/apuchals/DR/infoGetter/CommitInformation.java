package com.apuchals.DR.infoGetter;

import com.apuchals.DR.infoGetter.XMLBeans.LogEntry;

public class CommitInformation {

	private int revision;

	private String author;

	private String date;

	private String message;

	public CommitInformation(LogEntry le) {
		author = le.getAuthor();
		date = le.getDate();
		message = le.getMessage();
		revision = le.getRevision();
	}

	public int getRevision() {
		return revision;
	}

	public void setRevision(int revision) {
		this.revision = revision;
	}

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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
