FROM tomcat:10.1-jdk11-openjdk
ADD target/student-survey-backend.war /usr/local/tomcat/webapps/
EXPOSE 8080
CMD ["catalina.sh","run"]
