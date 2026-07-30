import java.util.Scanner;

public class Main {
    private static SistemaAlunos sa = new SistemaAlunos();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean executando = true;

        while (executando) {
            System.out.println("\n--- SISTEMA DE ALUNOS ---");
            System.out.println("1. Cadastrar aluno");
            System.out.println("2. Deletar aluno");
            System.out.println("3. Ver informações do aluno");
            System.out.println("4. Alterar Email");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            int entrada = sc.nextInt();
            sc.nextLine();

            switch (entrada) {
                case 1: {
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    System.out.print("Data de nascimento (dd/MM/yyyy): ");
                    String data = sc.nextLine();

                    cadastraAluno(nome, email, data);
                    break;
                }

                case 2: {
                    System.out.print("Matrícula: ");
                    String matricula = sc.nextLine();

                    deletaAluno(matricula);
                    break;
                }

                case 3: {
                    System.out.print("Matrícula: ");
                    String matricula = sc.nextLine();

                    infoAluno(matricula);
                    break;
                }

                case 4: {
                    System.out.print("Digite a matricula: ");
                    String matricula = sc.nextLine();
                    System.out.println("Digite o novo email: ");
                    String novoEmail = sc.nextLine();

                    alteraDadosEmail(matricula, novoEmail);
                    break;
                }

                case 0: {
                    System.out.println("Sistema encerrado.");
                    executando = false;
                    break;
                }
                
                default:
                    System.out.println("Opção inválida.");
            }
        }

        sc.close();
    }

    public static void cadastraAluno(String nome, String email, String data) {
        System.out.println(sa.cadastraAlunos(nome, email, data));
    }


    public static void deletaAluno(String matricula) {
        int retorno = sa.deletaAluno(matricula);
        
        if(retorno == 1){
            System.out.println("Aluno deletado com sucesso!!");
        }
        else{
            System.out.println("Não foi possivel deletar o aluno");
        }
        
    }
    public static void alteraDadosEmail(String matricula, String novoEmail){
        System.out.println(sa.alteraEmail(matricula, novoEmail));
    }

    public static void infoAluno(String matricula) {
        System.out.println(sa.infoAluno(matricula));
    }
}