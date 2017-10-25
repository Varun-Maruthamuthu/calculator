
call mvn clean

echo "*********MAVEN Clean completed***********"

call mvn install 


call mvn package -DskipTests=true

echo "*********MAVEN Package completed***********"


java -jar target/Calculator-0.0.1-SNAPSHOT.jar



