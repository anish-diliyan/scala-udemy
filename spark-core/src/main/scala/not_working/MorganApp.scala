package not_working

import scala.concurrent.Await
import scala.concurrent.duration._

object MorganApp extends App {
  implicit val db = DatabaseConnection.db

  try {
    // Initialize database and create schema
    DatabaseConnection.initialize()

    // Test connection
    DatabaseConnection.testConnection()

    // Create a new user
    val newUser = User(None, "Test not_working.User", "test@example.com")
    val futureUser = UserRepository.create(newUser)
    val createdUser = Await.result(futureUser, 5.seconds)
    println(s"Created user: $createdUser")

    // Find user by email
    val userByEmail = Await.result(UserRepository.findByEmail("test@example.com"), 5.seconds)
    println(s"Found user by email: $userByEmail")

    // Print all users
    val users = Await.result(UserRepository.findAll(), 5.seconds)
    println("\nAll users:")
    users.foreach(println)

  } catch {
    case e: Exception =>
      println(s"Error: ${e.getMessage}")
      e.printStackTrace()
  } finally {
    db.close()
  }
}

