FROM openjdk:8
ARG JAR_FILE=target/boot-hello.jar
COPY ${JAR_FILE} .
EXPOSE 8090
ENTRYPOINT ["java","-jar","/boot-hello.jar"]