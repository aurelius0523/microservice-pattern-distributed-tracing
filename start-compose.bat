@REM Build service artifact and docker image
call mvn clean install -DskipTests -f employee-service/pom.xml
call docker build -t aurelius0523/employee-service:latest employee-service
call mvn clean install -DskipTests -f inventory-service/pom.xml
call docker build -t aurelius0523/inventory-service:latest inventory-service

@REM prune untagged docker images. WARNING, it will also tag non-employee/inventory service dangling images!
call echo y|docker image prune

@REM Use compose to up all images
call docker-compose up -d