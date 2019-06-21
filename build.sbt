organization in ThisBuild := "com.github.rthoth"
version in ThisBuild := "1.0.0-SNAPSHOT"
scalaVersion in ThisBuild := "2.12.8"

lagomKafkaEnabled in ThisBuild := false
lagomCassandraEnabled in ThisBuild := false

val macwire = "com.softwaremill.macwire" %% "macros" % "2.2.5" % "provided"


lazy val `lagom-tracker` = project.in(file("."))
  .settings()
  .aggregate(`user-impl`)

//lazy val `tracker-api` = project.in(file("tracker-api"))
//  .settings(
//    libraryDependencies ++= Seq(
//      lagomScaladslApi
//    )
//  )
//
//lazy val `tracker-impl` = project.in(file("tracker-impl"))
//  .enablePlugins(LagomScala)
//  .settings(
//    libraryDependencies ++= Seq(
//      macwire
//    )
//  )
//  .dependsOn(`tracker-api`)

lazy val `user-api` = project.in(file("user-api"))
  .settings(
    libraryDependencies ++= Seq(
      lagomScaladslApi
    )
  )

lazy val `user-impl` = project.in(file("user-impl"))
  .enablePlugins(LagomScala)
  .settings(
    libraryDependencies ++= Seq(
      macwire,
      lagomScaladslPersistenceJdbc
    )
  )
  .dependsOn(`user-api`)

//lazy val `matcher-api` = project.in(file("matcher-api"))
//  .settings(
//    libraryDependencies ++= Seq(
//      lagomScaladslApi
//    )
//  )
//
//lazy val `matcher-impl` = project.in(file("matcher-impl"))
//  .enablePlugins(LagomScala)
//  .settings(
//    libraryDependencies ++= Seq(
//      macwire
//    )
//  )
//  .dependsOn(`matcher-api`)
