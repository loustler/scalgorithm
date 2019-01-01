import sbt._
import sbt.Keys._
import org.scalastyle.sbt.ScalastylePlugin.autoImport._
import com.lucidchart.sbt.scalafmt.ScalafmtCorePlugin.autoImport._

/**
  * @author loustler
  * @since 0.0.1
  */
object Settings extends Dependencies {
  private val commonSettings = Seq(
    name := "sKaLa",
    organization := "io.loustler",
    scalaOrganization := scalaOrganizationUsed,
    scalaVersion := scalaVersionUsed,
    crossScalaVersions := crossScalaVersionsUsed,
    scalafmtVersion := scalaFmtVersionUsed,
    autoScalaLibrary := true
  )

  private val rootSettings = commonSettings

  private val modulesSettings = commonSettings ++ Seq(
    scalacOptions ++= Seq(
      // standard settings
      "-target:jvm-1.8",
      "-encoding",
      "UTF-8",
      "-unchecked",
      "-deprecation",
      "-explaintypes",
      "-feature",
      // language features
      "-language:existentials",
      "-language:higherKinds",
      "-language:implicitConversions",
      "-language:postfixOps",
      // private options
      "-Xexperimental",
      "-Ybackend-parallelism",
      "8",
      "-Yno-adapted-args",
      "-Ypartial-unification",
      // warnings
      "-Ywarn-dead-code",
      "-Ywarn-extra-implicit",
      "-Ywarn-inaccessible",
      "-Ywarn-infer-any",
      "-Ywarn-macros:after",
      "-Ywarn-nullary-override",
      "-Ywarn-nullary-unit",
      "-Ywarn-numeric-widen",
      "-Ywarn-unused:implicits",
      "-Ywarn-unused:patvars",
      "-Ywarn-unused:privates",
      "-Ywarn-value-discard",
      // advanced options
      "-Xcheckinit",
      "-Xfatal-warnings",
      "-Xfuture",
      // linting
      "-Xlint:adapted-args",
      "-Xlint:by-name-right-associative",
      "-Xlint:constant",
      "-Xlint:delayedinit-select",
      "-Xlint:doc-detached",
      "-Xlint:inaccessible",
      "-Xlint:infer-any",
      "-Xlint:missing-interpolator",
      "-Xlint:nullary-override",
      "-Xlint:nullary-unit",
      "-Xlint:option-implicit",
      "-Xlint:package-object-classes",
      "-Xlint:poly-implicit-overload",
      "-Xlint:private-shadow",
      "-Xlint:stars-align",
      "-Xlint:type-parameter-shadow",
      "-Xlint:unsound-match"
    ).filterNot(
      (if (scalaVersion.value.startsWith("2.13"))
         Set(
           // removed in 2.13.x
           "-Yno-adapted-args",
           "-Ypartial-unification",
           // only for 2.11.x
           "-Xexperimental"
         )
       else if (scalaVersion.value.startsWith("2.12"))
         Set(
           // only for 2.11.x
           "-Xexperimental"
         )
       else if (scalaVersion.value.startsWith("2.11"))
         Set(
           // added in 2.12.x
           "-Ybackend-parallelism",
           "8",
           "-Ywarn-extra-implicit",
           "-Ywarn-macros:after",
           "-Ywarn-unused:implicits",
           "-Ywarn-unused:patvars",
           "-Ywarn-unused:privates",
           "-Xlint:constant"
         )
       else Set.empty[String]).contains _
    ),
    console / scalacOptions --= Seq(
      // warnings
      "-Ywarn-unused:implicits",
      "-Ywarn-unused:imports",
      "-Ywarn-unused:locals",
      "-Ywarn-unused:params",
      "-Ywarn-unused:patvars",
      "-Ywarn-unused:privates",
      // advanced options
      "-Xfatal-warnings",
      // linting
      "-Xlint"
    ),
    Global / cancelable := true,
    resolvers ++= commonResolvers,
    Compile / scalafmtOnCompile := true,
    scalastyleFailOnError := true,
  )
}
