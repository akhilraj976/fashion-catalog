FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/*.jar fashion-catalog-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/fashion-catalog-0.0.1-SNAPSHOT.jar"]