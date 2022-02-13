Voucher Pool Project

How To Run
This application is packaged as a war which has Tomcat embedded. No Tomcat or JBoss installation is necessary. You run it using the java -jar command.

Clone this repository
Make sure you are using JDK 1.8 and Maven 3.x
You can build the project and run the tests by running mvn clean package

Once successfully built, you can run the service :
        mvn spring-boot:run -Drun.arguments="spring.profiles.active=test"

Database
- Install MySQL Database
- dump sql file in db folder
- configure db access details in src/main/resources/application.properties

Once the application runs you should see something like this
xxxx


About the Service
This project is micro service voucher pool. ....


Endpoints available:
http://localhost:8080/api/receipients
http://localhost:8080/api/specialoffers
http://localhost:8080/api/vouchercodes

1. Create a Receipient
POST /api/receipients
Accept: application/json
Content-Type: application/json

{
    "name" : "Ali",
    "email" : "ali@gmail.com"
}

RESPONSE: HTTP 201 (Created)
Location header: http://localhost:8080/api/receipients/1

2. Create Special Offer
POST /api/specialoffers
Accept: application/json
Content-Type: application/json

{
    "name" : "CNY Offer",
    "discount" : 12.5,
    "expirationDate" : "2022-02-28 00:00:00"
}

RESPONSE: HTTP 201 (Created)
Location header: http://localhost:8080/api/specialoffers/1

3. Use a Voucher Code
POST /api/vouchercodes
Accept: application/json
Content-Type: application/json

{
    "code" : "1df64495bf404605b231d6016db154eb",
    "email" : "ali@gmail.com"
}

RESPONSE: HTTP 200 (OK)

4. Get Voucher Codes by Email
GET /api/vouchercodes/email/ali@gmail.com
Accept: application/json
Content-Type: application/json


RESPONSE: HTTP 200 (OK)

{
    [
        {
            "code" : "xxxxx",
            "email" : "ali@gmail.com",
            "specialOfferName" : "CNY Offer",
            "discount" : 12.5
        },
        {
            "code" : "xxxxx",
            "email" : "ali@gmail.com",
            "specialOfferName" : "Raya Offer",
            "discount" : 15.0
        },

    ]
}
