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

package com.techstomach.ehs.core.user;

import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.techstomach.ehs.core.role.JdRole;


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
    @JsonProperty
    private Date dateCreated;

    @Column(name = "dateModified", nullable = false)
    @JsonProperty
    private Date dateModified;

    @Column(name = "emailAddress", nullable = false)
    @JsonProperty
    private String emailAddress;

    @Column(name = "uniqueUserId", nullable = false)
    @JsonProperty
    private String uniqueUserId;

    @Column(name = "userPassword", nullable = false)
    @JsonProperty
    private String userPassword;

    @Column(name = "firstName", nullable = false)
    @JsonProperty
    private String firstName;

    @Column(name = "isActive", nullable = false)
    @JsonProperty
    private Integer isActive;

    @Column(name = "lastName", nullable = false)
    @JsonProperty
    private String lastName;

    @Column(name = "licenseNumber", nullable = false)
    @JsonProperty
    private String licenseNumber;

    @Column(name = "middleName", nullable = false)
    @JsonProperty
    private String middleName;

    @Column(name = "modifiedBy", nullable = false)
    @JsonProperty
    private String modifiedBy;

    @Column(name = "phoneNumber", nullable = false)
    @JsonProperty
    private String phoneNumber;

    @Column(name = "qualification", nullable = false)
    @JsonProperty
    private String qualification;

    @ManyToOne
    @JoinColumn(name = "roleId_fk")
    @JsonProperty
    private JdRole roleId;

    @Column(name = "specialization", nullable = false)
    @JsonProperty
    private String specialization;

    @Column(name = "userType", nullable = false)
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

    public String getUniqueUserId() {
        return uniqueUserId;
    }

    public void setUniqueUserId(String uniqueUserId) {
        this.uniqueUserId = uniqueUserId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}