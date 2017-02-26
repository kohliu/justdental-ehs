package com.techstomach.ehs.core;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name = "jd_role", catalog = "jdehs_dev")
public class JdRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roleId")
    @JsonProperty
    private Long roleId;

    @Column(name = "dateCreated", nullable = false)
    @NotNull
    @JsonProperty
    private Date dateCreated;

    @Column(name = "dateModified", nullable = false)
    @NotNull
    @JsonProperty
    private Date dateModified;

    @Column(name = "isActive", nullable = false)
    @NotNull
    @JsonProperty
    private Integer isActive = 0;

    @Column(name = "modifiedBy", nullable = false)
    @NotNull
    @JsonProperty
    private String modifiedBy;

    @Column(name = "roleDescription", nullable = false)
    @NotNull
    @JsonProperty
    private String roleDescription;

    @Column(name = "roleName", nullable = false)
    @NotNull
    @JsonProperty
    private String roleName;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
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

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JdRole jdRole = (JdRole) o;

        if (!dateCreated.equals(jdRole.dateCreated)) return false;
        if (!dateModified.equals(jdRole.dateModified)) return false;
        if (!isActive.equals(jdRole.isActive)) return false;
        if (!modifiedBy.equals(jdRole.modifiedBy)) return false;
        if (!roleDescription.equals(jdRole.roleDescription)) return false;
        return roleName.equals(jdRole.roleName);
    }

    @Override
    public int hashCode() {
        int result = dateCreated.hashCode();
        result = 31 * result + dateModified.hashCode();
        result = 31 * result + isActive.hashCode();
        result = 31 * result + modifiedBy.hashCode();
        result = 31 * result + roleDescription.hashCode();
        result = 31 * result + roleName.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "JdRole{" +
                "roleId=" + roleId +
                ", dateCreated=" + dateCreated +
                ", dateModified=" + dateModified +
                ", isActive=" + isActive +
                ", modifiedBy='" + modifiedBy + '\'' +
                ", roleDescription='" + roleDescription + '\'' +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
