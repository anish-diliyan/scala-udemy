<div style="text-align: center"><h2>Big Data</h2></div>
<div style="text-align: center"><h4>
Can not fit and processed on standard computer, so you will need a cluster of computer that can store and process the data.
</h4></div>

<div style="text-align: center"><h2>What is Spark</h2></div>
<div style="text-align: center"><h4>
Unified computing engine and libraries for distributed data processing at scale, so that working with BIg Data became easier.
</h4></div>

### Unified
* Spark has hundreds of libraries for data processing, but it's unified in the sense that it has a set of consistent and composable
APIs and Spark supports multiple languages and all the APIs look very similarly, if not the same in all these languages.

* It's also unified in the sense that Spark can do optimizations across the different libraries, so not within a set of libraries.
for example, you're doing machine learning task on top of some data sets or data frames, and these are obtained with Spark SQL, 
which is another set of libraries, Spark is smart enough to optimize your code and optimize the execution of that code on the 
cluster across the machine learning and the Spark sequel libraries.

### Computing engine
Spark is a computing engine, meaning that it's completely detached from where the data resides and how the data is being fetched.
Spark also supports a set of libraries used for data processing. Spark comes with a set of standard libraries, including sequel, 
machine learning, lib streaming and graphx out of the box. But there are also hundreds of open source third party libraries for 
specific use cases.

### Spark Api Architecture
* **Low Level Apis:** RDDs and Distributed Variables
* **High Level (Structured) Apis:** DataFrame, DataSets, Spark Sql
* **Applications:** Streaming, ML, GraphX, Other Libraries