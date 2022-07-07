# consuming-data-rest-template

This project uses the Codeforces API: https://codeforces.com/apiHelp/methods#problemset.recentStatus
Codeforces is a Competitive Programming Platform and by using the API provided, we can access some
data like Contests, Rating, Problem Set, Blog Entries, User Handles etc.

In this case I am using the #problemset.recentStatus endpoint to get the Recent submissions.
so according to the api we have to issue a GET request to the  https://codeforces.com/api/problemset.recentStatus
URI and there is a request-param to be added with name count, which has to be assigned value upto 1000, so it
will get us that many submissions entries.

Here I am using the most common method which is using **Rest Template** class which provides simple method
_exchange()_ to query the uri and pass the http verb and HttpEntity in case you have any request headers and
to pass the body, at last the response object type. It will return the ResponseEntity<T> so we can get the data using _#getBody()_
method.
     
    Unfortunately, The RestTemplate class is marked for maintainance in Spring Framework 5 and will
    be deprecated in future releases. As it is not suitable in some cases like handle Async data

To run the project, use command: **_mvn spring-boot:run_**
We can also use the mvn wraper (.mvnw.cmd) 

**There are two endpoints that we can query from the client:**

    1. http://localhost:8080/status?count=2 -> To get the Complete Status Object as an Array.
    2. http://localhost:8080/members?count=2 -> To get only the Members.

I have used **Postman** for querying the endpoints and verifying the response:

![img.png](img.png)

![img_1.png](img_1.png)