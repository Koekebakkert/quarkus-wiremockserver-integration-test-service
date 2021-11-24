package service;

import io.smallrye.graphql.client.typesafe.api.GraphQLClientApi;
import org.eclipse.microprofile.graphql.Name;
import org.eclipse.microprofile.graphql.Query;

@GraphQLClientApi(configKey = "graphql-service")
public interface GraphqlServiceClient {

    @Query(value = "echo")
    Echo echo(@Name("echo") Echo echo);
}
