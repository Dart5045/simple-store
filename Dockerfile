FROM eclipse-temurin:17 as build
ENV MAVEN_OPTS="-XX:+TieredCompilation -XX:TieredStopAtLevel=1"
WORKDIR /opt/app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

COPY ./common ./common
COPY ./store-service ./store-service
RUN ./mvnw dependency:go-offline
RUN ./mvnw clean install -Dmaven.test.skip=true

FROM openjdk:17-alpine

WORKDIR /opt/app

COPY --from=build /opt/app/store-service/store-container/target/store-container-0.0.1-SNAPSHOT.jar /opt/app
CMD ["java", "-jar", "--enable-preview", "/opt/app/store-container-0.0.1-SNAPSHOT.jar"]