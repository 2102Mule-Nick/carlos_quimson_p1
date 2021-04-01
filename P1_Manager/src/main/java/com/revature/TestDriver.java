package com.revature;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.revature.config.AppConfig;
import com.revature.messaging.JmsMessageSender;

public class TestDriver {

public static void main(String[] args) {
		
		String command = null;
		
		Scanner scan = new Scanner(System.in);
		
		ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
		
		JmsMessageSender messageSender = appContext.getBean("jmsMessageSender", JmsMessageSender.class);
		
		
		/*
		messageSender.simpleSend("Just testing how to use JMS");
		
		System.out.println("Message sent to Housekeeping");
		*/
		
		
	}
}
