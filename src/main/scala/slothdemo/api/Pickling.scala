package slothdemo.api

import io.circe.{Decoder, Encoder}
import org.joda.time.DateTime

import scala.util.Try

object Pickling {

  type PickleType = String
  type Event = String
  type State = String


  implicit val encodeDateTime: Encoder[DateTime] = Encoder.encodeString.contramap[DateTime](_.toString)

  implicit val decodeDateTime: Decoder[DateTime] = Decoder.decodeString.emapTry { str =>
    Try(DateTime.parse(str))
  }

  implicit val encodeArithmeticException: Encoder[ArithmeticException] = Encoder.encodeString.contramap[ArithmeticException](_.toString)

  implicit val decodeArithmeticException: Decoder[ArithmeticException] = Decoder.decodeString.emapTry(str => Try(new ArithmeticException(str)))

}
