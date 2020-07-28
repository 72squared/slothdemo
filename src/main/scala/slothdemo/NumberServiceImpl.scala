package slothdemo
import scala.concurrent.Future

object NumberServiceImpl extends NumberService {

  override def add(a: Int, b: Int): Future[Int] = Future.successful(a + b)

  override def multiply(a: Int, b: Int): Future[Int] = Future.successful(a * b)
}