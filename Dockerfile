FROM openjdk:17-alpine

EXPOSE 8080

ARG JAR_FILE=target/product-service.jar
ADD ${JAR_FILE} app.jar

ENTRYPOINT exec java -jar /app.jar

#FROM openjdk:17
#EXPOSE 8080
#COPY ./target/product-service.jar product-service.jar
#ENTRYPOINT ["java","-jar", "product-service.jar"]