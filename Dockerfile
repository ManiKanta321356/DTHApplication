FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/DTHApplication-0.0.1-SNAPSHOT.jar  /app.jar

EXPOSE 8080

COPY["java","-jar","app.jar/"]