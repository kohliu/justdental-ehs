package com.techstomach.ehs.core;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "jd_user", catalog = "jdehs_dev")
public class JdUser {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    @JsonProperty
    private Long userId;

    @Column(name = "dateCreated", nullable = false)
    @NotNull
    @JsonProperty
    private Date dateCreated;

    @Column(name = "dateModified", nullable = false)
    @NotNull
    @JsonProperty
    private Date dateModified;

    @Column(name = "emailAddress", nullable = false)
    @NotNull
    @JsonProperty
    private String emailAddress;

    @Column(name = "firstName", nullable = false)
    @NotNull
    @JsonProperty
    private String firstName;

    @Column(name = "isActive", nullable = false)
    @NotNull
    @JsonProperty
    private Integer isActive;

    //	/** Field mapping. */
//	private Set<JdAppointment> jdAppointments = new HashSet<JdAppointment>();
//
//	/** Field mapping. */
//	private Set<JdBookingSlots> jdBookingSlotss = new HashSet<JdBookingSlots>();
//
//	/** Field mapping. */
//	private Set<JdClinicRoleMap> jdClinicRoleMaps = new HashSet<JdClinicRoleMap>();
//
//	/** Field mapping. */
//	private Set<JdDiagnosticChart> jdDiagnosticCharts = new HashSet<JdDiagnosticChart>();
//
//	/** Field mapping. */
//	private Set<JdInvoice> jdInvoices = new HashSet<JdInvoice>();
//
//	/** Field mapping. */
//    private Set<JdLoginTracking> jdLoginTrackings = new HashSet<JdLoginTracking>();
//
//	/** Field mapping. */
//	private Set<JdPatientMedicalChart> jdPatientMedicalCharts = new HashSet<JdPatientMedicalChart>();
//
//	/** Field mapping. */
//	private Set<JdPatientMedication> jdPatientMedications = new HashSet<JdPatientMedication>();
//
//	/** Field mapping. */
//	private Set<JdTreatmentPlan> jdTreatmentPlans = new HashSet<JdTreatmentPlan>();

    @Column(name = "lastName", nullable = false)
    @NotNull
    @JsonProperty
    private String lastName;

    @Column(name = "licenseNumber", nullable = false)
    @NotNull
    @JsonProperty
    private String licenseNumber;

    @Column(name = "middleName", nullable = false)
    @NotNull
    @JsonProperty
    private String middleName;

    @Column(name = "modifiedBy", nullable = false)
    @NotNull
    @JsonProperty
    private String modifiedBy;

    @Column(name = "phoneNumber", nullable = false)
    @NotNull
    @JsonProperty
    private String phoneNumber;

    @Column(name = "qualification", nullable = false)
    @NotNull
    @JsonProperty
    private String qualification;

    @ManyToOne
    @JoinColumn(name = "roleId_fk")
    @JsonProperty
    private JdRole roleId;

    @Column(name = "specialization", nullable = false)
    @NotNull
    @JsonProperty
    private String specialization;

    @Column(name = "userType", nullable = false)
    @NotNull
    @JsonProperty
    private String userType;

    public JdRole getRoleId() {
        return roleId;
    }

    public void setRoleId(JdRole roleId) {
        this.roleId = roleId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }


