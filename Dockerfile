FROM openjdk:8

MAINTAINER wangliang <wanglia@microsoft.com>

VOLUME /data

COPY target/*.jar /app.jar

ENTRYPOINT ["java","-jar","/app.jar"]

EXPOSE 9090
