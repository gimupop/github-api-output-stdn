#github-api-issues
output issues.

https://api.github.com/repos/spring-projects/spring-boot/issues

You can change behavior by argument.<br>
If you not set argument , use default setting.

##how to use
java -jar github-api-output-stdout-1.0-jar-with-dependencies.jar read write parPage

###example
java -jar github-api-output-stdout-1.0-jar-with-dependencies.jar api stdout 30

##argument list
###read
api  --default

###write
stdout  --default<br> 
file

###paePage
natural number
30 --default