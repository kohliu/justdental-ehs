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
@Table(name = "jd_booking_slots", catalog = "jdehs_dev")
public class JdBookingSlots {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "slotId")
	@JsonProperty
	private Long slotId;

    @ManyToOne
    @JoinColumn(name = "clinicId_fk")
    @JsonProperty
	private JdClinic clinicId;

	@Column(name = "dateCreated", nullable = false)
	@NotNull
	@JsonProperty
	private Date dateCreated;

	@Column(name = "dateModified", nullable = false)
	@NotNull
	@JsonProperty
	private Date dateModified;

	@Column(name = "modifiedBy", nullable = false)
	@NotNull
	@JsonProperty
	private String modifiedBy;

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

    @ManyToOne
    @JoinColumn(name = "userId_fk")
    @JsonProperty
	private JdUser userId;

	public Long getSlotId() {
		return slotId;
	}

	public void setSlotId(Long slotId) {
		this.slotId = slotId;
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
