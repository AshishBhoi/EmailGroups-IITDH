FROM maven:3-jdk-8 AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

FROM anapsix/alpine-java
MAINTAINER Ashish Kumar Bhoi
COPY --from=build /home/app/target/EmailGroup-1.0-SNAPSHOT.jar /EmailGroup.jar
COPY Emails.csv /Emails.csv
COPY Keywords.csv /Keywords.csv
COPY Persons.csv /Persons.csv
CMD ["java", "-jar", "/EmailGroup.jar", "/Emails.csv", "/Keywords.csv", "/Persons.csv"]