/*
 * Copyright (c) 2017 Techstomach (TM)
 *
 * This software is an intellectual property of Techstomach Solutions Pvt Ltd,India.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.techstomach.ehs.core.appointment;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.techstomach.ehs.core.clinic.JdClinic;
import com.techstomach.ehs.core.user.JdUser;

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

    @Column(name = "appointmentStatus")
    @JsonProperty
    @Enumerated
    private JdAppointmentStatus appointmentStatus = JdAppointmentStatus.PENDING_APPROVAL;

	@Column(name = "appointmentTakenBy")
	@JsonProperty
	private String appointmentTakenBy;

    @Column(name = "appointmentStartTime")
	@JsonProperty
    private Date appointmentStartTime;

    @ManyToOne
    @JoinColumn(name = "clinicId_fk")
	@JsonProperty
	private JdClinic clinicId;

    @Column(name = "creationDate")
    @JsonProperty
	private Date creationDate;

	@Column(name = "invoiceId_fk")
	@JsonProperty
	private Long invoiceId;

    @Column(name = "slotDuration")
    @JsonProperty
	private Integer slotDuration;

    @Column(name = "slotEndTime")
    @JsonProperty
	private Date slotEndTime;

    @Column(name = "slotStartTime")
    @JsonProperty
	private Date slotStartTime;

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

    public JdAppointmentStatus getAppointmentStatus() {
        return appointmentStatus;
    }

    public void setAppointmentStatus(JdAppointmentStatus appointmentStatus) {
        this.appointmentStatus = appointmentStatus;
    }

    public String getAppointmentTakenBy() {
        return appointmentTakenBy;
    }

    public void setAppointmentTakenBy(String appointmentTakenBy) {
        this.appointmentTakenBy = appointmentTakenBy;
    }

    public Date getAppoitmentStartTime() {
        return appointmentStartTime;
    }

    public void setAppoitmentStartTime(Date appoitmentStartTime) {
        this.appointmentStartTime = appoitmentStartTime;
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
