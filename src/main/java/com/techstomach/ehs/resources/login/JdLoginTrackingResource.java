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

package com.techstomach.ehs.resources.login;

import com.techstomach.ehs.core.login.JdLoginTracking;
import com.techstomach.ehs.dao.login.JdLoginTrackingDAO;
import io.dropwizard.hibernate.UnitOfWork;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by ujjwal on 2/25/2017.
 */
@Path("/jdlogintracking")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
@Api(value = "/jdlogintracking", description = "Just Dental login Tracking")
public class JdLoginTrackingResource {

    JdLoginTrackingDAO jdLoginTrackingDAO;

    public JdLoginTrackingResource(JdLoginTrackingDAO jdLoginTrackingDAO) {
        this.jdLoginTrackingDAO = jdLoginTrackingDAO;
    }

    @GET
    @UnitOfWork
    @ApiOperation(value = "get all Just Dental login Tracking", notes = "get all Just Dental login Tracking", response = JdLoginTracking.class)
    public List<JdLoginTracking> getAll() {
        return jdLoginTrackingDAO.getAll();
    }

    @GET
    @Path("/{id}")
    @UnitOfWork
    @ApiOperation(value = "get specific Just Dental login Tracking", notes = "get specific Just Dental login Tracking", response = JdLoginTracking.class)
    public JdLoginTracking get(@PathParam("id") Long id) {
        return jdLoginTrackingDAO.findById(id);
    }

    @POST
    @UnitOfWork
    @ApiOperation(value = "post new Just Dental login Tracking", notes = "post new Just Dental login Tracking", response = JdLoginTracking.class)
    public JdLoginTracking add(@Valid JdLoginTracking jdLoginTracking) {
        JdLoginTracking newJdLoginTracking = jdLoginTrackingDAO.insert(jdLoginTracking);
        return newJdLoginTracking;
    }

    @PUT
    @Path("/{id}")
    @UnitOfWork
    @ApiOperation(value = "update existing Just Dental login Tracking", notes = "update existing Just Dental login Tracking", response = JdLoginTracking.class)
    public JdLoginTracking update(@PathParam("id") Long id, @Valid JdLoginTracking jdLoginTracking) {
        jdLoginTracking.setLoginTrackId(id);
        jdLoginTrackingDAO.update(jdLoginTracking);
        return jdLoginTracking;
    }

    @DELETE
    @Path("/{id}")
    @UnitOfWork
    @ApiOperation(value = "delete specific Just Dental login Tracking", notes = "delete specific Just Dental login Tracking", response = JdLoginTracking.class)
    public void delete(@PathParam("id") Long id) {
        jdLoginTrackingDAO.delete(jdLoginTrackingDAO.findById(id));
    }
}
