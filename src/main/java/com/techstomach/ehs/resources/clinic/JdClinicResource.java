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

package com.techstomach.ehs.resources.clinic;

import com.techstomach.ehs.core.clinic.JdClinic;
import com.techstomach.ehs.dao.clinic.JdClinicDAO;
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
@Path("/jdclinic")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
@Api(value = "/jdclinic", description = "Just Dental Clinics")
public class JdClinicResource {

    JdClinicDAO jdClinicDAO;

    public JdClinicResource(JdClinicDAO jdClinicDAO) {
        this.jdClinicDAO = jdClinicDAO;
    }

    @GET
    @UnitOfWork
    @ApiOperation(value = "get all Just Dental Clinics", notes = "get all Just Dental Clinics", response = JdClinic.class)
    public List<JdClinic> getAll() {
        return jdClinicDAO.getAll();
    }

    @GET
    @Path("/{id}")
    @UnitOfWork
    @ApiOperation(value = "get specific Just Dental Clinics", notes = "get specific Just Dental Clinics", response = JdClinic.class)
    public JdClinic get(@PathParam("id") Long id) {
        return jdClinicDAO.findById(id);
    }

    @POST
    @UnitOfWork
    @ApiOperation(value = "post new Just Dental Clinics", notes = "post new Just Dental Clinics", response = JdClinic.class)
    public JdClinic add(@Valid JdClinic jdClinic ) {
        JdClinic newJdClinic  = jdClinicDAO.insert(jdClinic );
        return newJdClinic ;
    }

    @PUT
    @Path("/{id}")
    @UnitOfWork
    @ApiOperation(value = "update existing Just Dental Clinics", notes = "update existing Just Dental Clinics", response = JdClinic.class)
    public JdClinic update(@PathParam("id") Long id, @Valid JdClinic jdClinic) {
        jdClinic.setClinicId(id);
        jdClinicDAO.update(jdClinic);
        return jdClinic;
    }

    @DELETE
    @Path("/{id}")
    @UnitOfWork
    @ApiOperation(value = "delete specific Just Dental RolClinicses", notes = "delete specific Just Dental Clinics", response = JdClinic.class)
    public void delete(@PathParam("id") Long id) {
        jdClinicDAO.delete(jdClinicDAO.findById(id));
    }
}
