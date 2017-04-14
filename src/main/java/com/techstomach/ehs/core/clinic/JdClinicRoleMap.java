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

package com.techstomach.ehs.core.clinic;

import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.techstomach.ehs.core.user.JdUser;

@Entity
@Table(name = "jd_clinic_role_map", catalog = "jdehs_dev")
public class JdClinicRoleMap{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "clinicRoleId")
	@JsonProperty
	private Long clinicRoleId;

	@ManyToOne
	@JoinColumn(name = "clinicId_fk")
	@JsonProperty
	private JdClinic clinicId;

	@Column(name = "dateCreated", nullable = false)
	@JsonProperty
	private Date dateCreated;

	@Column(name = "dateModified", nullable = false)
	@JsonProperty
	private Date dateModified;

	@Column(name = "isActive", nullable = false)
	@JsonProperty
	private Integer isActive;

	@Column(name = "modifiedBy", nullable = false)
	@JsonProperty
	private String modifiedBy;

	@ManyToOne
	@JoinColumn(name = "userId_fk")
	@JsonProperty
	private JdUser userId;

	public Long getClinicRoleId() {
		return clinicRoleId;
	}

	public void setClinicRoleId(Long clinicRoleId) {
		this.clinicRoleId = clinicRoleId;
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
