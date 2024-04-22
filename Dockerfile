FROM maven:3.8-openjdk-17
LABEL author="TOUBAL Zine-Eddine & BEN AHMED Yacine"
WORKDIR /app
COPY pom.xml /app
RUN mvn clean dependency:go-offline
COPY . /app
CMD mvn spring-boot:run
