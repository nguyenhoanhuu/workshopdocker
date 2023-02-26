FROM openjdk:11.0.16
WORKDIR /product
COPY ./target/thu-bong-gia-re-rest-apis-spring-boot-0.0.1-SNAPSHOT.jar /product
COPY . /product
EXPOSE 8080
CMD ["java","-jar","thu-bong-gia-re-rest-apis-spring-boot-0.0.1-SNAPSHOT.jar"]