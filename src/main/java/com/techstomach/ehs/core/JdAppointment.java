package com.techstomach.ehs.core;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "jd_appointment", catalog = "jdehs_dev")
public class JdAppointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointmentId")
    @JsonProperty
    private Long appointmentId;

	@Column(name = "appointmentDescription")
	@JsonProperty
	private String appointmentDescription;

	@Column(name = "appointmentStatus", nullable = false)
	@NotNull
	@JsonProperty
	private Integer appointmentStatus;

	@Column(name = "appointmentTakenBy")
	@JsonProperty
	private String appointmentTakenBy;

	@Column(name = "appoitmentStartTime", nullable = false)
	@NotNull
	@JsonProperty
	private Date appoitmentStartTime;

    @ManyToOne
    @JoinColumn(name = "clinicId_fk")
	@JsonProperty
	private JdClinic clinicId;

	@Column(name = "creationDate", nullable = false)
	@NotNull
	@JsonProperty
	private Date creationDate;

	@Column(name = "invoiceId_fk")
	@JsonProperty
	private Long invoiceId;

	@Column(name = "modifiedBy", nullable = false)
	@NotNull
	@JsonProperty
	private String modifiedBy;

	@Column(name = "modifiedDate")
	@JsonProperty
	private Date modifiedDate;

	@Column(name = "slotDuration", nullable = false)
	@NotNull
	@JsonProperty
	private Integer slotDuration;

	@Column(name = "slotEndTime", nullable = false)
	@NotNull
	@JsonProperty
	private Date slotEndTime;

	@Column(name = "slotStartTime", nullable = false)
	@NotNull
	@JsonProperty
	private Date slotStartTime;

	@Column(name = "userCheckIn", nullable = false)
	@NotNull
	@JsonProperty
	private Date userCheckIn;

	@Column(name = "userCheckOut", nullable = false)
	@NotNull
	@JsonProperty
	private Date userCheckOut;

    @ManyToOne
    @JoinColumn(name = "userId_fk")
    @JsonProperty
	private JdUser userId;

    public String getAppointmentDescription() {
        return appointmentDescription;
    }

    public void setAppointmentDescription(String appointmentDescription) {
        this.appointmentDescription = appointmentDescription;
    }

    public Integer getAppointmentStatus() {
        return appointmentStatus;
    }

    public void setAppointmentStatus(Integer appointmentStatus) {
        this.appointmentStatus = appointmentStatus;
    }

    public String getAppointmentTakenBy() {
        return appointmentTakenBy;
    }

    public void setAppointmentTakenBy(String appointmentTakenBy) {
        this.appointmentTakenBy = appointmentTakenBy;
    }

    public Date getAppoitmentStartTime() {
        return appoitmentStartTime;
    }

    public void setAppoitmentStartTime(Date appoitmentStartTime) {
        this.appoitmentStartTime = appoitmentStartTime;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Long invoiceIdFk) {
        this.invoiceId= invoiceIdFk;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Integer getSlotDuration() {
        return slotDuration;
    }

    public void setSlotDuration(Integer slotDuration) {
        this.slotDuration = slotDuration;
    }

    public Date getSlotEndTime() {
        return slotEndTime;
    }

    public void setSlotEndTime(Date slotEndTime) {
        this.slotEndTime = slotEndTime;
    }

    public Date getSlotStartTime() {
        return slotStartTime;
    }

    public void setSlotStartTime(Date slotStartTime) {
        this.slotStartTime = slotStartTime;
    }

    public Date getUserCheckIn() {
        return userCheckIn;
    }

    public void setUserCheckIn(Date userCheckIn) {
        this.userCheckIn = userCheckIn;
    }

    public Date getUserCheckOut() {
        return userCheckOut;
    }

    public void setUserCheckOut(Date userCheckOut) {
        this.userCheckOut = userCheckOut;
    }

    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public JdClinic getClinicId() {
        return clinicId;
    }

    public void setClinicId(JdClinic clinicId) {
        this.clinicId = clinicId;
    }

    public JdUser getUserId() {
        return userId;
    }

    public void setUserId(JdUser userId) {
        this.userId = userId;
    }
}
