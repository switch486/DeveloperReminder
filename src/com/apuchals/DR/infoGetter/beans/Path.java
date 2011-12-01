package com.apuchals.DR.infoGetter.beans;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;

@Root(name="path")
public class Path {

	@Attribute(name="kind")
	private String kind;

	@Attribute(name="action")
	private String action;
	
	@Attribute(name="copyfrom-path", required = false)
	private String copyFromPath;
	
	@Attribute(name="copyfrom-rev", required = false)
	private String copyFromRev;
	
	@Text
	private String value;
	
	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getCopyFromPath() {
		return copyFromPath;
	}

	public void setCopyFromPath(String copyFromPath) {
		this.copyFromPath = copyFromPath;
	}

	public String getCopyFromRev() {
		return copyFromRev;
	}

	public void setCopyFromRev(String copyFromRev) {
		this.copyFromRev = copyFromRev;
	}
	
}
