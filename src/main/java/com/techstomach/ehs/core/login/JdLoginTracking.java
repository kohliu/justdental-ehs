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

package com.techstomach.ehs.core.login;

import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.techstomach.ehs.core.user.JdUser;

@Entity
@Table(name = "jd_login_tracking", catalog = "jdehs_dev")
public class JdLoginTracking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loginTrackId")
    @JsonProperty
    private Long loginTrackId;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "userId_fk", nullable=false)
    @Column(name ="userId_fk", insertable = false, updatable = false)
    @JsonIgnore
    private Long userIdFk;

    @Column(name = "appId")
    @JsonProperty
    private String appId = "Browser";

    @Column(name = "dateCreated")
    @JsonProperty
    private Date dateCreated;

    @Column(name = "loginGUID")
    @JsonProperty
    private String loginGUID;

    @Column(name = "isActive")
    @JsonProperty
    private Boolean isActive = Boolean.TRUE;

    public Long getLoginTrackId() {
        return loginTrackId;
    }

    public void setLoginTrackId(Long loginTrackId) {
        this.loginTrackId = loginTrackId;
    }

    public Long getUserIdFk() {
        return userIdFk;
    }

    public void setUserIdFk(Long userIdFk) {
        this.userIdFk = userIdFk;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getLoginGUID() {
        return loginGUID;
    }

    public void setLoginGUID(String loginGUID) {
        this.loginGUID = loginGUID;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean isActive) {
        this.isActive = isActive;
    }
}
