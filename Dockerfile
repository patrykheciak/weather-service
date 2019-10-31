FROM openjdk:8-jdk-alpine3.9
ADD target/weather-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
CMD java -Dvaadin.productionMode -jar weather-0.0.1-SNAPSHOT.jar