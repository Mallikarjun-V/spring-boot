<h1>Spring Boot JPA Hibernate</h1>

The possible values for <b>hbm2ddl.auto</b>:

1. <b>create</b> - hibernate first drops the existing tables data and structure, then creates new tables and executes the operations on the newly created tables.

2. <b>validate</b> - hibernate only validates the table structure- whether the table and columns exist or not. If the table doesn’t exist then hibernate throws an exception. Validate is the default value for hbm2ddl.auto.

3. <b>update</b> - hibernate checks for the table and columns. If a table doesn’t exist then it creates new tables and where as if a column doesn’t exist it creates new columns for it.

4. <b>create-drop</b> -  hibernate first checks for a table and do the necessary operations and finally drops the table after all the operations were completed.


<b>@Entity</b> - annotation defines that a class can be mapped to a table. And that is it, it is just a marker, like for example Serializable interface.

And why @Entity annotation is mandatory? ... well, it is the way how JPA is designed. When you create a new entity you have to do at least two things

annotated it with @Entity

create an id field and annotate it with @Id

Anything else is optional, for example table name is derived from entity class name (and therefore @Table annotation can be optional), table's columns are derived from entities variables (and therefore @Column annotation can be optional), and so on




<b>Problems faced during development</b>

- Exception while running the Application
 .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.1.1.RELEASE)

