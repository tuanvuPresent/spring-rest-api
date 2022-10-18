FROM maven:3.8.5-openjdk-11 AS maven_build
WORKDIR /app
COPY src /app/src
COPY pom.xml /app
RUN mvn package

FROM openjdk
WORKDIR /app
COPY --from=maven_build /app/target/demo-0.0.1-SNAPSHOT.jar /app/demo-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","demo-0.0.1-SNAPSHOT.jar"]
