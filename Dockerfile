FROM openjdk:17
EXPOSE 8080
COPY target/product-service.jar product-service.jar
ENTRYPOINT ["java","-jar", "product-service.jar"]