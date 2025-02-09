import slick.jdbc.PostgresProfile.api._
import scala.concurrent.Future
import java.time.LocalDate


case class Employee(
                     empNo: Int,
                     birthDate: LocalDate,
                     firstName: String,
                     lastName: String,
                     gender: String,
                     hireDate: LocalDate
                   )




class Employees(tag: Tag) extends Table[Employee](tag, "employees") {
  def empNo = column[Int]("emp_no", O.PrimaryKey)
  def birthDate = column[LocalDate]("birth_date")
  def firstName = column[String]("first_name")
  def lastName = column[String]("last_name")
  def gender = column[String]("gender")
  def hireDate = column[LocalDate]("hire_date")

  def * = (empNo, birthDate, firstName, lastName, gender, hireDate) <> (Employee.tupled, Employee.unapply)
}

object EmployeeRepository {
  private val employees = TableQuery[Employees]

  def findAll()(implicit db: Database): Future[Seq[Employee]] = {
    db.run(employees.result)
  }

  def findById(empNo: Int)(implicit db: Database): Future[Option[Employee]] = {
    db.run(employees.filter(_.empNo === empNo).result.headOption)
  }
}

