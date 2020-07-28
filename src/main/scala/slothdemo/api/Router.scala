package slothdemo.api

import slothdemo.{GreetingService, GreetingServiceImpl, NumberService, NumberServiceImpl}
import io.circe.generic.auto._
import chameleon.ext.circe._

import scala.concurrent.Future
import Pickling._
import covenant.core.api.ApiDsl


import scala.concurrent.{Await, Future}




case class ApiError(msg: String)


object Router {
  import cats.implicits._

  import scala.concurrent.ExecutionContext.Implicits.global

  type Event = String
  type State = String

  object Dsl extends ApiDsl[Event, ApiError, State] {
    override def applyEventsToState(state: State, events: Seq[Event]): State = state + " " + events.mkString(",")
    override def unhandledException(t: Throwable): ApiError = ApiError(t.getMessage)
  }

  val router = sloth.Router[PickleType, Future]
    .route[GreetingService](GreetingServiceImpl)
    .route[NumberService](NumberServiceImpl)
}
