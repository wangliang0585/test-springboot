echo "====================Begin build================================="
mvn clean install -Dmaven.test.skip=true
java -jar target/spring*.jar
echo "====================End build==================================="
echo "====================Begin run==================================="