package slothdemo.api

import akka.actor.ActorSystem
import covenant.http.HttpClient
import slothdemo.{GreetingService, NumberService}
import io.circe.generic.auto._, chameleon.ext.circe._

object Client {

  implicit val system = ActorSystem()
  import Pickling._
  val client = HttpClient[Pickling.PickleType](Config.url)
  val greetingService: GreetingService = client.wire[GreetingService]
  val numberService: NumberService = client.wire[NumberService]
}
