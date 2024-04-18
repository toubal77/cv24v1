FROM maven:3.8-openjdk-17
LABEL author="TOUBAL Zine-Eddine"
COPY pom.xml /app
RUN mvn clean dependency:go-offline
WORKDIR /app
CMD mvn spring-boot:run
