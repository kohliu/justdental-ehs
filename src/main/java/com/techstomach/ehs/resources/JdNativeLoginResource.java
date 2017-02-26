package com.techstomach.ehs.resources;

import com.techstomach.ehs.core.JdNativeLogin;
import com.techstomach.ehs.dao.JdNativeLoginDAO;
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
@Path("/jdnativelogin")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
@Api(value = "/jdnativelogin", description = "Just Dental Native login")
public class JdNativeLoginResource {

    JdNativeLoginDAO jdNativeLoginDAO;

    public JdNativeLoginResource(JdNativeLoginDAO jdRoleDAO) {
        this.jdNativeLoginDAO = jdRoleDAO;
    }

    @GET
    @UnitOfWork
    @ApiOperation(value = "get all Just Dental Native Logins", notes = "get all Just Dental Native Logins", response = JdNativeLogin.class)
    public List<JdNativeLogin> getAll() {
        return jdNativeLoginDAO.getAll();
    }

    @GET
    @Path("/{id}")
    @UnitOfWork
    @ApiOperation(value = "get specific Just Dental Native Logins", notes = "get specific Just Dental Native Logins", response = JdNativeLogin.class)
    public JdNativeLogin get(@PathParam("id") Long id) {
        return jdNativeLoginDAO.findById(id);
    }

    @POST
    @UnitOfWork
    @ApiOperation(value = "post new Just Dental Native Logins", notes = "post new Just Dental Native Logins", response = JdNativeLogin.class)
    public JdNativeLogin add(@Valid JdNativeLogin jdNativeLogin) {
        JdNativeLogin newJdNativeLogin = jdNativeLoginDAO.insert(jdNativeLogin);
        return newJdNativeLogin;
    }

    @PUT
    @Path("/{id}")
    @UnitOfWork
    @ApiOperation(value = "update existing Just Dental Native Logins", notes = "update existing Just Dental Native Logins", response = JdNativeLogin.class)
    public JdNativeLogin update(@PathParam("id") Long id, @Valid JdNativeLogin jdNativeLogin) {
        jdNativeLogin.setLoginId(id);
        jdNativeLoginDAO.update(jdNativeLogin);
        return jdNativeLogin;
    }

    @DELETE
    @Path("/{id}")
    @UnitOfWork
    @ApiOperation(value = "delete specific Just Dental Native Logins", notes = "delete specific Just Dental Native Logins", response = JdNativeLogin.class)
    public void delete(@PathParam("id") Long id) {
        jdNativeLoginDAO.delete(jdNativeLoginDAO.findById(id));
    }
}
