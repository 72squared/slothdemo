package slothdemo

import org.joda.time.DateTime

import scala.concurrent.Future

object GreetingServiceImpl extends GreetingService {
  def greet(person: Person): Future[String] = Future.successful(s"hello, ${person.name}, it is ${person.dt}")
  def create(name: String): Future[Person] = Future.successful(Person(name=name, dt=DateTime.now))
}
