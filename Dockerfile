FROM alpine/git as clone 
WORKDIR /app
RUN git clone https://github.com/rane-vedang/friendmanager.git

FROM maven:3.5-jdk-8-alpine as build 
WORKDIR /app
COPY --from=clone /app/friendmanager /app 
RUN mvn clean install
ENTRYPOINT ["mvn","spring-boot:run"]
EXPOSE 8080
