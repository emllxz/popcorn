    import java.awt.*;
    import java.util.Scanner;
    import static java.lang.Integer.parseInt;
    import java.util.ArrayList;
    import java.util.List;
    import java.time.LocalDate;
    import java.time.LocalTime;


    public class Main{

        private static final Scanner sc = new Scanner(System.in);
        private static final List<Filme> filmes = new ArrayList<>();
        private static int contadorFilme = 1;
        private static final List<Sala> salas = new ArrayList<>();
        private static int contadorSala = 1;
        private static final List<Sessao> sessoes = new ArrayList<>();
        private static int contadorSessao = 1;

        public static void main (String[] args){
            boolean executando = true;

            while(executando) {
                System.out.println("- - - - - - - - - - - - -");
                System.out.println("   Sessão Cinema   ");
                System.out.println("- - - - - - - - - - - - -");
                System.out.println("1. Area de ADM");
                System.out.println("2. Area de Cliente");
                System.out.println("0. Sair");
                System.out.println("Escolha uma opção: ");

                int opcao = parseInt(sc.nextLine());

                switch (opcao) {
                    case 1:
                        menuADM();
                        break;
                    case 2:
                        menuCliente();
                        break;
                    case 0:
                        executando = false;
                        System.out.println("Encerrando o Sistema...");
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            }
        }

        public static void menuADM(){
            boolean voltar = false;

            while(!voltar){
                System.out.println("- - - - - - - - - - - - -");
                System.out.println("  Area do Administrador  ");
                System.out.println("- - - - - - - - - - - - -");
                System.out.println("1. Cadastrar filme");
                System.out.println("2. Cadastrar sala");
                System.out.println("3. Cadastrar sessão");
                System.out.println("4. Listar filmes");
                System.out.println("5. Listar salas");
                System.out.println("6. Listar sessões");
                System.out.println("0. Voltar");
                System.out.println("Escolha uma opção: ");

                int opcao = Integer.parseInt(sc.nextLine());

                switch(opcao){
                    case 1:
                        cadastrarFilmes();
                        break;
                    case 2:
                        cadastrarSalas();
                        break;
                    case 3:
                        cadastrarSessoes();
                        break;
                    case 4:
                        listarFilmes();
                        break;
                    case 5:
                        listarSalas();
                        break;
                    case 6:
                        listarSessao();
                        break;
                    case 0:
                        voltar = true;
                        System.out.println("Menu inicial: ");
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            }
        }

        public static void menuCliente() {

            boolean voltar = false;

            while (!voltar) {

                System.out.println("- - - - - - - - - - - - -");
                System.out.println("  Area do Administrador  ");
                System.out.println("- - - - - - - - - - - - -");
                System.out.println("1. Cadastrar usuário");
                System.out.println("2. Fazer login");
                System.out.println("3. Consultar sessões");
                System.out.println("4. Comprar ingressos");
                System.out.println("5. Cancelar ingressos");
                System.out.println("0. Voltar");
                System.out.println("Escolha uma opção: ");

                int opcao = Integer.parseInt(sc.nextLine());

                switch (opcao) {
                    case 0:
                        voltar = true;
                        break;
                }
            }

        }
        //USUÁRIO ADMIN -- CADASTRO DE FILME
        public static void cadastrarFilmes() {
            boolean continuar = true;

            while (continuar) {

                System.out.println("\n- - - - - - - - - - - - -");
                System.out.println("     CADASTRAR FILME      ");
                System.out.println("- - - - - - - - - - - - -");

                System.out.print("Título: ");
                String titulo = sc.nextLine();

                System.out.print("Descrição: ");
                String descricao = sc.nextLine();

                System.out.print("Duração: ");
                String duracao = sc.nextLine();

                System.out.print("Classificação Indicativa: ");
                int classificacaoIndicativa = Integer.parseInt(sc.nextLine());

                System.out.print("Gênero: ");
                String genero = (sc.nextLine());

                System.out.print("Data de lançamento (AAAA-MM-DD): ");
                LocalDate dataLancamento = LocalDate.parse(sc.nextLine());

                boolean disponivel = true;

                Filme filme = new Filme(
                        contadorFilme++,
                        titulo,
                        descricao,
                        duracao,
                        classificacaoIndicativa,
                        genero,
                        dataLancamento,
                        disponivel
                );

                filmes.add(filme);

                System.out.println("\nFilme cadastrado com sucesso!");

                System.out.println("\nDeseja cadastrar um novo filme? Sim/Não: ");
                String resposta = sc.nextLine();

                if(resposta.equalsIgnoreCase("Não")) {
                    continuar = false;
                }
            }
            System.out.println("\nVoltando ao Menu...");
        }

        //USUÁRIO ADMIN -- CADASTRO DE SALA
        public static void cadastrarSalas() {
            boolean continuar = true;

            while (continuar){

                System.out.println("\n- - - - - - - - - - - - -");
                System.out.println("     CADASTRAR SALA      ");
                System.out.println("- - - - - - - - - - - - -");

                System.out.print("Número da sala: ");
                int numeroSala = Integer.parseInt(sc.nextLine());

                System.out.print("Capacidade: ");
                int capacidade = Integer.parseInt(sc.nextLine());

                Sala sala = new Sala(
                        contadorSala++,
                        numeroSala,
                        capacidade
                );

                salas.add(sala);

                System.out.println("\nSala cadastrado com sucesso!");

                System.out.println("\nDeseja cadastrar uma nova sala? Sim/Não: ");
                String resposta = sc.nextLine();

                if(resposta.equalsIgnoreCase("Não")) {
                    continuar = false;
                }
            }
            System.out.println("\nVoltando ao Menu...");
        }

        //USUÁRIO ADMIN -- CADASTRAR SESSAO
        private static void cadastrarSessoes(){
            boolean continuar = true;

            while (continuar) {
                System.out.println("\n- - - - - - - - - - - - -");
                System.out.println("     CADASTRAR SESSÃO      ");
                System.out.println("- - - - - - - - - - - - - ");

                System.out.print("Data de Exibição (AAAA-MM-DD): ");
                LocalDate data = LocalDate.parse(sc.nextLine());

                System.out.print("Horário de Exibição (HH:MM): ");
                LocalTime horario = LocalTime.parse(sc.nextLine());

                System.out.println("Idiomas disponíveis: ");
                String idioma = sc.nextLine();

                System.out.println("Segue lista de filmes disponíveis: ");
                listarFilmes();
                System.out.println("Digite a ID do Filme desejado: ");
                int idFilme = Integer.parseInt(sc.nextLine());

                Filme filmeSelecionado = null;

                for (Filme filme : filmes) {
                    if (filme.getIdFilme() == idFilme) {
                        filmeSelecionado = filme;
                        break;
                    }
                }
                if (filmeSelecionado == null) {
                    System.out.println("Filme não encontrado!");
                    return;
                }


                System.out.println("Segue lista de salas disponíveis: ");
                listarSalas();
                System.out.println("Digite a ID da Sala desejada: ");
                int idSala = Integer.parseInt(sc.nextLine());

                Sala salaSelecionada = null;

                for (Sala sala : salas) {
                    if (sala.getIdSala() == idSala) {
                        salaSelecionada = sala;
                        break;
                    }
                }
                if (salaSelecionada == null) {
                    System.out.println("Sala não encontrada!");
                    return;
                }

                Sessao sessao = new Sessao(
                        contadorSessao++,
                        data,
                        horario,
                        idioma,
                        filmeSelecionado,
                        salaSelecionada
                );

                sessoes.add(sessao);

                System.out.println("\nSessão cadastrada com sucesso!");
                System.out.println("\nDeseja cadastrar uma nova Sessão? Sim/Não");
                String resposta = sc.nextLine();

                if (resposta.equalsIgnoreCase("Não")){
                    continuar = false;
                }
            }
        }

        //USUÁRIO ADMIN -- LISTA DE FILME
        private static void listarFilmes() {
            System.out.println("\n- - - - - - - - - - - - -");
            System.out.println("     LISTA DE FILMES      ");
            System.out.println("- - - - - - - - - - - - -");

            if(filmes.isEmpty()) {
                System.out.println("Nenhum filme cadastrado.");
                return;
            }
            for (Filme filme : filmes) {
                System.out.println(filme);
                System.out.println();
            }
        }

        //USUÁRIO ADMIN -- LISTA DE SALA
        private static void listarSalas() {
            System.out.println("\n- - - - - - - - - - - - -");
            System.out.println("     LISTA DE SALAS      ");
            System.out.println("- - - - - - - - - - - - -");

            if(salas.isEmpty()) {
                System.out.println("Nenhuma sala cadastrada.");
                return;
            }
            for (Sala sala : salas){
                System.out.println(salas);
                System.out.println();
            }
        }
        //USUÁRIO ADMIN -- LISTA DA SESSÃO
        private static void listarSessao() {
            System.out.println("\n- - - - - - - - - - - - -");
            System.out.println("     LISTA DE SESSÕES      ");
            System.out.println("- - - - - - - - - - - - -");

            if(sessoes.isEmpty()) {
                System.out.println("Nenhuma sessão cadastrada.");
                return;
            }
            for(Sessao sessao : sessoes){
                System.out.println(sessoes);
                System.out.println();
            }
        }
    }
