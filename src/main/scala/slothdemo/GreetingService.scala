package slothdemo

import scala.concurrent.Future
import org.joda.time.DateTime
import sloth.PathName

case class Person(name:String, dt:DateTime=DateTime.now)

@PathName("welcome")
trait GreetingService {

  def greet(person: Person): Future[String]
  def create(name:String): Future[Person]

  @PathName("getperson")
  def create: Future[Person]

}
