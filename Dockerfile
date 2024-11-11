FROM openjdk:21

ARG JAR_FILE=./target/*.jar

WORKDIR /home/app

EXPOSE 8080:8080

COPY $JAR_FILE app.jar

ENTRYPOINT [ "java", "-jar", "app.jar"]
