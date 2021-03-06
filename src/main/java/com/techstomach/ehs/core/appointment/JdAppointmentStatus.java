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

/**
 * Created by ujjwal on 3/25/2017.
 */
public enum JdAppointmentStatus {

    PENDING_APPROVAL(-1),
    BOOKED(0),
    ACTIVATED(1),
    IN_PROGRESS(2),
    COMPELTED(3);

    private Integer appointmentStatusId;

    private JdAppointmentStatus(int appointmentStatusId) {
        this.appointmentStatusId = appointmentStatusId;
    }

    public int getRoleId() {
        return appointmentStatusId;
    }
}
