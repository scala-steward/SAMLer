name := """SAMLer"""
organization := "com.henricook"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

addCommandAlias("c", "compile")
addCommandAlias("t", "test")
addCommandAlias("r", "reload")

scalaVersion := "2.12.8"

scalacOptions += "-Ypartial-unification"

libraryDependencies ++= Seq(
  guice,
  "dev.zio" %% "zio" % "1.0.0-RC9",
  "org.typelevel" %% "cats-core" % "2.0.0-M4",
  "com.olegpy" %% "better-monadic-for" % "0.3.0",
  // Test
  "org.scalatestplus.play" %% "scalatestplus-play" % "4.0.3" % Test
)

// TwirlKeys.templateFormats += ("xml" -> "com.henricook.formatters.XMLFormat")

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.henricook.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.henricook.binders._"
