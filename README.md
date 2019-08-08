# fashion-catalog
Spring Boot and React project for Fashion products catalog

# Fashion Catalog Backend details
----------------------------------------------------------------------------------------
1) From the root directory, package the application with command > mvn package

2) As the docker-maven-plugin is added to pom.xml, packaging the application should automatically create a new image in docker.

3) Alternatively(if step 2 is skipped), from the root directory of the project, execute "docker build --tag=fashionapp ." command. (This will build the application and create a docker image on the local)

3) Execute "docker run -p 8080:8080 -t fashionapp:0.0.1-SNAPSHOT" command to start the application.

4) If you run as standalone application and not on docker, do a maven clean build > "mvn clean install" 
   and then >"java -jar fashion-catalog-0.0.1-SNAPSHOT.jar"
   
5) You can use Swagger to test the application, 
	Swagger UI -> http://localhost:8080/swagger-ui.html

6) This application is built with spring boot embedded In-Memory H2 Database.
   Hence, the state is maintained only until the application is up and running. 
   Tables are automatically created on server startup using CommandRunner.Alternatively, you can change the datasource to external database for persistence
   
7) Test cases are covered for various classes using Unit and Integration testing.
   
   

#Fashion Catalog Front End details
----------------------------------------------------------------------------------------
1) Front end is build with React.js

2) npm modules are installed react_code directory

3) npm installation is added as part of maven build plugin

4) Once npm install is completed, npm build happens and moves the compiled code to src/main/resources/static directory.
5) Alternatively , if the spring boot application is up and running, front end app can be started by using >npm start command under react_code directory
6) Product catalog is pre-loaded with a set of fashion products of different brands.
7) By default landing page calls Product List API and loads all the products from the inventory
8) Search works with Title and brand as keywords. If there is no match, search will return the Trending list of products which are updated randomly
9) I haven't created a fancy UI but just left it vanilla way as simple as I can. 
10) Bootstrap could've been used for better UX


#Fashion Catalog API details and Key points
----------------------------------------------------------------------------------------
1) Sample products are stored in the database at the start of the application.

2) Additional trending flag is added to product with which we can identify trending products when a match with title is not found while filtering the list of products.

#Fashion Catalog Sample API collection
----------------------------------------------------------------------------------------
Get List of Products
---------------
curl -X GET http://localhost:8080/fashion/v1/products -H 'Content-Type: application/json'

Filter products based on title
-----------------------
curl -X GET  'http://localhost:8080/fashion/v1/products/search?title=jeans' -H 'Content-Type: application/json'