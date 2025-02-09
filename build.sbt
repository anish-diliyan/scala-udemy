// Common values
val sparkVersion = "3.5.4"
val postgresVersion = "42.7.5"
val logVersion = "2.24.3"

// Repository resolvers
resolvers ++= Seq(
  "bintray-spark-packages" at "https://dl.bintray.com/spark-packages/maven",
  "Typesafe Simple Repository" at "https://repo.typesafe.com/typesafe/simple/maven-releases",
  "MavenRepository" at "https://mvnrepository.com"
)

// Common dependencies
lazy val commonDependencies = Seq(
  "org.apache.logging.log4j" % "log4j-api" % logVersion,
  "org.apache.logging.log4j" % "log4j-core" % logVersion,
  "junit" % "junit" % "4.13.2" % Test,
  "com.novocode" % "junit-interface" % "0.11" % Test
)

// Spark specific dependencies
lazy val sparkDependencies = Seq(
  "org.apache.spark" %% "spark-core" % sparkVersion,
  "org.apache.spark" %% "spark-sql" % sparkVersion
)

// data base dependencies
lazy val dbDependencies = Seq(
  "org.postgresql" % "postgresql" % "42.7.5",
  "com.typesafe.slick" %% "slick" % "3.5.2",
  "com.typesafe.slick" %% "slick-hikaricp" % "3.5.2",
  "org.flywaydb" % "flyway-core" % "11.3.1"  // For database migrations
)

// Test options
testOptions += Tests.Argument(TestFrameworks.JUnit, "-v", "-a")

// Root project settings
lazy val root = (project in file("."))
  .aggregate(scalaCore, scalaAdvanced, sparkCore, sparkPractice)
  .settings(
    name := "scala-udemy",
    version := "0.1",
    scalaVersion := "2.13.14"
  )

// Scala Core subproject
lazy val scalaCore = (project in file("scala-core"))
  .settings(
    name := "scala-core",
    libraryDependencies ++= commonDependencies
  )

// Scala Advanced subproject
lazy val scalaAdvanced = (project in file("scala-advanced"))
  .settings(
    name := "scala-advanced",
    libraryDependencies ++= commonDependencies
  )

// Spark Core subproject
lazy val sparkCore = (project in file("spark-core"))
  .settings(
    name := "spark-core",
    libraryDependencies ++= commonDependencies ++ sparkDependencies ++ dbDependencies
  )

// Morgan subproject
lazy val sparkPractice = (project in file("spark-practice"))
  .settings(
    name := "spark-practice",
    libraryDependencies ++= sparkDependencies
  )

