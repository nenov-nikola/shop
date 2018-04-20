//package com.store.configuration;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().anyRequest().authenticated()
//                .antMatchers("/v1/api/commodities", "/v1/api/login").hasAnyRole("ADMIN","USER")
//                .antMatchers("/v1/api/get-commodity/**").hasRole("ADMIN")
//                .antMatchers("/v1/api/delete-commodity/**").hasRole("ADMIN")
//                .antMatchers("/v1/api/add-commodity/**").hasRole("ADMIN")
//                .antMatchers("/v1/api/update-commodity/**").hasRole("ADMIN")
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .permitAll();
//    }
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("nikola").password("123").roles("USER");
//        auth.inMemoryAuthentication().withUser("nenov").password("123").roles("ADMIN");
//    }
//
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
//    }
//
//}
