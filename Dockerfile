FROM ubuntu:latest
LABEL authors="joshuayeo"

ENTRYPOINT ["top", "-b"]

FROM openjdk:23-jdk-oracle AS builder

ARG COMPILE_DIR=/compiledir

WORKDIR ${COMPILE_DIR}

COPY mvnw .
COPY pom.xml .
COPY .mvn .mvn
COPY src src

## Build the application
RUN ./mvnw package -Dmaven.test.skip=true

## How to run the applicaiton
#ENV SERVER_PORT=8080
# for Railway

ENV noticeboard_db_host=localhost
ENV noticeboard_db_port=6379
ENV noticeboard_db_database=0
ENV noticeboard_db_username=""
ENV noticeboard_db_password=""

EXPOSE ${PORT}

# App will run in second stage
# ENTRYPOINT SERVER_PORT=${PORT} java -jar target/Day18-0.0.1-SNAPSHOT.jar

## Day 18 - slide 13
## The second stage
FROM openjdk:23-jdk-oracle

ARG WORK_DIR=/app

WORKDIR ${WORK_DIR}

COPY --from=builder /compiledir/target/noticeboard-0.0.1-SNAPSHOT.jar App.jar

ENV PORT=8080
ENV noticeboard_db_host=localhost
ENV noticeboard_db_port=6379
ENV noticeboard_db_database=0
ENV noticeboard_db_username=""
ENV noticeboard_db_password=""

EXPOSE ${PORT}



ENTRYPOINT java -jar App.jar