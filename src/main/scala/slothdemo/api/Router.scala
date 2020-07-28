package slothdemo.api

import slothdemo.{GreetingService, GreetingServiceImpl, NumberService, NumberServiceImpl}
import io.circe.generic.auto._
import chameleon.ext.circe._

import scala.concurrent.Future
import Pickling._
import akka.http.scaladsl.model.HttpRequest
import covenant.core.api.ApiDsl
import covenant.http.api.HttpApiConfiguration
import sloth.ClientException

import scala.concurrent.{Await, Future}




case class ApiError(msg: String)


object Router {
  import cats.implicits._

  import scala.concurrent.ExecutionContext.Implicits.global

  val router = sloth.Router[PickleType, Future]
    .route[GreetingService](GreetingServiceImpl)
    .route[NumberService](NumberServiceImpl)

}
