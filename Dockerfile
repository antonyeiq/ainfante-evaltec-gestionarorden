FROM openjdk:11
VOLUME [ "/data" ]
EXPOSE 8882
ADD target/ainfante-evaltec-gestionarorden-0.0.1-SNAPSHOT.jar app-evaltec-gestionarorden.jar
ENTRYPOINT ["java","-jar","/app-evaltec-gestionarorden.jar"]