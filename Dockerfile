FROM openjdk:11
EXPOSE 8080
WORKDIR /applications
COPY ./target/product-service.jar product-service.jar
ENTRYPOINT ["java","-jar", "product-service.jar"]