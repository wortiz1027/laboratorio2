package co.edu.javeriana.securityserver.model;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "oauth_client_details", schema = "securitydb")
@NamedQueries({
        @NamedQuery(name = "OauthClientDetails.findAll", query = "SELECT o FROM OauthClientDetails o")
        , @NamedQuery(name = "OauthClientDetails.findByClientId", query = "SELECT o FROM OauthClientDetails o WHERE o.clientId = :clientId")
        , @NamedQuery(name = "OauthClientDetails.findByResourceId", query = "SELECT o FROM OauthClientDetails o WHERE o.resourceId = :resourceId")
        , @NamedQuery(name = "OauthClientDetails.findByClientSecret", query = "SELECT o FROM OauthClientDetails o WHERE o.clientSecret = :clientSecret")
        , @NamedQuery(name = "OauthClientDetails.findByScope", query = "SELECT o FROM OauthClientDetails o WHERE o.scope = :scope")
        , @NamedQuery(name = "OauthClientDetails.findByAuthorizedGrantTypes", query = "SELECT o FROM OauthClientDetails o WHERE o.authorizedGrantTypes = :authorizedGrantTypes")
        , @NamedQuery(name = "OauthClientDetails.findByWebServerRedirectUri", query = "SELECT o FROM OauthClientDetails o WHERE o.webServerRedirectUri = :webServerRedirectUri")
        , @NamedQuery(name = "OauthClientDetails.findByAuthorities", query = "SELECT o FROM OauthClientDetails o WHERE o.authorities = :authorities")
        , @NamedQuery(name = "OauthClientDetails.findByAccessTokenValidity", query = "SELECT o FROM OauthClientDetails o WHERE o.accessTokenValidity = :accessTokenValidity")
        , @NamedQuery(name = "OauthClientDetails.findByRefreshTokenValidity", query = "SELECT o FROM OauthClientDetails o WHERE o.refreshTokenValidity = :refreshTokenValidity")
        , @NamedQuery(name = "OauthClientDetails.findByAdditionalInformation", query = "SELECT o FROM OauthClientDetails o WHERE o.additionalInformation = :additionalInformation")
        , @NamedQuery(name = "OauthClientDetails.findByAutoapprove", query = "SELECT o FROM OauthClientDetails o WHERE o.autoapprove = :autoapprove")})
public class OauthClientDetails implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "client_id")
    private String clientId;

    @Basic(optional = false)
    @Column(name = "resource_id")
    private String resourceId;

    @Basic(optional = false)
    @Column(name = "client_secret")
    private String clientSecret;

    @Column(name = "scope")
    private String scope;

    @Column(name = "authorized_grant_types")
    private String authorizedGrantTypes;

    @Column(name = "web_server_redirect_uri")
    private String webServerRedirectUri;

    @Column(name = "authorities")
    private String authorities;

    @Column(name = "access_token_validity")
    private BigInteger accessTokenValidity;

    @Column(name = "refresh_token_validity")
    private BigInteger refreshTokenValidity;

    @Column(name = "additional_information")
    private String additionalInformation;

    @Column(name = "autoapprove")
    private String autoapprove;

    public OauthClientDetails() {
    }

    public OauthClientDetails(String clientId) {
        this.clientId = clientId;
    }

    public OauthClientDetails(String clientId, String resourceId, String clientSecret) {
        this.clientId = clientId;
        this.resourceId = resourceId;
        this.clientSecret = clientSecret;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getAuthorizedGrantTypes() {
        return authorizedGrantTypes;
    }

    public void setAuthorizedGrantTypes(String authorizedGrantTypes) {
        this.authorizedGrantTypes = authorizedGrantTypes;
    }

    public String getWebServerRedirectUri() {
        return webServerRedirectUri;
    }

    public void setWebServerRedirectUri(String webServerRedirectUri) {
        this.webServerRedirectUri = webServerRedirectUri;
    }

    public String getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    public BigInteger getAccessTokenValidity() {
        return accessTokenValidity;
    }

    public void setAccessTokenValidity(BigInteger accessTokenValidity) {
        this.accessTokenValidity = accessTokenValidity;
    }

    public BigInteger getRefreshTokenValidity() {
        return refreshTokenValidity;
    }

    public void setRefreshTokenValidity(BigInteger refreshTokenValidity) {
        this.refreshTokenValidity = refreshTokenValidity;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public String getAutoapprove() {
        return autoapprove;
    }

    public void setAutoapprove(String autoapprove) {
        this.autoapprove = autoapprove;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clientId != null ? clientId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OauthClientDetails)) {
            return false;
        }
        OauthClientDetails other = (OauthClientDetails) object;
        if ((this.clientId == null && other.clientId != null) || (this.clientId != null && !this.clientId.equals(other.clientId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "vectores2.OauthClientDetails[ clientId=" + clientId + " ]";
    }

}