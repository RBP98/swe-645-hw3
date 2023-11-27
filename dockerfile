#This is a docker file which is used to build docker image

# Swathi Guptha - G01393328
# Rajas Bipinchandra patil - G01393353
# Poorvi Lakkadi - G01389351


FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/student-survey-backend.jar
COPY ${JAR_FILE} .
CMD [ "java", "-jar",  "/student-survey-backend.jar"]