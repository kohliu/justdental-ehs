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

package com.techstomach.ehs.dao.clinic;

import com.techstomach.ehs.core.clinic.JdClinicRoleMap;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by ujjwal on 3/2/2017.
 */
public class JdClinicRoleMapDAO extends AbstractDAO<JdClinicRoleMap>{

    /**
     * Creates a new DAO with a given session provider.
     *
     * @param sessionFactory a session provider
     */
    public JdClinicRoleMapDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public List<JdClinicRoleMap> getAll() {
        return (List<JdClinicRoleMap>) currentSession().createCriteria(JdClinicRoleMap.class).list();
    }

    public JdClinicRoleMap findById(long id) {
        return currentSession().get(JdClinicRoleMap.class, id);
    }

    public void delete(JdClinicRoleMap jdClinicRoleMap) {
        currentSession().delete(jdClinicRoleMap);
    }

    public void update(JdClinicRoleMap jdClinicRoleMap) {
        currentSession().saveOrUpdate(jdClinicRoleMap);
    }

    public JdClinicRoleMap insert(JdClinicRoleMap jdClinicRoleMap) {
        return persist(jdClinicRoleMap);
    }
}
