# address-book

### Overview
Simple test project, which simulates Address Book.
You can save/read addressses with phone numbers. Each address can have 1 to N phone numbers.

Screenshot: http://i.imgur.com/Mkj9CBV.png

### Running
The application uses Spring Boot with embedded Tomcat and HSQLDB. To run, just use command
*mvn clean spring-boot:run*

Nothing else is required - database and tables will be created in HSQLDB automatically.

### Full technology stack and reasons to choose
* Java 8 - because this the latest Java version, and I'm a Java-developer :)
* HSQLDB - because it should be enough for test task, and with such DBs you don't have to install anything on your PC
* Spring Boot - because it really speeds up the start with many default settings
* Spring Core - because it's de-facto a gold standart in enterprise development
* Spring MVC - because it's the best Web framework! :)
* Spring Data - because with Spring Data you nearly don't care what's the implementation of the database. you can switch it really quickly. and also the CRUD is generated for you - you should just use the basic interface methods
* JSP - because it's easy to use it with Spring MVC, easier than choosing some Web Framework as for such task
* Tomcat (Embedded) - because there is no need to install normal Tomcat or other application server, everything works out of the box
* Logback - the best and the most powerful logging library
* Bootstrap 3 - because I wanted to create a good modern design just out of the box, without spending too many effort on it
* HTML/CSS - for Web front-end development
* JavaScript/jQuery - for Web front-end development
* JUnit - because it's gold standard in unit testing
* Mockito - because Spring Tests work with Mockito out of the box. as for me, I like JMock more

### What else could be done (did not have enough time)
* Improving UI of the table (maybe adding hints for truncated values)
* More user-friendly validation messages, lighning up error inputs
* Ability to delete phone input after adding it
* Javadocs, comments
* Favicon :)
