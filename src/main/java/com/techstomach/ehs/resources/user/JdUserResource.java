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

import com.techstomach.ehs.core.login.JdLoginTracking;
import com.techstomach.ehs.core.user.JdUser;
import com.techstomach.ehs.dao.login.JdLoginTrackingDAO;
import com.techstomach.ehs.dao.role.JdRoleDAO;
import com.techstomach.ehs.dao.user.JdUserDAO;
import io.dropwizard.hibernate.UnitOfWork;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.security.SecureRandom;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
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
    JdLoginTrackingDAO jdLoginTrackingDAO;

    public JdUserResource(JdUserDAO jdRoleDAO) {
        this.jdUserDAO = jdRoleDAO;
    }

    public JdUserResource(JdUserDAO jdRoleDAO, JdLoginTrackingDAO jdLoginTrackingDAO) {
        this.jdUserDAO = jdRoleDAO;
        this.jdLoginTrackingDAO = jdLoginTrackingDAO;
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

    @GET
    @Path("/email/{email}")
    @UnitOfWork
    @ApiOperation(value = "get specific Just Dental Users", notes = "get specific Just Dental Users", response = JdUser.class)
    public List<JdUser> get(@PathParam("email") String email) {
        return jdUserDAO.findByEmail(email);
    }

    @GET
    @Path("/userType/{userType}")
    @UnitOfWork
    @ApiOperation(value = "get specific Just Dental Users", notes = "get specific Just Dental Users", response = JdUser.class)
    public List<JdUser> getUserType(@PathParam("userType") String userType) {
        return jdUserDAO.findByUserType(userType);
    }

    @POST
    @UnitOfWork
    @ApiOperation(value = "post new Just Dental Users", notes = "post new Just Dental Users", response = JdUser.class)
    public Response add(@Valid JdUser jdUser) {
        LOGGER.info("User Add: adding user with username = " + jdUser.getUniqueUserId() + " and phone number = " + jdUser.getPhoneNumber());
        Date date = new Date();

        if(jdUser.getPhoneNumber() == null || jdUser.getPhoneNumber().length() == 0)
        {
            LOGGER.log(Level.WARNING, "User Add: invalid request. user's phone number is not provided");
            return Response.status(Response.Status.BAD_REQUEST).entity("{\"error\": \"invalid request. user's phone number is not provided\"}").build();
        }
        if(jdUser.getUniqueUserId() == null || jdUser.getUniqueUserId().length() == 0)
        {
            LOGGER.log(Level.WARNING, "User Add: invalid request. user's email address is not provided");
            return Response.status(Response.Status.BAD_REQUEST).entity("{\"error\": \"invalid request. user's email address is not provided\"}").build();
        }

        if (!jdUserDAO.findByUserName(jdUser.getUniqueUserId()).isEmpty()) {
            LOGGER.log(Level.WARNING, "User Add: user's email address is already registered, username = " + jdUser.getUniqueUserId() + " and phone number = " + jdUser.getPhoneNumber());
            return Response.status(Response.Status.BAD_REQUEST).entity("{\"error\": \"user's email address is already registered\"}").build();
        }
        if (!jdUserDAO.findByPhoneNumber(jdUser.getPhoneNumber()).isEmpty()) {
            LOGGER.log(Level.WARNING, "User Add: user's phone number is already registered, username = " + jdUser.getUniqueUserId() + " and phone number = " + jdUser.getPhoneNumber());
            return Response.status(Response.Status.BAD_REQUEST).entity("{\"error\": \"user's phone number is already registered\"}").build();
        }

        LOGGER.info("User Add: successfully added user with username = " + jdUser.getUniqueUserId() + " and phone number = " + jdUser.getPhoneNumber());
        jdUser.setDateCreated(date);
        JdLoginTracking newLoginTracker = new JdLoginTracking();
        newLoginTracker.setActive(Boolean.TRUE);
        newLoginTracker.setAppId("Browser");
        newLoginTracker.setDateCreated(new Date());
        final String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        newLoginTracker.setLoginGUID(uuid);
        HashSet<JdLoginTracking> logintrackerSet = new HashSet<>();
        logintrackerSet.add(newLoginTracker);
        jdUser.setLoggedInSession(logintrackerSet);
        return Response.ok(jdUserDAO.insert(jdUser)).build();
    }

    @POST
    @Path("/login")
    @UnitOfWork
    @ApiOperation(value = "post new Just Dental Users", notes = "post new Just Dental Users", response = JdUser.class)
    public Response login(@Valid JdUser jdUser) {
        // if login user name exists - if not then send jduser back
        //if user exists check password
        try
        {
            LOGGER.info("Login: searching user with username = " + jdUser.getUniqueUserId() + " and password = ****");
            List<JdUser> jdUsers = jdUserDAO.validateUserByUserName(jdUser.getUniqueUserId(), jdUser.getUserPassword());
            if (!jdUsers.isEmpty()) {
                LOGGER.info("Login: user found with matching username and password");
                JdUser validatedUser = jdUsers.get(0);
                LOGGER.info("Generating a loginTracker for this user");
                List<JdLoginTracking> jdLoginTracking = jdLoginTrackingDAO.findActiveLoginByUserId(validatedUser.getUserId());
                if(jdLoginTracking!=null && jdLoginTracking.size()>0) {
                    JdLoginTracking activeTracker = jdLoginTracking.get(0);
                    // check if the sesssion has expired from the login tracker createDate
                    DateTime now = new DateTime(new Date());
                    DateTime sessionCreateTime = new DateTime(activeTracker.getDateCreated());
                    // 1 hour session expiry
                    DateTime sessionExpiryDate = sessionCreateTime.plusHours(1);
                LOGGER.info("Session create time: "+sessionCreateTime+ ", session expiry time: "+sessionExpiryDate);
                    if (sessionExpiryDate.isAfter(now)) {
                        LOGGER.info("User session is still active");
                        return Response.ok(validatedUser).build();
                    } else {
                        LOGGER.info("User session is obsolete and a new login session id is required");
                        activeTracker.setActive(Boolean.FALSE);
                        jdLoginTrackingDAO.update(activeTracker);
                        HashSet<JdLoginTracking> logintrackerSet = new HashSet<>();
                        logintrackerSet.add(activeTracker);
                        validatedUser.setLoggedInSession(logintrackerSet);
                        return Response.ok(validatedUser).build();
                    }
                }else {
                    LOGGER.info("User does not have an active logged in session. Creating a new session");
                    JdLoginTracking newLoginTracker = new JdLoginTracking();
                    newLoginTracker.setActive(Boolean.TRUE);
                    newLoginTracker.setAppId("Browser");
                    newLoginTracker.setDateCreated(new Date());
                    final String uuid = UUID.randomUUID().toString().replaceAll("-", "");
                    newLoginTracker.setLoginGUID(uuid);
                    HashSet<JdLoginTracking> logintrackerSet = new HashSet<>();
                    logintrackerSet.add(newLoginTracker);
                    validatedUser.setLoggedInSession(logintrackerSet);
                    jdUserDAO.insert(validatedUser);
                    return Response.ok(validatedUser).build();
                }
            }
            else
            {
                LOGGER.info("Login: user not found with matching username and password. trying with phoneNumber ...");
                jdUsers = jdUserDAO.validateUserByPhone(jdUser.getPhoneNumber(), jdUser.getUserPassword());
                if (!jdUsers.isEmpty()) {
                    LOGGER.info("Login: user found with matching phoneNumber and password");
                    return Response.ok(jdUsers.get(0)).build();
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            return Response.serverError()
                    .entity("{\"error\": \"user login failed because of exception: " + e.toString() + "\"}")
                    .build();
        }

        LOGGER.info("Login: no user found with matching phoneNumber/username and password");
        return Response.status(Response.Status.UNAUTHORIZED)
                .entity("{\"error\": \"user is not authorized\"}")
                .build();
    }

    @Deprecated
    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @UnitOfWork
    @ApiOperation(value = "post new Just Dental registration user", notes = "post new Just Dental registration user", response = JdUser.class)
    public JdUser register(@FormParam("firstName") String firstName, @FormParam("lastName") String lastName,
                           @FormParam("emailAddress") String emailAddress, @FormParam("mobileNumber") String mobileNumber, @FormParam("password") String password) {

        LOGGER.info("New User registration received for email:" + emailAddress);
        JdUser jdUser = new JdUser();
        Date createDate = new Date();
        jdUser.setDateCreated(createDate);
        jdUser.setDateModified(createDate);
        jdUser.setEmailAddress(emailAddress);
        jdUser.setPhoneNumber(mobileNumber);
        jdUser.setFirstName(firstName);
        jdUser.setLastName(lastName);
        jdUser.setUserPassword(password);
        System.out.println(jdUser.getEmailAddress());
        return jdUserDAO.insert(jdUser);
    }

    @PUT
    @Path("/{id}")
    @UnitOfWork
    @ApiOperation(value = "update existing Just Dental Users", notes = "update existing Just Dental Users", response = JdUser.class)
    public JdUser update(@PathParam("id") Long id, @Valid JdUser jdUser) {

        LOGGER.info("User Update: updating user with username = " + jdUser.getUniqueUserId() + " and phone number = " + jdUser.getPhoneNumber());
        Date date = new Date();

        jdUser.setUserId(id);
        jdUser.setDateModified(date);

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
