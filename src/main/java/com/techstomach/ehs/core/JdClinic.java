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
@Table(name = "jd_clinic", catalog = "jdehs_dev")
public class JdClinic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "clinicId")
    @JsonProperty
    private Long clinicId;

    @Column(name = "dateCreated", nullable = false)
    @NotNull
    @JsonProperty
    private Date dateCreated;

    @Column(name = "dateModified", nullable = false)
    @NotNull
    @JsonProperty
    private Date dateModified;

    @Column(name = "city", nullable = false)
    @NotNull
    @JsonProperty
    private String city;

    @Column(name = "clinicName", nullable = false)
    @NotNull
    @JsonProperty
    private String clinicName;

    @Column(name = "clinicType")
    @NotNull
    @JsonProperty
    private String clinicType;

    @Column(name = "country", nullable = false)
    @NotNull
    @JsonProperty
    private String country;

    @Column(name = "daysAvailable")
    @NotNull
    @JsonProperty
    private String daysAvailable;

    @Column(name = "gmap", nullable = false)
    @NotNull
    @JsonProperty
    private String gmap;

    @Column(name = "isActive", nullable = false)
    @NotNull
    @JsonProperty
	private Integer isActive;

    @Column(name = "locality", nullable = false)
    @NotNull
    @JsonProperty
    private String locality;

    @Column(name = "modifiedBy", nullable = false)
    @NotNull
    @JsonProperty
    private String modifiedBy;

    @Column(name = "notification")
    @NotNull
    @JsonProperty
    private String notification;

    @Column(name = "pincode")
    @NotNull
    @JsonProperty
    private Long pincode;

    @Column(name = "primaryContactName", nullable = false)
    @NotNull
    @JsonProperty
    private String primaryContactName;

    @Column(name = "primaryContactNumber", nullable = false)
    @NotNull
    @JsonProperty
    private Long primaryContactNumber;

    @Column(name = "state", nullable = false)
    @NotNull
    @JsonProperty
    private String state;

    @Column(name = "street1", nullable = false)
    @NotNull
    @JsonProperty
    private String street1;

    @Column(name = "street2", nullable = false)
    @NotNull
    @JsonProperty
    private String street2;

    @Column(name = "taxNumber", nullable = false)
    @NotNull
    @JsonProperty
	private String taxNumber;

    @Column(name = "workingHours")
    @NotNull
    @JsonProperty
    private String workingHours;

    public Long getClinicId() {
        return clinicId;
    }

    public void setClinicId(Long clinicId) {
        this.clinicId = clinicId;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getClinicName() {
        return clinicName;
    }

    public void setClinicName(String cliniNname) {
        this.clinicName = cliniNname;
    }

    public String getClinicType() {
        return clinicType;
    }

    public void setClinicType(String clinicType) {
        this.clinicType = clinicType;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDaysAvailable() {
        return daysAvailable;
    }

    public void setDaysAvailable(String daysAvailable) {
        this.daysAvailable = daysAvailable;
    }

    public String getGmap() {
        return gmap;
    }

    public void setGmap(String gmap) {
        this.gmap = gmap;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public String getNotification() {
        return notification;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }

    public Long getPincode() {
        return pincode;
    }

    public void setPincode(Long pincode) {
        this.pincode = pincode;
    }

    public String getPrimaryContactName() {
        return primaryContactName;
    }

    public void setPrimaryContactName(String primaryContactName) {
        this.primaryContactName = primaryContactName;
    }

    public Long getPrimaryContactNumber() {
        return primaryContactNumber;
    }

    public void setPrimaryContactNumber(Long primaryContactNumber) {
        this.primaryContactNumber = primaryContactNumber;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    public String getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(String workingHours) {
        this.workingHours = workingHours;
    }
}
