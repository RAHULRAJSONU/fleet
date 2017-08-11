package com.rahul.brainedge_backend.configuration;

import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.google.common.base.Preconditions;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.rahul.brainedge_backend")
@PropertySource("classpath:application.properties")
@EnableJpaRepositories("com.rahul.brainedge_backend.repository")
public class JpaHibernateConfiguration {
	
	@Resource
	private Environment env;
	
	@Bean
	public DataSource dataSource() {
		BasicDataSource ds=new BasicDataSource();
		ds.setDriverClassName(Preconditions.checkNotNull(env.getRequiredProperty("db.driver")));
		ds.setUrl(Preconditions.checkNotNull(env.getRequiredProperty("db.url")));
		ds.setUsername(Preconditions.checkNotNull(env.getRequiredProperty("db.username")));
		ds.setPassword(Preconditions.checkNotNull(env.getRequiredProperty("db.password")));
		return ds;
	}
	
	public Properties properties() {
		Properties p=new Properties();
		p.put("hibernate.dialect", Preconditions.checkNotNull(env.getRequiredProperty("hibernate.dialect")));
		p.put("hibernate.hbm2ddl.auto", Preconditions.checkNotNull(env.getRequiredProperty("hibernate.hbm2ddl.auto")));
		p.put("hibernate.show_sql", Preconditions.checkNotNull(env.getRequiredProperty("hibernate.show_sql")));
		p.put("hibernate.format_sql", Preconditions.checkNotNull(env.getRequiredProperty("hibernate.format_sql")));
		return p;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean emfb=new LocalContainerEntityManagerFactoryBean();
		emfb.setDataSource(dataSource());
		emfb.setPackagesToScan(Preconditions.checkNotNull(env.getRequiredProperty("entitymanager.packages.to.scan")));
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	    emfb.setJpaVendorAdapter(vendorAdapter);
		emfb.setJpaProperties(properties());
		return emfb;		
	}
	
	@Bean
	public JpaTransactionManager transactionManager() {
		JpaTransactionManager txn=new JpaTransactionManager();
		txn.setEntityManagerFactory(entityManagerFactory().getObject());
		return txn;
	}
}
