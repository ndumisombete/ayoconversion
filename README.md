# ayoconversion

Before you run the project

Make show you have maven running in your local machine the version here is 3.8.1

Make sure you have java 8 is installed in your machine

You may use gitbash to clone the project

Make sure you have IDE running ,this was ran on intellij 2021 version




How to run the project?

1. clone the project from github
2. Open the project on your Intellij or any other IDE you maybe using
3. run mvn clean install package
4. Then run the micro service

When the application running 

You can start your postman or go to your browser and start swagger-ui

To test using swagger-ui use the url

http://localhost:8080/swagger-ui.html

You will find 2 endpoints

Post : http://localhost:8080/v1/person
{
  "fullName": "Ndumiso Mbete",
  "idNumber": 8706112348084,
  "personId": "0",
  "telephoneNumber": "0731230109"
}
And 

Get : http://localhost:8080/v1/persons


Mysql Workbench

![Mysql_bench](https://user-images.githubusercontent.com/15628986/138229614-f0487567-9661-4087-bf12-fa7103b3cb97.PNG)

Submit form information

![post_person_information](https://user-images.githubusercontent.com/15628986/138230368-85506424-35f5-4eef-b4b5-6415e7ae0a08.PNG)


Form submitted successful

![post_person_information_successful](https://user-images.githubusercontent.com/15628986/138229894-952717b6-6676-4944-b131-98779c73bcc5.PNG)

Get the list of all submitted form information

![get_person_information](https://user-images.githubusercontent.com/15628986/138230184-0cc84b84-c244-417a-bfe0-1c8a03131107.PNG)

