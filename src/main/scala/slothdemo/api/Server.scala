package slothdemo.api

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import covenant.http.AkkaHttpRoute

object Server extends App {

  implicit val system = ActorSystem()
  import scala.concurrent.ExecutionContext.Implicits.global
  Http().bindAndHandle(AkkaHttpRoute.fromFutureRouter(Router.router), interface = Config.interface, port = Config.port)
}
