package com.techstomach.ehs.resources;

import com.techstomach.ehs.core.JdUser;
import com.techstomach.ehs.dao.JdUserDAO;
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
@Path("/jduser")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
@Api(value = "/jduser", description = "Just Dental Users {Doctors,Patients,Admins etc.}")
public class JdUserResource {
    JdUserDAO jdUserDAO;

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
