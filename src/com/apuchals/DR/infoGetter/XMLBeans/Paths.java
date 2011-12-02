package com.apuchals.DR.infoGetter.XMLBeans;

import java.util.List;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name = "paths")
public class Paths {

	@ElementList(name = "path", inline = true)
	private List<Path> path;

	public List<Path> getPath() {
		return path;
	}

	public void setPath(List<Path> path) {
		this.path = path;
	}

}
