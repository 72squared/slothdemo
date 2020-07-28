package slothdemo

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.RouteResult._
import covenant.http._
import slothdemo.JsonRouter.router
import slothdemo.JsonConfig.{interface, port}

object JsonServer extends App {

  implicit val system = ActorSystem()
  import scala.concurrent.ExecutionContext.Implicits.global
  Http().bindAndHandle(AkkaHttpRoute.fromFutureRouter(router), interface = interface, port = port)
}
