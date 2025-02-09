object TestConnection extends App {
  implicit val db = DatabaseConnection.db

  try {
    DatabaseConnection.testConnection()
  } finally {
    db.close()
  }
}


