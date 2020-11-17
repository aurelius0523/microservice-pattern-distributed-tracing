## Distributed tracing demo

### How to run
1. start sleuth
2. start sleuth2
3. start `zipkin-server` by running `java -jar zipkin-server-2.12.9-exec.jar`
4. Execute http call to sleuth 

### Learnings
1. `spring-cloud-starter-sleuth` will add tracing (spanId) to request headers
1. `spring-cloud-starter-zipkin` will forward those traces to `zipkin-server`