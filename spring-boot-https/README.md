
TO generate self-signed SSL certificate.
Go to JDK/bin from command prompt, execute the below command and follow the instructions.

	keytool -genkey -alias tomcat -storetype PKCS12 -keyalg RSA -keysize 2048 -keystore keystore.p12 -validity 3650

copy the keystore file from JDK/bin to the project root folder.

Make the following changes in application.properties

	server.servlet.context-path:/spring-boot-https
	server.port:443
	server.ssl.key-store:keystore.p12
	server.ssl.key-store-password:password
	server.ssl.keyStoreType:PKCS12
	server.ssl.keyAlias:tomcat