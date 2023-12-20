FROM amazoncorretto:17
WORKDIR /api_app

COPY . .
RUN ./gradlew build

CMD ["java", "-jar", "build/libs/demo-0.0.1-SNAPSHOT.jar"]