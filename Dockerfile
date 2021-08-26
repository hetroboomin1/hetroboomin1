FROM openjdk:11
#EXPOSE 16000
RUN addgroup bots && useradd --no-create-home RestApiUser -g bots
USER RestApiUser
COPY target/MrktDataApi-0.0.1-SNAPSHOT.jar MrktDataApi.jar
ENTRYPOINT [ "java","-jar","/MrktDataApi.jar" ]