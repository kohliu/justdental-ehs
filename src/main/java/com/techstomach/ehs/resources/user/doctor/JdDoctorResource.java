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

package com.techstomach.ehs.resources.user.doctor;

import com.techstomach.ehs.core.user.doctor.JdDoctor;
import com.techstomach.ehs.dao.user.doctor.JdDoctorDAO;
import io.dropwizard.hibernate.UnitOfWork;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("/jddoctor")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
@Api(value = "/jddoctor", description = "Just Dental Doctor")
public class JdDoctorResource {
    private final static Logger LOGGER = Logger.getLogger(JdDoctorResource.class.getName());

    JdDoctorDAO jdDoctortDAO;

    public JdDoctorResource(JdDoctorDAO jdDoctortDAO) {
        this.jdDoctortDAO = jdDoctortDAO;
    }

    @GET
    @UnitOfWork
    @ApiOperation(value = "get all Just Dental Doctors", notes = "get all Just Dental Doctors", response = JdDoctor.class)
    public List<JdDoctor> getAll() {
        return jdDoctortDAO.getAll();
    }

    @GET
    @Path("/{id}")
    @UnitOfWork
    @ApiOperation(value = "get specific Just Dental Doctors", notes = "get specific Just Dental Doctors", response = JdDoctor.class)
    public JdDoctor get(@PathParam("id") Long id) {
        return jdDoctortDAO.findById(id);
    }

    @POST
    @UnitOfWork
    @ApiOperation(value = "post new Just Dental Doctors", notes = "post new Just Dental Doctors", response = JdDoctor.class)
    public Response add(@Valid JdDoctor jdDoctor) {
        LOGGER.info("User Add: adding user with username = " + jdDoctor.getUniqueUserId() + " and phone number = " + jdDoctor.getPhoneNumber());
        Date date = new Date();

        if(jdDoctor.getPhoneNumber() == null || jdDoctor.getPhoneNumber().length() == 0)
        {
            LOGGER.log(Level.WARNING, "User Add: invalid request. user's phone number is not provided");
            return Response.status(Response.Status.BAD_REQUEST).entity("{\"error\": \"invalid request. user's phone number is not provided\"}").build();
        }
        if(jdDoctor.getUniqueUserId() == null || jdDoctor.getUniqueUserId().length() == 0)
        {
            LOGGER.log(Level.WARNING, "User Add: invalid request. user's email address is not provided");
            return Response.status(Response.Status.BAD_REQUEST).entity("{\"error\": \"invalid request. user's email address is not provided\"}").build();
        }

        if (!jdDoctortDAO.findByUserName(jdDoctor.getUniqueUserId()).isEmpty()) {
            LOGGER.log(Level.WARNING, "User Add: user's email address is already registered, username = " + jdDoctor.getUniqueUserId() + " and phone number = " + jdDoctor.getPhoneNumber());
            return Response.status(Response.Status.BAD_REQUEST).entity("{\"error\": \"user's email address is already registered\"}").build();
        }
        if (!jdDoctortDAO.findByPhoneNumber(jdDoctor.getPhoneNumber()).isEmpty()) {
            LOGGER.log(Level.WARNING, "User Add: user's phone number is already registered, username = " + jdDoctor.getUniqueUserId() + " and phone number = " + jdDoctor.getPhoneNumber());
            return Response.status(Response.Status.BAD_REQUEST).entity("{\"error\": \"user's phone number is already registered\"}").build();
        }

        LOGGER.info("User Add: sucessfully added user with username = " + jdDoctor.getUniqueUserId() + " and phone number = " + jdDoctor.getPhoneNumber());
        jdDoctor.setDateCreated(date);

        return Response.ok(jdDoctortDAO.insert(jdDoctor)).build();
    }

    @PUT
    @Path("/{id}")
    @UnitOfWork
    @ApiOperation(value = "update existing Just Dental Doctors", notes = "update existing Just Dental Doctors", response = JdDoctor.class)
    public JdDoctor update(@PathParam("id") Long userId, @Valid JdDoctor jdDoctor) {
        jdDoctor.setUserId(userId);
        jdDoctortDAO.update(jdDoctor);
        return jdDoctor;
    }

    @DELETE
    @Path("/{id}")
    @UnitOfWork
    @ApiOperation(value = "delete specific Just Dental Doctors", notes = "delete specific Just Dental Doctors", response = JdDoctor.class)
    public void delete(@PathParam("id") Long id) {
        jdDoctortDAO.delete(jdDoctortDAO.findById(id));
    }
}
