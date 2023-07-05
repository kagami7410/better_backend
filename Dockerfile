FROM openjdk:18
COPY ./target/backend_app-0.0.1-SNAPSHOT.jar /app/better_backend.jar
WORKDIR /app
EXPOSE 9080
ENTRYPOINT ["java", "-jar", "better_backend.jar"]