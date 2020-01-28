<h1>Spring Boot Profiles</h1>

<h2>Profile-specific Properties</h2>

In addition to application.properties files, profile-specific properties can also be defined by using the following naming convention: application-{profile}.properties. The Environment has a set of default profiles (by default, [default]) that are used if no active profiles are set. In other words, if no profiles are explicitly activated, then properties from application-default.properties are loaded.

Profile-specific properties are loaded from the same locations as standard application.properties, with profile-specific files always overriding the non-specific ones, whether or not the profile-specific files are inside or outside your packaged jar.

If several profiles are specified, a last-wins strategy applies. For example, profiles specified by the spring.profiles.active property are added after those configured through the SpringApplication API and therefore take precedence.

<h2>Placeholder in Properties</h2>
The values in application.properties are filtered through the existing Environment when they are used, so you can refer back to previously defined values (for example, from System properties).

>> app.name=MyApp
>> app.description=${app.name} is a Spring Boot application

<h2>Profiles</h2>

Spring applications typically need to run in multiple environments. e.g., development, testing, staging, and production. Each environment has its own set of properties. e,g., you might need to use Postgres for development, MySQL for production. Hence the database connection properties differ while running application during development/production. In such cases, you can Spring Profiles. 
Spring Profiles provide a way to segregate parts of the application configuration an make it available only in certain environments.

Any @Component, @Configuration or @ConfigurationProperties can be marked with @Profile to limit when it is loaded, as shown in the following example:

@Configuration(proxyBeanMethods = false)
@Profile("production")
public class ProductionConfiguration {

    // ...

}

Note: If @ConfigurationProperties beans are registered via @EnableConfigurationProperties instead of automatic scanning, the @Profile annotation needs to be specified on the @Configuration class that has the @EnableConfigurationProperties annotation. In the case where @ConfigurationProperties are scanned, @Profile can be specified on the @ConfigurationProperties class itself.

You can use a <b>spring.profiles.active</b> Environment property to specify which profiles are active. you could include it in your application.properties, as shown in the following example:

<b>spring.profiles.active=dev,hsqldb</b>
You could also specify it on the command line by using the following switch: <b>--spring.profiles.active=dev,hsqldb</b>
e.g.,
cmd> java -jar spring-boot-actuator.jar --spring.profiles.active=dev

The spring.profiles.active property follows the same ordering rules as other properties: The highest PropertySource wins. This means that you can specify active profiles in application.properties and then replace them by using the command line switch.

Sometimes, it is useful to have profil-specific properties that add to the active profiles rather than replace them. The spring.profiles.include property can be used to unconditionally add active profiles. The SpringApplication entry point also has a Java API for setting additional profiles (that is, on top of those activated by the spring.profiles.active property). See the setAdditionalProfiles() method in SpringApplication

For example, when an application with the following properties is run by using the switch, --spring.profiles.active=prod, the proddb and prodmq profiles are also activated:

---
my.property: fromyamlfile
---
spring.profiles: prod
spring.profiles.include:
  - proddb
  - prodmq


<h1>Accessing Command Line Properties</h1>

By default, SpringApplication converts any command line option arguments (that is, arguments starting with --, such as --server.port=9000) to a property and adds them to the Spring Environment. As mentioned previously, command line properties always take precedence over other property sources.

If you do not want command line properties to be added to the Environment, you can disable them by using SpringApplication.setAddCommandLineProperties(false).

Application Testing

Run the SpringBootProfileApplication.java using the command
>> java -jar spring-boot-profile.jar --spring.profiles.active=qa

Spring will load application.properties and application-qa.properties into spring environment.

Access the URL

http://localhost:8080/spring-boot-actuator/profiles

Above API returns the active profile DB based on the @Profile(..) annotation.
