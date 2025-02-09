# Git setup
git config --local --get user.name
git config --local --get user.email

git config --local user.name "Anish Kumar"
git config --local user.email "anish.diliyan@gmail.com"

## "origin" is the remote name, and the URL is the HTTPS URL of the repository on GitHub.
Get origin Url
> git remote get-url origin

Add Origin Url
> git remote add origin https://github.com/anish-diliyan/scala-udemy

Remove Origin Url
> git remote remove origin

# Setup Postgres DataBase
1. run db-setup.bat to start postgres and load data in employees database
2. run db-connect.bat to connect with database and start pgsql terminal
3. run db-status.bat to check database is running or not (optional)
4. run db-stop.bat to stop the database again you need to start run db-connect.bat

> NO need to install pgsql database because, here running pgsql using binaries and kept in postgres/installer  

# Error: java.io.FileNotFoundException: HADOOP_HOME and hadoop.home.dir are unset.

The error message "java.io.FileNotFoundException: HADOOP_HOME and hadoop.home.dir are unset" typically occurs
when you're trying to run a Hadoop-related application (like Spark with Hadoop dependencies) on a Windows machine, and
the system can't find the Hadoop binaries.

Solution: download hadoop binary and add bin folder in env variable - Add winutil.exe and hadoop.dll in hadoop/bin folder,
so that it is also present in class path. You need to download version of winutil.exe and hadoop.dll must be same as hadoop.
