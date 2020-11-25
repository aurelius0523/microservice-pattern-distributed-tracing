@REM Build service artifact and docker image
call mvn clean install -DskipTests -f employee-service/pom.xml
call docker build -t aurelius0523/employee-service:latest employee-service
call mvn clean install -DskipTests -f inventory-service/pom.xml
call docker build -t aurelius0523/inventory-service:latest inventory-service
call docker build -t aurelius0523/postgresql-service:latest postgresql-service

@REM prune untagged docker images. WARNING, it will also tag non-employee/inventory service dangling images!
call echo y|docker image prune

@REM stop and remove all docker containers
call docker stop employee && docker container rm employee
call docker stop inventory && docker container rm inventory
call docker stop zipkin && docker container rm zipkin
call docker stop psql && docker container rm psql

@REM start all docker containers
call docker run -d --name employee -p 9080:8080 -e SPRING_PROFILES_ACTIVE=docker aurelius0523/employee-service
call docker run -d --name inventory -p 9081:8081 -e SPRING_PROFILES_ACTIVE=docker aurelius0523/inventory-service
call docker run -d --name zipkin -p 9411:9411 openzipkin/zipkin
call docker run -d --name psql -p 5432:5432 aurelius0523/postgresql-service
