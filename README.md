A sample code to implement apo with Java agent

# build apring boot sample
```
cd springboot-example
mvn package
```
# build jaba agent
```
cd aop-agent
mvn package
```
# run
```
java -javaagent:aop-agent/target/aop-agent-1.0-jar-with-dependencies.jar -classpath aop-agent/target/aop-agent-1.0-jar-with-dependencies.jar -jar springboot-example/target/springboot-example-1.0.jar
```

# test
```
curl http://localhost:8080
```
