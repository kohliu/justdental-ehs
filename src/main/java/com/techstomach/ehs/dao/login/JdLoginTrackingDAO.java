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

package com.techstomach.ehs.dao.login;

import com.techstomach.ehs.core.login.JdLoginTracking;
import com.techstomach.ehs.core.user.JdUser;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by ujjwal on 2/25/2017.
 */
public class JdLoginTrackingDAO extends AbstractDAO<JdLoginTracking> {

    /**
     * Creates a new DAO with a given session provider.
     *
     * @param sessionFactory a session provider
     */
    public JdLoginTrackingDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public List<JdLoginTracking> getAll() {
        return (List<JdLoginTracking>) currentSession().createCriteria(JdLoginTracking.class).list();
    }

    public JdLoginTracking findById(long id) {
        return currentSession().get(JdLoginTracking.class, id);
    }

    public List<JdLoginTracking> findActiveLoginByUserId(long userId) {
       return currentSession().createCriteria(JdLoginTracking.class).add(Restrictions.eq("userId_fk", userId)).add(Restrictions.eq("isActive",1)).list();
    }

    public void delete(JdLoginTracking jdLoginTracking) {
        currentSession().delete(jdLoginTracking);
    }

    public void update(JdLoginTracking jdLoginTracking) {
        currentSession().saveOrUpdate(jdLoginTracking);
    }

    public JdLoginTracking insert(JdLoginTracking jdLoginTracking) {
        return persist(jdLoginTracking);
    }
}
