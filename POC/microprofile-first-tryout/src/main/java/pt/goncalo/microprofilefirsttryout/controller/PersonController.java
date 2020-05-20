package pt.goncalo.microprofilefirsttryout.controller;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import pt.goncalo.microprofilefirsttryout.model.Person;
import pt.goncalo.microprofilefirsttryout.repository.PersonRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.UUID;

/*
 * Created by: @author Gonçalo Silva
 * 20/05/2020
 */
@Path("person")
@RequestScoped
//strange syntax is for java 7 compatibility
@RequiredArgsConstructor(onConstructor = @__(@Inject))
public class PersonController {

    /**
     * CDI Eyes only
     */
    public PersonController() {
        this(null);
    }


    private final PersonRepository repository;

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") String id){
        Person p = repository.get(id);
        return Response.ok(p).build();
    }

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response list(){
        return Response.ok(repository.list()).build();
    }




}
