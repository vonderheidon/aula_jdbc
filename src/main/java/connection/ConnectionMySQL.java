package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMySQL {
    //url
    private static final String URL = "jdbc:mysql://localhost:3306/nome do seu banco";
    //user
    private static final String USER = "usuário do MySQL (o padrão é root)";
    //password
    private static final String PASSWORD = "senha do seu usuário";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexão realizada com sucesso.");
        } catch (SQLException ex) {
            System.err.println("Erro ao conectar ao banco de dados.\n".concat(ex.getMessage()));
        }
        return connection;
    }
}
