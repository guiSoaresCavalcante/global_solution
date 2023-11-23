FROM openjdk:17

COPY target/global-0.0.1-SNAPSHOT.jar /app/global.jar

CMD ["java", "-jar", "/app/global.jar"]

# porta que a aplicacao ira utilizar
EXPOSE 8080
