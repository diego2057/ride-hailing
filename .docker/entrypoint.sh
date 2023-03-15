#!/bin/bash

# Start PostgreSQL database in detached mode
docker run --name mydb -p 5432:5432 -e POSTGRES_USER=$DB_USER -e POSTGRES_PASSWORD=$DB_PASS -e POSTGRES_DB=$DB_NAME -d postgres:latest

# Wait for database to start
while ! docker exec mydb pg_isready -h localhost -p 5432 -U $DB_USER -d $DB_NAME -t 1; do
  echo "Waiting for database to start..."
  sleep 1
done

# Start Spring Boot application
java -jar ride-hailing.jar --spring.datasource.url=jdbc:postgresql://${DB_HOST}:${DB_PORT}/${DB_NAME} --spring.datasource.username=${DB_USER} --spring.datasource.password=${DB_PASS}
