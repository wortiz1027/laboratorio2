package co.edu.javeriana.securityserver.configuration;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.approval.*;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.JdbcAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.request.DefaultOAuth2RequestFactory;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableAuthorizationServer
@SuppressWarnings("deprecation")
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    Logger logger = LoggerFactory.getLogger(AuthorizationServerConfig.class);

    @Autowired
    @Qualifier("authenticationManagerBean")
    private AuthenticationManager authenticationManager;

    @Autowired
    private DataSource dataSource;

    @Autowired
    @Qualifier("customClientDetailsService")
    private ClientDetailsService clientDetailService;

    @Autowired
    @Qualifier("customUserDetailsService")
    private UserDetailsService userDetailsService;

    @Autowired
    @Qualifier("customPasswordEncoder")
    private PasswordEncoder oauthClientPasswordEncoder;

    @Bean
    public JdbcTokenStore tokenStore() {
        return new JdbcTokenStore(dataSource);
    }

    @Bean
    protected AuthorizationCodeServices authorizationCodeServices() {
        return new JdbcAuthorizationCodeServices(dataSource);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                .tokenStore(tokenStore())
                .userApprovalHandler(userApprovalHandler())
                .authenticationManager(this.authenticationManager)
                .authorizationCodeServices(authorizationCodeServices())
                .userDetailsService(this.userDetailsService);
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) {
        oauthServer.tokenKeyAccess("permitAll()")
                //.checkTokenAccess("isAuthenticated()")
                .checkTokenAccess("permitAll()")
                .passwordEncoder(this.oauthClientPasswordEncoder)
                .allowFormAuthenticationForClients();
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        // Con los datos del cliente en base de datos
        clients.withClientDetails(clientDetailService);

        // Con los datos del cliente en memoria
			/*clients
				.inMemory()
					.withClient("cotizaciones_app")
						.authorizedGrantTypes("authorization_code")
						.authorities("USER")
						.scopes("user_info")
						.resourceIds("cotizaciones_service")
						.secret(oauthClientPasswordEncoder.encode("957254c06ba79806dfa64591f6942613"))
						.accessTokenValiditySeconds(300)
						.refreshTokenValiditySeconds(600)
						.autoApprove(true)
                        .redirectUris("http://localhost:8082/cotizaciones/login/oauth2/code/");*/
    }

    @Bean
    @Primary
    public DefaultTokenServices tokenServices() {
        DefaultTokenServices tokenServices = new DefaultTokenServices();
        tokenServices.setSupportRefreshToken(true);
        tokenServices.setTokenStore(tokenStore());
        return tokenServices;
    }

    @Bean
    public PersistentTokenRepository customPersistentTokenRepository() {
        JdbcTokenRepositoryImpl db = new JdbcTokenRepositoryImpl();
        db.setDataSource(dataSource);

        return db;
    }

    @Bean
    public UserApprovalHandler userApprovalHandler() {
        ApprovalStoreUserApprovalHandler userApprovalHandler= new ApprovalStoreUserApprovalHandler();
        userApprovalHandler.setApprovalStore(approvalStore());
        userApprovalHandler.setClientDetailsService(clientDetailService);
        userApprovalHandler.setRequestFactory(requestFactory());
        return userApprovalHandler;
    }

    @Bean
    public ApprovalStore approvalStore() {
        return new JdbcApprovalStore(dataSource);
    }

    @Bean
    public DefaultOAuth2RequestFactory requestFactory(){
        return new DefaultOAuth2RequestFactory(clientDetailService);
    }

    @Bean
    @Autowired
    public ApprovalStore approvalStore(TokenStore tokenStore) throws Exception {
        TokenApprovalStore store = new TokenApprovalStore();
        store.setTokenStore(tokenStore);
        return store;
    }

}