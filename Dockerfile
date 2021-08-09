FROM adoptopenjdk:latest
LABEL MAINTAINER="walkingError"
ADD /build/libs/bluewater-server-0.0.1-SNAPSHOT.jar app.jar
ENV JAVA_OPTS=""
ENTRYPOINT ["java", "-jar", "/app.jar"]