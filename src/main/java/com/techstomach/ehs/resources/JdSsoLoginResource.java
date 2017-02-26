package com.techstomach.ehs.resources;

import com.techstomach.ehs.core.JdSsoLogin;
import com.techstomach.ehs.dao.JdSsoLoginDAO;
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
@Path("/jdssologin")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
@Api(value = "/jdssologin", description = "Just Dental Sso login")
public class JdSsoLoginResource {


    JdSsoLoginDAO jdSsoLoginDAO;

    public JdSsoLoginResource(JdSsoLoginDAO jdSsoLoginDAO) {
        this.jdSsoLoginDAO = jdSsoLoginDAO;
    }

    @GET
    @UnitOfWork
    @ApiOperation(value = "get all Just Dental Sso login", notes = "get all Just Dental Sso login", response = JdSsoLogin.class)
    public List<JdSsoLogin> getAll() {
        return jdSsoLoginDAO.getAll();
    }

    @GET
    @Path("/{id}")
    @UnitOfWork
    @ApiOperation(value = "get specific Just Dental Sso login", notes = "get specific Just Dental Sso login", response = JdSsoLogin.class)
    public JdSsoLogin get(@PathParam("id") Long id) {
        return jdSsoLoginDAO.findById(id);
    }

    @POST
    @UnitOfWork
    @ApiOperation(value = "post new Just Dental Sso login", notes = "post new Just Dental Sso login", response = JdSsoLogin.class)
    public JdSsoLogin add(@Valid JdSsoLogin jdSsoLogin) {
        JdSsoLogin newJdSsoLogin = jdSsoLoginDAO.insert(jdSsoLogin);
        return newJdSsoLogin;
    }

    @PUT
    @Path("/{id}")
    @UnitOfWork
    @ApiOperation(value = "update existing Just Dental Sso login", notes = "update existing Just Dental Sso login", response = JdSsoLogin.class)
    public JdSsoLogin update(@PathParam("id") Long id, @Valid JdSsoLogin jdSsoLogin) {
        jdSsoLogin.setSsoLoginId(id);
        jdSsoLoginDAO.update(jdSsoLogin);
        return jdSsoLogin;
    }

    @DELETE
    @Path("/{id}")
    @UnitOfWork
    @ApiOperation(value = "delete specific Just Dental Sso login", notes = "delete specific Just Dental Sso login", response = JdSsoLogin.class)
    public void delete(@PathParam("id") Long id) {
        jdSsoLoginDAO.delete(jdSsoLoginDAO.findById(id));
    }
}
