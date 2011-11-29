package com.apuchals.DR.common;

import java.net.URL;

public abstract class Parser {
	
	public abstract Keywords parse(URL url);
	
	public Keywords parse() {
		return parse (null);
	}

}
