FROM azul/zulu-openjdk-alpine:11.0.7

ADD target/inventory-service-0.0.1-SNAPSHOT.jar inventory-service-0.0.1-SNAPSHOT.jar

EXPOSE 8081

ENTRYPOINT ["java","-jar","/inventory-service-0.0.1-SNAPSHOT.jar"]