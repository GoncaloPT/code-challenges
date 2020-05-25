package pt.goncalo.microprofilefirsttryout.service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
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
import java.util.Objects;

import static javax.ws.rs.core.Response.Status.BAD_REQUEST;

/*
 * Created by: @author Gonçalo Silva
 * 20/05/2020
 */
@Path("person")
@RequestScoped
//strange syntax is for java 7 compatibility
@RequiredArgsConstructor(onConstructor = @__(@Inject))
@Tag(name = "Person service", description = "Interact with person entity")
public class PersonService {

    /**
     * CDI Eyes only
     */
    public PersonService() {
        this(null);
    }


    private final PersonRepository repository;

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    //Open API Metadata
    @Operation(description = "Get person with specified id")
    @APIResponses({
            @APIResponse(responseCode = "200", description = "There you have it!"),
            @APIResponse(responseCode = "404", description = "Can't find it...."),
            @APIResponse(responseCode = "400", description = "Say again?!")
    })
    public Response get(@PathParam("id") String id) {
        if(Objects.isNull(id) || id.isEmpty()){
            return Response.status(BAD_REQUEST).build();
        }
        Person p = repository.get(id);
        return Response.ok(p).build();
    }

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    //Open API Metadata
    @Operation(description = "Get everyone aboard!")
    @APIResponses({
            @APIResponse(responseCode = "200", description = "There you have it!")
    })
    public Response list() {
        return Response.ok(repository.list()).build();
    }


}
