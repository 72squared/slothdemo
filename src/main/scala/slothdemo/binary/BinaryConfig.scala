package slothdemo.binary

object BinaryConfig {
  val port = 8090
  val interface = "0.0.0.0"
  val url = s"http://${interface}:${port}"
}
