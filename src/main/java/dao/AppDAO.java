package dao;


public class AppDAO {
    public static void main(String[] args) {
        var PessoaDAO = new PessoaDAO();

        //var cabrunco = new Pessoa("Cabrunco","123.456.789-10");
        //var lombreta = new Pessoa("Lombreta","321.654.987-01");

        //PessoaDAO.savePessoa(cabrunco);
        //PessoaDAO.savePessoa(lombreta);

        //PessoaDAO.getAll().forEach(System.out::println);

        //var pessoa = PessoaDAO.findByCPF("123.456.789-10");
        //System.out.println(pessoa);

        //var pessoa = new Pessoa(1L,"Lapiseira","666");
        //PessoaDAO.updatePessoa(pessoa);

        //PessoaDAO.deletePessoa(2L);
        PessoaDAO.getAll().forEach(System.out::println);
    }
}
