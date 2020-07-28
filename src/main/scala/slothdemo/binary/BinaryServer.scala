package slothdemo.binary

import akka.actor.ActorSystem

object BinaryServer extends App {

  implicit val system = ActorSystem()
  //Http().bindAndHandle(AkkaHttpRoute.fromFutureRouter(router), interface = interface, port = port)
}
