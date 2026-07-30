import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SistemaAlunos {
    private AlunoDAO alunoDAO = new AlunoDAO();
    private int posicao;

    public String cadastraAlunos(String nome, String email, String data){
        LocalDate idade = retornaData(data);
        
        Aluno a1 = new Aluno(nome, idade, email);
        
        String mat = alunoDAO.cadastrar(a1);
        if(mat != null){
            return "ALUNO " + nome + " CADASTRADO!!\nMATRICULA: " + mat;
        }
        posicao --;
        return "ERRO AO CADASTRAR ALUNO";
    }

    public String alteraEmail(String matricula, String novoEmail){
        if(alunoDAO.alterar(matricula, novoEmail)){
            return "Email alterado para " + novoEmail;
        }
        return "ERRO AO ALTERAR EMAIL!!";
    }

    private LocalDate retornaData(String nascimento){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate data = LocalDate.parse(nascimento, formato);
        return data;
    }

    public String infoAluno(String matricula){
        Aluno a = alunoDAO.buscar(matricula);
        if(a != null){
            return a.toString();
        }
        else{
            return "Não foi possivel encontrar esse aluno!!";
        }
    }

    public int deletaAluno(String matricula){
        if(alunoDAO.deletar(matricula)){
            return 1;
        }
        return 0;
    }
}
