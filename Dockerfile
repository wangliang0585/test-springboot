FROM centos:7

MAINTAINER wangliang <wanglia@microsoft.com>

# Add the jar file to the /usr/local/bin directory
ADD target/*.jar /app.jar

# Run the jar file
ENTRYPOINT ["java", "-jar", "/app.jar"]

# Expose the port 8080
EXPOSE 8080

