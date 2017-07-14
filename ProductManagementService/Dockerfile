FROM oraclelinux:7-slim

MAINTAINER Raj.Etta@oracle.com

#Move to guest OS or find another way. Each of the following creates a 'layer'
ENV http_proxy "http://www-proxy.us.oracle.com:80"
ENV https_proxy "http://www-proxy.us.oracle.com:80"

RUN yum -y install java-1.8.0-openjdk-devel && yum clean all

ENV JAVA_HOME /usr/lib/jvm/java-openjdk

COPY target/prod-service-0.0.1-SNAPSHOT.jar /tmp/app.jar
RUN bash -c 'touch /tmp/app.jar'
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=dev","/tmp/app.jar"]
