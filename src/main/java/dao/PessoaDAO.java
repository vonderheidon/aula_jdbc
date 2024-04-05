package dao;

import connection.ConnectionMySQL;
import domain.Pessoa;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PessoaDAO {
    private Connection connection;

    public PessoaDAO() {
        this.connection = ConnectionMySQL.getConnection();
    }

    public void savePessoa(Pessoa pessoa) {
        String sql = "INSERT INTO pessoa (nome,cpf) VALUES(?,?)";

        try {
            var stmt = connection.prepareStatement(sql);
            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getCpf());
            stmt.execute();
            System.out.printf("O(a) %s foi adicionado(a) com sucesso.\n",pessoa.getNome());
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir a pessoa na tabela.\n".concat(ex.getMessage()));
        }
    }

    public List<Pessoa> getAll() {
        var pessoas = new ArrayList<Pessoa>();
        String sql = "SELECT * FROM pessoa;";

        try {
            var stmt = connection.prepareStatement(sql);
            var resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                var pessoa = new Pessoa(
                        resultSet.getLong("id"),
                        resultSet.getString("nome"),
                        resultSet.getString("cpf")
                );
                pessoas.add(pessoa);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return pessoas;
    }

    public Pessoa findByCPF(String cpf) {
        String sql = "SELECT * FROM pessoa WHERE cpf = ?";
        var pessoa = new Pessoa();

        try {
            var stmt = connection.prepareStatement(sql);
            stmt.setString(1,cpf);
            var resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                pessoa.setCpf(resultSet.getString("cpf"));
                pessoa.setId(resultSet.getLong("id"));
                pessoa.setNome(resultSet.getString("nome"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return pessoa;
    }

    public void updatePessoa(Pessoa pessoa) {
        String sql = "UPDATE pessoa SET nome = ?, cpf = ? WHERE id = ?;";

        try {
            var stmt = connection.prepareStatement(sql);
            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getCpf());
            stmt.setString(3, String.valueOf(pessoa.getId()));
            stmt.execute();
            System.out.println("Usuário atualizado com sucesso.");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deletePessoa(Long id) {
        var sql = "DELETE FROM pessoa WHERE id = ?";

        try {
            var stmt = connection.prepareStatement(sql);
            stmt.setLong(1, id);
            stmt.execute();
            System.out.println("Usuário removido com sucesso.");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
}
