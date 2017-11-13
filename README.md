# 


## Working with Batcave supercomp in Eclipse/STS

Application is built using Spring Boot

### prerequisites
The following items should be installed in your system:
* Maven 3 (http://www.sonatype.com/books/mvnref-book/reference/installation.html)
* git command line tool (https://help.github.com/articles/set-up-git)
* Eclipse with the m2e plugin (m2e is installed by default when using the STS (http://www.springsource.org/sts) distribution of Eclipse)
* Tomcat 7.x or above

Note: when m2e is available, there is an m2 icon in Help -> About dialog.
If m2e is not there, just follow the install process here: http://eclipse.org/m2e/download/


### Steps to Compile & Run:

1) In the command line
```
git clone https://github.com/tvasudev007/Batcave-supercomp.git 	
```
2) Inside Eclipse
```
File -> Import -> Maven -> Existing Maven project
Enter the path and click on Finish.

& Fianlly, Right click on the project and run as "Run on Server" (TOMCAT)


REST APIS:

BASE URL: http://localhost:8080/BatmanTheSaviour/





