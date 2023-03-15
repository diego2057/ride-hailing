# Use a lightweight image of the latest OpenJDK 11
FROM openjdk:11-jre-slim

# Set environment variables for Spring Boot application
ENV APP_HOME=/app
ENV APP_PORT=8080
ENV DB_HOST=db
ENV DB_PORT=5432
ENV DB_NAME=mydb
ENV DB_USER=myuser
ENV DB_PASS=mypassword

# Create application directory
RUN mkdir $APP_HOME

# Set working directory for the container
WORKDIR $APP_HOME

# Copy the JAR file of the application into the container
COPY build/libs/*.jar $APP_HOME

# Expose the port that the application will listen on
EXPOSE $APP_PORT

# Set entrypoint script
COPY ./.docker/entrypoint.sh /entrypoint.sh
RUN chmod 755 /entrypoint.sh
ENTRYPOINT ["/bin/bash", "entrypoint.sh"]
