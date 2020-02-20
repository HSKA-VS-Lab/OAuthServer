package de.hska.iwi.vslab.OAuthServer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public UserDetailsService beanUserDetailsService() {
        return new CustomUserDetailsService();
    }
    
    @Bean(name = "authenticationManager")
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //auth.inMemoryAuthentication().withUser("user").password(passwordEncoder.encode("secret")).roles("USER"); // ROLE_ is added automatically
        //auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder.encode("secret")).roles("ADMIN");
        auth.userDetailsService(userDetailsService);//.passwordEncoder(passwordEncoder);

    }

    /*
    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder().username("user").password(passwordEncoder.encode("secret")).roles("USER").build();
        UserDetails admin = User.withDefaultPasswordEncoder().username("admin").password(passwordEncoder.encode("secret")).roles("USER").build();
        return new InMemoryUserDetailsManager(user, admin);
    }
*/
}
