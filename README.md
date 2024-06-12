# grpc-spring-boot-example


## Curl Command 

```shell
curl -d '{"mathsSign":"+", "firstNumber":"10", "secondNumber":"10"}' -H "Content-Type: application/json" -X POST http://localhost:8080/give-me-result
```

```shell
curl -d '{"mathsSign":"*", "firstNumber":"10", "secondNumber":"10"}' -H "Content-Type: application/json" -X POST http://localhost:8080/give-me-result
```

```shell
curl -d '{"mathsSign":"-", "firstNumber":"30", "secondNumber":"10"}' -H "Content-Type: application/json" -X POST http://localhost:8080/give-me-result
```

```shell
curl -d '{"mathsSign":"X", "firstNumber":"30", "secondNumber":"10"}' -H "Content-Type: application/json" -X POST http://localhost:8080/give-me-result
```