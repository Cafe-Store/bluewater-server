FROM openjdk:8-jre-alpine


EXPOSE 8080

COPY ./build/libs/bluewater-server-0.0.1-SNAPSHOT.jar /usr/app/app.jar
WORKDIR /usr/app

ENTRYPOINT ["java","-jar","app.jar"]