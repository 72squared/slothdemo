package slothdemo.json

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import covenant.http.AkkaHttpRoute

object JsonServer extends App {

  implicit val system = ActorSystem()
  import scala.concurrent.ExecutionContext.Implicits.global
  Http().bindAndHandle(AkkaHttpRoute.fromFutureRouter(JsonRouter.router), interface = JsonConfig.interface, port = JsonConfig.port)
}
