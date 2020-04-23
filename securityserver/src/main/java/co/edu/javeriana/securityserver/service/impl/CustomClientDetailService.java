package co.edu.javeriana.securityserver.service.impl;

import java.util.*;

import co.edu.javeriana.securityserver.model.OauthClientDetails;
import co.edu.javeriana.securityserver.repository.OAuthClientRepository;
import co.edu.javeriana.securityserver.service.dao.ClientServicesDao;
import co.edu.javeriana.securityserver.utils.Constants;
import co.edu.javeriana.securityserver.utils.InfoLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Transactional
@Service("customClientDetailsService")
@SuppressWarnings("deprecation")
public class CustomClientDetailService implements ClientDetailsService, ClientServicesDao {

    @Autowired
    private OAuthClientRepository repository;

    @Override
    @InfoLogger(origen = "loadClientByClientId")
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {

        if (repository.isClientAvailable(clientId) == 0){
            throw new ClientRegistrationException(String.format(Constants.MSG_ERROR_CLIENTE_NO_REGISTRADO, clientId));
        }

        OauthClientDetails client = repository.loadClientById(clientId);

        BaseClientDetails clientDetails = new BaseClientDetails();

        List<String> authorities = Arrays.asList(client.getAuthorizedGrantTypes().split(","));

        List<GrantedAuthority> authoritiesList = new ArrayList<GrantedAuthority>();

        for (String s : authorities){
            authoritiesList.add(new SimpleGrantedAuthority(s));
        }

        Set<String> uris = new HashSet<String>(Arrays.asList(client.getWebServerRedirectUri().split(",")));

        clientDetails.setClientId(client.getClientId());
        clientDetails.setScope(Arrays.asList(client.getScope().split(",")));
        clientDetails.setAuthorizedGrantTypes(Arrays.asList(client.getAuthorizedGrantTypes().split(",")));
        clientDetails.setAuthorities(authoritiesList);
        clientDetails.setAccessTokenValiditySeconds(client.getAccessTokenValidity().intValue());
        clientDetails.setClientSecret(client.getClientSecret());
        clientDetails.setRegisteredRedirectUri(uris);
        clientDetails.setResourceIds(Arrays.asList(client.getResourceId().split(",")));

        String approve = client.getAutoapprove() == null ? "false" : "true";

        if(approve.equalsIgnoreCase("true"))
            clientDetails.setAutoApproveScopes(StringUtils.commaDelimitedListToSet(client.getAutoapprove()));
        else
            clientDetails.setAutoApproveScopes(new HashSet<String>());

        return clientDetails;
    }

    @Override
    public void createClient(OauthClientDetails client) {
        if (client != null){
            repository.save(client);
        }
    }

    @Override
    public boolean isUserAvailable(String clientId) {
        if (clientId != null){
            repository.isClientAvailable(clientId);
        }

        return false;
    }

    @Override
    public OauthClientDetails getClientById(String clientId) {

        OauthClientDetails client = null;

        if (!clientId.equalsIgnoreCase("")){
            client = repository.loadClientById(clientId);
        }

        return client;
    }

    @Override
    public OauthClientDetails update(OauthClientDetails client) {
        return null;
    }

    @Override
    public void delete(OauthClientDetails client) {

    }

}