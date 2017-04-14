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

package com.techstomach.ehs.dao.user;

import com.techstomach.ehs.core.user.JdUser;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by ujjwal on 2/25/2017.
 */
public class JdUserDAO extends AbstractDAO<JdUser> {

    /**
     * Creates a new DAO with a given session provider.
     *
     * @param sessionFactory a session provider
     */
    public JdUserDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public List<JdUser> getAll() {
        return (List<JdUser>) currentSession().createCriteria(JdUser.class).list();
    }

    public JdUser findById(long id) {
        return currentSession().get(JdUser.class, id);
    }

    public void delete(JdUser jdUser) {
        currentSession().delete(jdUser);
    }

    public void update(JdUser jdUser) {

        currentSession().saveOrUpdate(jdUser);
    }

    public JdUser insert(JdUser jdUser) {
        return persist(jdUser);
    }
}