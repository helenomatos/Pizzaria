# Pizzaria CGH — query screen

A Java Swing screen that connects to a MySQL database for a pizzeria and shows the result of any query in a table. It was a course exercise in JDBC: opening a connection, running a statement and turning the `ResultSet` into a `JTable`.

## Features

- **Connection handling:** `BD` opens and closes the MySQL connection.
- **Query screen:** `Consulta2` takes an SQL query, runs it and builds the table columns from the result's metadata.

## Configuration

The connection details come from environment variables. Without them, the code falls back to a local MySQL server.

| Variable      | Default                               |
| ------------- | ------------------------------------- |
| `DB_URL`      | `jdbc:mysql://localhost:3306/pizzaria` |
| `DB_USER`     | `root`                                |
| `DB_PASSWORD` | *(empty)*                             |

## Run

Requires a JDK and the [MySQL Connector/J](https://dev.mysql.com/downloads/connector/j/) jar.

```bash
javac -encoding UTF-8 -d out *.java
java -cp "out:mysql-connector-j.jar" Consulta2      # on Windows use ; instead of :
```

---

Made by [Heleno Matos](https://portfolio.helenomatos.com) during the Computer Technician course at CEAP (2019–2021).
