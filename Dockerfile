FROM openjdk:11
WORKDIR /target
COPY target/*.jar target/cgpuzzle.jar

# EXPOSE 5000
CMD ["java", "-jar", "target/cgpuzzle.jar"]

