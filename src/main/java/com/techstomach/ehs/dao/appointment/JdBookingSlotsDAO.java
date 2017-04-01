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

import com.techstomach.ehs.core.appointment.JdBookingSlots;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by ujjwal on 3/2/2017.
 */
public class JdBookingSlotsDAO extends AbstractDAO<JdBookingSlots> {


    /**
     * Creates a new DAO with a given session provider.
     *
     * @param sessionFactory a session provider
     */
    public JdBookingSlotsDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public List<JdBookingSlots> getAll() {
        return (List<JdBookingSlots>) currentSession().createCriteria(JdBookingSlots.class).list();
    }

    public JdBookingSlots findById(long id) {
        return currentSession().get(JdBookingSlots.class, id);
    }

    public void delete(JdBookingSlots jdBookingSlots) {
        currentSession().delete(jdBookingSlots);
    }

    public void update(JdBookingSlots jdBookingSlots) {
        currentSession().saveOrUpdate(jdBookingSlots);
    }

    public JdBookingSlots insert(JdBookingSlots jdBookingSlots) {
        return persist(jdBookingSlots);
    }
}