2020-01-28 17:54:07.842  INFO 7472 --- [           main] c.learn.SpringBootHibernateApplication   : Starting SpringBootHibernateApplication on MALLIKARJUN with PID 7472 (E:\IDE\workspace\spring-boot-hibernate\target\classes started by MALLIKARJUN in E:\IDE\workspace\spring-boot-hibernate)
2020-01-28 17:54:07.849  INFO 7472 --- [           main] c.learn.SpringBootHibernateApplication   : No active profile set, falling back to default profiles: default
2020-01-28 17:54:08.781  INFO 7472 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data repositories in DEFAULT mode.
2020-01-28 17:54:08.875  INFO 7472 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 83ms. Found 1 repository interfaces.
2020-01-28 17:54:09.284  INFO 7472 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'org.springframework.transaction.annotation.ProxyTransactionManagementConfiguration' of type [org.springframework.transaction.annotation.ProxyTransactionManagementConfiguration$$EnhancerBySpringCGLIB$$d024049] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2020-01-28 17:54:09.942  INFO 7472 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
2020-01-28 17:54:09.971  INFO 7472 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2020-01-28 17:54:09.971  INFO 7472 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet Engine: Apache Tomcat/9.0.13
2020-01-28 17:54:09.984  INFO 7472 --- [           main] o.a.catalina.core.AprLifecycleListener   : The APR based Apache Tomcat Native library which allows optimal performance in production environments was not found on the java.library.path: [C:\Program Files\Java\jre1.8.0_202\bin;C:\Windows\Sun\Java\bin;C:\Windows\system32;C:\Windows;C:/Program Files/Java/jre1.8.0_202/bin/server;C:/Program Files/Java/jre1.8.0_202/bin;C:/Program Files/Java/jre1.8.0_202/lib/amd64;C:\Program Files (x86)\Common Files\Oracle\Java\javapath;C:\Program Files\Apache Software Foundation\apache-maven-3.3.9\bin;C:\ProgramData\Oracle\Java\javapath;C:\Program Files\MongoDB\Server\3.0\bin;C:\Windows\system32;C:\Windows;C:\Windows\System32\Wbem;C:\Program Files\Common Files\Microsoft Shared\Windows Live;C:\Program Files (x86)\Common Files\Microsoft Shared\Windows Live;C:\Program Files (x86)\Apache Software Foundation\apache-maven-3.3.3\bin;C:\Program Files (x86)\Windows Live\Shared;C:\Program Files (x86)\Windows Kits\8.1\Windows Performance Toolkit\;C:\Program Files\Microsoft SQL Server\110\Tools\Binn\;C:\Program Files\Microsoft SQL Server\120\Tools\Binn\;C:\Windows\System32\WindowsPowerShell\v1.0\;C:\Program Files (x86)\pgmodeler;C:\Windows\System32\WindowsPowerShell\v1.0\;C:\Program Files\Interactive Intelligence\ICUserApps\;C:\Program Files (x86)\Interactive Intelligence\ICUserApps\;C:\Program Files (x86)\Interactive Intelligence\ININ Trace Initialization\;C:\Program Files (x86)\Brackets\command;C:\Windows\System32\WindowsPowerShell\v1.0\;C:\Program Files\TortoiseGit\bin;C:\Program Files (x86)\Microsoft SQL Server\110\Tools\Binn\;C:\Program Files\Microsoft SQL Server\110\DTS\Binn\;C:\Program Files (x86)\Microsoft SQL Server\Client SDK\ODBC\130\Tools\Binn\;C:\Program Files (x86)\Microsoft SQL Server\140\Tools\Binn\;C:\Program Files (x86)\Microsoft SQL Server\140\DTS\Binn\;C:\Program Files (x86)\Microsoft SQL Server\140\Tools\Binn\ManagementStudio\;C:\Program Files\nodejs\;C:\Program Files\Zulu\zulu-11\bin\;G:\Program Files\Redis\;C:\Program Files\Git\cmd;C:\Program Files (x86)\Apache Software Foundation\apache-maven-3.3.3\bin;C:\Program Files (x86)\Git\bin;C:\Users\MALLIKARJUN\AppData\Roaming\npm;C:\Program Files\Docker Toolbox;E:\IDE\eclipse-jee-2019-09-R-win32-x86_64\eclipse;;.]
2020-01-28 17:54:10.226  INFO 7472 --- [           main] o.a.c.c.C.[.[.[/spring-boot-hibernate]   : Initializing Spring embedded WebApplicationContext
2020-01-28 17:54:10.227  INFO 7472 --- [           main] o.s.web.context.ContextLoader            : Root WebApplicationContext: initialization completed in 2291 ms
2020-01-28 17:54:10.422  INFO 7472 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
2020-01-28 17:54:10.746  INFO 7472 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
2020-01-28 17:54:10.824  INFO 7472 --- [           main] o.hibernate.jpa.internal.util.LogHelper  : HHH000204: Processing PersistenceUnitInfo [
	name: default
	...]
2020-01-28 17:54:10.930  INFO 7472 --- [           main] org.hibernate.Version                    : HHH000412: Hibernate Core {5.3.7.Final}
2020-01-28 17:54:10.931  INFO 7472 --- [           main] org.hibernate.cfg.Environment            : HHH000206: hibernate.properties not found
2020-01-28 17:54:11.192  INFO 7472 --- [           main] o.hibernate.annotations.common.Version   : HCANN000001: Hibernate Commons Annotations {5.0.4.Final}
2020-01-28 17:54:11.463  INFO 7472 --- [           main] org.hibernate.dialect.Dialect            : HHH000400: Using dialect: org.hibernate.dialect.PostgreSQL95Dialect
2020-01-28 17:54:11.651  INFO 7472 --- [           main] o.h.e.j.e.i.LobCreatorBuilderImpl        : HHH000424: Disabling contextual LOB creation as createClob() method threw error : java.lang.reflect.InvocationTargetException

java.lang.reflect.InvocationTargetException: null
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:1.8.0_202]
	at sun.reflect.NativeMethodAccessorImpl.invoke(Unknown Source) ~[na:1.8.0_202]
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(Unknown Source) ~[na:1.8.0_202]
	at java.lang.reflect.Method.invoke(Unknown Source) ~[na:1.8.0_202]
	at org.hibernate.engine.jdbc.env.internal.LobCreatorBuilderImpl.useContextualLobCreation(LobCreatorBuilderImpl.java:113) [hibernate-core-5.3.7.Final.jar:5.3.7.Final]
	at org.hibernate.engine.jdbc.env.internal.LobCreatorBuilderImpl.makeLobCreatorBuilder(LobCreatorBuilderImpl.java:54) [hibernate-core-5.3.7.Final.jar:5.3.7.Final]
	at org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentImpl.<init>(JdbcEnvironmentImpl.java:271) [hibernate-core-5.3.7.Final.jar:5.3.7.Final]
	at org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator.initiateService(JdbcEnvironmentInitiator.java:114) [hibernate-core-5.3.7.Final.jar:5.3.7.Final]
	at org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator.initiateService(JdbcEnvironmentInitiator.java:35) [hibernate-core-5.3.7.Final.jar:5.3.7.Final]
	at org.hibernate.boot.registry.internal.StandardServiceRegistryImpl.initiateService(StandardServiceRegistryImpl.java:94) [hibernate-core-5.3.7.Final.jar:5.3.7.Final]
	at org.hibernate.service.internal.AbstractServiceRegistryImpl.createService(AbstractServiceRegistryImpl.java:263) [hibernate-core-5.3.7.Final.jar:5.3.7.Final]
	at org.hibernate.service.internal.AbstractServiceRegistryImpl.initializeService(AbstractServiceRegistryImpl.java:237) [hibernate-core-5.3.7.Final.jar:5.3.7.Final]
	at org.hibernate.service.internal.AbstractServiceRegistryImpl.getService(AbstractServiceRegistryImpl.java:214) [hibernate-core-5.3.7.Final.jar:5.3.7.Final]
	at org.hibernate.id.factory.internal.DefaultIdentifierGeneratorFactory.injectServices(DefaultIdentifierGeneratorFactory.java:152) [hibernate-core-5.3.7.Final.jar:5.3.7.Final]
	at org.hibernate.service.internal.AbstractServiceRegistryImpl.injectDependencies(AbstractServiceRegistryImpl.java:286) [hibernate-core-5.3.7.Final.jar:5.3.7.Final]
	at org.hibernate.service.internal.AbstractServiceRegistryImpl.initializeService(AbstractServiceRegistryImpl.java:243) [hibernate-core-5.3.7.Final.jar:5.3.7.Final]
	at org.hibernate.service.internal.AbstractServiceRegistryImpl.getService(AbstractServiceRegistryImpl.java:214) [hibernate-core-5.3.7.Final.jar:5.3.7.Final]
	at org.hibernate.boot.internal.InFlightMetadataCollectorImpl.<init>(InFlightMetadataCollectorImpl.java:179) [hibernate-core-5.3.7.Final.jar:5.3.7.Final]
	at org.hibernate.boot.model.process.spi.MetadataBuildingProcess.complete(MetadataBuildingProcess.java:119) [hibernate-core-5.3.7.Final.jar:5.3.7.Final]
	at org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl.metadata(EntityManagerFactoryBuilderImpl.java:904) [hibernate-core-5.3.7.Final.jar:5.3.7.Final]
	at org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl.build(EntityManagerFactoryBuilderImpl.java:935) [hibernate-core-5.3.7.Final.jar:5.3.7.Final]
	at org.springframework.orm.jpa.vendor.SpringHibernateJpaPersistenceProvider.createContainerEntityManagerFactory(SpringHibernateJpaPersistenceProvider.java:57) [spring-orm-5.1.3.RELEASE.jar:5.1.3.RELEASE]
	at org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean.createNativeEntityManagerFactory(LocalContainerEntityManagerFactoryBean.java:365) [spring-orm-5.1.3.RELEASE.jar:5.1.3.RELEASE]
	at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.buildNativeEntityManagerFactory(AbstractEntityManagerFactoryBean.java:390) [spring-orm-5.1.3.RELEASE.jar:5.1.3.RELEASE]
	at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.afterPropertiesSet(AbstractEntityManagerFactoryBean.java:377) [spring-orm-5.1.3.RELEASE.jar:5.1.3.RELEASE]
	at org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean.afterPropertiesSet(LocalContainerEntityManagerFactoryBean.java:341) [spring-orm-5.1.3.RELEASE.jar:5.1.3.RELEASE]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.invokeInitMethods(AbstractAutowireCapableBeanFactory.java:1804) [spring-beans-5.1.3.RELEASE.jar:5.1.3.RELEASE]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1741) [spring-beans-5.1.3.RELEASE.jar:5.1.3.RELEASE]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:576) [spring-beans-5.1.3.RELEASE.jar:5.1.3.RELEASE]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:498) [spring-beans-5.1.3.RELEASE.jar:5.1.3.RELEASE]
	at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:320) [spring-beans-5.1.3.RELEASE.jar:5.1.3.RELEASE]
	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:222) ~[spring-beans-5.1.3.RELEASE.jar:5.1.3.RELEASE]
	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:318) [spring-beans-5.1.3.RELEASE.jar:5.1.3.RELEASE]
	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:199) [spring-beans-5.1.3.RELEASE.jar:5.1.3.RELEASE]
	at org.springframework.context.support.AbstractApplicationContext.getBean(AbstractApplicationContext.java:1083) ~[spring-context-5.1.3.RELEASE.jar:5.1.3.RELEASE]
	at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:853) ~[spring-context-5.1.3.RELEASE.jar:5.1.3.RELEASE]
	at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:546) ~[spring-context-5.1.3.RELEASE.jar:5.1.3.RELEASE]
	at org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext.refresh(ServletWebServerApplicationContext.java:142) ~[spring-boot-2.1.1.RELEASE.jar:2.1.1.RELEASE]
	at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:775) ~[spring-boot-2.1.1.RELEASE.jar:2.1.1.RELEASE]
	at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:397) ~[spring-boot-2.1.1.RELEASE.jar:2.1.1.RELEASE]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:316) ~[spring-boot-2.1.1.RELEASE.jar:2.1.1.RELEASE]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1260) ~[spring-boot-2.1.1.RELEASE.jar:2.1.1.RELEASE]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1248) ~[spring-boot-2.1.1.RELEASE.jar:2.1.1.RELEASE]
	at com.learn.SpringBootHibernateApplication.main(SpringBootHibernateApplication.java:10) ~[classes/:na]
