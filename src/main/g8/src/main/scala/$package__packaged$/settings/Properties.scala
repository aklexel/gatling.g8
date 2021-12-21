package $package$.settings

object Properties {
  // load app url
  lazy val baseUrl: String = sys.props.getOrElse("url", "http://computer-database.gatling.io")

  // load profile params
  lazy val startUsersPerSec: Int = Integer.getInteger("startUsersPerSec", 0).toInt
  lazy val usersPerSec: Int = Integer.getInteger("usersPerSec", 1).toInt
  lazy val rampUpDuration: Int = Integer.getInteger("rampUpDuration", usersPerSec).toInt
  lazy val testDuration: Int = Integer.getInteger("testDuration", 10 * 60).toInt
  lazy val loadSteps: Int = Integer.getInteger("loadSteps", 3).toInt
}
