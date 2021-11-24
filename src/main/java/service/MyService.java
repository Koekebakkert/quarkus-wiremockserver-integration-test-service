package service;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class MyService {

    @Inject
    GraphqlServiceClient graphqlService;

    public String echo(String msg) {
        return graphqlService.echo(new Echo(msg)).getMsg();
    }

}
