package org.bhagwan.shoppingbackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages={"org.bhagwan.shoppingbackend.dto"})
@EnableTransactionManagement
public class HibernateConfig {

	//change below based on the DBMS you choose
	private static final String DATABASE_URL="jdbc:h2:tcp://localhost/~/onlineshopping";
	private static final String DATABASE_DRIVER="org.h2.Driver";
	private static final String DATABASE_DIALECT="org.hibernate.dialect.H2Dialect";
	private static final String DATABASE_USERNAME="sa";
	private static final String DATABASE_PASSWORD="";
	//dataSource bean will be available
	@Bean
	public DataSource getDataSource(){
		BasicDataSource datasource= new BasicDataSource(); 
		//providing database connection information
		datasource.setDriverClassName(DATABASE_DRIVER);
		datasource.setUrl(DATABASE_URL);
		datasource.setUsername(DATABASE_USERNAME);
		datasource.setPassword(DATABASE_PASSWORD);
		return datasource;
	}
	
	//SessionFactory Bean will be available 
	@Bean
	public SessionFactory getSessionFactory(DataSource datasource){
		LocalSessionFactoryBuilder builder= new LocalSessionFactoryBuilder(datasource);
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("org.bhagwan.shoppingbackend.dto");
		return builder.buildSessionFactory();
	}

	//all the hibernate properties retuen this method
	private Properties getHibernateProperties() {
		Properties properties= new Properties();
		properties.put("hibernate.dialect", DATABASE_DIALECT);
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		properties.put("hibernate.hbm2ddl.auto", "update");
		
		return properties;
	}
	
	//Transaction manager Bean
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory){
		HibernateTransactionManager transactionManager= new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}
	
}
