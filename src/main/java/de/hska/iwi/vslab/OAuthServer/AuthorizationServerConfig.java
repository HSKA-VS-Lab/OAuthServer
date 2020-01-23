package de.hska.iwi.vslab.OAuthServer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.InMemoryAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

//@RequireArgsConstructor
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private TokenStore tokenStore;


    @Autowired
    private PasswordEncoder encoder;


    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        oauthServer.tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()");
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
<<<<<<< Updated upstream
                .withClient("webshop_app")
=======
                .withClient("frontendId")
>>>>>>> Stashed changes
                .authorizedGrantTypes("password", "authorization_code", "refresh_token", "client_credentials")
                .authorities("ROLE_USER", "ROLE_ADMIN")
                .scopes("read", "write")
                .autoApprove(true)
<<<<<<< Updated upstream
                .secret("{noop}clientsecret")
                .and()
                .withClient("Api_Product")
                .authorizedGrantTypes("client_credentials")
                .scopes("read", "write")
                .autoApprove(true)
                .secret("{noop}clientsecret")
                .and()
                .withClient("Api_Role")
                .authorizedGrantTypes("client_credentials")
                .scopes("read", "write")
                .autoApprove(true)
                .secret("{noop}clientsecret")
                .and()
                .withClient("Api_User")
                .authorizedGrantTypes("client_credentials")
                .scopes("read", "write")
                .autoApprove(true)
                .secret("{noop}clientsecret")
                .and()
                .withClient("Comp_Product_Category")
                .authorizedGrantTypes("client_credentials")
                .scopes("read", "write")
                .autoApprove(true)
                .secret("{noop}clientsecret")
                .and()
                .withClient("Comp_User_Role")
                .authorizedGrantTypes("client_credentials")
                .scopes("read", "write")
                .autoApprove(true)
                .secret("{noop}clientsecret")
                .and()
                .withClient("Core_Category")
                .authorizedGrantTypes("client_credentials")
                .scopes("read", "write")
                .autoApprove(true)
                .secret("{noop}clientsecret")
                .and()
                .withClient("Core_Product")
                .authorizedGrantTypes("client_credentials")
                .scopes("read", "write")
                .autoApprove(true)
                .secret("{noop}clientsecret")
                .and()
                .withClient("Core_Role")
                .authorizedGrantTypes("client_credentials")
                .scopes("read", "write")
                .autoApprove(true)
                .secret("{noop}clientsecret")
                .and()
                .withClient("Core_User")
                .authorizedGrantTypes("client_credentials")
                .scopes("read", "write")
                .autoApprove(true)
                .secret("{noop}clientsecret")
                .and()
                .withClient("Zuul")
                .authorizedGrantTypes("client_credentials")
                .scopes("read", "write")
                .autoApprove(true)
                .secret("{noop}clientsecret");
=======
                .secret(encoder.encode("frontendSecret"))
                //TODO: einfügen der anderen Services
                .and()
                .withClient("coreUserId")
                .authorizedGrantTypes("client_credentials")
                .scopes("read", "write")
                .autoApprove(true)
                .secret(encoder.encode("coreUserSecret")).and()
                .withClient("apiUserId")
                .authorizedGrantTypes("client_credentials")
                .scopes("read", "write")
                .autoApprove(true)
                .secret(encoder.encode("apiUserSecret"))
                .and()
                .withClient("zuulId")
                .authorizedGrantTypes("client_credentials")
                .scopes("read", "write")
                .autoApprove(true)
                .secret(encoder.encode("zuulSecret"))
                .and()
                .withClient("oauthId")
                .authorizedGrantTypes("client_credentials")
                .scopes("read", "write")
                .autoApprove(true)
                .secret(encoder.encode("oauthSecret"));
>>>>>>> Stashed changes

    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager)
                .tokenStore(tokenStore)
                .userDetailsService(userDetailsService);
    }

    @Bean
    public TokenStore tokenStore() {
        return new InMemoryTokenStore();
    }


    @Bean
    protected AuthorizationCodeServices authorizationCodeServices() {
        return new InMemoryAuthorizationCodeServices();
    }

<<<<<<< Updated upstream
}
=======
}
>>>>>>> Stashed changes
