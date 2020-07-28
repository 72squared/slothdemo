package slothdemo.json

import akka.actor.ActorSystem
import covenant.http.HttpClient
import slothdemo.{GreetingService, NumberService}
import io.circe.generic.auto._, chameleon.ext.circe._

object JsonClient {

  implicit val system = ActorSystem()
  import JsonPickling._
  val client = HttpClient[JsonPickling.PickleType](JsonConfig.url)
  val greetingService: GreetingService = client.wire[GreetingService]
  val numberService: NumberService = client.wire[NumberService]
}
