package slothdemo

object JsonConfig {
  val port = 8099
  val interface = "0.0.0.0"
  val url = s"http://${interface}:${port}"
}
