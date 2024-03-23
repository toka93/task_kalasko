# task_xm
# How to setup the project?

- Install JDK 21 
- Install Maven
- Install Eclipse IDE:
https://www.eclipse.org/downloads/
- Open Eclipse and open Help List and choose Install New Software , Search for TestNG and Install it.
- Open file List and choose Open project from file system and choose project directory 



#  Configuration :
Web Configuration inside test/resources 
- Website URL
- Browser (chrome/firefox)
- Headless (true/false)
Log4j Configuration inside main/resources
 
   

# Test Data: 
 saved in json file inside Data Folder.



# Steps:
- Open CMD
- CD to the directory contains the project
- mvn test.
- run from Eclipse IDE from class file or from suite file.

# After Every Run : 
- Report and Log  for every test will be generated.
- Reports in Reports folder and logs in logs folder.

# Test Design:

1 package one for web ui task.

# Automation Strategy

Page object was applied by creating sperate class for each page in the app holds locators and actions 
Data is saved in json file.
Extent Report library is used for reporting
Log4j is used to generate logs 
Testng used for handling running, assertions and handle tests life cycle by using annotations.


