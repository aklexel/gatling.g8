package $package$.scenarios

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object TestScenario {
  private val data = csv("search.csv").circular

  def main = scenario("Test")
    .exec(
      http("1.1 main")
        .get("/")
    )
    .pause(1)
    .feed(data)
    .exec(
      http("1.2 search")
        .get("/computers?f=\${text}")
    )
}
