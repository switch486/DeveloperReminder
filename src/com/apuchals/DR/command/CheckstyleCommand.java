package com.apuchals.DR.command;

import com.apuchals.DR.common.XMLConfiguration.CommandConfig;
import com.apuchals.DR.toRemove.NotImplementedException;

public class CheckstyleCommand extends AbstractCommand {

	@Override
	public String[] buildCommand(CommandConfig commandConfig) {
		// desired example:
		// java -classpath jarLocation additionalClassPathElements mainClassToRun -c configurationFile FILE_HERE -f xml
		throw new NotImplementedException();
	}

}
