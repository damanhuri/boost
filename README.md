
# Boost Test - Voucher Codes Pool

## Voucher Pool Project

### How To Run

This application is packaged as a war which has Tomcat embedded. No Tomcat or JBoss installation is necessary. You run it using the java -jar command.

#### Clone this repository
Make sure you are using JDK 1.8 and Maven 3.x
You can build the project and run the tests by running mvn clean package

Once successfully built, you can run the service :
        mvn spring-boot:run -Drun.arguments="spring.profiles.active=test"

#### Database
- Install MySQL Database
- dump sql file in db folder
- configure db access details in src/main/resources/application.properties

Once the application runs you should see something like this
```
2022-02-14 01:06:06.575  INFO 6928 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2022-02-14 01:06:06.589  INFO 6928 --- [           main] c.b.i.v.VoucherpoolApplication           : Started VoucherpoolApplication in 5.338 seconds (JVM running for 5.934)
2022-02-14 01:06:16.324  INFO 6928 --- [nio-8080-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
2022-02-14 01:06:16.324  INFO 6928 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
2022-02-14 01:06:16.327  INFO 6928 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Completed initialization in 3 ms
```


### About the Service
This project is micro service voucher pool. A voucher pool is a collection of (voucher) codes that can be used by customers (recipients) to get discounts in a
web shop. Each code may only be used once and we would like to know when it was used by the recipient. Since
there can be many recipients in a voucher pool, we need a call that auto-generates voucher codes for each recipient.

#### Endpoints available:
> http://localhost:8080/api/receipients

> http://localhost:8080/api/specialoffers

> http://localhost:8080/api/vouchercodes

#### 1. Create a Receipient
POST /api/receipients

Accept: application/json

Content-Type: application/json
```
{
    "name" : "Ali",
    "email" : "ali@gmail.com"
}
```
RESPONSE: HTTP 201 (Created)
Location header: http://localhost:8080/api/receipients/1

#### 2. Create Special Offer
POST /api/specialoffers

Accept: application/json

Content-Type: application/json

```
{
    "name" : "CNY Offer",
    "discount" : 12.5,
    "expirationDate" : "2022-02-28 00:00:00"
}
```

RESPONSE: HTTP 201 (Created)
Location header: http://localhost:8080/api/specialoffers/1

#### 3. Use a Voucher Code
POST /api/vouchercodes
Accept: application/json
Content-Type: application/json

```
{
    "code" : "1df64495bf404605b231d6016db154eb",
    "email" : "ali@gmail.com"
}
```

RESPONSE: HTTP 200 (OK)

#### 4. Get Voucher Codes by Email
GET /api/vouchercodes/email/ali@gmail.com

Accept: application/json

Content-Type: application/json


RESPONSE: HTTP 200 (OK)

```
[
    {
        "code": "1df64495bf404605b231d6016db154eb",
        "email": "ali@gmail.com",
        "discount": 12.5,
        "specialOfferName": "CNY Offer",
        "usageDate": "2022-02-13 16:47:16"
    },
    {
        "code": "536a449b44a84be7a7aa947e51a2738f",
        "email": "ali@gmail.com",
        "discount": 12.5,
        "specialOfferName": "Raya Offer",
        "usageDate": null
    }
]
```

