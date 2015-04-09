package net.safedata.spring.intro.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class DataSourceConfig implements EnvironmentAware {

    private RelaxedPropertyResolver propertyResolver;

    @Override
    public void setEnvironment(Environment environment) {
        this.propertyResolver = new RelaxedPropertyResolver(environment, "spring.datasource.");
    }

    @Bean(destroyMethod = "close")
    public HikariDataSource dataSource() {
        final HikariConfig config = buildConfig();

        final HikariDataSource dataSource = new HikariDataSource(config);

        dataSource.setAutoCommit(true);

        dataSource.setMinimumIdle(propertyResolver.getProperty("min-idle", Integer.class, 1));
        dataSource.setMaximumPoolSize(propertyResolver.getProperty("max-active", Integer.class, 2));
        dataSource.setConnectionTimeout(propertyResolver.getProperty("max-wait", Integer.class, 3000));

        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        final LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();

        localSessionFactoryBean.setDataSource(dataSource());
        localSessionFactoryBean.setPackagesToScan("net.safedata.spring.intro");

        return localSessionFactoryBean;
    }

    @Bean
    public HibernateTransactionManager transactionManager() {
        return new HibernateTransactionManager(sessionFactory().getObject());
    }

    private HikariConfig buildConfig() {
        final HikariConfig hikariConfig = new HikariConfig();

        hikariConfig.setDataSourceClassName(propertyResolver.getProperty("dataSourceClassName"));
        hikariConfig.addDataSourceProperty("url", propertyResolver.getProperty("url"));
        hikariConfig.addDataSourceProperty("user", propertyResolver.getProperty("username"));
        hikariConfig.addDataSourceProperty("password", propertyResolver.getProperty("password"));

        return hikariConfig;
    }

    /*
    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("classpath:entities-ddl.sql")
                .continueOnError(false)
                .ignoreFailedDrops(false)
                .build();
    }
    */
}
