FROM tomcat:9.0
ADD target/testDecrypter.war /usr/local/tomcat/webapps
CMD ["catalina.sh", "run"]
