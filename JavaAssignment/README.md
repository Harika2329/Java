Requirements:

For building and running the application you need:

JDK 1.8
Maven 3

Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the main method in the com.example.pointcalculater.PointCalculaterApplication from your IDE.

Alternatively you can use the Spring Boot Maven plugin like so:

mvn spring-boot:run


Call Rest API;

URL: http://localhost:8090/calculate-points/customers/1
Method: Get

API Response:

{
customerId: 1,
lastMonthPoints: 20,
lastSecondMonthPoints: 50,
lastThirdMonthPoints: 230,
totalPoints: 280
}

