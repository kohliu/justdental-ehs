package com.techstomach.ehs.resources;

import com.techstomach.ehs.core.JdBookingSlots;
import com.techstomach.ehs.dao.JdBookingSlotsDAO;
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
@Path("/jdbookingslots")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
@Api(value = "/jdbookingslots", description = "Just Dental Booking Slots")
public class JdBookingSlotsResource {

    JdBookingSlotsDAO jdBookingSlotsDAO;

    public JdBookingSlotsResource(JdBookingSlotsDAO jdBookingSlotsDAO) {
        this.jdBookingSlotsDAO = jdBookingSlotsDAO;
    }

    @GET
    @UnitOfWork
    @ApiOperation(value = "get all Just Dental Booking Slots", notes = "get all Just Dental Booking Slots", response = JdBookingSlots.class)
    public List<JdBookingSlots> getAll() {
        return jdBookingSlotsDAO.getAll();
    }

    @GET
    @Path("/{id}")
    @UnitOfWork
    @ApiOperation(value = "get specific Just Dental Booking Slots", notes = "get specific Just Dental Booking Slots", response = JdBookingSlots.class)
    public JdBookingSlots get(@PathParam("id") Long id) {
        return jdBookingSlotsDAO.findById(id);
    }

    @POST
    @UnitOfWork
    @ApiOperation(value = "post new Just Dental Booking Slots", notes = "post new Just Dental Booking Slots", response = JdBookingSlots.class)
    public JdBookingSlots add(@Valid JdBookingSlots jdBookingSlots ) {
        JdBookingSlots newJdBookingSlots = jdBookingSlotsDAO.insert(jdBookingSlots);
        return newJdBookingSlots ;
    }

    @PUT
    @Path("/{id}")
    @UnitOfWork
    @ApiOperation(value = "update existing Just Dental Booking Slots", notes = "update existing Just Dental Booking Slots", response = JdBookingSlots.class)
    public JdBookingSlots update(@PathParam("id") Long id, @Valid JdBookingSlots jdBookingSlots) {
        jdBookingSlots.setSlotId(id);
        jdBookingSlotsDAO.update(jdBookingSlots);
        return jdBookingSlots;
    }

    @DELETE
    @Path("/{id}")
    @UnitOfWork
    @ApiOperation(value = "delete specific Just Dental Booking Slots", notes = "delete specific Just Dental Booking Slots", response = JdBookingSlots.class)
    public void delete(@PathParam("id") Long id) {
        jdBookingSlotsDAO.delete(jdBookingSlotsDAO.findById(id));
    }
}
