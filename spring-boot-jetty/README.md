Change Embedded Servlet Container in Spring Boot.

Exclude Embedded Tomcat starter from spring-boot-starter-web dependency. Add Jetty starter dependency.

	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
			<!-- excluding embedded Tomcat as we are going to embed Jetty -->
			<exclusions>
				<exclusion>
					<groupId>org.springframework.boot</groupId>
					<artifactId>spring-boot-starter-tomcat</artifactId>
				</exclusion>
			</exclusions>
		</dependency>
		
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-jetty</artifactId>
		</dependency>
	</dependencies>