package com.apuchals.DR.common;


public class UseCase {
	
	protected static IParser parser;

	public void setParser(IParser parser) {
		UseCase.parser = parser;
	}

}
