FROM maven:3.5-jdk-8 as maven_build
WORKDIR /app

COPY pom.xml .
# To resolve dependencies in a safe way (no re-download when the source code changes)
RUN mvn clean package -Dmaven.main.skip -Dmaven.test.skip && rm -r target

# To package the application
COPY src ./src
RUN mvn clean package -Dmaven.test.skip

FROM amazoncorretto:11
COPY target/Eco-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar","app.jar"]