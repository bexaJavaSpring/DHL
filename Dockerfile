#Stage 1: Prepared Stage
FROM maven:openjdk as prepared
ENV APP_HOME=/opt/DHL

# Set the working directory
WORKDIR $APP_HOME

# Copy only the necessary files from the build stage
COPY src $APP_HOME/src
COPY pom.xml $APP_HOME

RUN mvn clean package

#Stage 2: Build Stage
FROM prepared as build
ENV APP_HOME=/opt/DHL

# Set the working directory
WORKDIR $APP_HOME
COPY --from=prepared $APP_HOME/target/shipping-service-0.0.1-SNAPSHOT.jar $APP_HOME
#
EXPOSE 7777

# Specify the command to run on container start
CMD ["java", "-jar", "shipping-service-0.0.1-SNAPSHOT.jar"]