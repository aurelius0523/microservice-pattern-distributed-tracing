FROM adoptopenjdk/openjdk11:alpine-jre

ADD target/employee-service-0.0.1-SNAPSHOT.jar employee-service-0.0.1-SNAPSHOT.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/employee-service-0.0.1-SNAPSHOT.jar"]