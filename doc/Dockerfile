FROM openjdk:11
ARG JAR_FILE= ../target/*.jar
COPY ${JAR_FILE} appDB.jar
ENTRYPOINT ["java","-jar","/appDB.jar"]
