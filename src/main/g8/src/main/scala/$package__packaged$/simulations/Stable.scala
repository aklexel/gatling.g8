package $package$.simulations

import $package$.scenarios.AuthScenario
import $package$.settings.Protocol.HTTP
import $package$.settings.Properties._
import io.gatling.core.Predef._
import scala.concurrent.duration._

class Stable extends Simulation {

  setUp(
    TestScenario.main.inject(
      rampUsersPerSec(startUsersPerSec) to usersPerSec during (rampUpDuration seconds),
      constantUsersPerSec(usersPerSec) during (testDuration seconds)
    )
  ).protocols(HTTP.config)

}
