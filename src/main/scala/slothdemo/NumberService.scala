package slothdemo

import scala.concurrent.Future

trait NumberService {
  def add(a: Int, b: Int): Future[Int]
  def multiply(a: Int, b: Int): Future[Int]
}


