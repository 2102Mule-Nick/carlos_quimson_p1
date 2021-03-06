package com.revature.config;


import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.Topic;
import javax.sql.DataSource;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.connection.SingleConnectionFactory;
import org.springframework.jms.core.JmsTemplate;

@Configuration
@ComponentScan("com.revature")
public class AppConfig {
	
	// JMS Broker URL
	public static final String BROKER_URL = "tcp://localhost:61616";

	// JMS Destinations
	public static final String ROOM_OOS_QUEUE = "ROOM_OOS_QUEUE";
	public static final String MAINTENANCE_TICKET_TOPIC = "MAINTENANCE_TICKET_TOPIC";
	public static final String ERROR_TOPIC = "ERROR_TOPIC";
	public static final String RESOLVED_TOPIC = "RESOLVED_TOPIC";
	
	//DataSource info
	public static final String DATASOURCE_URL = "jdbc:postgresql://" + System.getenv("DB_URL") +
			":5432/" + System.getenv("DB_NAME") + "?";
	
	public static final String DATASOURCE_DRIVERNAME = "org.postgresql.Driver";
	public static final String DATASOURCE_USERNAME = System.getenv("DB_USERNAME");
	public static final String DATASOURCE_PASSWORD = System.getenv("DB_PASS");
	public static final String DATASOURCE_SCHEMA = System.getenv("DB_SCHEMA"); //change this to system environment
	
	
	@Bean
	public DataSource dataSource() {
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(DATASOURCE_URL);
		dataSource.setDriverClassName(DATASOURCE_DRIVERNAME);
		dataSource.setUsername(DATASOURCE_USERNAME);
		dataSource.setPassword(DATASOURCE_PASSWORD);
		dataSource.setSchema(DATASOURCE_SCHEMA);
		return dataSource;
		
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		JdbcTemplate template = new JdbcTemplate();
		template.setDataSource(dataSource);
		return template;
	}
	
	@Bean
	public Logger log() {
		return Logger.getRootLogger();
	}
	
	@Bean
	public ActiveMQConnectionFactory amqConnectionFactory() {
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(BROKER_URL);
		connectionFactory.setTrustAllPackages(true);
		return connectionFactory;
	}
	
	@Bean
	public ConnectionFactory connectionFactory(ActiveMQConnectionFactory amqConnectionFactory) {
		return new SingleConnectionFactory(amqConnectionFactory);
	}
	
	@Bean
	public Queue destinationQueue() {
		return new ActiveMQQueue(ROOM_OOS_QUEUE);
	}
	
	@Bean
	public Topic maintenanceTopic() {
		return new ActiveMQTopic(MAINTENANCE_TICKET_TOPIC);
	}
	
	@Bean
	public Topic errorTopic() {
		return new ActiveMQTopic(ERROR_TOPIC);
	}
	
	@Bean
	public Topic resolvedTopic() {
		return new ActiveMQTopic(RESOLVED_TOPIC);
	}

	@Bean // for Queues
	public DefaultJmsListenerContainerFactory jmsListenerContainerFactory(ConnectionFactory connectionFactory) {
		DefaultJmsListenerContainerFactory container = new DefaultJmsListenerContainerFactory();
		container.setConnectionFactory(connectionFactory);
		return container;
	}
	
	@Bean // for topics
	public DefaultJmsListenerContainerFactory jmsListenerContainerTopic(ConnectionFactory connectionFactory) {
		DefaultJmsListenerContainerFactory container = new DefaultJmsListenerContainerFactory();
		container.setConnectionFactory(connectionFactory);
		container.setPubSubDomain(true);
		return container;
	}
	
	@Bean
	public JmsTemplate jmsTemplate(ConnectionFactory connectionFactory) {
		JmsTemplate template = new JmsTemplate();
		template.setConnectionFactory(connectionFactory);
		
		return template;
	}
	
}
