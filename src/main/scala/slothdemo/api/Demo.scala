package slothdemo.api

import org.joda.time.DateTime
import slothdemo.Person
import Client.{greetingService, numberService}

import scala.concurrent.Future
import scala.util.{Failure, Success}

object Demo extends App {
  import scala.concurrent.ExecutionContext.Implicits.global

  for {
    num <- numberService.add(1, 2)
    g <- greetingService.greet(person = Person("george", dt=DateTime.now.minusYears(5)))
    p <- greetingService.create(name="Jack")
    gp <- greetingService.create
  } yield {
    println(s"a + b: $num")
    println(s"greeting: $g")
    println(s"person is: $p")
    println(s"gp is: $gp")
    val result =  numberService.divideByZero(25)
    result onComplete  {
      case Success(value) => {
        println(value)
        sys.exit(0)
      }
      case Failure(e) => {
        println(s"bad news: $e")
        sys.exit(1)
      }
    }
  }
}
