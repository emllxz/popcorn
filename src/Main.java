import java.util.Scanner;
    import static java.lang.Integer.parseInt;
    import java.util.ArrayList;
    import java.util.List;
    import java.time.LocalDate;
    import java.time.LocalTime;


    public class Main {

        private static final Scanner sc = new Scanner(System.in);
        private static final List<Filme> filmes = new ArrayList<>();
        private static int contadorFilme = 1;
        private static final List<Sala> salas = new ArrayList<>();
        private static int contadorSala = 1;
        private static final List<Sessao> sessoes = new ArrayList<>();
        private static int contadorSessao = 1;
        private static final List<Cliente> clientes = new ArrayList<>();
        private static int contadorCliente = 1;
        private static Cliente clienteLogado;

        public static void main(String[] args) {
            boolean executando = true;

            while (executando) {
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

        public static void menuADM() {
            boolean voltar = false;

            while (!voltar) {
                System.out.println("- - - - - - - - - - - - -");
                System.out.println("  Area do Administrador  ");
                System.out.println("- - - - - - - - - - - - -");
                System.out.println("1. Cadastrar filme");
                System.out.println("2. Cadastrar sala");
                System.out.println("3. Cadastrar sessão");
                System.out.println("4. Listar filmes");
                System.out.println("5. Listar salas");
                System.out.println("6. Listar sessões");
                System.out.println("7. Listar usuários");
                System.out.println("0. Voltar");
                System.out.println("Escolha uma opção: ");

                int opcao = Integer.parseInt(sc.nextLine());

                switch (opcao) {
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
                        listarSessoes();
                        break;
                    case 7:
                        listarUsuarios();
                        break;
                    case 0:
                        voltar = true;
                        System.out.println("Menu inicial: ");
                        break;
                    default:
                        System.out.println("Opção inválida!");
                        return; //RETURN??????
                }
            }
        }

        public static void menuCliente() {

            boolean voltar = false;

            while (!voltar) {

                System.out.println("- - - - - - - - - - - - -");
                System.out.println("  Conecte a sua conta:  ");
                System.out.println("- - - - - - - - - - - - -");
                System.out.println("1. Cadastrar usuário");
                System.out.println("2. Fazer login");
                System.out.println("0. Voltar");
                System.out.println("Escolha uma opção: ");

                int opcaoPrincipal = Integer.parseInt(sc.nextLine());

                switch (opcaoPrincipal) {
                    case 1:
                        cadastrarCliente();
                        break;
                    case 2:
                        if (fazerLogin()) {
                            menuLogin();
                        }
                        break;
                    case 0:
                        voltar = true;
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            }

        }

        //USUÁRIO ADMIN -- 01 CADASTRAR FILME
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

                if (resposta.equalsIgnoreCase("Não")) {
                    continuar = false;
                }
            }
            System.out.println("\nVoltando ao Menu...");
        }

        //USUÁRIO ADMIN -- 02 CADASTRAR SALA
        public static void cadastrarSalas() {
            boolean continuar = true;

            while (continuar) {

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

                if (resposta.equalsIgnoreCase("Não")) {
                    continuar = false;
                }
            }
            System.out.println("\nVoltando ao Menu...");
        }

        //USUÁRIO ADMIN -- 03 CADASTRAR SESSAO
        private static void cadastrarSessoes() {
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

                if (resposta.equalsIgnoreCase("Não")) {
                    continuar = false;
                }
            }
        }

        //USUÁRIO ADMIN -- 04 LISTA DE FILMES
        private static void listarFilmes() {
            System.out.println("\n- - - - - - - - - - - - -");
            System.out.println("     LISTA DE FILMES      ");
            System.out.println("- - - - - - - - - - - - -");

            if (filmes.isEmpty()) {
                System.out.println("Nenhum filme cadastrado.");
                return;
            }
            for (Filme filme : filmes) {
                System.out.println(filme);
                System.out.println();
            }
        }

        //USUÁRIO ADMIN -- 05 LISTA DE SALAS
        private static void listarSalas() {
            System.out.println("\n- - - - - - - - - - - - -");
            System.out.println("     LISTA DE SALAS      ");
            System.out.println("- - - - - - - - - - - - -");

            if (salas.isEmpty()) {
                System.out.println("Nenhuma sala cadastrada.");
                return;
            }
            for (Sala sala : salas) {
                System.out.println(sala);
                System.out.println();
            }
        }

        //USUÁRIO ADMIN -- 06 LISTA DA SESSÃO
        private static void listarSessoes() {
            System.out.println("\n- - - - - - - - - - - - -");
            System.out.println("     LISTA DE SESSÕES      ");
            System.out.println("- - - - - - - - - - - - -");

            if (sessoes.isEmpty()) {
                System.out.println("Nenhuma sessão cadastrada.");
                return;
            }
            for (Sessao sessao : sessoes) {
                System.out.println(sessao);
                System.out.println();
            }
        }

        //USUÁRIO ADMIN -- 07 LISTA DE USUÁRIOS
        private static void listarUsuarios() {
            System.out.println("\n- - - - - - - - - - - - -");
            System.out.println("     LISTA DE USUÁRIOS      ");
            System.out.println("- - - - - - - - - - - - -");

            if (clientes.isEmpty()) {
                System.out.println("Nenhum usuário cadastrado.");
                return;
            }
            for (Cliente cliente : clientes) {
                System.out.println(cliente);
                System.out.println();
            }

        }

        //USUÁRIO CLIENTE -- CADASTRAR USUÁRIO
        private static void cadastrarCliente() {
            boolean continuar = true;

            while (continuar) {
                System.out.println("\n- - - - - - - - - - - - -");
                System.out.println("     CADASTRAR CLIENTE      ");
                System.out.println("- - - - - - - - - - - - - ");

                System.out.println("Digite o nome completo: ");
                String nome = sc.nextLine();

                System.out.println("Digite a data de nascimento (AAAA-MM-DD: ");
                LocalDate dataNascimento = LocalDate.parse(sc.nextLine());

                System.out.println("Digite o email: ");
                String email = sc.nextLine();

                System.out.println("Digite o telefone: ");
                String telefone = sc.nextLine();

                System.out.println("Digite a senha do usuário: ");
                String senha = sc.nextLine();

                System.out.println("Usuário cadastrado com sucesso!");

                Cliente cliente = new Cliente(
                        contadorCliente++,
                        nome,
                        email,
                        senha,
                        telefone,
                        dataNascimento
                );

                clientes.add(cliente);

                System.out.println("\nDeseja cadastrar um novo usuário? Sim/Não");
                String resposta = sc.nextLine();

                if (resposta.equalsIgnoreCase("Não")) {
                    continuar = false;
                }
            }
        }

        private static boolean fazerLogin() {
            System.out.println("\n- - - - - - - - - - - - -");
            System.out.println("      FAZER LOGIN         ");
            System.out.println("- - - - - - - - - - - - - ");

            System.out.print("Digite E-mail cadastrado: ");
            String email = sc.nextLine();

            System.out.print("Digite a senha: ");
            String senha = sc.nextLine();

            for (Cliente cliente : clientes) {
                if (cliente.getEmail().equalsIgnoreCase(email)
                        && cliente.getSenha().equals(senha)) {

                    clienteLogado = cliente;

                    System.out.println("Login realizado com sucesso!");
                    System.out.println("Bem vindo(a), " + cliente.getNome());

                    return true;
                }
            }
            System.out.print("E-mail ou senha inválidos!");
            return (false);
            }
        private static void menuLogin() {
            boolean voltar = false;

            while (!voltar) {

                System.out.println("- - - - - - - - - - - - -");
                System.out.println("  Area do Cliente  ");
                System.out.println("- - - - - - - - - - - - -");
                System.out.println("1. Ver sessões");
                System.out.println("2. Comprar Ingresso");
                System.out.println("3. Meus ingressos");
                System.out.println("4. Cancelar Ingresso ");
                System.out.println("5. Meu perfil");
                System.out.println("0. Logout");
                System.out.println("Escolha uma opção: ");

                int opcaoPrincipal = Integer.parseInt(sc.nextLine());

                switch (opcaoPrincipal) {
                    case 1:
                        cadastrarCliente();
                        break;
                    case 2:
                        if (fazerLogin()) {
                            menuLogin();
                        }
                        break;
                    case 0:
                        voltar = true;
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            }

        }
    }
