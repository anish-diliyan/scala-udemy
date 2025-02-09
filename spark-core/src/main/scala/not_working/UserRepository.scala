package not_working

import slick.jdbc.H2Profile.api._

import scala.concurrent.Future

class Users(tag: Tag) extends Table[User](tag, Some("MORGAN"), "USERS") {
  def id = column[Long]("ID", O.PrimaryKey, O.AutoInc)
  def name = column[String]("NAME")
  def email = column[String]("EMAIL")

  def * = (id.?, name, email) <> (User.tupled, User.unapply)
}

object UserRepository {
  private val users = TableQuery[Users]

  def create(user: User)(implicit db: Database): Future[User] = {
    val insertQuery = users returning users.map(_.id) into ((user, id) => user.copy(id = Some(id)))
    db.run(insertQuery += user)
  }

  def findAll()(implicit db: Database): Future[Seq[User]] = {
    db.run(users.result)
  }

  def findByEmail(email: String)(implicit db: Database): Future[Option[User]] = {
    db.run(users.filter(_.email === email).result.headOption)
  }
}
