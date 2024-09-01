# Cron Expression Parser

## Overview

The Cron Expression Parser is a Java-based application designed to parse and expand cron expressions. It supports the parsing of minute, hour, day of month, month, day of week, and command fields in a cron expression.

## Prerequisites

- Java Development Kit (JDK) 8 or higher
- Maven 3.6.0 or higher

## Installation

### Cloning the Repository

First, clone the repository to your local machine using the following command:

- git clone https://github.com/rka8870/cron-parser
- Building the Project
Navigate to the project directory and build the project using Maven:

 - cd cron-parser
 - mvn clean install

### Running the Application

#### Running from an IDE
Open the project in your preferred IDE (e.g., IntelliJ IDEA, Eclipse).
Navigate to the Main class in the org.example package.
Run the Main class.

#### Running from the Command Prompt Using a JAR File
- Compile the Java source files: Ensure you are in the root directory of the project and compile the Java source files to the out directory.
- command -> javac -d out -sourcepath src/main/java $(find src/main/java -name "*.java")
- Create the JAR file: Create a JAR file named CronExpressionParser-1.0-SNAPSHOT.jar with the specified MANIFEST.MF file.
- command -> jar cfm CronExpressionParser-1.0-SNAPSHOT.jar MANIFEST.MF -C out .
- Run the JAR file: Execute the JAR file with a cron expression as an argument.
- command -> java -jar CronExpressionParser-1.0-SNAPSHOT.jar "*/15 0 1,15 * 1-5 /usr/bin/find"
<img width="1066" alt="Screenshot 2024-09-01 at 8 01 02 PM" src="https://github.com/user-attachments/assets/61e6cbeb-2bdc-4fe6-a56c-435e974008bb">
<img width="1035" alt="Screenshot 2024-09-01 at 7 59 41 PM" src="https://github.com/user-attachments/assets/60615e30-c4b6-4507-ac19-7e094699f9bb">

#### Example MANIFEST.MF
Ensure your MANIFEST.MF file specifies the Main-Class attribute correctly. For example:

Manifest-Version: 1.0
Main-Class: org.example.Main
Usage Once the application is running, it will prompt you to enter a cron expression. The application will then parse and expand the expression, displaying the expanded fields.

### Example Cron Expressions

Valid Cron Expressions
*/15 0 1,15 * 1-5 /usr/bin/find
This expression means:
Every 15 minutes
At hour 0
On the 1st and 15th day of the month
Every month
On Monday to Friday
Execute the command /usr/bin/find


0 12 * * 0 /usr/bin/backup
This expression means:
At minute 0
At hour 12 (noon)
Every day of the month
Every month
On Sunday
Execute the command /usr/bin/backup


Invalid Cron Expressions
*/15 0 1,15 * 1-5 /usr/bin/find extraField
This expression has too many fields.

*/15 0 1,15 a 1-5
This expression contains an invalid character a.

*/15 0 1,15 *-5 /usr/bin/find
This expression contains an invalid range *-5.

# All Steps Snapshot
<img width="1728" alt="Screenshot 2024-09-01 at 8 29 15 PM" src="https://github.com/user-attachments/assets/24884b49-b4bf-4dd4-94d7-d851462830d4">


# Support
Email to rka8870@gmail.com for support
