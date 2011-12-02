package com.apuchals.DR.common.XMLConfiguration;

import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import com.apuchals.DR.common.exceptions.NoSuchCommandException;

@Root(name = "Configuration")
public class Configuration {
	
	@ElementList(name = "command", inline = true)
	private List<CommandConfig> commands;
	
	// TODO 02.12.2011 apuchals > REMOVE THE NOT REQUIRED ANNOTATION: , required = false
	@Element(name = "notification", required = false)
	private NotificationConfig notification;

	public List<CommandConfig> getCommands() {
		return commands;
	}

	public void setCommands(List<CommandConfig> commands) {
		this.commands = commands;
	}

	public NotificationConfig getNotification() {
		return notification;
	}

	public void setNotification(NotificationConfig notification) {
		this.notification = notification;
	}
	
	@SuppressWarnings("unchecked")
	public <T> T getCommand (T instance) {
		for (CommandConfig cc : commands) {
			if (cc.getClass().equals(instance.getClass())) {
				return (T) cc;
			}
		}
		throw new NoSuchCommandException(instance.getClass().getName());
	}

}
