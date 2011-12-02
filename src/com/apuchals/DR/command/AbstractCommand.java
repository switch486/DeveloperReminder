package com.apuchals.DR.command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.apuchals.DR.common.XMLConfiguration.CommandConfig;
import com.apuchals.DR.toRemove.NotImplementedException;

public abstract class AbstractCommand {

	private String[] command = null;

	public List<String> execute(CommandConfig commandConfig) {
		setComputeCommand(commandConfig);
		return executeCommandAndGrabOutput(command);
	}

	private void setComputeCommand(CommandConfig commandConfig) {
		if (command == null) {
			command = buildCommand(commandConfig);
		}
	}

	public abstract String[] buildCommand(CommandConfig keywords);

	public List<String> executeCommandAndGrabOutput(String[] command) {
		List<String> resultList = new ArrayList<String>();
		Runtime run = Runtime.getRuntime();
		Process pr = null;
		try {
			pr = run.exec(command);
		} catch (IOException e) {
			// TODO 29.11.2011 apuchals > handle exceptions;
			throw new NotImplementedException();
		}
		// try {
		// pr.waitFor();
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }
		BufferedReader buf = new BufferedReader(new InputStreamReader(
				pr.getInputStream()));
		String line = "";
		try {
			while ((line = buf.readLine()) != null) {
				resultList.add(line);
			}
		} catch (IOException e) {
			// TODO 29.11.2011 apuchals > handle exceptions;
			throw new NotImplementedException();
		}
		return resultList;
	}

}
