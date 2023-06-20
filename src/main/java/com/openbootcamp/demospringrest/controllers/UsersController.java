package com.openbootcamp.demospringrest.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.openbootcamp.demospringrest.models.User;
import com.openbootcamp.demospringrest.services.UserService;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
@Path("/")
public class UsersController {

    ObjectMapper objectMapper = new ObjectMapper();
    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;

        this.userService.add(new User(1L, "kaorufl@gmail.com", "juancito", "Torres","https://reqres.in/img/faces/2-image.jpg"));
        this.userService.add(new User(2L, "janet.weaver@reqres.in", "Janet", "Weaver", "https://reqres.in/img/faces/2-image.jpg"));
    }

    @GET
    @Path("/users")
    @Produces("application/json")
    public List<User> listarTodos(){
        return userService.getAll();
    }

    @DELETE
    @Path("/users/{id}")
    public Response EliminarPorId (@PathParam("id")Long id){

        try {
            userService.remove(id);
            return Response.noContent().build();
        } catch (Exception e) {
            return Response.serverError().build();
        }
    }


    @GET
    @Path("/users/{id}")
    @Produces("application/json")
    public Response ListarUnoPorId (@PathParam("id") Long id){
        User user = userService.get(id);

        if (user != null){
            Map<String, Object> response = new HashMap<>();
            response.put("Data", user);

            try {
                String json = objectMapper.writeValueAsString(response);
                return Response.ok(json).build();
            } catch (JsonProcessingException e){
                return Response.serverError().build();
            }

        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }


}
