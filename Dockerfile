FROM java:8
FROM maven:3.5-jdk-8-alpine
ADD src /usr
ADD pom.xml /usr
WORKDIR /usr
RUN mvn clean install
WORKDIR /usr
ENTRYPOINT ["mvn","spring-boot:run"]
EXPOSE 8080
