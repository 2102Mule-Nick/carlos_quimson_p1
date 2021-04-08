package com.revature.config;

import java.util.Properties;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.jms.Topic;
import javax.sql.DataSource;
import javax.transaction.TransactionManager;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.connection.SingleConnectionFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.jta.JtaTransactionManager;

import com.revature.messaging.JmsMessageListener;

import bitronix.tm.TransactionManagerServices;
import bitronix.tm.resource.jdbc.PoolingDataSource;
import bitronix.tm.resource.jms.PoolingConnectionFactory;

@Configuration
@ComponentScan("com.revature")
@EnableTransactionManagement
public class AppConfig {

	// JMS Broker URL
	public static final String BROKER_URL = "tcp://localhost:61616";

	// JMS Destinations
	public static final String ROOM_STATUS_QUEUE = "ROOM_STATUS_QUEUE";
	public static final String HOUSEKEEPING_TICKET_TOPIC = "HOUSEKEEPING_TICKET_TOPIC";
	public static final String MAINTENANCE_TICKET_TOPIC = "MAINTENANCE_TICKET_TOPIC";
	public static final String ERROR_TOPIC = "ERROR_TOPIC";
	public static final String RESOLVED_TOPIC = "RESOLVED_TOPIC";
	public static final String HK_TICKET_UPDATE_QUEUE = "HK_TICKET_UPDATE_QUEUE";
	
	//public static final String DATASOURCE_DRIVERNAME = "org.postgresql.Driver";
	public static final String DATASOURCE_DRIVERNAME = "org.postgresql.xa.PGXADataSource";
	public static final String DATASOURCE_USERNAME = System.getenv("DB_USERNAME");
	public static final String DATASOURCE_PASSWORD = System.getenv("DB_PASS");
	public static final String DATASOURCE_SCHEMA = System.getenv("DB_SCHEMA"); // change this to system environment
	
	// DataSource info
	public static final String DATASOURCE_URL = "jdbc:postgresql://" + System.getenv("DB_URL") + ":5432/"
			+ System.getenv("DB_NAME") + "?currentSchema=" + DATASOURCE_SCHEMA;
	
	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		System.out.println(DATASOURCE_URL);
		PoolingDataSource dataSource = new PoolingDataSource();
		dataSource.setClassName(DATASOURCE_DRIVERNAME);
		dataSource.setUniqueName("PostGresDB");
		dataSource.setMaxPoolSize(10);
		dataSource.setAllowLocalTransactions(true);
		dataSource.getDriverProperties().put("Url", DATASOURCE_URL);
		dataSource.getDriverProperties().put("user", DATASOURCE_USERNAME);
		dataSource.getDriverProperties().put("password", DATASOURCE_PASSWORD);
		dataSource.init();
		return dataSource;

	}
	
	@Bean
	public ConnectionFactory bitronixConnectionFactory() {
		PoolingConnectionFactory connectionFactory = new PoolingConnectionFactory();
		connectionFactory.setClassName("org.apache.activemq.ActiveMQXAConnectionFactory");
		connectionFactory.setUniqueName("activemq");
		connectionFactory.setMaxPoolSize(10);
		connectionFactory.setAllowLocalTransactions(true);
		Properties props = new Properties();
		props.put("brokerURL", BROKER_URL);
		connectionFactory.setDriverProperties(props);
		return connectionFactory;
	}
	
	@Bean
	public bitronix.tm.Configuration btmConfig() {
		bitronix.tm.Configuration config = TransactionManagerServices.getConfiguration();
		config.setDisableJmx(true);
		config.setServerId("spring-btm");
		return config;
	}

	@Bean(destroyMethod = "shutdown")
	@DependsOn("btmConfig")
	public TransactionManager primaryTransactionManager() {
		return TransactionManagerServices.getTransactionManager();
	}

	@Bean
	public JtaTransactionManager jtaTransactionManager(TransactionManager primaryTransactionManager) {
		JtaTransactionManager jtaTransactionManager = new JtaTransactionManager();
		jtaTransactionManager.setTransactionManager(primaryTransactionManager);
		return jtaTransactionManager;
	}

//	@Bean
//	public DataSource dataSource() {
//
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		dataSource.setUrl(DATASOURCE_URL);
//		dataSource.setDriverClassName(DATASOURCE_DRIVERNAME);
//		dataSource.setUsername(DATASOURCE_USERNAME);
//		dataSource.setPassword(DATASOURCE_PASSWORD);
//		dataSource.setSchema(DATASOURCE_SCHEMA);
//		return dataSource;
//
//	}
		
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
		//connectionFactory.setTrustAllPackages(true); //causing issues when trying to get REST to work
		return connectionFactory;
	}
	
	@Bean
	public ConnectionFactory connectionFactory(ActiveMQConnectionFactory amqConnectionFactory) {
		return new SingleConnectionFactory(amqConnectionFactory);
	}
	
	@Bean
	public Queue housekeepingQueue() {
		return new ActiveMQQueue(ROOM_STATUS_QUEUE);
	}
	
	@Bean
	public Topic housekeepingTicketTopic() {
		return new ActiveMQTopic(HOUSEKEEPING_TICKET_TOPIC);
	}
	
	@Bean Topic maintenanceTicketTopic() {
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
	
	@Bean
	public Queue housekeepingTicketUpdateQueue() {
		return new ActiveMQQueue(HK_TICKET_UPDATE_QUEUE);
	}
	
//	@Bean
//	public DefaultJmsListenerContainerFactory jmsListenerContainerFactory(ConnectionFactory connectionFactory) {
//		DefaultJmsListenerContainerFactory container = new DefaultJmsListenerContainerFactory();
//		container.setConnectionFactory(connectionFactory);
//		return container;
//	}
	
//	@Bean
//	public DefaultMessageListenerContainer jmsContainer(ConnectionFactory connectionFactory, JmsMessageListener messageListener) {
//		DefaultMessageListenerContainer container = new DefaultMessageListenerContainer();
//		container.setConnectionFactory(connectionFactory);
//		container.setDestinationName(ROOM_STATUS_QUEUE); //set in the JmsMessageListener via annotation
//		container.setMessageListener(messageListener);
//		
//		return container;
//	}
	
	@Bean
	public JmsTemplate jmsTemplate(ConnectionFactory connectionFactory) {
		JmsTemplate template = new JmsTemplate();
		template.setConnectionFactory(connectionFactory);
		
		return template;
	}
	
}
