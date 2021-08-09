FROM adoptopenjdk:latest
LABEL MAINTAINER="walkingError"
RUN ./gradlew clean build
COPY /home/app/build/libs/bluewater-server-0.0.1-SNAPSHOT.jar /usr/local/lib/app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/app.jar"]