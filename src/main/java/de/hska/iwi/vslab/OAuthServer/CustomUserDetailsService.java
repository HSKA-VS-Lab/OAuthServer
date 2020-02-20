package de.hska.iwi.vslab.OAuthServer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

public class CustomUserDetailsService implements UserDetailsService {


    //@Autowired
    //private OAuth2RestTemplate restTemplate;

    @Autowired
    private PasswordEncoder encoder;

    //auth.inMemoryAuthentication().withUser("user").password(passwordEncoder.encode("secret")).roles("USER"); // ROLE_ is added automatically
       // auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder.encode("secret")).roles("ADMIN");

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if (username.equals("user")) {
            return User.withUsername("user").username("user").password(encoder.encode("secret")).roles("USER").build();
        } else if (username.equals("admin")) {
            return User.builder().username("admin").password(encoder.encode("secret")).roles("ADMIN").build();
        }
        return User.withUsername("fallback").username("fallback").password(encoder.encode("secret")).roles("ADMIN").build();


/*
        if (username.equals("admin")) {
            UserDetails us = org.springframework.security.core.userdetails.User.withUsername(username)
                .password("admin")
                .authorities("")
                .build();
            return us;
        }
        User[] users = restTemplate.getForObject("http://localhost:8083/user/" + username, User[].class);
        if(users == null || users.length == 0) {
@@ -30,7 +42,7 @@ public UserDetails loadUserByUsername(String username) throws UsernameNotFoundEx
        user.setPassword(encoder.encode(user.getPassword()));
        return user;

*/
    }

}