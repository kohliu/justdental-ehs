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

import com.techstomach.ehs.core.login.JdNativeLogin;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by ujjwal on 2/25/2017.
 */
public class JdNativeLoginDAO extends AbstractDAO<JdNativeLogin> {

    /**
     * Creates a new DAO with a given session provider.
     *
     * @param sessionFactory a session provider
     */
    public JdNativeLoginDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public List<JdNativeLogin> getAll() {
        return (List<JdNativeLogin>) currentSession().createCriteria(JdNativeLogin.class).list();
    }

    public JdNativeLogin findById(long id) {
        return currentSession().get(JdNativeLogin.class, id);
    }

    public void delete(JdNativeLogin jdNativeLogin) {
        currentSession().delete(jdNativeLogin);
    }

    public void update(JdNativeLogin jdNativeLogin) {
        currentSession().saveOrUpdate(jdNativeLogin);
    }

    public JdNativeLogin insert(JdNativeLogin jdNativeLogin) {
        return persist(jdNativeLogin);
    }
}
