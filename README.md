# consuming-data-web-client

This project uses the Codeforces API: https://codeforces.com/apiHelp/methods#problemset.recentStatus
Codeforces is a Competitive Programming Platform and by using the API provided, we can access some
data like Contests, Rating, Problem Set, Blog Entries, User Handles etc.

In this case I am using the #problemset.recentStatus endpoint to get the Recent submissions.
so according to the api we have to issue a GET request to the  https://codeforces.com/api/problemset.recentStatus
URI and there is a request-param to be added with name count, which has to be assigned value upto 1000, so it
will get us that many submissions entries.

Consuming data with Web Client, which is ok for example purposes, like this, but it should be used
when building **reactive-apps** to get the full benefit out of it.
It is similar to that of Rest-Template, here we are just using the WebClient's get() method to issue
an _HTTP GET_ request to the specified URI and then _retrieve()_ the data and we get the data and convert
it to **Mono<T>** which is a publisher of the data, so Spring Boot will be subscribing to the Mono
data which is published, and we get Http Mono response when we query the endpoint.


To run the project, use command: **_mvn spring-boot:run_**
We can also use the mvn wraper (.mvnw.cmd) 

**There are two endpoints that we can query from the client:**

    1. http://localhost:8080/status?count=2 -> To get the Complete Status Object as an Array.
    2. http://localhost:8080/members?count=2 -> To get only the Members.

I have used **Postman** for querying the endpoints and verifying the response:

![img.png](img.png)

![img_1.png](img_1.png)