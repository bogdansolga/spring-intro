package net.safedata.spring.intro.config;

import net.safedata.spring.intro.security.SuccessfulAuthHandler;
import net.safedata.spring.intro.security.UnsuccessfulAuthHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.sql.DataSource;

@Configuration
@AutoConfigureAfter(DataSourceConfig.class)
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, jsr250Enabled = true, securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter implements EnvironmentAware {

    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityConfig.class);

    private RelaxedPropertyResolver propertyResolver;

    @Autowired
    private DataSource dataSource;

    @Override
    public void setEnvironment(Environment environment) {
        this.propertyResolver = new RelaxedPropertyResolver(environment, "spring.security.auth.");
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder()).init(auth);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //http://docs.spring.io/spring-security/site/docs/4.0.0.RELEASE/reference/htmlsingle/#jc-httpsecurity
        
        http.formLogin()
            .loginPage("/j_spring_security_check")
                .usernameParameter("j_username") // defaults to username
                .passwordParameter("j_password") // defaults to password
            .defaultSuccessUrl("/#users")
            .failureUrl("/#home")
            .successHandler(successfulAuthHandler())
            .failureHandler(unsuccessfulAuthHandler())
        .permitAll();

        http.logout()
            .logoutUrl("/j_spring_security_logout")
        .permitAll();

        http.csrf().disable();
        http.headers()
            .xssProtection().disable()
            .frameOptions().disable()
            .contentTypeOptions().disable()
            .cacheControl().disable();

        http.sessionManagement()
            .sessionAuthenticationErrorUrl("/#")
            .invalidSessionUrl("/#")
            .and().authorizeRequests().antMatchers(
                "/*/user/**",
                "/*/product/**"
        ).access("authenticated");

        http.logout()
                .invalidateHttpSession(true)
                .logoutSuccessUrl("/#home")
                .deleteCookies("JSESSIONID")
                .permitAll();

        //http.addFilterBefore(postAuthenticationFilter(), BasicAuthenticationFilter.class);
    }

    @Override
    public void configure(final WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/index.html")
                .antMatchers("/templates/**")
                .antMatchers("/js/**")
                .antMatchers("/css/**");
    }

    @Bean
    public SuccessfulAuthHandler successfulAuthHandler() {
        return new SuccessfulAuthHandler();
    }

    @Bean
    public UnsuccessfulAuthHandler unsuccessfulAuthHandler() {
        return new UnsuccessfulAuthHandler();
    }

    @Override
    public UserDetailsService userDetailsService() {
        JdbcDaoImpl userDetailsService = new JdbcDaoImpl();

        userDetailsService.setDataSource(dataSource);
        userDetailsService.setUsersByUsernameQuery(propertyResolver.getProperty("usersByUsernameQuery"));
        userDetailsService.setAuthoritiesByUsernameQuery(propertyResolver.getProperty("authoritiesByUsernameQuery"));

        return userDetailsService;
    }
}
