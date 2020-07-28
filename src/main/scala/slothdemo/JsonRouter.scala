package slothdemo

import io.circe.generic.auto._, chameleon.ext.circe._


import scala.concurrent.Future

object JsonRouter {
  import cats.implicits._
  import slothdemo.JsonPickling._

  import scala.concurrent.ExecutionContext.Implicits.global

  val router = sloth.Router[PickleType, Future]
    .route[GreetingService](GreetingServiceImpl)
    .route[NumberService](NumberServiceImpl)

}
