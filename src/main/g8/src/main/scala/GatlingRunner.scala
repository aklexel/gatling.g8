import io.gatling.app.Gatling
import io.gatling.core.config.GatlingPropertiesBuilder
import $package$.simulations._

object GatlingRunner extends App {
  val props = new GatlingPropertiesBuilder
  props.simulationClass( sys.props.getOrElse("test", classOf[Debug].getName) )

  Gatling.fromMap(props.build)
}
