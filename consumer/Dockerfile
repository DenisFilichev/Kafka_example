FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY consumer/build/libs/consumer-0.0.1-SNAPSHOT.jar consumer.jar

CMD ["java", "-jar", "consumer.jar"]