package net.safedata.spring.intro.config;

import net.safedata.spring.intro.security.PostAuthFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityConfig.class);

    @SuppressWarnings("unused")
    @EnableGlobalMethodSecurity(prePostEnabled = true, jsr250Enabled = true)
    public static class GlobalSecurityConfiguration extends GlobalMethodSecurityConfiguration {
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("ana").password("spring").roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //http://docs.spring.io/spring-security/site/docs/4.0.0.RELEASE/reference/htmlsingle/#jc-httpsecurity
        
        http.formLogin()
            .loginPage("/j_spring_security_check")
                .usernameParameter("j_username") // defaults to username
                .passwordParameter("j_password") // defaults to password
            .defaultSuccessUrl("/#users")
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
                .deleteCookies("JSESSIONID", "sd-remember-me", "currentAccount")
                .permitAll();

        http.addFilter(postAuthenticationFilter());
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
    public PostAuthFilter postAuthenticationFilter() {
        final PostAuthFilter paf = new PostAuthFilter();

        AuthenticationManager authenticationManager = null;
        try {
            authenticationManager = this.authenticationManager();
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }

        paf.setAuthenticationManager(authenticationManager);

        return paf;
    }
}
