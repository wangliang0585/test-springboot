FROM centos:7

MAINTAINER wangliang <wanglia@microsoft.com>

# Install the Java JDK 8, git
RUN yum install -y java-1.8.0-openjdk-devel git

# Maven
ARG MAVEN_VERSION=3.8.6

# curl get the maven tar.gz file
RUN curl -fsSL https://archive.apache.org/dist/maven/maven-3/${MAVEN_VERSION}/binaries/apache-maven-${MAVEN_VERSION}-bin.tar.gz | tar xzf - -C /usr/share \
  && mv /usr/share/apache-maven-$MAVEN_VERSION /usr/share/maven \
  && ln -s /usr/share/maven/bin/mvn /usr/bin/mvn

# ENV Maven
ENV M2_HOME /usr/share/maven \
  && ENV M2 $M2_HOME/bin \
  && ENV PATH $M2:$PATH

# git clone and mvn install the project then mvn package
RUN git clone "https://github.com/wangliang0585/test-springboot.git" && cd test-springboot && mvn install package -DskipTests
# Copy the jar file to the /usr/local/bin directory
COPY target/*.jar /app.jar

# Run the jar file
ENTRYPOINT ["java", "-jar", "/app.jar"]

# Expose the port 8080
EXPOSE 8080

