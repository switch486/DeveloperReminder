package com.apuchals.DR;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"bean-config.xml");

		DeveloperReminderStarter reminder = (DeveloperReminderStarter) ctx
				.getBean(DeveloperReminderStarter.class.getName());

		reminder.start();
	}
}
