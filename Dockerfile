FROM openjdk:17-jdk
COPY target/cv24v1-0.0.1-SNAPSHOT.war /app/cv24v1-0.0.1-SNAPSHOT.war
WORKDIR /app
CMD ["java", "-jar", "cv24v1-0.0.1-SNAPSHOT.war"]
