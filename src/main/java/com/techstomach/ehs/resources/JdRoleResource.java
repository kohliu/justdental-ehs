package com.techstomach.ehs.resources;

import com.techstomach.ehs.core.JdRole;
import com.techstomach.ehs.dao.JdRoleDAO;
import io.dropwizard.hibernate.UnitOfWork;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by ujjwal on 2/24/2017.
 */
@Path("/jdrole")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
@Api(value = "/jdrole", description = "Just Dental Roles")
public class JdRoleResource {

    JdRoleDAO jdRoleDAO;

    public JdRoleResource(JdRoleDAO jdRoleDAO) {
        this.jdRoleDAO = jdRoleDAO;
    }

    @GET
    @UnitOfWork
    @ApiOperation(value = "get all Just Dental Roles", notes = "get all Just Dental Roles", response = JdRole.class)
    public List<JdRole> getAll() {
        return jdRoleDAO.getAll();
    }

    @GET
    @Path("/{id}")
    @UnitOfWork
    @ApiOperation(value = "get specific Just Dental Roles", notes = "get specific Just Dental Roles", response = JdRole.class)
    public JdRole get(@PathParam("id") Long id) {
        return jdRoleDAO.findById(id);
    }

    @POST
    @UnitOfWork
    @ApiOperation(value = "post new Just Dental Roles", notes = "post new Just Dental Roles", response = JdRole.class)
    public JdRole add(@Valid JdRole jdRole) {
        JdRole newJdRole = jdRoleDAO.insert(jdRole);
        return newJdRole;
    }

    @PUT
    @Path("/{id}")
    @UnitOfWork
    @ApiOperation(value = "update existing Just Dental Roles", notes = "update existing Just Dental Roles", response = JdRole.class)
    public JdRole update(@PathParam("id") Long id, @Valid JdRole jdRole) {
        jdRole.setRoleId(id);
        jdRoleDAO.update(jdRole);
        return jdRole;
    }

    @DELETE
    @Path("/{id}")
    @UnitOfWork
    @ApiOperation(value = "delete specific Just Dental Roles", notes = "delete specific Just Dental Roles", response = JdRole.class)
    public void delete(@PathParam("id") Long id) {
        jdRoleDAO.delete(jdRoleDAO.findById(id));
    }
}
