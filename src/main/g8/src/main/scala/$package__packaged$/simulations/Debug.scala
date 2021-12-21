package $package$.simulations

import $package$.scenarios.AuthScenario
import $package$.settings.Protocol.HTTP
import $package$.settings.Properties._
import io.gatling.core.Predef._
import scala.concurrent.duration._

class Debug extends Simulation {

  setUp(
    TestScenario.main.inject(
      atOnceUsers(1),
      //      rampConcurrentUsers(startUsersPerSec) to usersPerSec during (rampUpDuration seconds),
      //      constantConcurrentUsers(usersPerSec) during(testDuration seconds)
    )
  ).protocols(HTTP.config)

}
