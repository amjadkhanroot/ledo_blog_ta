FROM maven:3.8-openjdk-17-slim

WORKDIR /lendoblogapi
COPY . /lendoblogapi
RUN mvn clean install


CMD mvn spring-boot:run