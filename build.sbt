name := "spark-udemy"

version := "0.1"

scalaVersion := "2.13.14"

val sparkVersion = "3.5.4"
val postgresVersion = "42.7.4"
val logVersion = "2.24.3"

resolvers ++= Seq(
  "bintray-spark-packages" at "https://dl.bintray.com/spark-packages/maven",
  "Typesafe Simple Repository" at "https://repo.typesafe.com/typesafe/simple/maven-releases",
  "MavenRepository" at "https://mvnrepository.com"
)

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % sparkVersion,
  "org.apache.spark" %% "spark-sql" % sparkVersion,
  // logging
  "org.apache.logging.log4j" % "log4j-api" % logVersion,
  "org.apache.logging.log4j" % "log4j-core" % logVersion,
  // pgsql for Db connectivity
  "org.postgresql" % "postgresql" % postgresVersion,
  // testing
  "junit" % "junit" % "4.13.2" % Test,
  "com.novocode" % "junit-interface" % "0.11" % Test
)

// Add this to ensure JUnit tests are run
testOptions += Tests.Argument(TestFrameworks.JUnit, "-v", "-a")