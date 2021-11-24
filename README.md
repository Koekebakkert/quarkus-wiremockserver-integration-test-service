# quarkus-wiremockserver-integration-test-service

This project tests the integration with Wiremockserver and Quarkus.

To check the result of the integration test result with Quarkus:

```
mvn clean -Pintegration-test,image,use-docker -Dquarkus.version=2.1.0.Final verify
```

and for native:

```
mvn clean -Pintegration-test,image,use-docker,native -Dquarkus.version=2.1.0.Final verify
```

For quarkus.version 2.1.0.Final it will succeed, for [2.2.0.Final - 2.5.0.Final] it will fail.
