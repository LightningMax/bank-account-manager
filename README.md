# Bank Account Management

A simple command-line application for managing bank accounts using Java and SQLite.

Personal project with the purpose for learning how to connect a database with an application and the MVC pattern.

## Features
- Create and manage client bank accounts.
- Store data in an SQLite database.
- Follow MVC architecture for clean code separation.

## Prerequisites
Ensure you have the following installed:
- [Java 21 or later](https://adoptopenjdk.net/)
- [Apache Maven](https://maven.apache.org/install.html)

## Installation
### Clone the Repository
```sh
git clone https://github.com/LightningMax/bank-account-manager.git
cd bank-account-manager
```


## Running the Application

1. Compile the project:
   ```sh
   mvn clean package
   ```
2. Run the generated JAR file:
   ```sh
   java -jar target/BankAccountManagement-1.0-SNAPSHOT.jar
   ```

## Database Setup
The application automatically creates an SQLite database file when run for the first time. Ensure you have write permissions in the directory.