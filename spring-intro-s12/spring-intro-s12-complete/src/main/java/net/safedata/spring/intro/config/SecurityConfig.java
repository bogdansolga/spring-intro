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
        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
        auth.eraseCredentials(true);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.formLogin().permitAll().loginPage("/#login")
                .and()
                .csrf().disable()
                .headers()
                .frameOptions().disable();

        http.sessionManagement()
            .sessionAuthenticationErrorUrl("/#")
            .invalidSessionUrl("/#")
            .and().authorizeRequests().antMatchers(
                "/user/**",
                "/product/**"
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
