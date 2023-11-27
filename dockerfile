#This is a docker file which is used to build docker image

# Swathi Guptha - G01393328
# Rajas Bipinchandra patil - G01393353
# Poorvi Lakkadi - G01389351

# FROM openjdk:17
# COPY target/student-survey-backend.jar app.jar
# EXPOSE 8080
# CMD java -jar app.jar

FROM maven:3.8.5-openjdk-17-slim AS tag
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package
FROM openjdk:17-jdk-slim
WORKDIR /opt/app
COPY --from=tag /home/app/target/student-survey-backend.jar app.jar
CMD java -jar app.jar
# ENTRYPOINT ["java","-jar","app.jar"]
