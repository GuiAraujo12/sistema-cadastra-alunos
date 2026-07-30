import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Aluno {
    private String nome;
    private String matricula;
    private int idade;
    private String email;
    private LocalDate dataNascimento;
    
    public Aluno(String nome, LocalDate dataNascimento, String email){
        this.nome = nome;
        this.idade = calculaIdade(dataNascimento);
        this.dataNascimento = dataNascimento;
        this.email = email;
    }

    private int calculaIdade(LocalDate dataNascimento){
        int idade = Period.between(dataNascimento, LocalDate.now()).getYears();
        return idade;
    }

    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return """
            
            --- INFORMAÇÕES DO ALUNO ---
            Matrícula: %s
            Nome: %s
            E-mail: %s
            Data de nascimento: %s
            ---------------------------
            """.formatted(
                    matricula,
                    nome,
                    email,
                    dataNascimento.format(formato)
            );
}

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Aluno other = (Aluno) obj;
        if (matricula == null) {
            if (other.matricula != null)
                return false;
        } else if (!matricula.equals(other.matricula))
            return false;
        return true;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

}