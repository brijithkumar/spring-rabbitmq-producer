# spring-rabbitmq-producer


Simple microservice to produce message to RabbitMq using its default configurations.

Here routing exchange used is 'direct'. 

Application port is 8080

RabbitMq is using the default configurations. If you wish to change the RabbitMq properties, application.properties has to modified. 

Spring-rabbitmq-producer is communicating with rabbitmq using the port 5672.

Spring-rabbitmq-producer project is dockerized. To make the Spring-rabbitmq-producer project up and running, simply build the docker image and do the docker run.

Docker build ->  'docker build -t spring-rabbitmq-producer .'
Docker run  -> 'docker run -p 8080:8080 spring-rabbitmq-producer'




## Pre-requisite :- 

RabbitMq needs to be downloaded and installed in your machine.

## Steps to use RabbitMQ - 

Once RabbitMQ is downloaded and installed in your local machine, it can be accessed in the browser using the url http://localhost:15672/

Docker command to install RabbitMq in local system  
docker run -d --hostname my-rabbit --name rabbit-container -p 15672:15672 -p 5672:5672 rabbitmq:3-management




