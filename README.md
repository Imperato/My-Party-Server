# Introduction 
My Party is a web based project for parties in wich users can work in 2 different modalities:
1) organizer: he can see the parties created by him; create, edit and delete his parties and delete his account
2) user: he can see all the parties uploaded by the organizers, get tickets for the parties and delete his account

# Finalities
This project wants to be a simple example for beginners on how to use Rest principles to build a web service.

# Server
RESTful web service developed in Java and working with an external MySQL database. The communication between server and client takes place through HTTP protocol and his methods (GET, POST, PUT, DELETE). The representation of resources used during the communication is in JSON.

# Project Structure
The project is divided into 3 packages:
1) dao: contains classes Access (in which there are all the methods to get, post, update and delete resources from MySQL database) and Database (creates the connection to database)
2) model: contains AccessManager class (get the connection to database from Database class and passes it as parameter to Access class) and all the other POJO classes used to represent database resources in Java
3) resources: creates connection between server and client. Contains classes which map urls and HTTP methods (that must be specified by the client) with the relative Java methods (that provide/require JSON objects from/by clients)

# Database
The path to database is specified in dao/Database class, in the connectionURL String variable (line 12). I added "?autoReconnect=true&useSSL=false" at the end of the path as solution to issues occurred during testing phase. In line 14 is specified the driver to use for the connection (passed as parameter to forName method) and in line 15 are specified the credentials to access the database (in my case username=root and password=root).

# Tips
For developing and testing I used Eclipse Neon 3 dynamic web project connected to Apache Tomcat 8.0 (previously installed). For testing I used Google Postman. The URL to resources is specified in WebContent/WEB-INF/web.xml and in resources package classes:
1) in web.xml: in line 3 (between display-name tag) is specified the first part of the url (myParty); in line 15 (between url-pattern tag) is specified the second part of the url (rest)
2) in resources package classes: the last part of the url (the one who identificate the resource) is specified in @Path variables

The HTTP method (GET, POST, ecc...) is specified in the client request

The full path is composed by web server address and url like this: 
http://web_server_address:web_server_port/display-name/url-pattern/url_to_resource
for example: http://127.0.0.1:8080/myParty/rest/parties

# Thanks to
1) JAX-RS
2) Jersey
3) Jackson
4) Gson