    //    /**
//     * Return the value associated with the column: jdAppointment.
//	 * @return A Set&lt;JdAppointment&gt; object (this.jdAppointment)
//	 */
// 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "useridFk"  )
// 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
//	@Basic( optional = false )
//	@Column( nullable = false  )
//	public Set<JdAppointment> getJdAppointments() {
//		return this.jdAppointments;
//
//	}
//
//	/**
//	 * Adds a bi-directional link of type JdAppointment to the jdAppointments set.
//	 * @param jdAppointment item to add
//	 */
//	public void addJdAppointment(JdAppointment jdAppointment) {
//		jdAppointment.setUseridFk(this);
//		this.jdAppointments.add(jdAppointment);
//	}
//
//
//    /**
//     * Set the value related to the column: jdAppointment.
//	 * @param jdAppointment the jdAppointment value you wish to set
//	 */
//	public void setJdAppointments(final Set<JdAppointment> jdAppointment) {
//		this.jdAppointments = jdAppointment;
//	}

//    /**
//     * Return the value associated with the column: jdBookingSlots.
//	 * @return A Set&lt;JdBookingSlots&gt; object (this.jdBookingSlots)
//	 */
// 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "useridFk"  )
// 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
//	@Basic( optional = false )
//	@Column( nullable = false  )
//	public Set<JdBookingSlots> getJdBookingSlotss() {
//		return this.jdBookingSlotss;
//
//	}
//
//	/**
//	 * Adds a bi-directional link of type JdBookingSlots to the jdBookingSlotss set.
//	 * @param jdBookingSlots item to add
//	 */
//	public void addJdBookingSlots(JdBookingSlots jdBookingSlots) {
//		jdBookingSlots.setUseridFk(this);
//		this.jdBookingSlotss.add(jdBookingSlots);
//	}
//
//
//    /**
//     * Set the value related to the column: jdBookingSlots.
//	 * @param jdBookingSlots the jdBookingSlots value you wish to set
//	 */
//	public void setJdBookingSlotss(final Set<JdBookingSlots> jdBookingSlots) {
//		this.jdBookingSlotss = jdBookingSlots;
//	}

//    /**
//     * Return the value associated with the column: jdClinicRoleMap.
//	 * @return A Set&lt;JdClinicRoleMap&gt; object (this.jdClinicRoleMap)
//	 */
// 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "useridFk"  )
// 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
//	@Basic( optional = false )
//	@Column( nullable = false  )
//	public Set<JdClinicRoleMap> getJdClinicRoleMaps() {
//		return this.jdClinicRoleMaps;
//
//	}
//
//	/**
//	 * Adds a bi-directional link of type JdClinicRoleMap to the jdClinicRoleMaps set.
//	 * @param jdClinicRoleMap item to add
//	 */
//	public void addJdClinicRoleMap(JdClinicRoleMap jdClinicRoleMap) {
//		jdClinicRoleMap.setUseridFk(this);
//		this.jdClinicRoleMaps.add(jdClinicRoleMap);
//	}
//
//
//    /**
//     * Set the value related to the column: jdClinicRoleMap.
//	 * @param jdClinicRoleMap the jdClinicRoleMap value you wish to set
//	 */
//	public void setJdClinicRoleMaps(final Set<JdClinicRoleMap> jdClinicRoleMap) {
//		this.jdClinicRoleMaps = jdClinicRoleMap;
//	}
//
//    /**
//     * Return the value associated with the column: jdDiagnosticChart.
//	 * @return A Set&lt;JdDiagnosticChart&gt; object (this.jdDiagnosticChart)
//	 */
// 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "useridFk"  )
// 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
//	@Basic( optional = false )
//	@Column( nullable = false  )
//	public Set<JdDiagnosticChart> getJdDiagnosticCharts() {
//		return this.jdDiagnosticCharts;
//
//	}
//
//	/**
//	 * Adds a bi-directional link of type JdDiagnosticChart to the jdDiagnosticCharts set.
//	 * @param jdDiagnosticChart item to add
//	 */
//	public void addJdDiagnosticChart(JdDiagnosticChart jdDiagnosticChart) {
//		jdDiagnosticChart.setUseridFk(this);
//		this.jdDiagnosticCharts.add(jdDiagnosticChart);
//	}
//
//
//    /**
//     * Set the value related to the column: jdDiagnosticChart.
//	 * @param jdDiagnosticChart the jdDiagnosticChart value you wish to set
//	 */
//	public void setJdDiagnosticCharts(final Set<JdDiagnosticChart> jdDiagnosticChart) {
//		this.jdDiagnosticCharts = jdDiagnosticChart;
//	}
//
//    /**
//     * Return the value associated with the column: jdInvoice.
//	 * @return A Set&lt;JdInvoice&gt; object (this.jdInvoice)
//	 */
// 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "useridFk"  )
// 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
//	@Basic( optional = false )
//	@Column( nullable = false  )
//	public Set<JdInvoice> getJdInvoices() {
//		return this.jdInvoices;
//
//	}
//
//	/**
//	 * Adds a bi-directional link of type JdInvoice to the jdInvoices set.
//	 * @param jdInvoice item to add
//	 */
//	public void addJdInvoice(JdInvoice jdInvoice) {
//		jdInvoice.setUseridFk(this);
//		this.jdInvoices.add(jdInvoice);
//	}
//
//
//    /**
//     * Set the value related to the column: jdInvoice.
//	 * @param jdInvoice the jdInvoice value you wish to set
//	 */
//	public void setJdInvoices(final Set<JdInvoice> jdInvoice) {
//		this.jdInvoices = jdInvoice;
//	}
//
//    /**
//     * Return the value associated with the column: jdLoginTracking.
//	 * @return A Set&lt;JdLoginTracking&gt; object (this.jdLoginTracking)
//	 */
// 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "useridFk"  )
// 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
//	@Basic( optional = false )
//	@Column( nullable = false  )
//	public Set<JdLoginTracking> getJdLoginTrackings() {
//		return this.jdLoginTrackings;
//
//	}
//
//	/**
//	 * Adds a bi-directional link of type JdLoginTracking to the jdLoginTrackings set.
//	 * @param jdLoginTracking item to add
//	 */
//	public void addJdLoginTracking(JdLoginTracking jdLoginTracking) {
//		jdLoginTracking.setUserIdFk(this);
//		this.jdLoginTrackings.add(jdLoginTracking);
//	}
//
//
//    /**
//     * Set the value related to the column: jdLoginTracking.
//	 * @param jdLoginTracking the jdLoginTracking value you wish to set
//	 */
//	public void setJdLoginTrackings(final Set<JdLoginTracking> jdLoginTracking) {
//		this.jdLoginTrackings = jdLoginTracking;
//	}
//
//    /**
//     * Return the value associated with the column: jdPatientMedicalChart.
//	 * @return A Set&lt;JdPatientMedicalChart&gt; object (this.jdPatientMedicalChart)
//	 */
// 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "useridFk"  )
// 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
//	@Basic( optional = false )
//	@Column( nullable = false  )
//	public Set<JdPatientMedicalChart> getJdPatientMedicalCharts() {
//		return this.jdPatientMedicalCharts;
//
//	}
//
//	/**
//	 * Adds a bi-directional link of type JdPatientMedicalChart to the jdPatientMedicalCharts set.
//	 * @param jdPatientMedicalChart item to add
//	 */
//	public void addJdPatientMedicalChart(JdPatientMedicalChart jdPatientMedicalChart) {
//		jdPatientMedicalChart.setUseridFk(this);
//		this.jdPatientMedicalCharts.add(jdPatientMedicalChart);
//	}
//
//
//    /**
//     * Set the value related to the column: jdPatientMedicalChart.
//	 * @param jdPatientMedicalChart the jdPatientMedicalChart value you wish to set
//	 */
//	public void setJdPatientMedicalCharts(final Set<JdPatientMedicalChart> jdPatientMedicalChart) {
//		this.jdPatientMedicalCharts = jdPatientMedicalChart;
//	}
//
//    /**
//     * Return the value associated with the column: jdPatientMedication.
//	 * @return A Set&lt;JdPatientMedication&gt; object (this.jdPatientMedication)
//	 */
// 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "useridFk"  )
// 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
//	@Basic( optional = false )
//	@Column( nullable = false  )
//	public Set<JdPatientMedication> getJdPatientMedications() {
//		return this.jdPatientMedications;
//
//	}
//
//	/**
//	 * Adds a bi-directional link of type JdPatientMedication to the jdPatientMedications set.
//	 * @param jdPatientMedication item to add
//	 */
//	public void addJdPatientMedication(JdPatientMedication jdPatientMedication) {
//		jdPatientMedication.setUseridFk(this);
//		this.jdPatientMedications.add(jdPatientMedication);
//	}
//
//
//    /**
//     * Set the value related to the column: jdPatientMedication.
//	 * @param jdPatientMedication the jdPatientMedication value you wish to set
//	 */
//	public void setJdPatientMedications(final Set<JdPatientMedication> jdPatientMedication) {
//		this.jdPatientMedications = jdPatientMedication;
//	}
//
//    /**
//     * Return the value associated with the column: jdTreatmentPlan.
//	 * @return A Set&lt;JdTreatmentPlan&gt; object (this.jdTreatmentPlan)
//	 */
// 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "useridFk"  )
// 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
//	@Basic( optional = false )
//	@Column( nullable = false  )
//	public Set<JdTreatmentPlan> getJdTreatmentPlans() {
//		return this.jdTreatmentPlans;
//
//	}
//
//	/**
//	 * Adds a bi-directional link of type JdTreatmentPlan to the jdTreatmentPlans set.
//	 * @param jdTreatmentPlan item to add
//	 */
//	public void addJdTreatmentPlan(JdTreatmentPlan jdTreatmentPlan) {
//		jdTreatmentPlan.setUseridFk(this);
//		this.jdTreatmentPlans.add(jdTreatmentPlan);
//	}
//
//
//    /**
//     * Set the value related to the column: jdTreatmentPlan.
//	 * @param jdTreatmentPlan the jdTreatmentPlan value you wish to set
//	 */
//	public void setJdTreatmentPlans(final Set<JdTreatmentPlan> jdTreatmentPlan) {
//		this.jdTreatmentPlans = jdTreatmentPlan;
//	}
//
//    /**
//     * Return the value associated with the column: lastname.
//	 * @return A String object (this.lastname)
//	 */
//	@Basic( optional = true )
//	@Column( length = 255  )
//	public String getLastname() {
//		return this.lastname;
//
//	}
//
//
//
//    /**
//     * Set the value related to the column: lastname.
//	 * @param lastname the lastname value you wish to set
//	 */
//	public void setLastname(final String lastname) {
//		this.lastname = lastname;
//	}
//
//    /**
//     * Return the value associated with the column: licensenumber.
//	 * @return A String object (this.licensenumber)
//	 */
//	@Basic( optional = true )
//	@Column( length = 255  )
//	public String getLicensenumber() {
//		return this.licensenumber;
//
//	}
//
//
//
//    /**
//     * Set the value related to the column: licensenumber.
//	 * @param licensenumber the licensenumber value you wish to set
//	 */
//	public void setLicensenumber(final String licensenumber) {
//		this.licensenumber = licensenumber;
//	}
//
//    /**
//     * Return the value associated with the column: middlename.
//	 * @return A String object (this.middlename)
//	 */
//	@Basic( optional = true )
//	@Column( length = 255  )
//	public String getMiddlename() {
//		return this.middlename;
//
//	}
//
//
//
//    /**
//     * Set the value related to the column: middlename.
//	 * @param middlename the middlename value you wish to set
//	 */
//	public void setMiddlename(final String middlename) {
//		this.middlename = middlename;
//	}
//
//    /**
//     * Return the value associated with the column: modifiedby.
//	 * @return A String object (this.modifiedby)
//	 */
//	@Basic( optional = false )
//	@Column( nullable = false, length = 255  )
//	public String getModifiedby() {
//		return this.modifiedby;
//
//	}
//
//
//
//    /**
//     * Set the value related to the column: modifiedby.
//	 * @param modifiedby the modifiedby value you wish to set
//	 */
//	public void setModifiedby(final String modifiedby) {
//		this.modifiedby = modifiedby;
//	}
//
//    /**
//     * Return the value associated with the column: phonenumber.
//	 * @return A String object (this.phonenumber)
//	 */
//	@Basic( optional = true )
//	@Column( length = 255  )
//	public String getPhonenumber() {
//		return this.phonenumber;
//
//	}
//
//
//
//    /**
//     * Set the value related to the column: phonenumber.
//	 * @param phonenumber the phonenumber value you wish to set
//	 */
//	public void setPhonenumber(final String phonenumber) {
//		this.phonenumber = phonenumber;
//	}
//
//    /**
//     * Return the value associated with the column: qualification.
//	 * @return A String object (this.qualification)
//	 */
//	@Basic( optional = true )
//	@Column( length = 255  )
//	public String getQualification() {
//		return this.qualification;
//
//	}
//
//
//
//    /**
//     * Set the value related to the column: qualification.
//	 * @param qualification the qualification value you wish to set
//	 */
//	public void setQualification(final String qualification) {
//		this.qualification = qualification;
//	}
//
//    /**
//     * Return the value associated with the column: roleidFk.
//	 * @return A JdRole object (this.roleidFk)
//	 */
//	@ManyToOne( cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY )
//	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
//	@Basic( optional = false )
//	@JoinColumn(name = "roleId_fk", nullable = false )
//	public JdRole getRoleidFk() {
//		return this.roleidFk;
//
//	}
//
//
//
//    /**
//     * Set the value related to the column: roleidFk.
//	 * @param roleidFk the roleidFk value you wish to set
//	 */
//	public void setRoleidFk(final JdRole roleidFk) {
//		this.roleidFk = roleidFk;
//	}
//
//    /**
//     * Return the value associated with the column: specialization.
//	 * @return A String object (this.specialization)
//	 */
//	@Basic( optional = true )
//	@Column( length = 255  )
//	public String getSpecialization() {
//		return this.specialization;
//
//	}
//
//
//
//    /**
//     * Set the value related to the column: specialization.
//	 * @param specialization the specialization value you wish to set
//	 */
//	public void setSpecialization(final String specialization) {
//		this.specialization = specialization;
//	}
//
//    /**
//     * Return the value associated with the column: usertype.
//	 * @return A String object (this.usertype)
//	 */
//	@Basic( optional = true )
//	@Column( length = 255  )
//	public String getUsertype() {
//		return this.usertype;
//
//	}
//
//
//
//    /**
//     * Set the value related to the column: usertype.
//	 * @param usertype the usertype value you wish to set
//	 */
//	public void setUsertype(final String usertype) {
//		this.usertype = usertype;
//	}
}