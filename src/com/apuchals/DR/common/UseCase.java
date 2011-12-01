package com.apuchals.DR.common;

import java.net.URL;

public class UseCase {

	protected static Parser parser;

	public void setParser(Parser parser) {
		UseCase.parser = parser;
	}

	public URL tr(String s) {
		return getClass().getResource(s);
	}

}
