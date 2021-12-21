package $package$.scenarios

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object TestScenario {

  def main = scenario("Test")
    .exec(
      http("1.1 main")
        .get("/")
    )
    .pause(1)
    .exec(
      http("1.2 search")
        .get("/computers?f=macbook")
    )
}
