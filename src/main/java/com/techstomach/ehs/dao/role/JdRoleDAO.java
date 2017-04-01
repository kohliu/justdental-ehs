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

package com.techstomach.ehs.dao.role;

import com.techstomach.ehs.core.role.JdRole;
import com.techstomach.ehs.core.role.RoleType;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by ujjwal on 2/24/2017.
 */
public class JdRoleDAO extends AbstractDAO<JdRole> {

    /**
     * Creates a new DAO with a given session provider.
     *
     * @param sessionFactory a session provider
     */
    public JdRoleDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public List<JdRole> getAll() {
        return (List<JdRole>) currentSession().createCriteria(JdRole.class).list();
    }

    public JdRole findById(long id) {
        return currentSession().get(JdRole.class, id);
    }

    public Long findRoleIdByName(RoleType roleName) {
        return currentSession().get(JdRole.class, roleName).getRoleId();
    }

    public void delete(JdRole jdRole) {
        currentSession().delete(jdRole);
    }

    public void update(JdRole jdRole) {
        currentSession().saveOrUpdate(jdRole);
    }

    public JdRole insert(JdRole jdRole) {
        return persist(jdRole);
    }
}
