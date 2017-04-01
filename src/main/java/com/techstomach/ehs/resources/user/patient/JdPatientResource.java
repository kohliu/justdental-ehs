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
import java.util.List;

/**
 * Created by ujjwal on 3/2/2017.
 */
@Path("/jdpatient")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
@Api(value = "/jdpatient", description = "Just Dental Patient")
public class JdPatientResource {

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
    public JdPatient add(@Valid JdPatient jdPatient) {
        JdPatient newJdPatient = jdPatientDAO.insert(jdPatient);
        return newJdPatient;
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
