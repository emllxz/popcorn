import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Filme> filmes = new ArrayList<>();
        ArrayList<Sessao> sessoes = new ArrayList<>();

        System.out.println("\n-----Cadastro de Cliente -----\n");
        System.out.println("Digite o nome: ");
        String nome = sc.nextLine();

        System.out.println("Digite o email: ");
        String email = sc.nextLine();

        System.out.println("Digite a senha: ");
        String senha = sc.nextLine();

        System.out.println("Digite o telefone:");
        String telefone = sc.nextLine();

        System.out.println("Digite a data de nascimento (yyyy-MM-dd):");
        String dataTexto = sc.nextLine();
        LocalDate dataNaciemento = LocalDate.parse(dataTexto);

        Cliente cliente = new Cliente(
                1,
                nome,
                email,
                senha,
                telefone,
                dataNaciemento
        );

        clientes.add(cliente);

        System.out.println("\nClientes cadastrados:");
        for (Cliente c : clientes) {
            System.out.println(c);
        }

        System.out.println("\n========================");

        System.out.println("\n-----Cadastro de Filme -----\n");
        System.out.println("Digite o título: ");
        String titulo = sc.nextLine();

        System.out.println("Digite a descrição: ");
        String descricao = sc.nextLine();

        System.out.println("Digite a duração: ");
        String duracao = sc.nextLine();

        System.out.println("Digite a Classificação Indicativa:");
        int classificacaoIndicativa = sc.nextInt();
        sc.nextLine();

        System.out.println("Digite o gênero:");
        String genero = sc.nextLine();

        System.out.println("Digite a data de lançamento (yyyy-MM-dd):");
        String dataTexto1 = sc.nextLine();
        LocalDate dataLancamento = LocalDate.parse(dataTexto1);

        boolean disponivel = true;

        Filme filme = new Filme(
                1,
                titulo,
                descricao,
                duracao,
                classificacaoIndicativa,
                genero,
                dataLancamento,
                disponivel);

        filmes.add(filme);

        System.out.println("\nFilmes cadastrados:");
        for (Filme f : filmes) {
            System.out.println(f);
        }

        sc.close();
    }
}