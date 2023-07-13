FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY producer/build/libs/producer-0.0.1-SNAPSHOT.jar producer.jar

CMD ["java", "-jar", "producer.jar"]