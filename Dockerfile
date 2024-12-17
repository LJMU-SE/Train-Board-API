FROM maven:3.9.9-eclipse-temurin-21-alpine AS build

ENV HOME=/usr/app
RUN mkdir -p $HOME
WORKDIR $HOME
ADD pom.xml $HOME
RUN mvn verify --fail-never
ADD . $HOME
RUN mvn clean package

FROM eclipse-temurin:21-alpine
COPY --from=build /usr/app/target/train-board-api-jar-with-dependencies.jar /app/runner.jar
ENTRYPOINT java -jar /app/runner.jar