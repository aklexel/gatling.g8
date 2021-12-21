package $package$.settings

import io.gatling.http.protocol.HttpProtocolBuilder
import Properties._

object Protocol {
  object HTTP {
    import io.gatling.core.Predef._
    import io.gatling.http.Predef._

    val config: HttpProtocolBuilder = http
      .baseUrl( baseUrl )
      .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8")
      .acceptLanguageHeader("en-US,en;q=0.5")
      .userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:84.0) Gecko/20100101 Firefox/84.0")
      .warmUp( baseUrl + "/version" )
  }
}
