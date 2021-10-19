# spi - demo

Demonstration how to extend the default keycloak registration validation to only allow e-mail addresses from a specific domain.

Steps to deploy and  test:
1. run `mvn clean install` to get the jar file with dependencies.
2. download and extract keycloak (keycloak 15.0.2 used for this example: https://www.keycloak.org/archive/downloads-15.0.2.html)
3. copy the spi jar to keycloak deployments folder ({keycloak}/standalone/deployments)
4. start the keycloak ({keycloak}/standalone/bin/standalone.sh / bat)
5. the spi should be deployed, keycloak should say something like: `08:25:50,948 INFO  [org.keycloak.subsystem.server.extension.KeycloakProviderDeploymentProcessor] (MSC service thread 1-8) Deploying Keycloak provider: test-1-jar-with-dependencies.jar
   `
6. create and configure a realm using keycloak admin interface (http://localhost:8080), allow user registration in the realm login config tab
7. in the 'Authorization' admin part: 
   1. copy the registration flow and add our spi to the copied flow
   2. set the copied registration flow as the default registration flow in the 'Bindings' tab
8. try to register a new user using the account client (http://localhost:8080/auth/realms/test/account, click login and then register a new user - only the users with @willhaben.at emails should be accepted, otherwise an error should be shown



Live coded during java vienna oktober 2021 meetup (https://www.meetup.com/Java-Vienna/events/280658091/)

