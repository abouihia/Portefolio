FROM openjdk:11
VOLUME /tmp
ADD portfolio-0.0.1-SNAPSHOT.jar app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-jar","/app.jar"]