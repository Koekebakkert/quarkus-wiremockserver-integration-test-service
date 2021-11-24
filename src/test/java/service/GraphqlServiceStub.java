package service;

import com.github.tomakehurst.wiremock.WireMockServer;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;
import java.util.Collections;
import java.util.Map;

public class GraphqlServiceStub implements QuarkusTestResourceLifecycleManager {

    private WireMockServer wireMockServer;

    @Override
    public Map<String, String> start() {

        String echoResult = "{\n"
                + "    \"data\": {\n"
                + "        \"echo\": {\n"
                + "            \"msg\": \"testing123\"\n"
                + "        }\n"
                + "    }\n"
                + "}";

        wireMockServer = new WireMockServer(0);
        wireMockServer.start();

        wireMockServer.stubFor(post(urlEqualTo("/"))
                .willReturn(aResponse()
                        .withHeader("Content-type", "application/json")
                        .withBody(echoResult)));

        return Collections.singletonMap("graphql-service/mp-graphql/url", wireMockServer.baseUrl());
    }

    @Override
    public void stop() {
        if (null != wireMockServer) {
            wireMockServer.stop();
            wireMockServer = null;
        }
    }

}
