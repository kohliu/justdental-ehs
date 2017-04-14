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

import com.fasterxml.jackson.annotation.JsonProperty;
import com.techstomach.ehs.core.user.JdUser;


@Entity
@Table(name = "jd_native_login", catalog = "jdehs_dev")
public class JdNativeLogin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loginId")
    @JsonProperty
    private Long loginId;

    @ManyToOne
    @JoinColumn(name = "userId_fk")
    @JsonProperty
    private JdUser userIdFk;

    @Column(name = "uniqueLoginName", nullable = false)
    @JsonProperty
    private String uniqueLoginName;

    @Column(name = "dateCreated", nullable = false)
    @JsonProperty
    private Date dateCreated;

    @Column(name = "dateModified", nullable = false)
    @JsonProperty
    private Date dateModified;

    @Column(name = "lastPasswordChanged", nullable = false)
    @JsonProperty
    private Date lastPasswordChanged;

    @Column(name = "modifiedBy", nullable = false)
    @JsonProperty
    private String modifiedBy;

    @Column(name = "passwordAnswer", nullable = false)
    @JsonProperty
    private String passwordAnswer;

    @Column(name = "passwordKey", nullable = false)
    @JsonProperty
    private String passwordKey;

    @Column(name = "passwordQuestion", nullable = false)
    @JsonProperty
    private String passwordQuestion;

    public Long getLoginId() {
        return loginId;
    }

    public void setLoginId(Long loginId) {
        this.loginId = loginId;
    }

    public JdUser getUserIdFk() {
        return userIdFk;
    }

    public void setUserIdFk(JdUser userIdFk) {
        this.userIdFk = userIdFk;
    }

    public Date getLastPasswordChanged() {
        return lastPasswordChanged;
    }

    public void setLastPasswordChanged(Date lastPasswordChanged) {
        this.lastPasswordChanged = lastPasswordChanged;
    }

    public String getPasswordAnswer() {
        return passwordAnswer;
    }

    public void setPasswordAnswer(String passwordAnswer) {
        this.passwordAnswer = passwordAnswer;
    }

    public String getPasswordKey() {
        return passwordKey;
    }

    public void setPasswordKey(String passwordKey) {
        this.passwordKey = passwordKey;
    }

    public String getPasswordQuestion() {
        return passwordQuestion;
    }

    public void setPasswordQuestion(String passwordQuestion) {
        this.passwordQuestion = passwordQuestion;
    }

    public String getUniqueLoginName() {
        return uniqueLoginName;
    }

    public void setUniqueLoginName(String uniqueLoginName) {
        this.uniqueLoginName = uniqueLoginName;
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
}
