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

package com.techstomach.ehs.dao.appointment;

import com.techstomach.ehs.core.appointment.JdAppointment;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by ujjwal on 3/1/2017.
 */
public class JdAppointmentDAO extends AbstractDAO<JdAppointment> {

    /**
     * Creates a new DAO with a given session provider.
     *
     * @param sessionFactory a session provider
     */
    public JdAppointmentDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public List<JdAppointment> getAll() {
        return (List<JdAppointment>) currentSession().createCriteria(JdAppointment.class).list();
    }

    public JdAppointment findById(long id) {
        return currentSession().get(JdAppointment.class, id);
    }

    public void delete(JdAppointment jdAppointment) {
        currentSession().delete(jdAppointment);
    }

    public void update(JdAppointment jdAppointment) {
        currentSession().saveOrUpdate(jdAppointment);
    }

    public JdAppointment insert(JdAppointment jdAppointment) {
        return persist(jdAppointment);
    }
}
