This setup provides:

An embedded H2 database running in PostgreSQL compatibility mode

No installation required

Persistent storage (data is saved to ./data/morgan_db)

Slick integration for type-safe database queries

Connection pooling with HikariCP

Basic repository pattern implementation

Unit tests

Sample application

The database file will be created automatically in the data directory of your project. The data persists between runs, making it suitable for development work. If you need to reset the database, simply delete the files in the data directory.

This approach is perfect for development and testing, but remember that there might be some slight differences between H2's PostgreSQL mode and a real PostgreSQL database. For production, you should switch to a real PostgreSQL database.

