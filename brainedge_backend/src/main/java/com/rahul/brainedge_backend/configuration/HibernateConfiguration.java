/*package com.rahul.brainedge_backend.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.google.common.base.Preconditions;

@Configuration
@Component
@EnableTransactionManagement
@ComponentScan(basePackages ={ "com.rahul.brainedge_backend.entity" })
@PropertySource(value = { "classpath:application.properties" })
public class HibernateConfiguration {

	@Autowired
	private Environment env;
	
	@Bean("dataSource")
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(Preconditions.checkNotNull(env.getRequiredProperty("db.driver")));
		dataSource.setUrl(Preconditions.checkNotNull(env.getRequiredProperty("db.url")));
		dataSource.setUsername(Preconditions.checkNotNull(env.getRequiredProperty("db.username")));
		dataSource.setPassword(Preconditions.checkNotNull(env.getRequiredProperty("db.password")));
		return dataSource;
	}
	
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
		builder.addProperties(hibernateProperties());
		builder.scanPackages("com.rahul.brainedge_backend.entity");
		return builder.buildSessionFactory();
	}
	
	@Bean
	public HibernateTransactionManager getTransectionManager(SessionFactory factory) {
		HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager(factory);
		return hibernateTransactionManager;
	}


	
	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}
	
	public Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", Preconditions.checkNotNull(env.getRequiredProperty("hibernate.dialect")));
		properties.put("hibernate.show_sql",
				Preconditions.checkNotNull(env.getRequiredProperty("hibernate.show_sql")));
		properties.put("hibernate.format_sql",
				Preconditions.checkNotNull(env.getRequiredProperty("hibernate.format_sql")));
		properties.put("hibernate.hbm2ddl.auto", Preconditions.checkNotNull(env.getRequiredProperty("hibernate.hbm2ddl.auto")));
		return properties;
	}


}
*/