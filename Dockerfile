FROM maven:3.6.3-openjdk-17

COPY . /project
RUN  cd /project && mvn package

#run the spring boot application
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-jar","/project/target/QouteChart1-1.0-SNAPSHOT.jar"]


