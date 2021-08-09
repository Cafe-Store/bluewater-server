FROM adoptopenjdk:latest
LABEL MAINTAINER="walkingError"

ENTRYPOINT exec java -jar bluewater-server-0.0.1-SNAPSHOT.jar