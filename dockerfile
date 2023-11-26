FROM tomcat:8.0.20-jre8
COPY student-survey-backend.war /usr/local/tomcat/webapps/
