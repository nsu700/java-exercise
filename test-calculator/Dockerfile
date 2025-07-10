FROM openjdk:21-jdk-slim

WORKDIR /app

COPY target/test-calculator-0.0.1-SNAPSHOT.jar /app/test-calculator.jar

ENTRYPOINT ["java", "-jar", "test-calculator.jar"]
