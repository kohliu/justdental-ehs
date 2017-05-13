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

package com.techstomach.ehs.core.user.patient;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.techstomach.ehs.core.user.JdUser;

import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "jd_patient", catalog = "jdehs_dev")
public class JdPatient extends JdUser {

    @Column(name = "aadharNumber")
    @JsonProperty
    private String aadharNumber;

    @Column(name = "bloodGroup")
    @JsonProperty
    private String bloodGroup;

    @Column(name = "city")
    @JsonProperty
    private String city;

    @Column(name = "country")
    @JsonProperty
    private String country;

//    @Column(name = "creationDate")
//    @NotNull
//    @JsonProperty
//    private Date creationDate;

    @Column(name = "dateOfBirth")
    @JsonProperty
    private Date dateOfBirth;
    @Column(name = "education")
    @JsonProperty
    private String education;

//    @Column(name = "emailAddress")
//    @JsonProperty
//    private String emailAddress;

    @Column(name = "emergencyContactName")
    @JsonProperty
    private String emergencyContactName;
    @Column(name = "emergencyContactNumber")
    @JsonProperty
    private String emergencyContactNumber;
    @Column(name = "emergencyContactRelationship")
    @JsonProperty
    private String emergencyContactRelationship;
    @Column(name = "familyHistory", columnDefinition="LONGTEXT")
    @JsonProperty
    private String familyHistory;

//    @Column(name = "firstname")
//    @NotNull
//    @JsonProperty
//    private String firstname;
//
//    @Column(name = "gender")
//    @NotNull
//    @JsonProperty
//    private String gender;

    @Column(name = "habbits", columnDefinition="TEXT")
    @JsonProperty
    private String habbits;
    @Column(name = "insuranceExpiration")
    @JsonProperty
    private Date insuranceExpiration;
    @Column(name = "insuranceNumber")
    @JsonProperty
    private String insuranceNumber;

//    @Column(name = "lastname")
//    @NotNull
//    @JsonProperty
//    private String lastname;

    @Column(name = "locality")
    @JsonProperty
    private String locality;
    @Column(name = "maritalStatus")
    @JsonProperty
    private String maritalStatus;
    @Column(name = "medicalHistory", columnDefinition="LONGTEXT")
    @JsonProperty
    private String medicalHistory;

//    @Column(name = "middleName")
//    @JsonProperty
//    private String middleName;

//    @Column(name = "modifiedBy")
//    @JsonProperty
//    private String modifiedBy;
//    @Column(name = "modifiedDate")
//    @NotNull
//    @JsonProperty
//    private Date modifiedDate;
    @Column(name = "occupation")
    @JsonProperty
    private String occupation;
    @Column(name = "packageId_fk")
    @JsonProperty
    private Long packageId;
    @Column(name = "patientDisplayId")
    @JsonProperty
    private String patientDisplayId;
    @Column(name = "patientNote", columnDefinition="LONGTEXT")
    @JsonProperty
    private String patientNote;
//    @Column(name = "phoneNumber")
//    @JsonProperty
//    private String phoneNumber;
    @Column(name = "pincode")
    @JsonProperty
    private Long pincode;
    @Column(name = "placeOfBirth")
    @JsonProperty
    private String placeOfBirth;
    @Column(name = "religion")
    @JsonProperty
    private String religion;
    @Column(name = "socialHistory", columnDefinition="LONGTEXT")
    @JsonProperty
    private String socialHistory;
    @Column(name = "state")
    @JsonProperty
    private String state;
    @Column(name = "street1")
    @JsonProperty
    private String street1;
    @Column(name = "street2")
    @JsonProperty
    private String street2;

    public String getAadharNumber() {
        return aadharNumber;
    }

    public void setAadharNumber(String aadharNumber) {
        this.aadharNumber = aadharNumber;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

//    public Date getCreationDate() {
//        return creationDate;
//    }
//
//    public void setCreationDate(Date creationDate) {
//        this.creationDate = creationDate;
//    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }
//
//    @Override
//    public String getEmailAddress() {
//        return emailAddress;
//    }
//
//    @Override
//    public void setEmailAddress(String emailAddress) {
//        this.emailAddress = emailAddress;
//    }

    public String getEmergencyContactName() {
        return emergencyContactName;
    }

    public void setEmergencyContactName(String emergencyContactName) {
        this.emergencyContactName = emergencyContactName;
    }

    public String getEmergencyContactNumber() {
        return emergencyContactNumber;
    }

    public void setEmergencyContactNumber(String emergencyContactNumber) {
        this.emergencyContactNumber = emergencyContactNumber;
    }

    public String getEmergencyContactRelationship() {
        return emergencyContactRelationship;
    }

    public void setEmergencyContactRelationship(String emergencyContactRelationship) {
        this.emergencyContactRelationship = emergencyContactRelationship;
    }

    public String getFamilyHistory() {
        return familyHistory;
    }

    public void setFamilyHistory(String familyHistory) {
        this.familyHistory = familyHistory;
    }

//    public String getFirstname() {
//        return firstname;
//    }
//
//    public void setFirstname(String firstname) {
//        this.firstname = firstname;
//    }
//
//    public String getGender() {
//        return gender;
//    }
//
//    public void setGender(String gender) {
//        this.gender = gender;
//    }

    public String getHabbits() {
        return habbits;
    }

    public void setHabbits(String habbits) {
        this.habbits = habbits;
    }

    public Date getInsuranceExpiration() {
        return insuranceExpiration;
    }

    public void setInsuranceExpiration(Date insuranceExpiration) {
        this.insuranceExpiration = insuranceExpiration;
    }

    public String getInsuranceNumber() {
        return insuranceNumber;
    }

    public void setInsuranceNumber(String insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }
//
//    public String getLastname() {
//        return lastname;
//    }
//
//    public void setLastname(String lastname) {
//        this.lastname = lastname;
//    }

    public String getLcality() {
        return locality;
    }

    public void setLcality(String lcality) {
        this.locality = lcality;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

//    @Override
//    public String getMiddleName() {
//        return middleName;
//    }
//
//    @Override
//    public void setMiddleName(String middleName) {
//        this.middleName = middleName;
//    }
//
//    @Override
//    public String getModifiedBy() {
//        return modifiedBy;
//    }
//
//    @Override
//    public void setModifiedBy(String modifiedBy) {
//        this.modifiedBy = modifiedBy;
//    }
//
//    public Date getModifiedDate() {
//        return modifiedDate;
//    }
//
//    public void setModifiedDate(Date modifiedDate) {
//        this.modifiedDate = modifiedDate;
//    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public Long getPackageId() {
        return packageId;
    }

    public void setPackageId(Long packageId) {
        this.packageId = packageId;
    }

    public String getPatientDisplayId() {
        return patientDisplayId;
    }

    public void setPatientDisplayId(String patientDisplayId) {
        this.patientDisplayId = patientDisplayId;
    }

    public String getPatientNote() {
        return patientNote;
    }

    public void setPatientNote(String patientNote) {
        this.patientNote = patientNote;
    }

//    @Override
//    public String getPhoneNumber() {
//        return phoneNumber;
//    }
//
//    @Override
//    public void setPhoneNumber(String phoneNumber) {
//        this.phoneNumber = phoneNumber;
//    }

    public Long getPincode() {
        return pincode;
    }

    public void setPincode(Long pincode) {
        this.pincode = pincode;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getSocialHistory() {
        return socialHistory;
    }

    public void setSocialHistory(String socialHistory) {
        this.socialHistory = socialHistory;
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
}
