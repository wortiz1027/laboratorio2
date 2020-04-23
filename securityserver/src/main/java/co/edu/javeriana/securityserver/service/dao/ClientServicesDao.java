package co.edu.javeriana.securityserver.service.dao;

import co.edu.javeriana.securityserver.model.OauthClientDetails;

public interface ClientServicesDao {

    void createClient(OauthClientDetails client);

    boolean isUserAvailable(String clientId);

    OauthClientDetails getClientById(String clientId);

    OauthClientDetails update(OauthClientDetails client);

    void delete(OauthClientDetails client);


}
