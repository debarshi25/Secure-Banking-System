# Secure Banking Application
A skeleton secure banking system (SBS) with limited functional, performance, and security requirements for secure banking transactions and user account management.
#### Users Categories
The users of this system are classified in the following four categories according to their roles:
##### Internal Users:
Internal users can be classified into 3 groups:
###### 1. Tier-1 employees:
Responsible for assisting the customer with various banking operations, such  as initiating fund deposit, issuing cashier cheques and transferring money etc. Tier 1 employee will do online operations like adding money to customer account (money deposit), etc.
###### 2. Tier-2 employees:
Responsible for the authorization of critical transactional operations. Each bank has a threshold amount, which a customer can send in a day for a transaction. If a customer exceeds this threshold amount, the customer is notified that permission is needed from an internal employee (Tier 2 employee) to proceed. Transactions of this type are considered as critical transactions. The threshold amount for this project is $1,000 USD. A tier-2 employee must also be able to create, modify, and close customer’s accounts.
###### 3. Tier-3 employees (Administrators):
create, maintain, change, and delete all the internal users’ accounts and ensure smooth functioning of the banking system.
##### External Users:
###### Individual customers:
Individuals, each of them has at least one of the following three types of accounts: checking, savings and credit card with common functions, such as fund transfer, debit and credit from user accounts.
#### Download Project
```
git clone https://github.com/debarshi25/Secure-Banking-System.git
```
#### Front-end: Angular
```
cd sbsapp
npm install
ng serve --open
```
#### Backend: Spring Boot
- Replace MySQL credentials with yours in ./src/main/resources/application.properties
- Build Module 'SBS' and run SbsApplication.java

#### Database: MySQL
```
create database SBSNonTransactional;
CREATE USER 'newuser'@'localhost' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON * . * TO 'newuser'@'localhost';
```