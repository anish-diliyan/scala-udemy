# Git setup
git config --local --get user.name
git config --local --get user.email

git config --local user.name "Anish Kumar"
git config --local user.email "anish.diliyan@gmail.com"

# "origin" is the remote name, and the URL is the HTTPS URL of the repository on GitHub.
git remote get-url origin
git remote set-url --add origin https://github.com/anish-diliyan/spark-udemy


# SetUp pgsql using Zip file (for window user only)
1. Download Zip file for window (https://www.enterprisedb.com/download-postgresql-binaries) and extract.
2. Set bin folder in env variable path. (D:\installed\pgsql\bin)
3. Create a bat file start_pg.bat using following script to start pgsql from command line using command "start_pg" and save at (D:\installed\pgsql\bin)
```shell
@echo off
echo Starting PostgreSQL...
"D:\installed\pgsql\bin\pg_ctl.exe" -D "D:\pgsql_data" start
if %ERRORLEVEL% EQU 0 (
    echo PostgreSQL started successfully.
) else (
    echo Failed to start PostgreSQL. Error code: %ERRORLEVEL%
)
pause
```
4. Create a bat file "stop_pg.bat" using following script to stop pgsql from command line using command "stop_pg" and save at (D:\installed\pgsql\bin)
```shell
@echo off
echo Starting PostgreSQL...
"D:\installed\pgsql\bin\pg_ctl.exe" -D "D:\pgsql_data" stop
if %ERRORLEVEL% EQU 0 (
    echo PostgreSQL shutdown successfully.
) else (
    echo Failed to shutdown PostgreSQL. Error code: %ERRORLEVEL%
)
pause
```
5. initiate a pg database server using following command (this is one time activity), but first create database folder at D:\installed\pgsql
```shell
initdb.exe -D D:\installed\pgsql\database -U postgres -W -E UTF8 -A scram-sha-256
```
6. Create password for postgres database
```shell
Enter new superuser password: postgres (you can use any password here)
Enter it again: postgres
```
# SetUp database
1. CREATE DATABASE employees;
2. CREATE USER udemy with password 'pgsql';
3. GRANT ALL PRIVILEGES ON employees.* TO 'udemy'@'%';
4. FLUSH PRIVILEGES;
5. psql -U udemy -d employees -f employees_db.sql (add data in database)

# Query database employees
1. run command start_pg from cmd
2. in another terminal psql -U udemy -d employees (password pgsql)
3. execute the queries.

> Error: java.io.FileNotFoundException: HADOOP_HOME and hadoop.home.dir are unset.

The error message "java.io.FileNotFoundException: HADOOP_HOME and hadoop.home.dir are unset" typically occurs
when you're trying to run a Hadoop-related application (like Spark with Hadoop dependencies) on a Windows machine, and
the system can't find the Hadoop binaries.

Solution: download hadoop binary and add bin folder in env variable - Add winutil.exe and hadoop.dll in hadoop/bin folder,
so that it is also present in class path. version of winutil.exe and hadoop.dll must be same as hadoop.

---------------------------------- Big Data ---------------------------------------------------------------
Big Data is a problem, and Hadoop is one of many solution for Big data. Data is a information that you want to store and
process.
When you get problem with data storing and processing then such type of data is called Big Data. problem is not limited
to storing and processing but problem can be any number of problem, it can be up to infinity.
Some of the problems is Volume, Value, Visualization, Velocity, Variety.
> it is a trending terms so any problems that you bring, convert it into some synonyms or the first letter should start with V.

### Different Stage of Data
Storage -> Processing -> Testing -> Visualization -> Data Science/Machine Learning -> Automation/Scheduling

### History of Hadoop
2002 ---- GFS (google file system for storage)
2004 ---- GMR (google map reduce for processing)
2006 ---- Hadoop (GFS -> HDFS + GMR -> MR) invented by Duck cutting
It is an open source so many distribution provided by several companies, called commercial Hadoop. Some of these is:
Cloudera -> ClouderaVm, Hortonworks -> Hdp sandbox, Amazon -> Emr, Databricks -> Databricks Sandbox.

### RoadMap To Start as Data Engineer
1. Linux
2. SQL
3. Java, Python, Scala
4. Hdfs, Hive, Spark Batch and Sql
5. Etl(extract, transform, load) concepts: Etl is something like Data warehouse
6. Basics of Cloud: Recommended Aws - Your Resume title will be - Big Data with Aws
7. Work on project challenges and optimizations: learn Hadoop, Hive, Spark Optimization
8. Prepare Your Cv and attend Interviews

---------------------------- HDFS - Hadoop Distributed File System --------------------------------------------------
> What is a file system ? Used to read and write from and to Hard drive Ex: NTFS -> New technology file system -> Used in window os
file system is just using the concept of library, where we have multiple partition for different category of data.
partition is further divided in blocks, it is the smallest part of file system, for NTFS each block size 16 KB.

> Types of file System: 1. Distributed - HDFS 2. Stand-Alone - NTFS

> Types of Distributed System: 1. Master Slave (master is controlling all the nodes) 2. Peer to Peer (every node acts like friends)
Master Slave is prone to SPOF - Single point of failure because of master node.

### Two basic concept
1. Block: Default Block size in HDFS is 64 MB till version 1 and 128 MB in HDFS version 2 and onwards.
2. Replication: For 1 Block there is default 2 more copy will be created that is called replication, if you are loading
   1 GB of data to the cluster that means you need 3 GB of Space to store. Copies will be stored on other nodes to solve if
   node goes down other two nodes will be available to serve.