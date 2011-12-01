package com.apuchals.DR.infoGetter;

import java.io.File;

public class CheckedFile implements IFileExtension {

	private File location;

	private String action;

	private String kind;

	private String fileExtension;

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public File getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = new File(location);
		this.fileExtension = getFileExtension(location);
	}

	private String getFileExtension(String string) {
		try {
			return string.substring(string.lastIndexOf(".")).replace(".", "");
		} catch (StringIndexOutOfBoundsException e) {
			return "";
		}
	}

	public String getFileExtension() {
		return fileExtension;
	}

	@Override
	public String toString() {
		String sep = " | ";
		return getClass().getName() + sep + action + sep + kind + sep
				+ fileExtension + sep + location.getPath();
	}

}
