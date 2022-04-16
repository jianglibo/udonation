FROM openjdk:17-jdk-alpine
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

# docker build -t udonations-spring-boot-docker .
# docker run -p 8080:8080 udonations-spring-boot-docker