## Distributed tracing demo

### How to run
1. start sleuth
2. start sleuth2
3. start `zipkin-server` by running `java -jar zipkin-server-2.12.9-exec.jar`
4. Execute http call to sleuth 

### Learnings
1. `spring-cloud-starter-sleuth` will add tracing (spanId) to request headers
1. `spring-cloud-starter-zipkin` will forward those traces to `zipkin-server`
1. A docker container cannot call another docker container by default because they live in different subnets. 
As a workaround, use `http://host.docker.internal:port` instead of `http://localhost:port`.
1. *HOWEVER*, if you're using `docker-compose` and you want to call from container A to container B, you can replace 
the domain with `service` name in `docker-compose.yml`. e.g.,

```yaml
version: "3.8"
services:
  employee:
    image: aurelius0523/employee-service
    restart: always
    ports:
      - 9080:8080
  # if employee-service needs to call inventory-service, the url will be
  # http://inventory/9081 instead of http://locahost:9081 or http://host.docker.internal:9081
  inventory:
    image: aurelius0523/inventory-service
    restart: always
    ports:
      - 9081:8081

```