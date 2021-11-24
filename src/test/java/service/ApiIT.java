package service;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusIntegrationTest;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import org.junit.jupiter.api.Test;

@QuarkusIntegrationTest
@QuarkusTestResource(GraphqlServiceStub.class)
public class ApiIT {

    @Test
    public void testEcho() {
        given()
                .body("{\n"
                        + "  \"msg\": \"hello\"\n"
                        + "}")
                .header("Content-type",  "application/json")
                .when()
                .post("/echo")
                .then()
                .statusCode(200)
                .body(containsString("testing123"));
    }

}
