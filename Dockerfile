FROM maven:3.8.3-jdk-11-slim AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean package

FROM openjdk:11-jre-slim
WORKDIR /app
COPY --from=build /app/target/spring-rabbitmq-producer-0.0.1.jar .
EXPOSE 8080
CMD ["java","-jar","spring-rabbitmq-producer-0.0.1.jar"]
