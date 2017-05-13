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

package com.techstomach.ehs.dao.user.doctor;

import com.techstomach.ehs.core.user.doctor.JdDoctor;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class JdDoctorDAO extends AbstractDAO<JdDoctor> {

    /**
     * Creates a new DAO with a given session provider.
     *
     * @param sessionFactory a session provider
     */
    public JdDoctorDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public List<JdDoctor> getAll() {
        return (List<JdDoctor>) currentSession().createCriteria(JdDoctor.class).list();
    }

    public JdDoctor findById(long id) {
        return currentSession().get(JdDoctor.class, id);
    }

    public void delete(JdDoctor jdDoctor) {
        currentSession().delete(jdDoctor);
    }

    public void update(JdDoctor jdDoctor) {
        currentSession().saveOrUpdate(jdDoctor);
    }

    public JdDoctor insert(JdDoctor jdDoctor) {
        return persist(jdDoctor);
    }

    public List<JdDoctor> findByPhoneNumber(String phoneNumber) {
        return (List<JdDoctor>) currentSession().createCriteria(JdDoctor.class).add(Restrictions.eq("phoneNumber", phoneNumber)).list();
    }

    public List<JdDoctor> findByUserName(String userName) {
        return (List<JdDoctor>) currentSession().createCriteria(JdDoctor.class).add(Restrictions.eq("uniqueUserId", userName)).list();
    }
}