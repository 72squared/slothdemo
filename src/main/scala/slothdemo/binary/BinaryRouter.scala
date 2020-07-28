package slothdemo.binary

import java.nio.ByteBuffer

import slothdemo.{NumberService, NumberServiceImpl}

import scala.concurrent.Future

object BinaryRouter {
  import cats.implicits._

  import scala.concurrent.ExecutionContext.Implicits.global

//  val router = sloth.Router[ByteBuffer, Future]
//    .route[NumberService](NumberServiceImpl)

}
