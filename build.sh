cd ./api-1
./mvnw clean package install -Dquarkus.profile=prod -DskipTests
cd ../api-2
./mvnw clean package install -Dquarkus.profile=prod -DskipTests
cd ../docker-composer-mbank
docker-compose up --build