# spring-rabbitmq-producer


Simple microservice to produce message to RabbitMq using its default configurations.

Here routing exchange used is 'direct'. 

Application port is 8080

RabbitMq is using the default configurations, so there is no entries for rabbitmq under application.properties file. If you have any custom config changes related to RabbitMq, application.properties has to modified for that. 

Default port of RabbitMQ is 15672

Once RabbitMQ is downloaded and installed in your local machine, it can be accessed in the browser using the url http://localhost:15672/

Docker command to install RabbitMq in local system - 
docker run -d --hostname my-rabbit --name rabbit-container -p 15672:15672 -p 5672:5672 rabbitmq:3-management


