package de.hska.iwi.vslab.OAuthServer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
<<<<<<< Updated upstream
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomUserDetailsService implements UserDetailsService {

    private static final Logger log = LoggerFactory.getLogger(CustomUserDetailsService.class);
=======

public class CustomUserDetailsService implements UserDetailsService{
>>>>>>> Stashed changes

    @Autowired
    private OAuth2RestTemplate restTemplate;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

<<<<<<< Updated upstream
        try {
            UrlBuilder urlBuilder = new UrlBuilder();
            log.info("URL:" + urlBuilder.getUserUrl(username));
            User user = restTemplate.getForObject(urlBuilder.getUserUrl(username), User.class);

        if(user == null) {
            throw new UsernameNotFoundException("User with username = " + username + " not found");
        }

        //user.setPassword(encoder.encode(user.getPassword()));

        return user;

        } catch (Exception e) {
            System.out.println(e);
            throw e;
        }

    }
=======
        User[] users = restTemplate.getForObject("http://localhost:8083/user/" + username, User[].class);
        if(users == null || users.length == 0) {
            throw new UsernameNotFoundException("User with username = " + username + " not found");
        }

        User user = users[0];
        user.setPassword(encoder.encode(user.getPassword()));

        return user;

    }

>>>>>>> Stashed changes
}
