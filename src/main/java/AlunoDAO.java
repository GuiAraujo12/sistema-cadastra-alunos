import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class AlunoDAO {

    public String cadastrar(Aluno aluno) {
        String sql = """
                INSERT INTO alunos (nome, email, data_nascimento)
                VALUES (?, ?, ?)
                RETURNING matricula;
                """;

        try (Connection conexao = Conexao.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setString(1, aluno.getNome());
            comando.setString(2, aluno.getEmail());
            comando.setObject(3, aluno.getDataNascimento());

            ResultSet resultado = comando.executeQuery();

            if (resultado.next()) {
                return resultado.getString("matricula");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar aluno: " + e.getMessage());
        }
        return null;
    }

    public boolean alterar(String matricula, String novoEmail) {
        String sql = """
                UPDATE alunos
                SET email = ?
                WHERE matricula = ?;
                """;

        try (Connection conexao = Conexao.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setString(1, novoEmail);
            comando.setString(2, matricula);

            int linhasAfetadas = comando.executeUpdate();
            return linhasAfetadas > 0;
            
        } catch (SQLException e) {
            System.out.println("Erro ao alterar email: " + e.getMessage());
            return false;
        }
    }

    public boolean deletar(String matricula) {
        String sql = """
                DELETE FROM alunos
                WHERE matricula = ?
                """;

        try (Connection conexao = Conexao.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setString(1, matricula);

            int linhasAfetadas = comando.executeUpdate();
            return linhasAfetadas > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao deletar aluno: " + e.getMessage());
            return false;
        }
    }

    public Aluno buscar(String matricula) {
        String sql = """
                SELECT nome, email, data_nascimento
                FROM alunos
                WHERE matricula = ?
                """;

        try (Connection conexao = Conexao.conectar();
            PreparedStatement comando = conexao.prepareStatement(sql)) {

            comando.setString(1, matricula);
            
            ResultSet resultado = comando.executeQuery();

            if (resultado.next()) {
            String nome = resultado.getString("nome");
            String email = resultado.getString("email");

            LocalDate dataNascimento = resultado.getObject("data_nascimento", LocalDate.class);

            return new Aluno(nome, dataNascimento, email);
        }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar aluno: " + e.getMessage());
        }
        return null;
    }
}
