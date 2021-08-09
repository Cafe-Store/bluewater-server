FROM adoptopenjdk:latest
LABEL MAINTAINER="walkingError"
COPY /home/runner/work/bluewater-server/build/libs/*.jar app.jar
EXPOSE 8080
ENV JAVA_OPTS=""
ENTRYPOINT ["java", "-jar", "app.jar"]