FROM anapsix/alpine-java
MAINTAINER Ashish Kumar Bhoi
COPY ./target/EmailGroup-1.0-SNAPSHOT.jar /EmailGroup.jar
COPY Emails.csv /Emails.csv
COPY Keywords.csv /Keywords.csv
COPY Persons.csv /Persons.csv
CMD ["java", "-jar", "/EmailGroup.jar", "/Emails.csv", "/Keywords.csv", "/Persons.csv"]