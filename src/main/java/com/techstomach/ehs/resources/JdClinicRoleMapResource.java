package com.techstomach.ehs.resources;

import com.techstomach.ehs.core.JdClinicRoleMap;
import com.techstomach.ehs.dao.JdClinicRoleMapDAO;
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
@Path("/jdclinicrolemap")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
@Api(value = "/jdclinicrolemap", description = "Just Dental Clinic & User Role Map")
public class JdClinicRoleMapResource {

    JdClinicRoleMapDAO jdClinicRoleMapDAO;

    public JdClinicRoleMapResource(JdClinicRoleMapDAO jdClinicRoleMapDAO) {
        this.jdClinicRoleMapDAO = jdClinicRoleMapDAO;
    }

    @GET
    @UnitOfWork
    @ApiOperation(value = "get all Just Dental Booking Slots", notes = "get all Just Dental Booking Slots", response = JdClinicRoleMap.class)
    public List<JdClinicRoleMap> getAll() {
        return jdClinicRoleMapDAO.getAll();
    }

    @GET
    @Path("/{id}")
    @UnitOfWork
    @ApiOperation(value = "get specific Just Dental Booking Slots", notes = "get specific Just Dental Booking Slots", response = JdClinicRoleMap.class)
    public JdClinicRoleMap get(@PathParam("id") Long id) {
        return jdClinicRoleMapDAO.findById(id);
    }

    @POST
    @UnitOfWork
    @ApiOperation(value = "post new Just Dental Booking Slots", notes = "post new Just Dental Booking Slots", response = JdClinicRoleMap.class)
    public JdClinicRoleMap add(@Valid JdClinicRoleMap jdClinicRoleMap ) {
        JdClinicRoleMap newJdClinicRoleMap = jdClinicRoleMapDAO.insert(jdClinicRoleMap);
        return newJdClinicRoleMap ;
    }

    @PUT
    @Path("/{id}")
    @UnitOfWork
    @ApiOperation(value = "update existing Just Dental Booking Slots", notes = "update existing Just Dental Booking Slots", response = JdClinicRoleMap.class)
    public JdClinicRoleMap update(@PathParam("id") Long id, @Valid JdClinicRoleMap jdClinicRoleMap) {
        jdClinicRoleMap.setClinicRoleId(id);
        jdClinicRoleMapDAO.update(jdClinicRoleMap);
        return jdClinicRoleMap;
    }

    @DELETE
    @Path("/{id}")
    @UnitOfWork
    @ApiOperation(value = "delete specific Just Dental Booking Slots", notes = "delete specific Just Dental Booking Slots", response = JdClinicRoleMap.class)
    public void delete(@PathParam("id") Long id) {
        jdClinicRoleMapDAO.delete(jdClinicRoleMapDAO.findById(id));
    }
}
