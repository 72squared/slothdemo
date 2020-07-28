package slothdemo.json

import slothdemo.{GreetingService, GreetingServiceImpl, NumberService, NumberServiceImpl}
import io.circe.generic.auto._, chameleon.ext.circe._

import scala.concurrent.Future
import JsonPickling._

object JsonRouter {
  import cats.implicits._

  import scala.concurrent.ExecutionContext.Implicits.global

  val router = sloth.Router[PickleType, Future]
    .route[GreetingService](GreetingServiceImpl)
    .route[NumberService](NumberServiceImpl)

}
