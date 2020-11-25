FROM adoptopenjdk/openjdk11:alpine-jre

ADD target/inventory-service-0.0.1-SNAPSHOT.jar inventory-service-0.0.1-SNAPSHOT.jar

EXPOSE 8081

ENTRYPOINT ["java","-jar","/inventory-service-0.0.1-SNAPSHOT.jar"]