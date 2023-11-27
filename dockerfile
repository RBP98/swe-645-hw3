#This is a docker file which is used to build docker image

# Swathi Guptha - G01393328
# Rajas Bipinchandra patil - G01393353
# Poorvi Lakkadi - G01389351

FROM openjdk:17
COPY target/student-survey-backend.jar app.jar
EXPOSE 8080
CMD java -jar app.jar
