package service;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RequestScoped
@Path("/echo")
public class ApiResource {

    @Inject
    MyService myService;

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String echo(Echo echo) {
        return myService.echo(echo.getMsg());
    }

}
