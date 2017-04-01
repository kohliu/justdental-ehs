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

package com.techstomach.ehs.core.role;

/**
 * Created by ujjwal on 3/5/2017.
 */
public enum RoleType {

    PATIENT("PATIENT"),
    DOCTOR("DOCTOR"),
    DOCTOR_CLINIC("DOCTOR_CLINIC"),
    DOCTOR_SPECIALIST("DOCTOR_SPECIALIST"),
    CLINIC_STAFF("CLINIC_STAFF"),
    ADMIN("ADMIN"),
    TECH_SUPPORT("TECH_SUPPORT");

    private String roleType;

    private RoleType(String roleType) {
        this.roleType = roleType;
    }

    public String getRoleType() {
        return roleType;
    }
}