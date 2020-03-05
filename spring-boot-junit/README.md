CI/CD Jenkins


Tomcat 9 Configuration

Update roles and user credentials - Configuring tomcat security
1. Go to $CATALINA_HOME/conf directory and look for tomcat-users.xml file
2. Open the file in your editor and add the following lines right before the last line 

	<user username="tomcatmanager" password="password" roles="manager-gui"/>
	<user username="deployer" password="password" roles="manager-script"/>
Here the deployer account would be used to deploy the WAR file over http. manager-gui based tomcatmanager user would be used to manage the manager web application at http://<HostName>:8080/manager

Github Configuration

1. Go to project https://github.com/Mallikarjun-V/spring-boot
2. Go to Settings, Click on Webhooks -> Add webhook
3. Enter Payload URL (Jenkins webhook): 
4. Select Content type: application/json
5. Enter Secret if set on Jenkins
6. Select Just the push event
7. Check Active
8. Click on Add webhook button


Jenkins Configuration

GitHub Integration plugin installation.
1. Go to Manage Jenkins
2. Select Manage Plugins
3. Select Installed -> search GitHub Integration
4. If GitHub Integration not installed, Goto Available
5. Select GitHub Integration
6. Click on Download now and install after restart


To add Maven Project in New Item Page,

1. Go to Manage Jenkins >> Manage Plugin,
	click on Available Tab,
	In the filter box enter "Maven plugin" and you will get search result as "Unleash Maven Plugin",
	√ enable the check-box, click on "Download now and install after restart"

2. Git Tool Installation
	Manage Jenkins -> Global Tool Configuration -> Git
3. Maven Tool Installation
	Manage Jenkins -> Global Tool Configuration -> Maven
4. Install Deploy to Container Plugin
	Manage Jenkins -> Manage Plugins -> Available -> Deploy to Container Plugin

Create New Maven Project	
Go to Jenkins Dashboard
1. Create New Item/Job
2. Enter Item Name
3. Select Maven project
4. Click Ok
5. On General, Check Github project -> Enter project url: https://github.com/Mallikarjun-V/spring-boot/
6. On Source Code Management, Check Git
7. Enter Repository url: https://github.com/Mallikarjun-V/spring-boot.git
8. Enter Credentials if it's private repository, else keep blank
6. On Build Triggers, check GitHub hook trigger for GITScm polling
7. Build - select Invoke top-level Maven targets
	Root POM: /spring-boot-junit/pom.xml 
	Goals and options: --debug clean install
7. Go to Post Build Actions
	Select Deploy ear/war to a container
	Enter 
		WAR/EAR files: /spring-boot-junit/target/spring-boot-junit.war
		Context path: spring-boot-junit
		Containers: Select Tomcat 9.x
		Select credentials
		Tomcat URL: http://<tomcat-server-ip>:8080
		

	