package SpringMVCDemo7.config;

import java.util.Properties;

import javax.sql.DataSource;
import javax.transaction.TransactionManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration
@PropertySource("classpath:database.properties")
public class HibernateConfig {
	@Autowired
	private Environment env;

	@Bean
	public LocalSessionFactoryBean getSessionFactoryBean() {
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		factoryBean.setDataSource(dataSource());
		factoryBean.setPackagesToScan("SpringMVCDemo7");
		factoryBean.setHibernateProperties(properties());
		return factoryBean;
	}
	
	@Bean
	public HibernateTransactionManager transactionManager() {
		HibernateTransactionManager h = new HibernateTransactionManager();
		h.setSessionFactory(getSessionFactoryBean().getObject());
		return h;
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty("hibernate.connection.driverClass"));
		dataSource.setUrl(env.getProperty("hibernate.url"));
		return dataSource;
	}

	@Bean
	public Properties properties() {
		Properties p = new Properties();
		p.setProperty(org.hibernate.cfg.Environment.SHOW_SQL, env.getProperty("hibernate.showSql"));
		p.setProperty(org.hibernate.cfg.Environment.DIALECT, env.getProperty("hibernate.dialect"));
		return p;
	}
}
