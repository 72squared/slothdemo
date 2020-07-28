package slothdemo.api

import org.joda.time.DateTime
import slothdemo.Person
import Client.{numberService, greetingService}

object Demo extends App {
  import scala.concurrent.ExecutionContext.Implicits.global

  for {
    num <- numberService.add(1, 2)
    g <- greetingService.greet(person = Person("george", dt=DateTime.now.minusYears(5)))
    p <- greetingService.create(name="Jack")
    z <- numberService.divideByZero(25)

  } yield {
    println(s"a + b: $num")
    println(s"greeting: $g")
    println(s"person is: $p")
    println(s"divide by zero: $z")
    sys.exit(0)
  }
}
