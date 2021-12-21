package $package$.simulations

import $package$.scenarios.AuthScenario
import $package$.settings.Protocol.HTTP
import $package$.settings.Properties._
import io.gatling.core.Predef._
import scala.concurrent.duration._

class Load extends Simulation {

  setUp(
    TestScenario.main.inject(
      incrementUsersPerSec(usersPerSec)
        .times(loadSteps)
        .eachLevelLasting(testDuration seconds)
        .separatedByRampsLasting(rampUpDuration seconds)
        .startingFrom(startUsersPerSec)
    )
  ).protocols(HTTP.config)

}
