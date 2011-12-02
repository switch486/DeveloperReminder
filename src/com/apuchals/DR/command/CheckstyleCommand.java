package com.apuchals.DR.command;

import com.apuchals.DR.common.Keywords;
import com.apuchals.DR.toRemove.NotImplementedException;

public class CheckstyleCommand extends AbstractCommand {

	@Override
	public String[] buildCommand(Keywords keywords) {
		// desired example:
		// java -classpath jarLocation additionalClassPathElements mainClassToRun -c configurationFile FILE_HERE -f xml
		throw new NotImplementedException();
	}

}
