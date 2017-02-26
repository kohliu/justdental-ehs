package com.techstomach.ehs.core;

import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name = "jd_native_login", catalog = "jdehs_dev")
public class JdNativeLogin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loginId")
    @JsonProperty
    private Long loginId;

    @ManyToOne
    @JoinColumn(name = "userId_fk")
    @JsonProperty
    private JdUser userIdFk;

    @Column(name = "uniqueLoginName", nullable = false)
    @NotNull
    @JsonProperty
    private String uniqueLoginName;

    @Column(name = "dateCreated", nullable = false)
    @NotNull
    @JsonProperty
    private Date dateCreated;

    @Column(name = "dateModified", nullable = false)
    @NotNull
    @JsonProperty
    private Date dateModified;

    @Column(name = "lastPasswordChanged", nullable = false)
    @NotNull
    @JsonProperty
    private Date lastPasswordChanged;

    @Column(name = "modifiedBy", nullable = false)
    @NotNull
    @JsonProperty
    private String modifiedBy;

    @Column(name = "passwordAnswer", nullable = false)
    @NotNull
    @JsonProperty
    private String passwordAnswer;

    @Column(name = "passwordKey", nullable = false)
    @NotNull
    @JsonProperty
    private String passwordKey;

    @Column(name = "passwordQuestion", nullable = false)
    @NotNull
    @JsonProperty
    private String passwordQuestion;

    public Long getLoginId() {
        return loginId;
    }

    public void setLoginId(Long loginId) {
        this.loginId = loginId;
    }

    public JdUser getUserIdFk() {
        return userIdFk;
    }

    public void setUserIdFk(JdUser userIdFk) {
        this.userIdFk = userIdFk;
    }

    public Date getLastPasswordChanged() {
        return lastPasswordChanged;
    }

    public void setLastPasswordChanged(Date lastPasswordChanged) {
        this.lastPasswordChanged = lastPasswordChanged;
    }

    public String getPasswordAnswer() {
        return passwordAnswer;
    }

    public void setPasswordAnswer(String passwordAnswer) {
        this.passwordAnswer = passwordAnswer;
    }

    public String getPasswordKey() {
        return passwordKey;
    }

    public void setPasswordKey(String passwordKey) {
        this.passwordKey = passwordKey;
    }

    public String getPasswordQuestion() {
        return passwordQuestion;
    }

    public void setPasswordQuestion(String passwordQuestion) {
        this.passwordQuestion = passwordQuestion;
    }

    public String getUniqueLoginName() {
        return uniqueLoginName;
    }

    public void setUniqueLoginName(String uniqueLoginName) {
        this.uniqueLoginName = uniqueLoginName;
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

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
}
