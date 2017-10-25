mvn clean

echo "*********MAVEN Clean completed***********"

mvn install 


mvn package -DskipTests=true

echo "*********MAVEN Package completed***********"


java -jar target/Calculator-0.0.1-SNAPSHOT.jar

