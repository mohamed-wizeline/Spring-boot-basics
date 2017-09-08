# Spring Boot Basics
A project with the basics needed for spring boot

## Tests
Tests will be added with comments explaining what each test does.
Note is that if you will use MocMvc you need to add the 
annotation ```@AutoConfigureMockMvc``` to the test class.

## Feign clients
You need to add the dependency ```spring-cloud-starter-feign```
and dependency management ```spring-cloud-dependencies```

You need to add the annotation ```@EnableFeignClients``` to the class
that initializes the spring boot application

And you need to add the annotation ```@FeignClient``` to the interface
you will use for consuming.
