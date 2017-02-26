package com.techstomach.ehs.core;

import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "jd_sso_login", catalog = "jdehs_dev")
public class JdSsoLogin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ssoLoginId")
    @JsonProperty
    private Long ssoLoginId;

    @ManyToOne
    @JoinColumn(name = "userId_fk")
    @JsonProperty
    private JdUser userIdFk;

    @Column(name = "dateCreated", nullable = false)
    @NotNull
    @JsonProperty
    private Date dateCreated;

    @Column(name = "dateModified", nullable = false)
    @NotNull
    @JsonProperty
    private Date dateModified;

    @Column(name = "providerUniqueId")
    @NotNull
    @JsonProperty
    private String providerUniqueId;

    @Column(name = "tokenExpiryDate")
    @NotNull
    @JsonProperty
    private Date tokenExpiryDate;

    @Column(name = "tokenId")
    @NotNull
    @JsonProperty
    private String tokenId;

    public Long getSsoLoginId() {
        return ssoLoginId;
    }

    public void setSsoLoginId(Long ssoLoginId) {
        this.ssoLoginId = ssoLoginId;
    }

    public JdUser getUserIdFk() {
        return userIdFk;
    }

    public void setUserIdFk(JdUser userIdFk) {
        this.userIdFk = userIdFk;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    public String getProviderUniqueId() {
        return providerUniqueId;
    }

    public void setProviderUniqueId(String providerUniqueId) {
        this.providerUniqueId = providerUniqueId;
    }

    public Date getTokenExpiryDate() {
        return tokenExpiryDate;
    }

    public void setTokenExpiryDate(Date tokenExpiryDate) {
        this.tokenExpiryDate = tokenExpiryDate;
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }
}
