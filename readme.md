# microservice-pattern-distributed-tracing

### How to run 
#### Using `docker-compose`:
1. Simply run `docker-compose up`
1. Make a call to `employee-service` by visiting `http://localhost:9080/employees`
1. Check `zipkin` at `http://localhost:9411/zipkin`. Click `Run Query` and then select the first span to view detail. You should see this:


![zipkin-ui](docs/zipkin.PNG)


1. It shows that call to `employee-service`'s `GET /employees` took 366ms.
1. It shows that `employee-service` called `inventory-service`'s `GET /inventories` REST resource.
1. It shows that `inventory-service` made a connection to database and executed some queries.

_protip_,  if you click on the `span` with `jdbc` prefix then you can see these details:
#### Sql executed
![sql](docs/sql.PNG)

#### total rows returned
![row](docs/row.PNG)
 
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