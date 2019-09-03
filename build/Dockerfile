#Lets use OpenJDK docker image
FROM openjdk:12-alpine
#FROM ubuntu

#Deploy the jar file to the container
COPY  /libs/websiteCustomerAPI-0.0.1-SNAPSHOT.jar /mcc_data_api.jar

CMD ["java","-jar","/mcc_data_api.jar"]
