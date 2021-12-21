enablePlugins(GatlingPlugin)

name := "$name$"
version := "0.0.1"

scalaVersion := "2.12.8"
scalacOptions := Seq(
  "-encoding", "UTF-8", "-target:jvm-1.8", "-deprecation",
  "-feature", "-unchecked", "-language:implicitConversions", "-language:postfixOps")

val gatlingVersion = "3.2.1"
libraryDependencies ++= Seq(
  "io.gatling.highcharts"   % "gatling-charts-highcharts" % gatlingVersion,
  "io.gatling"              % "gatling-test-framework"    % gatlingVersion
)

// DOCKER OPTIONS
enablePlugins(JavaAppPackaging, DockerPlugin, AshScriptPlugin)
val jvmFlags = List(
  // JVM options from gatling.sh in Gatling Bundle
  "-server",
  "-XX:+ExitOnOutOfMemoryError",
  "-XX:+UseG1GC -XX:+ParallelRefProcEnabled",
  "-XX:MaxInlineLevel=20 -XX:MaxTrivialSize=12 -XX:-UseBiasedLocking",
  //"-XX:+HeapDumpOnOutOfMemoryError",
  // set Xmx as 80% of available memory (by default 25% only)
  "-XX:+UseContainerSupport -XX:MaxRAMPercentage=80.0",
  // workaround to redefine HOCON array in gatling.conf
  "-Dgatling.data.writers.0=console"
)

// docker-related configs
dockerBaseImage := "openjdk:8-jre-alpine"
dockerEnvVars := Map(
  "JAVA_OPTS" -> jvmFlags.mkString(" "),
  "GATLING_NO_REPORTS" -> "true",
  "TZ" -> "Europe/Moscow",
)
Docker / daemonUser := "gatling"
mainClass in Compile := Some("GatlingRunner")
