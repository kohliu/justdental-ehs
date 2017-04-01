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

package com.techstomach.ehs.dao.user.patient;

import com.techstomach.ehs.core.user.patient.JdPatient;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by ujjwal on 3/2/2017.
 */
public class JdPatientDAO extends AbstractDAO<JdPatient> {

    /**
     * Creates a new DAO with a given session provider.
     *
     * @param sessionFactory a session provider
     */
    public JdPatientDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public List<JdPatient> getAll() {
        return (List<JdPatient>) currentSession().createCriteria(JdPatient.class).list();
    }

    public JdPatient findById(long id) {
        return currentSession().get(JdPatient.class, id);
    }

    public void delete(JdPatient jdPatient) {
        currentSession().delete(jdPatient);
    }

    public void update(JdPatient jdPatient) {
        currentSession().saveOrUpdate(jdPatient);
    }

    public JdPatient insert(JdPatient jdPatient) {
        return persist(jdPatient);
    }
}
