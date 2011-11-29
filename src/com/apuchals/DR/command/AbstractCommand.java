package com.apuchals.DR.command;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.apuchals.DR.common.Keywords;
import com.apuchals.DR.toRemove.NotImplementedException;

public abstract class AbstractCommand {
	
	private String [] command = null;

	public List<String> execute (Keywords keywords) {
		setComputeCommand(keywords);
		return grabOutput();
	}

	private List<String> grabOutput() {
		List<String> resultList = new ArrayList<String>();
		String s = null;
		try {
			Process ls_proc = Runtime.getRuntime().exec(command);

			Scanner ls_in = new Scanner(ls_proc.getInputStream());

			while (ls_in.hasNextLine()) {
				s = ls_in.nextLine();
				System.out.println(s);
				resultList.add(s);
			} 
		} catch (IOException e1) {
			// TODO 29.11.2011 apuchals > handle exceptions;
			throw new NotImplementedException();
		}
		return resultList;
	}

	private void setComputeCommand(Keywords keywords) {
		if (command == null) {
			command = buildCommand(keywords);
		}
	}
	
	public abstract String [] buildCommand (Keywords keywords);
	
}
