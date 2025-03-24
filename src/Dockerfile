# Use an official OpenJDK image
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy pom.xml and download dependencies
COPY pom.xml ./
RUN apt-get update && apt-get install -y maven && mvn dependency:go-offline

# Copy source code
COPY src ./src

# Package the application
RUN mvn package -DskipTests

# Run the application
CMD ["java", "-jar", "target/golfclub-api-1.0.0.jar"]
