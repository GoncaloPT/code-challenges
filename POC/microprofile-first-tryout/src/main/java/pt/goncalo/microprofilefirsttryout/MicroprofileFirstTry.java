package pt.goncalo.microprofilefirsttryout;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.servers.Server;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/*
 * Created by: @author Gonçalo Silva
 * 20/05/2020
 */
@ApplicationPath("microprofile")
@OpenAPIDefinition(info = @Info(
        title = "Microprofile first try",
        version = "1.0.0",
        contact = @Contact(
                name = "Gonçalo Silva",
                email = "goncalosamuel@gmail.com",
                url = "https://github.com/GoncaloPT")
        ),
        servers = {
                @Server(url = "/microprofile", description = "localhost")

        })

public class MicroprofileFirstTry extends Application {

}
