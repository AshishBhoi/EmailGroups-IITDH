# Email Grouping #

<div align="center">

[![GitHub](https://img.shields.io/github/license/AshishBhoi/EmailGroups-IITDH)](https://github.com/AshishBhoi/EmailGroups-IITDH/blob/master/LICENSE)
[![Docker Image CI](https://github.com/AshishBhoi/EmailGroups-IITDH/workflows/Docker%20Image%20CI/badge.svg)](https://github.com/AshishBhoi/EmailGroups-IITDH/actions?query=workflow%3A%22Docker+Image+CI%22)

</div>

## Links ##

- [GitHub Links](https://github.com/AshishBhoi/EmailGroups-IITDH)
- [GitHub CI (GitHub Actions)](https://github.com/AshishBhoi/EmailGroups-IITDH/actions?query=workflow%3A%22Docker+Image+CI%22)
- [Docker Tar File](https://github.com/AshishBhoi/EmailGroups-IITDH/releases/download/v1.0.0/email-groups.tar)
- [JAVA JAR file](https://github.com/AshishBhoi/EmailGroups-IITDH/releases/download/v1.0.0/EmailGroup-1.0-SNAPSHOT.jar)
- [Report](http://gitlab.iitdh.ac.in/160010017/email-groups/uploads/6641f92874fb23b3e4be54494f13d218/EmailGroups.pdf)

## Given files ##

### Persons.csv ###

- Name
- ID
- Email

### Keywords.csv ###

- Contents all the keywords with one keyword per line.

### Emails.csv ###

- Email ID
- Sender ID
- List of receiver ID
- Date and Time
- List of keywords
- If it is a reply previous Email ID else "null"

## Input ##

- Email.csv (Contains all the email exchanged)
- Keywords.csv (Contains all the keywords)
- Persons.csv (Contains details about the person)

## Output ##

Groups of people who have strongly communicated among themselves on a given keyword.
The group should contain persons who have sent at least 5 emails on the topic and also replied to 5 emails that she received on that topic in the last one month.

## Docker ##

- 'Dockerfile' added to create image.

        $ docker build . --file Dockerfile --tag email-groups
- Run that image.

        $ docker run email-groups
- Creating .tar of docker image

        $ docker save email-groups > email-groups.tar
    
- Load docker tar file

        $ docker load > email-groups.tar
    
- Run docker image

        $ docker run email-groups:v1.0.0

## Additional Details ##

- VERSION: 1.0.0
- Programming Language: JAVA
- Tools: MAVEN, DOCKER
- Domain: Software Engineering
- License: MIT
- Author: Ashish Kumar Bhoi
