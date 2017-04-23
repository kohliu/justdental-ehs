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
import org.hibernate.criterion.Restrictions;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by ujjwal on 2/25/2017.
 */
public class JdUserDAO extends AbstractDAO<JdUser> {
    private final static Logger LOGGER = Logger.getLogger(JdUserDAO.class.getName());
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

    public List<JdUser> findByEmail(String email) {
        return (List<JdUser>) currentSession().createCriteria(JdUser.class).add(Restrictions.eq("emailAddress", email)).list();
    }
    public List<JdUser> findByUserType(String userType) {
        return (List<JdUser>) currentSession().createCriteria(JdUser.class).add(Restrictions.eq("userType", userType)).list();
    }
    public List<JdUser> validateUserByEmail(String email, String password) {
        return (List<JdUser>) currentSession().createCriteria(JdUser.class).add(Restrictions.eq("emailAddress", email))
                .add(Restrictions.eq("userPassword", password)).list();
    }
    public List<JdUser> validateUserByPhone(String phoneNumber, String password) {
        LOGGER.info("Login: validating user with phone number " + phoneNumber + " and password = ****");
        return (List<JdUser>) currentSession().createCriteria(JdUser.class).add(Restrictions.eq("phoneNumber", phoneNumber))
                .add(Restrictions.eq("userPassword", password)).list();
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
