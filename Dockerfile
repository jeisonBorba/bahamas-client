FROM openjdk:8-jdk-alpine

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} app.jar
COPY logback-spring.xml .
COPY src/main/resources/application.properties .

EXPOSE 8080
ENTRYPOINT ["java","-jar", "-Dlogging.config=file:logback-spring.xml", "/app.jar"]