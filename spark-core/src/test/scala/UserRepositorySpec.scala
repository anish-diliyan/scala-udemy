import not_working.{DatabaseConnection, User, UserRepository}
import org.junit.{After, Before, Test}
import org.junit.Assert._

import scala.concurrent.Await
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

class UserRepositorySpec {
  implicit val db = DatabaseConnection.db

  @Before
  def setup(): Unit = {
    DatabaseConnection.initialize()
  }

  @Test
  def testCreateAndRetrieveUser(): Unit = {
    val user = User(None, "Test not_working.User", "test@example.com")
    val createdUser = Await.result(UserRepository.create(user), 5.seconds)

    assertNotNull(createdUser.id)
    assertEquals(user.name, createdUser.name)
    assertEquals(user.email, createdUser.email)

    val foundUser = Await.result(UserRepository.findByEmail("test@example.com"), 5.seconds)
    assertTrue(foundUser.isDefined)
    assertEquals(createdUser.id, foundUser.get.id)
  }

  @After
  def cleanup(): Unit = {
    db.close()
  }
}

