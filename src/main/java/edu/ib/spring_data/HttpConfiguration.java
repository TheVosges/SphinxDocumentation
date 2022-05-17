package edu.ib.spring_data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
public class HttpConfiguration extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.jdbcAuthentication()
                .usersByUsernameQuery("SELECT u.name, u.password_hash, 1 FROM users u WHERE u.name=?").passwordEncoder(passwordEncoder())
                .authoritiesByUsernameQuery("SELECT u.name, u.role, 1 FROM users u WHERE u.name=?")
                .dataSource(dataSource);

        UserDetailsService userDetails = auth.getDefaultUserDetailsService();

        System.out.println(userDetails.loadUserByUsername("admin").getPassword());
        System.out.println(userDetails.loadUserByUsername("admin").getAuthorities());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

//        http.authorizeRequests().antMatchers("/").permitAll().and()
//                .authorizeRequests().antMatchers("/console/**").permitAll();
////
//        http.headers().frameOptions().disable();

        http.httpBasic().and().authorizeRequests()
                .antMatchers(HttpMethod.GET,"/api/customer/all").hasAuthority("ADMIN")
                .and().csrf()
                .disable();
    }
}
