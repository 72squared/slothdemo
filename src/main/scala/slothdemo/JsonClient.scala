package slothdemo

import akka.actor.ActorSystem
import slothdemo.JsonConfig.url
import io.circe.generic.auto._, chameleon.ext.circe._

import covenant.http.HttpClient

object JsonClient {
  import slothdemo.JsonPickling._

  implicit val system = ActorSystem()

  val client = HttpClient[PickleType](url)
  val greetingService: GreetingService = client.wire[GreetingService]
  val numberService: NumberService = client.wire[NumberService]
}
