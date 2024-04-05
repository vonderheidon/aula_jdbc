package dml;

import connection.ConnectionMySQL;

import java.sql.Connection;
import java.sql.SQLException;

public class CreateTables {
    private Connection connection;

    public CreateTables() {
        this.connection = ConnectionMySQL.getConnection();
    }

    public void createTablePessoa() {
        String sql;

        sql = "CREATE TABLE IF NOT EXISTS pessoa (" +
                "id INT NOT NULL AUTO_INCREMENT," +
                "nome VARCHAR(50) NOT NULL," +
                "cpf VARCHAR(50) NOT NULL," +
                "PRIMARY KEY(id)" +
                ");";
        try {
            var stmt = connection.prepareStatement(sql);
            stmt.execute();
            System.out.println("Tabela pessoa criada com sucesso.");
        } catch (SQLException ex) {
            System.err.println("Erro ao criar a tabela pessoa.\n".concat(ex.getMessage()));
        }
    }
}
