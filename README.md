# 📚 Doctor Service Setup Guide

Welcome to the **Doctor Service Application**! This guide will walk you through the steps to set up the project, configure the database, and get the application running.

---

## 🚀 Prerequisites

Before starting, ensure you have the following installed:

- **PostgreSQL**: Database server to store application data.
- **Java**: Version 17 or higher is recommended.
- **Gradle **: To build and run the project.
- **Spring Boot**: No additional setup required for Spring Boot.

---

## 🏗️ Step 1: Create the Database

1. Open your PostgreSQL client (e.g., `pgAdmin`, `psql`, or another database tool).  
2. Run the following SQL query to create the `Doctor` database:

   ```sql
   CREATE DATABASE Doctor;
   CREATE SCHEMA IF NOT EXISTS slot;
   CREATE SCHEMA IF NOT EXISTS appointment;


