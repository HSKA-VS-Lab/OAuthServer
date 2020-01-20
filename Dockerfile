FROM openjdk:8-jdk-alpine
ADD target/OAuthServer-*.jar oauthserver.jar
EXPOSE 8094
ENTRYPOINT ["java","-jar", "oauthserver.jar"]