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

package com.techstomach.ehs.resources.user.patient;

import com.techstomach.ehs.core.user.patient.JdPatient;
import com.techstomach.ehs.dao.user.patient.JdPatientDAO;
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

/**
 * Created by ujjwal on 3/2/2017.
 */
@Path("/jdpatient")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
@Api(value = "/jdpatient", description = "Just Dental Patient")
public class JdPatientResource {
    private final static Logger LOGGER = Logger.getLogger(JdPatientResource.class.getName());

    JdPatientDAO jdPatientDAO;

    public JdPatientResource(JdPatientDAO jdPatientDAO) {
        this.jdPatientDAO = jdPatientDAO;
    }

    @GET
    @UnitOfWork
    @ApiOperation(value = "get all Just Dental Patients", notes = "get all Just Dental Patients", response = JdPatient.class)
    public List<JdPatient> getAll() {
        return jdPatientDAO.getAll();
    }

    @GET
    @Path("/{id}")
    @UnitOfWork
    @ApiOperation(value = "get specific Just Dental Patients", notes = "get specific Just Dental Patients", response = JdPatient.class)
    public JdPatient get(@PathParam("id") Long id) {
        return jdPatientDAO.findById(id);
    }

    @POST
    @UnitOfWork
    @ApiOperation(value = "post new Just Dental Patients", notes = "post new Just Dental Patients", response = JdPatient.class)
    public Response add(@Valid JdPatient jdPatient) {
        LOGGER.info("User Add: adding user with username = " + jdPatient.getUniqueUserId() + " and phone number = " + jdPatient.getPhoneNumber());
        Date date = new Date();

        if(jdPatient.getPhoneNumber() == null || jdPatient.getPhoneNumber().length() == 0)
        {
            LOGGER.log(Level.WARNING, "User Add: invalid request. user's phone number is not provided");
            return Response.status(Response.Status.BAD_REQUEST).entity("{\"error\": \"invalid request. user's phone number is not provided\"}").build();
        }
        if(jdPatient.getUniqueUserId() == null || jdPatient.getUniqueUserId().length() == 0)
        {
            LOGGER.log(Level.WARNING, "User Add: invalid request. user's email address is not provided");
            return Response.status(Response.Status.BAD_REQUEST).entity("{\"error\": \"invalid request. user's email address is not provided\"}").build();
        }

        if (!jdPatientDAO.findByUserName(jdPatient.getUniqueUserId()).isEmpty()) {
            LOGGER.log(Level.WARNING, "User Add: user's email address is already registered, username = " + jdPatient.getUniqueUserId() + " and phone number = " + jdPatient.getPhoneNumber());
            return Response.status(Response.Status.BAD_REQUEST).entity("{\"error\": \"user's email address is already registered\"}").build();
        }
        if (!jdPatientDAO.findByPhoneNumber(jdPatient.getPhoneNumber()).isEmpty()) {
            LOGGER.log(Level.WARNING, "User Add: user's phone number is already registered, username = " + jdPatient.getUniqueUserId() + " and phone number = " + jdPatient.getPhoneNumber());
            return Response.status(Response.Status.BAD_REQUEST).entity("{\"error\": \"user's phone number is already registered\"}").build();
        }

        LOGGER.info("User Add: sucessfully added user with username = " + jdPatient.getUniqueUserId() + " and phone number = " + jdPatient.getPhoneNumber());
        jdPatient.setDateCreated(date);

        return Response.ok(jdPatientDAO.insert(jdPatient)).build();
    }

    @PUT
    @Path("/{id}")
    @UnitOfWork
    @ApiOperation(value = "update existing Just Dental Patients", notes = "update existing Just Dental Patients", response = JdPatient.class)
    public JdPatient update(@PathParam("id") Long userId, @Valid JdPatient jdPatient) {
        jdPatient.setUserId(userId);
        jdPatientDAO.update(jdPatient);
        return jdPatient;
    }

    @DELETE
    @Path("/{id}")
    @UnitOfWork
    @ApiOperation(value = "delete specific Just Dental Patients", notes = "delete specific Just Dental Patients", response = JdPatient.class)
    public void delete(@PathParam("id") Long id) {
        jdPatientDAO.delete(jdPatientDAO.findById(id));
    }
}
