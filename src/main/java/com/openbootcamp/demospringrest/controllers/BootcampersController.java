package com.openbootcamp.demospringrest.controllers;

import com.openbootcamp.demospringrest.models.Bootcamper;
import com.openbootcamp.demospringrest.services.BootcamperService;

import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;


@Component
@Path("/")
public class BootcampersController {
    private final BootcamperService bootcamperService;


    public BootcampersController(BootcamperService bootcamperService) {
        this.bootcamperService = bootcamperService;

        this.bootcamperService.add(new Bootcamper("pedro", 1));
        this.bootcamperService.add(new Bootcamper("jose", 2));
        this.bootcamperService.add(new Bootcamper("pablito",3));
    }

    @GET
    @Path("/bootcampers")
    @Produces("application/json")
    public List<Bootcamper> listarTodos(){
        return bootcamperService.getAll();
    }

    @GET
    @Path("/bootcampers/{nombre}")
    @Produces("application/json")
    public Bootcamper listaruno(@PathParam("nombre")String nombre) {
        return bootcamperService.get(nombre);
    }

    @POST
    @Path("/bootcampers")
    @Produces("application/json")
    @Consumes("application/json")
    public Response meterBootcamper(Bootcamper bootcamper) {
        bootcamperService.add(bootcamper);

        return Response.created(URI.create("/bootcampers/" + bootcamper.getNombre() + bootcamper.getValor())
        ).build();
    }

    @DELETE
    @Path("/bootcampers/{nombre}")
    public void removeBootcampers(@PathParam("nombre") String nombre) {
        bootcamperService.deleteByName(nombre);
    }

    @DELETE
    @Path("/bootcampers")
    public void removeAllBootcampers(){
        bootcamperService.deleateAll();
    }
}
