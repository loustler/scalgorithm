import sbt._
import Dependencies._

/**
  * @author loustler
  * @since 0.0.1
  */
object Dependencies {
  val scalaOrganization  = "org.scala-lang"
  val scalaVersion       = "2.12.7" // latest stable version at 10/27/2018
  val crossScalaVersions = Seq("2.11.12", "2.12.7")

  // build tools version
  val scalaFmtVersion = "1.5.1"

  // resolvers
  val resolvers = Seq(
    Resolver sonatypeRepo "public",
    Resolver typesafeRepo "releases"
  )
}

trait Dependencies {
  val scalaOrganizationUsed  = scalaOrganization
  val scalaVersionUsed       = scalaVersion
  val crossScalaVersionsUsed = crossScalaVersions

  val scalaFmtVersionUsed = scalaFmtVersion

  // resolvers
  val commonResolvers = resolvers

  implicit class ProjectRoot(project: Project) {

    def root: Project = project in file(".")
  }
}