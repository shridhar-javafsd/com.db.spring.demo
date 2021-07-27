# com.db.spring.demo
 Spring boot demo for Deutsche Bank grads July 2021 

<<<<<<< HEAD
# Junit Testing with Java 
## Softwares Required 
*  Java 11 
*  Spring STS/Eclipse 
*  Internet Connectivity for Maven and other Related Downloads of the Tools 

Setting up your project for unit testing using JUnit 

* Create a new Workspace 
* Add a new Simple java Maven Project 

![New Maven Project](https://i.ibb.co/c6YKN36/lab11-1.png)

![Project Details](https://i.ibb.co/ZSTjLvF/lab11-2.png)

* In the pom.xml add the Support dependencies for JUnit 
~~~xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<groupId>com.vinsys</groupId>
	<artifactId>lab11-unittesting</artifactId>
	<version>0.0.1-SNAPSHOT</version>

	<dependencies>
		<dependency>
			<groupId>org.junit.jupiter</groupId>
			<artifactId>junit-jupiter-api</artifactId>
			<version>5.7.2</version>
			<scope>test</scope>
		</dependency>
	</dependencies>
</project>
~~~~

#### adding java 11 support
~~~ java
<project xmlns="http://maven.apache.org/POM/4.0.0"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<groupId>com.vinsys</groupId>
	<artifactId>lab11-unittesting</artifactId>
	<version>0.0.1-SNAPSHOT</version>

	<dependencies>
		<dependency>
			<groupId>org.junit.jupiter</groupId>
			<artifactId>junit-jupiter-api</artifactId>
			<version>5.7.2</version>
			<scope>test</scope>
		</dependency>
	</dependencies>
	<build>
		<plugins>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-compiler-plugin</artifactId>
				<version>3.8.0</version>
				<configuration>
					<release>11</release>
				</configuration>
			</plugin>
		</plugins>
	</build>
</project>
~~~

* Creating a stand alone class for testing 
Run the test using the Run as Unit Test 
![UnitTestRun ](https://i.ibb.co/tMLrX5H/lab11-3.png)

## Adding Setup and TearDown





## Generating Report for Test 
~~~xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<groupId>com.vinsys</groupId>
	<artifactId>lab11-unittesting</artifactId>
	<version>0.0.1-SNAPSHOT</version>

	<dependencies>
		<dependency>
			<groupId>org.junit.jupiter</groupId>
			<artifactId>junit-jupiter-api</artifactId>
			<version>5.7.2</version>
			<scope>test</scope>
		</dependency>
	</dependencies>
	<reporting>
		<plugins>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-surefire-report-plugin</artifactId>
				<version>3.0.0-M5</version>
			</plugin>

		</plugins>
	</reporting>
	<build>
		<plugins>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-compiler-plugin</artifactId>
				<version>3.8.0</version>
				<configuration>
					<release>11</release>
				</configuration>
			</plugin>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-site-plugin</artifactId>
				<version>3.7.1</version>
			</plugin>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-project-info-reports-plugin</artifactId>
				<version>3.0.0</version>
			</plugin>
		</plugins>
	</build>

</project>
~~~ 
in the above pom.xml we have added 

*  The Maven site plugin 
~~~xml
	<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-site-plugin</artifactId>
				<version>3.7.1</version>
    </plugin>
~~~~

*  The Reporting Configuration and Plugin 
~~~xml
<reporting>
		<plugins>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-surefire-report-plugin</artifactId>
				<version>3.0.0-M5</version>
			</plugin>
		</plugins>
</reporting>
~~~

* The Report site integration Plugin 
~~~xml
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-project-info-reports-plugin</artifactId>
    <version>3.0.0</version>
</plugin>
~~~

* To generate the Site Report now with the Test Report (- coverage ) Currently the coverge report is not enable hence we will be getting only the Test Reports only 

* Select you pom and run the target mvn site or (Goal set to set) from the ide 

![Unit Testing report](https://i.ibb.co/N9XwhhM/lab11-4.png)


## Enabling the Coverage Report unit testing 

*   Coverage report  
    JaCoCo reports help you visually analyze code coverage by using diamonds with colors for branches and background colors for lines:
*   Lines coverage reflects the amount of code that has been exercised based on the number of Java byte code instructions called by the tests.
*   Branches coverage shows the percent of exercised branches in the code – typically related to if/else and switch statements.
*   Cyclomatic complexity reflects the complexity of code by giving the number of paths needed to cover all the possible paths in a code through linear combination.


#### Adding the jacoco plugin 
~~~xml 
<reporting>
<plugins>
            <plugin>
                <groupId>org.jacoco</groupId>
                <artifactId>jacoco-maven-plugin</artifactId>
                <reportSets>
                    <reportSet>
                        <reports>
                            <report>report</report>
                        </reports>
                    </reportSet>
                </reportSets>
            </plugin>
</plugins>
</reporting>
<build>
    <plugins>
     <plugin>
                <groupId>org.jacoco</groupId>
                <artifactId>jacoco-maven-plugin</artifactId>
                <version>0.8.7</version>
                <executions>
                    <execution>
                        <goals>
                            <goal>prepare-agent</goal>
                        </goals>
                    </execution>
                    <execution>
                        <id>report</id>
                        <phase>prepare-package</phase>
                        <goals>
                            <goal>report</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
    </plugins>
</build>
~~~
The complete maven pom.xml 
~~~xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<groupId>com.vinsys</groupId>
	<artifactId>lab11-unittesting</artifactId>
	<version>0.0.1-SNAPSHOT</version>

	<dependencies>
		<dependency>
			<groupId>org.junit.jupiter</groupId>
			<artifactId>junit-jupiter-api</artifactId>
			<version>5.7.2</version>
			<scope>test</scope>
		</dependency>
	</dependencies>
	<reporting>
		<plugins>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-surefire-report-plugin</artifactId>
				<version>3.0.0-M5</version>
			</plugin>
			<plugin>
				<groupId>org.jacoco</groupId>
				<artifactId>jacoco-maven-plugin</artifactId>
				<reportSets>
					<reportSet>
						<reports>
							<report>report</report>
						</reports>
					</reportSet>
				</reportSets>
			</plugin>
		</plugins>
	</reporting>
	<build>
		<plugins>
			<plugin>
				<groupId>org.jacoco</groupId>
				<artifactId>jacoco-maven-plugin</artifactId>
				<version>0.8.7</version>
				<executions>
					<execution>
						<goals>
							<goal>prepare-agent</goal>
						</goals>
					</execution>
					<execution>
						<id>report</id>
						<phase>prepare-package</phase>
						<goals>
							<goal>report</goal>
						</goals>
					</execution>
				</executions>
			</plugin>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-compiler-plugin</artifactId>
				<version>3.8.0</version>
				<configuration>
					<release>11</release>
				</configuration>
			</plugin>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-site-plugin</artifactId>
				<version>3.7.1</version>
			</plugin>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-project-info-reports-plugin</artifactId>
				<version>3.0.0</version>
			</plugin>
		</plugins>
	</build>
</project>
~~~

The coverage report would Generate the coverage of each package level and class level and method level 

* To generate the Coverage report 
   *  mvn site 

* The generated Site report  
![Site Report](https://i.ibb.co/nMgc7xv/lab11-5.png) 

The coverage will determine the overall lines covered in current build 



=======
>>>>>>> 253e5aa67ee611f182cd13480962c58bcc91a6c2
# Debugging and Profiling Your java Code 
### Tools Required 
* Spring tool suite 
* Java 11 
* Download the [Visual VM ](https://visualvm.github.io/download.html) for Profiling
* Your Previously Created Java Spring boot Application 

### Debug Your Java Prorgam 

A Java program can be debugged simply by right clicking on the Java editor class file from Package explorer. Select Debug As → Java Application or use the shortcut Alt + Shift + D, J instead.

* Add a break point 
![BreakPoint](https://i.ibb.co/nMNqNW4/Lab9-1.png)

Now If you application is already running you may have to stop and start it in the Debug mode
![Restart in Debug](https://i.ibb.co/1Mqn4ZH/Lab9-2.png)

Now Hit the Postman Url for the link that you have applied the break point 
![Switch in Debug](https://i.ibb.co/LCn9WPZ/Lab9-3.png)

As soon as you hit your service you should find the debug break point activate  
![Service](https://i.ibb.co/znxL8MN/Lab9-4.png)

You can now decide the required actions 
* Resume 
* Stop 
* Step In 
* Step Over 
* Run to Return 

![Actions](https://i.ibb.co/zrPWb1m/Lab9-5.png)

The Debug Persepective 
![Debug Perspective](https://i.ibb.co/kHSvSvr/Lab9-6.png)


Inspecting and chaning Values at Runtime : 
![Inspect](https://i.ibb.co/TqTRb3w/Lab9-7.png)



# Profiling the Application 
### Using Java VisualVM 

What can you profile 
*   CPU Profiling. 
*   Memory Profiling. 

[Download VISUAL VM](https://visualvm.github.io/download.html)

Starting the Visual VM : 
In the you Visual VM Extracted Folder you will find --> visualvm.exe
Double click the visualvm.exe to start the the visualvm 

![VisualVM Home](https://i.ibb.co/HgdZt38/lab10-1.png)
The Visual VM will atomatically detect the Running JVM  alternative you can also go to command prompt and run jps to find java proceses  

Select the Appropriate PID which you wish to profile 
![Profiler Selected](https://i.ibb.co/8nynfm7/lab10-2.png)

* On the right hand side you should see the following tables 
    * Monitor  
    * Threads  
    * Sampler  
    * Profiler   
 
The Monitor thread allows you to show the 
*  Heap 
*  Thread Summary 
*  Classes Loaded 
*  CPU Utilization   


![Monitor Screen](https://i.ibb.co/9wgLzyD/lab10-3.png)  

If you wish to perform a manual Garbage Collection you can : Perform GC 
or Even Take a Heap Dump   
Hit the GC and Monitor the Heap Utiliazation Change (This is force GC)  

After GC you will see the Heap Utitlization going down  
![HeapDown](https://i.ibb.co/Jpcrv2f/lab10-4.png)

## The Threads tab
The threads tab is able to show all the current threads in your jvm it can be used to 
* Analyse the current threads 
* Take a Thread Dump 
* Understand thread Status 

Use the thread dump to take a thread dump (Generally Thread dumps are take at 5 sec interval and then compared with each other to find the stuck thread analysis on where the code is getting stuck)
![TD](https://i.ibb.co/VqHvcn6/lab10-5.png)


Profiling the Application 
To profile the application Put the desired filter for the classes that you wish to profile . 
The profiling can be used with either memory or with CPU Cycles 
In our case we have added 
* com.vinsys.lab8.** so that it profiles only our classes and its utlization on cpu and memory

![Profiling](https://i.ibb.co/DrYNKBF/lab10-8.png)

Exclude Api/Apps/Libs you wish not monitor 

Repeat the same for Memory Profiling 


<<<<<<< HEAD
=======



>>>>>>> 253e5aa67ee611f182cd13480962c58bcc91a6c2
# Program Documentation
Code documentation is a necessary evil that every developer has to deal with. Almost every programming language has different ways of approaching code documentation


* Three Types of Comment 
    * //  Single Line Comment 
    * /* */ Multi Line Comment
    * /** **/ Document Comment
    
Using [DOCCheck](https://openjdk.java.net/projects/code-tools/doccheck/) Detect documentation missouts
Version control is documentation

This part of the documentation is awesome! It documents change. In large projects, you may still be able to reconstruct why a co-worker who has long ago left the company did some weird change that you don’t understand right now. It is thus important to also include the aforementioned ticket ID in the change.

So, follow this rule: Is the change non-trivial (fixed spelling, fixed indentation, renamed local variable, etc.)? Then create a ticket and document this change with a ticket ID in your commit. Creating and referencing that ticket costs you only 1 minute, but it’ll save a future coworker hours of investigation!

Version numbering is documentation

A simple and concise version numbering system will help your users understand, which version they should upgrade to. A good example of how to do this correctly is semantic versioning. The golden rules here are to use an [X].[Y].[Z] versioning scheme that can be summarised as follows:

If a patch release includes bugfixes, performance improvements and API-irrelevant new features, [Z] is incremented by one.
If a minor release includes backwards-compatible, API-relevant new features, [Y] is incremented by one and [Z] is reset to zero.
If a major release includes backwards-incompatible, API-relevant new features, [X] is incremented by one and [Y], [Z] are reset to zero.

Basic Tips
* by keeping documentation simple and concise.
* by keeping documentation close to the code and close to the API, which are the ultimate truths of your application.
* by keeping your documentation DRY.
* by making documentation available to others, through a ticketing system, version control, semantic versioning.
* by referencing ticket IDs throughout your available media.
* by forgetting about “external” documentation, as long as you can.




<<<<<<< HEAD
## Test REST APIs on Postman 
=======
















##Test REST APIs 
>>>>>>> 253e5aa67ee611f182cd13480962c58bcc91a6c2

data to be inserted 
{  
    "id": "101",  
    "name": "Sonu",  
    "salary": 10.5   
}  

{  
    "id": "102",  
    "name": "Monu",  
    "salary": 10.6   
}  

{  
    "id": "103",  
    "name": "Tonu",  
    "salary": 10.7   
}  

{  
    "id": "104",  
    "name": "Gonu",  
    "salary": 10.8   
}  

1. Create - POST 
---------------- 

Open the Postman and do the following:

Select the POST
Invoke the URL http://localhost:8084/Employee
Select the Body
Select the Content-Type JSON (application/json).
Insert the data in the Body:
{  
    "id": "101",  
    "name": "Sonu",  
    "salary": 10.5 
}  

Click on Send

When the request is successfully executed, it shows the Status:200 OK. 
It means the record has been successfully inserted in the database.

Insert more data. 

1.1 Verify the data 

Open the H2 console to see the data.

Open the browser and invoke the URL http://localhost:8084/h2-console

Click on the Connect button 

write 

select * from employee; 

and run selected. 

Output 
<emp data>

2. Retrieve - GET 
-----------------

Open the Postman and send a GET request with the URL http://localhost:8084/Employee 
Output 
<emp data>

2.1 GET - Specified data 

Send a GET request with the URL http://localhost:8084/Employee/{id}

id=101


3. Delete - DELETE 
------------------ 

Select the DELETE method and invoke the URL http://localhost:8084/Employee/103

Execute the Select query in the H2 console. 

write select * from employee; 
and run selected. 

Output 
<emp data>


4. Update - PUT 
--------------- 

Select the PUT and invoke the URL http://localhost:8084/Employee

In the request body, paste the record to update. 

{  
    "id": "101",  
    "name": "Sonu",  
    "salary": 20.5   
}  

Click on the Send

Execute the Select query in the H2 console. 

write select * from employee; 
and run selected. 

Output 
<emp data> 

