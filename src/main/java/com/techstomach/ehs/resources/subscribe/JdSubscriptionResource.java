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

package com.techstomach.ehs.resources.subscribe;

import com.techstomach.ehs.core.subscribe.JdSubscription;
import com.techstomach.ehs.dao.subscribe.JdSubscriptionDAO;
import io.dropwizard.hibernate.UnitOfWork;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/jdsubscribe")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
@Api(value = "/jdsubscribe", description = "Just Dental Subscriptions")
public class JdSubscriptionResource {

    JdSubscriptionDAO jdSubscriptionDAO;

    public JdSubscriptionResource(JdSubscriptionDAO jdSubscriptionDAO) {
        this.jdSubscriptionDAO = jdSubscriptionDAO;
    }

    @GET
    @Path("/all")
    @UnitOfWork
    @ApiOperation(value = "get all Just Dental Subscriptions", notes = "get all Just Dental Subscriptions", response = JdSubscription.class)
    public List<JdSubscription> getAll() {
        return jdSubscriptionDAO.getAll();
    }

    @POST
    @UnitOfWork
    @ApiOperation(value = "post new Just Dental Subscriptions", notes = "post new Just Dental Subscriptions", response = JdSubscription.class)
    public JdSubscription add(@Valid JdSubscription jdSubscription) {
        JdSubscription newJdSubscription = jdSubscriptionDAO.insert(jdSubscription);
        return newJdSubscription;
    }
}
