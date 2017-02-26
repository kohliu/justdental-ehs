package com.techstomach.ehs.core;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "jd_login_tracking", catalog = "jdehs_dev")
public class JdLoginTracking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loginTrackId")
    @JsonProperty
    private Long loginTrackId;

    @ManyToOne
    @JoinColumn(name = "userId_fk")
    @JsonProperty
    private JdUser userIdFk;

    @Column(name = "appId")
    @NotNull
    @JsonProperty
    private Integer appId;

    @Column(name = "dateCreated", nullable = false)
    @NotNull
    @JsonProperty
    private Date dateCreated;

    @Column(name = "dateModified", nullable = false)
    @NotNull
    @JsonProperty
    private Date dateModified;

    @Column(name = "lastLogin")
    @NotNull
    @JsonProperty
    private Date lastLogin;

    @Column(name = "modifiedBy")
    @NotNull
    @JsonProperty
    private String modifiedBy;

    public Long getLoginTrackId() {
        return loginTrackId;
    }

    public void setLoginTrackId(Long loginTrackId) {
        this.loginTrackId = loginTrackId;
    }

    public JdUser getUserIdFk() {
        return userIdFk;
    }

    public void setUserIdFk(JdUser userIdFk) {
        this.userIdFk = userIdFk;
    }

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
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

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
}
