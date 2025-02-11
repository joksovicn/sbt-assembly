sbtPlugin := true

name := "sbt-assembly"

organization := "com.eed3si9n"

// version <<= (sbtVersion, version in Posterous) { (sv, nv) => "sbt" + sv + "_" + nv }

version := "0.7.1"

scalacOptions := Seq("-deprecation", "-unchecked")

publishMavenStyle := true

publishTo <<= version { (v: String) =>
  if(v endsWith "-SNAPSHOT") Some("Scala Tools Nexus" at "http://nexus.scala-tools.org/content/repositories/snapshots/")
  else Some("Scala Tools Nexus" at "http://nexus.scala-tools.org/content/repositories/releases/")
}

credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")

publishArtifact in (Compile, packageBin) := true

publishArtifact in (Test, packageBin) := false

publishArtifact in (Compile, packageDoc) := false

publishArtifact in (Compile, packageSrc) := false

seq(ScriptedPlugin.scriptedSettings: _*)
