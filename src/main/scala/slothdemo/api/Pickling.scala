package slothdemo.api

import io.circe.{Decoder, Encoder}
import org.joda.time.DateTime

import scala.util.Try

object Pickling {

  type PickleType = String

  implicit val encodeDateTime: Encoder[DateTime] = Encoder.encodeString.contramap[DateTime](_.toString)

  implicit val decodeDateTime: Decoder[DateTime] = Decoder.decodeString.emapTry { str =>
    Try(DateTime.parse(str))
  }
}