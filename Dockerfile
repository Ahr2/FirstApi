# 1️⃣ Use Java 21 (matches your JDK)
FROM eclipse-temurin:21-jre

# 2️⃣ Set working directory
WORKDIR /app

# 3️⃣ Copy jar file
COPY target/FirstApi-0.0.1-SNAPSHOT.jar app.jar

# 4️⃣ Expose application port
EXPOSE 8081

# 5️⃣ Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
