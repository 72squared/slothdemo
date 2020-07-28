package slothdemo
import JsonClient._
import org.joda.time.DateTime


object JsonDemo extends App {
  import scala.concurrent.ExecutionContext.Implicits.global
  for {
    num <- numberService.add(1, 2)
    g <- greetingService.greet(person = Person("george", dt=DateTime.now.minusYears(5)))
    p <- greetingService.create(name="Jack")

  } yield {
    println(s"a + b: $num")
    println(s"greeting: $g")
    println(s"person is: $p")
    sys.exit(0)
  }
}
