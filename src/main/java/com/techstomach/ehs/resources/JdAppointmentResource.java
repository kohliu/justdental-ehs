package com.techstomach.ehs.resources;

import com.techstomach.ehs.core.JdAppointment;
import com.techstomach.ehs.dao.JdAppointmentDAO;
import io.dropwizard.hibernate.UnitOfWork;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by ujjwal on 3/1/2017.
 */
@Path("/jdappointment")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
@Api(value = "/jdappointment", description = "Just Dental Appointments")
public class JdAppointmentResource {

    JdAppointmentDAO jdAppointmentDAO;

    public JdAppointmentResource(JdAppointmentDAO jdAppointmentDAO) {
        this.jdAppointmentDAO = jdAppointmentDAO;
    }

    @GET
    @UnitOfWork
    @ApiOperation(value = "get all Just Dental Appointments", notes = "get all Just Dental Appointments", response = JdAppointment.class)
    public List<JdAppointment> getAll() {
        return jdAppointmentDAO.getAll();
    }

    @GET
    @Path("/{id}")
    @UnitOfWork
    @ApiOperation(value = "get specific Just Dental Appointments", notes = "get specific Just Dental Appointments", response = JdAppointment.class)
    public JdAppointment get(@PathParam("id") Long id) {
        return jdAppointmentDAO.findById(id);
    }

    @POST
    @UnitOfWork
    @ApiOperation(value = "post new Just Dental Appointments", notes = "post new Just Dental Appointments", response = JdAppointment.class)
    public JdAppointment add(@Valid JdAppointment jdAppointment ) {
        JdAppointment newJdAppointment  = jdAppointmentDAO.insert(jdAppointment );
        return newJdAppointment ;
    }

    @PUT
    @Path("/{id}")
    @UnitOfWork
    @ApiOperation(value = "update existing Just Dental Appointments", notes = "update existing Just Dental Appointments", response = JdAppointment.class)
    public JdAppointment update(@PathParam("id") Long id, @Valid JdAppointment jdAppointment) {
        jdAppointment.setAppointmentId(id);
        jdAppointmentDAO.update(jdAppointment);
        return jdAppointment;
    }

    @DELETE
    @Path("/{id}")
    @UnitOfWork
    @ApiOperation(value = "delete specific Just Dental Appointments", notes = "delete specific Just Dental Appointments", response = JdAppointment.class)
    public void delete(@PathParam("id") Long id) {
        jdAppointmentDAO.delete(jdAppointmentDAO.findById(id));
    }
}
