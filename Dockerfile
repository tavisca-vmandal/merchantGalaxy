FROM java:8
COPY src /var/www/java/
WORKDIR /var/www/java
EXPOSE 8080
CMD ["java", "-jar", "MGTTG-1.0-SNAPSHOT.jar"]  