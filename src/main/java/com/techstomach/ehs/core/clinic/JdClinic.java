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

    @Column(name = "dateCreated")
    @JsonProperty
    private Date dateCreated;

    @Column(name = "dateModified")
    @JsonProperty
    private Date dateModified;

    @Column(name = "city")
    @JsonProperty
    private String city;

    @Column(name = "clinicName")
    @JsonProperty
    private String clinicName;

    @Column(name = "clinicType")
    @JsonProperty
    private String clinicType;

    @Column(name = "country")
    @JsonProperty
    private String country;

    @Column(name = "daysAvailable")
    @JsonProperty
    private String daysAvailable;

    @Column(name = "gmap")
    @JsonProperty
    private String gmap;

    @Column(name = "isActive")
    @JsonProperty
	private Integer isActive;

    @Column(name = "locality")
    @JsonProperty
    private String locality;

    @Column(name = "modifiedBy")
    @JsonProperty
    private String modifiedBy;

    @Column(name = "notification")
    @JsonProperty
    private String notification;

    @Column(name = "pincode")
    @JsonProperty
    private Long pincode;

    @Column(name = "primaryContactName")
    @JsonProperty
    private String primaryContactName;

    @Column(name = "primaryContactNumber")
    @JsonProperty
    private Long primaryContactNumber;

    @Column(name = "state")
    @JsonProperty
    private String state;

    @Column(name = "street1")
    @JsonProperty
    private String street1;

    @Column(name = "street2")
    @JsonProperty
    private String street2;

    @Column(name = "taxNumber")
    @JsonProperty
	private String taxNumber;

    @Column(name = "workingHours")
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
