# iqbusinessregistration
Before you run the project

Make show you have maven running in your local machine the version here is 3.8.1

Make sure you have java 8 is installed in your machine

You may use gitbash to clone the project

Make sure you have IDE running ,this was ran on intellij 2021 version

Make sure you have MYSQL intalled on your machine




How to run the project?

1. clone the project from github
2. Open the project on your Intellij or any other IDE you maybe using
3. go to application.properties to config your database
4. run mvn clean install package
5. Then run the micro service

When the application running 

You can start your postman or go to your browser and start swagger-ui

To test using swagger-ui use the url

http://localhost:8080/swagger-ui.html

You will find 3 endpoints

![image](https://user-images.githubusercontent.com/15628986/139850757-3fdbb3ce-18fd-4073-b455-6344ed00a6e1.png)



Get : http://localhost:8080/v1/measurementcategories

![image](https://user-images.githubusercontent.com/15628986/139851044-14f53225-2947-4a9f-ab57-f293bc8b57d8.png)


Get : http://localhost:8080/v1/units


![image](https://user-images.githubusercontent.com/15628986/139851351-a4ce47dd-d57b-46b0-a958-aeee55facaf6.png)

Get : http://localhost:8080/v1/TEMPERATURE/IMPERIAL/3.0

![image](https://user-images.githubusercontent.com/15628986/139852053-b261d6eb-ce48-4cba-b5ab-bacd7493f8a7.png)
