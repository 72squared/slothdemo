// The simplest possible sbt build file is just one line:

scalaVersion := "2.13.1"
// That is, to create a valid sbt build, all you've got to do is define the
// version of Scala you'd like your project to use.

// ============================================================================

// Lines like the above defining `scalaVersion` are called "settings". Settings
// are key/value pairs. In the case of `scalaVersion`, the key is "scalaVersion"
// and the value is "2.13.1"

// It's possible to define many kinds of settings, such as:

name := "slothdemo"
organization := "com.tally.scala"
version := "1.0"


// Want to use a published library in your project?
// You can define other libraries as dependencies in your build like this:
//libraryDependencies += "com.github.cornerman" %% "sloth" % "0.3.0"
libraryDependencies += "com.lihaoyi" %% "upickle" % "0.9.5"
libraryDependencies += "io.suzaku" %% "boopickle" % "1.3.2"
//libraryDependencies += "com.github.cornerman" %% "chameleon" % "0.3.0"

libraryDependencies += "org.typelevel" %% "cats-core" % "2.0.0"
libraryDependencies += "com.typesafe.akka" %% "akka-http"   % "10.1.12"
libraryDependencies += "joda-time" % "joda-time" % "2.10.6"


val circeVersion = "0.12.3"

libraryDependencies ++= Seq(
  "io.circe" %% "circe-core",
  "io.circe" %% "circe-generic",
  "io.circe" %% "circe-parser"
).map(_ % circeVersion)


resolvers += "jitpack" at "https://jitpack.io"
libraryDependencies ++= Seq(
  "com.github.cornerman.covenant" %% "covenant-http" % "master-SNAPSHOT",
  "com.github.cornerman.covenant" %% "covenant-ws" % "master-SNAPSHOT"
)