Caused by: java.sql.SQLFeatureNotSupportedException: Method org.postgresql.jdbc.PgConnection.createClob() is not yet implemented.
	at org.postgresql.Driver.notImplemented(Driver.java:688) ~[postgresql-42.2.5.jar:42.2.5]
	at org.postgresql.jdbc.PgConnection.createClob(PgConnection.java:1269) ~[postgresql-42.2.5.jar:42.2.5]
	... 44 common frames omitted

2020-01-28 17:54:11.663  INFO 7472 --- [           main] org.hibernate.type.BasicTypeRegistry     : HHH000270: Type registration [java.util.UUID] overrides previous : org.hibernate.type.UUIDBinaryType@45cd7bc5
2020-01-28 17:54:12.499  INFO 7472 --- [           main] o.h.t.schema.internal.SchemaCreatorImpl  : HHH000476: Executing import script 'org.hibernate.tool.schema.internal.exec.ScriptSourceInputNonExistentImpl@29f3c438'
2020-01-28 17:54:12.501  INFO 7472 --- [           main] j.LocalContainerEntityManagerFactoryBean : Initialized JPA EntityManagerFactory for persistence unit 'default'
2020-01-28 17:54:13.062  INFO 7472 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
2020-01-28 17:54:13.127  WARN 7472 --- [           main] aWebConfiguration$JpaWebMvcConfiguration : spring.jpa.open-in-view is enabled by default. Therefore, database queries may be performed during view rendering. Explicitly configure spring.jpa.open-in-view to disable this warning
2020-01-28 17:54:13.408  INFO 7472 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path '/spring-boot-hibernate'
2020-01-28 17:54:13.410  INFO 7472 --- [           main] c.learn.SpringBootHibernateApplication   : Started SpringBootHibernateApplication in 6.07 seconds (JVM running for 6.638)



Resolution: changed spring-boot-starter version from 2.1.1.RELEASE to 2.2.4.RELEASE in pom.xml
	
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.1.1.RELEASE</version>
		<relativePath /> <!-- lookup parent from repository -->
	</parent>
	to
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.2.4.RELEASE</version>
		<relativePath /> <!-- lookup parent from repository -->
	</parent>
	
	

