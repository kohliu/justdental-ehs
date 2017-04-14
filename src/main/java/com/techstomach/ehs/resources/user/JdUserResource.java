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

package com.techstomach.ehs.resources.user;

import com.techstomach.ehs.core.role.JdRole;
import com.techstomach.ehs.core.user.JdUser;
import com.techstomach.ehs.core.role.RoleType;
import com.techstomach.ehs.dao.role.JdRoleDAO;
import com.techstomach.ehs.dao.user.JdUserDAO;
import io.dropwizard.hibernate.UnitOfWork;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by ujjwal on 2/25/2017.
 */
@Path("/jduser")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
@Api(value = "/jduser", description = "Just Dental Users {Doctors,Patients,Admins etc.}")
public class JdUserResource {
    private final static Logger LOGGER = Logger.getLogger(JdUserResource.class.getName());
    JdUserDAO jdUserDAO;
    JdRoleDAO jdRoleDAO;

    public JdUserResource(JdUserDAO jdRoleDAO) {
        this.jdUserDAO = jdRoleDAO;
    }

    @GET
    @UnitOfWork
    @ApiOperation(value = "get all Just Dental Users", notes = "get all Just Dental Users", response = JdUser.class)
    public List<JdUser> getAll() {
        return jdUserDAO.getAll();
    }

    @GET
    @Path("/{id}")
    @UnitOfWork
    @ApiOperation(value = "get specific Just Dental Users", notes = "get specific Just Dental Users", response = JdUser.class)
    public JdUser get(@PathParam("id") Long id) {
        return jdUserDAO.findById(id);
    }

    @POST
    @UnitOfWork
    @ApiOperation(value = "post new Just Dental Users", notes = "post new Just Dental Users", response = JdUser.class)
    public JdUser add(@Valid JdUser jdUser) {
        return jdUserDAO.insert(jdUser);
    }

    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @UnitOfWork
    @ApiOperation(value = "post new Just Dental registration user", notes = "post new Just Dental registration user", response = JdUser.class)
    public JdUser register(@FormParam("firstName") String firstName, @FormParam("lastName") String lastName,
                           @FormParam("emailAddress") String emailAddress, @FormParam("mobileNumber") String mobileNumber, @FormParam("password") String password) {

        LOGGER.info("New User registration received for email:" + emailAddress);
        JdUser jdUser = new JdUser();
//        JdRole jdRole = new JdRole();
//        jdRole.setRoleId(jdRoleDAO.findRoleIdByName(RoleType.PATIENT));
        Date createDate = new Date();
        jdUser.setDateCreated(createDate);
        jdUser.setDateModified(createDate);
        jdUser.setEmailAddress(emailAddress);
        jdUser.setPhoneNumber(mobileNumber);
        jdUser.setFirstName(firstName);
        jdUser.setLastName(lastName);
        jdUser.setUserPassword(password);
//        jdUser.setModifiedBy(emailAddress);
//        jdUser.setIsActive(1);
//        jdUser.setLicenseNumber("");
//        jdUser.setQualification("");
//        jdUser.setRoleId(jdRole);
//        jdUser.setUserType(RoleType.PATIENT.toString());
//        jdUser.setSpecialization("");
//        jdUser.setMiddleName("");
        return jdUserDAO.insert(jdUser);
    }

    @PUT
    @Path("/{id}")
    @UnitOfWork
    @ApiOperation(value = "update existing Just Dental Users", notes = "update existing Just Dental Users", response = JdUser.class)
    public JdUser update(@PathParam("id") Long id, @Valid JdUser jdUser) {
        jdUser.setUserId(id);
        jdUserDAO.update(jdUser);
        return jdUser;
    }

    @DELETE
    @Path("/{id}")
    @UnitOfWork
    @ApiOperation(value = "delete specific Just Dental Users", notes = "delete specific Just Dental Users", response = JdUser.class)
    public void delete(@PathParam("id") Long id) {
        jdUserDAO.delete(jdUserDAO.findById(id));
    }
}