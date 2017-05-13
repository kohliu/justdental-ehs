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

package com.techstomach.ehs.core.user.doctor;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.techstomach.ehs.core.user.JdUser;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by ujjwal on 3/25/2017.
 */
@Entity
@Table(name = "jd_doctor", catalog = "jdehs_dev")
public class JdDoctor extends JdUser {

    @Column(name = "licenseNumber")
    @JsonProperty
    private String licenseNumber;

    @Column(name = "licenseExpiryDate")
    @JsonProperty
    private Date licenseExpiryDate;

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public Date getLicenseExpiryDate() {
        return licenseExpiryDate;
    }

    public void setLicenseExpiryDate(Date licenseExpiryDate) {
        this.licenseExpiryDate = licenseExpiryDate;
    }
}
