FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app
COPY . .
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:resolve
COPY src ./src
EXPOSE 8081
CMD ["./mvnw", "-Dskip.installnodenpm ","-Dskip.npm","-DskipTests","-Pdev"]