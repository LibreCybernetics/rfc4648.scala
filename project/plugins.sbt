ThisBuild / libraryDependencySchemes += "org.scala-native" % "sbt-scala-native" % "always"

// CrossPlatform

addSbtPlugin("org.portable-scala" % "sbt-scalajs-crossproject"      % "1.2.0")
addSbtPlugin("org.portable-scala" % "sbt-scala-native-crossproject" % "1.2.0")
addSbtPlugin("org.scala-native"   % "sbt-scala-native"              % "0.4.11")
addSbtPlugin("org.scala-js"       % "sbt-scalajs"                   % "1.13.0")

// Static Code Analysis

addSbtPlugin("org.wartremover" % "sbt-wartremover" % "3.0.9")

// Testing

addSbtPlugin("org.scoverage"      % "sbt-scoverage" % "2.0.7")
addSbtPlugin("pl.project13.scala" % "sbt-jmh"       % "0.4.4")
