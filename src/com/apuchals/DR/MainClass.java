package com.apuchals.DR;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {
	
	private static final String userDir = System.getProperty("user.dir");
	
	public static void main(String[] args) {
		
		System.out.println(userDir);

		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"bean-config.xml");

		DeveloperReminderStarter reminder = (DeveloperReminderStarter) ctx
				.getBean(DeveloperReminderStarter.class.getName());

		reminder.start();
	}
}
