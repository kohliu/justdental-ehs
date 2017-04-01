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

package com.techstomach.ehs.dao.subscribe;

import com.techstomach.ehs.core.subscribe.JdSubscription;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import java.util.List;

public class JdSubscriptionDAO extends AbstractDAO<JdSubscription> {

    /**
     * Creates a new DAO with a given session provider.
     *
     * @param sessionFactory a session provider
     */
    public JdSubscriptionDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public List<JdSubscription> getAll() {
        return (List<JdSubscription>) currentSession().createCriteria(JdSubscription.class).list();
    }

    public JdSubscription insert(JdSubscription jdSubscription) {
        return persist(jdSubscription);
    }
}
