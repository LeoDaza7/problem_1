# problem_1

### Description

This is a Java 8 Maven based API using Spring boot, lombok and Swagger dependencies.
REST API for a system that assigns students to classes. The API can be used by both a UI and programmatically by other systems.

### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.3.1.RELEASE/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.3.1.RELEASE/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.3.1.RELEASE/reference/htmlsingle/#boot-features-developing-web-applications)
* [Lombok](https://projectlombok.org/)
* [Swagger](https://mvnrepository.com/artifact/io.springfox/springfox-swagger-ui/2.9.2)

### CLI deploy

Please run the following commands on a CLI open at the root directory of the project.

From `.jar` file:

```shell script
mvn clean package
java -jar ./target/problem_1-0.0.1-SNAPSHOT.jar
```

Or

```shell script
mvn clean package
mvn spring-boot:run
```

### IDE deploy

First please add `Problem1Application` class to the Run/Debug configurations.
Then install the Lombok plugin in your preferred IDE.

#### IntelliJ IDEA
```text
Go to File > Settings > Plugins
Click on Browse repositories...
Search for Lombok Plugin
Click on Install plugin
Restart IntelliJ IDEA
```

#### Visual Studio Code
```text
press Ctrl + Shift + X to open the extension manager.
Type lombok to find the plugin, and click install.
Reload VS Code when asked.
```

#### Eclipse
```text
Double-click lombok.jar (downloadable from this site, or from your maven repository; it's the same jar). 
This starts the eclipse installer which will find eclipse (and eclipse variants as listed above),
and offers to install lombok into these eclipse installations.
```

### API swagger ui url

http://localhost:8080/swagger-ui.html

### Test ###

```shell script
mvn clean package
mvn test
```
