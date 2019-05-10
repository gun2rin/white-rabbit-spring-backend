## White Rabbit Java Spring Boot backend app

Checkout [white-rabbit.com.ru](https://white-rabbit.com.ru)


This project was generated with [Spring boot](https://spring.io/projects/spring-boot) version 2.1.4.
just for fun and to explain **CORS** interconnection between 
**Angular** frontend and different backend for Compo developers

### Install app and launch local server
You should have JDK installed on your machine
`sudo apt-get install openjdk-8-jdk` 

Clone it `git clone git@github.com:gun2rin/white-rabbit-spring-backend.git`

You should create application.yml in resources dir from .bak examples 
and set the settings up 

`cd` to project directory 
and run `./gralew bootRun` for a dev server. 

Backend should be built and started up. 
Embedded Tomcat will be available by default address `http://localhost:8080`

### Angular frontend
Checkout [angular](https://github.com/gun2rin/white-rabbit-frontend) based frontend 

### PHP Symfony backend
Checkout alternative [php-symfony](https://github.com/gun2rin/white-rabbit-symfony-backend)

### Funny
Java backend with spring-boot and dependencies packed is about 16Mb, unpacked ~59Mb

PHP backend with symfony and dependencies is about 93Mb
