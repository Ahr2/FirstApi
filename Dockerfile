# ================================
# 1️⃣ Build stage
# ================================
# # Compile version and Runtime version are the same (21) to avoid compatibility issues.
# Maven tool version is 3.9.9, which is compatible with Java 21 and provides good performance and stability for building the application.
FROM maven:3.9.9-eclipse-temurin-21 AS build 

WORKDIR /app

# Copy pom.xml first (for dependency caching)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy source code
COPY src ./src

# Build the jar (skip tests)
RUN mvn clean package -DskipTests


# ========================
# 2️⃣ Runtime stage
# ================================
FROM eclipse-temurin:21-jre

WORKDIR /app

# Copy jar from build stage
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8081

ENTRYPOINT ["java","-jar","app.jar"]
