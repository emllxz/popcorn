import java.time.Period;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final List<Filme> filmes = new ArrayList<>();
    private static final List<Sala> salas = new ArrayList<>();
    private static final List<Sessao> sessoes = new ArrayList<>();
    private static final List<Cliente> clientes = new ArrayList<>();
    private static final List<Ingresso> ingressosGerados = new ArrayList<>();

    private static int contadorFilme = 1;
    private static int contadorSala = 1;
    private static int contadorSessao = 1;
    private static int contadorCliente = 1;
    private static int contadorIngresso = 1;

    private static Cliente clienteLogado;
    private static String senhaAdmin = "Admin@!2026";

    public static int lerInput() {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("\nDigite apenas números:");
            }
        }
    }

    public static LocalDate lerData() {
        while (true) {
            try {
                return LocalDate.parse(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Data inválida! Use AAAA-MM-DD");
            }
        }
    }

    public static LocalTime lerHora() {
        while (true) {
            try {
                return LocalTime.parse(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Hora inválida! Use HH:MM");
            }
        }
    }

    public static void main(String[] args) {
        boolean executando = true;
        while (executando) {
            System.out.println("\n- - - - - - - - - - - - -");
            System.out.println("         Sessão Cinema   ");
            System.out.println("- - - - - - - - - - - - -");
            System.out.println("1. Area de ADM");
            System.out.println("2. Area de Cliente");
            System.out.println("0. Sair");
            System.out.println("\nEscolha uma opção: ");
            int opcao = lerInput();
            boolean voltar = false;

            switch (opcao) {
                case 1:
                    while (!voltar) {
                        System.out.println("\nDigite a senha de Administrador: ");
                        String senha = sc.nextLine();
                        if (senha.equals(senhaAdmin)) {
                            menuADM();
                            voltar = true;
                        } else {
                            System.out.println("\nSenha incorreta!");
                            System.out.println("\n1. Tentar novamente");
                            System.out.println("2. Voltar ao menu principal");
                            System.out.println("\nEscolha uma opção: ");
                            int opcaoErro = lerInput();
                            switch (opcaoErro) {
                                case 1:
                                    break;
                                case 2:
                                    voltar = true;
                                    break;
                                default:
                                    System.out.println("Opção inválida!");
                                    voltar = false;
                            }
                        }
                    }
                    break;
                case 2:
                    menuCliente();
                    break;
                case 0:
                    executando = false;
                    System.out.println("\nEncerrando o Sistema...");
                    break;
                default:
                    System.out.println("\nOpção inválida!");
                    break;
            }
        }
    }

    public static void menuADM() {
        boolean voltar = false;
        while (!voltar) {
            System.out.println("\n- - - - - - - - - - - - -");
            System.out.println("  Area do Administrador  ");
            System.out.println("- - - - - - - - - - - - -");
            System.out.println("1. Filmes");
            System.out.println("2. Salas");
            System.out.println("3. Sessões");
            System.out.println("4. Usuários");
            System.out.println("5. Relatórios");
            System.out.println("0. Voltar");
            System.out.println("\nEscolha uma opção: ");
            int opcao = lerInput();
            switch (opcao) {
                case 1: menuFilmes(); break;
                case 2: menuSalas(); break;
                case 3: menuSessoes(); break;
                case 4: menuUsuarios(); break;
                case 5: menuRelatorios(); break;
                case 0:
                    voltar = true;
                    System.out.println("\nRetornando ao Menu inicial... ");
                    break;
                default:
                    System.out.println("\nOpção inválida!");
                    break;
            }
        }
    }

    public static void menuFilmes() {
        boolean continuar = true;
        while (continuar) {
            System.out.println("\n- - - - - - - - - - - - -");
            System.out.println("       Menu Filmes       ");
            System.out.println("- - - - - - - - - - - - -");
            System.out.println("1. Cadastrar filme");
            System.out.println("2. Listar filmes");
            System.out.println("3. Inativar filme");
            System.out.println("0. Voltar");
            System.out.println("\nEscolha uma opção: ");
            int opcaoMenuFilme = lerInput();
            switch (opcaoMenuFilme) {
                case 1: cadastrarFilmes(); break;
                case 2: listarFilmes(); break;
                case 3: inativarFilme(); break;
                case 0:
                    continuar = false;
                    System.out.println("\nRetornando... ");
                    break;
                default:
                    System.out.println("\nOpção inválida!");
                    break;
            }
        }
    }

    public static void menuSalas() {
        boolean continuar = true;
        while (continuar) {
            System.out.println("\n- - - - - - - - - - - - -");
            System.out.println("        Menu Salas       ");
            System.out.println("- - - - - - - - - - - - -");
            System.out.println("1. Cadastrar salas");
            System.out.println("2. Listar salas");
            System.out.println("3. Remover sala");
            System.out.println("0. Voltar");
            System.out.println("\nEscolha uma opção: ");
            int opcaoMenuSalas = lerInput();
            switch (opcaoMenuSalas) {
                case 1: cadastrarSalas(); break;
                case 2: listarSalas(); break;
                case 3: removerSala(); break;
                case 0:
                    continuar = false;
                    System.out.println("\nRetornando... ");
                    break;
                default:
                    System.out.println("\nOpção inválida!");
                    break;
            }
        }
    }

    public static void menuSessoes() {
        boolean continuar = true;
        while (continuar) {
            System.out.println("\n- - - - - - - - - - - - -");
            System.out.println("       Menu Sessões       ");
            System.out.println("- - - - - - - - - - - - -");
            System.out.println("1. Cadastrar sessão");
            System.out.println("2. Listar sessões");
            System.out.println("3. Remover sessões");
            System.out.println("0. Voltar");
            System.out.println("\nEscolha uma opção: ");
            int opcaoMenuSessoes = lerInput();
            switch (opcaoMenuSessoes) {
                case 1: cadastrarSessoes(); break;
                case 2: listarSessoes(); break;
                case 3: removerSessao(); break;
                case 0:
                    continuar = false;
                    System.out.println("\n Retornando...");
                    break;
                default:
                    System.out.println("\nOpção inválida!");
                    break;
            }
        }
    }

    public static void menuUsuarios() {
        boolean continuar = true;
        while (continuar) {
            System.out.println("\n- - - - - - - - - - - - -");
            System.out.println("       Menu Usuários       ");
            System.out.println("- - - - - - - - - - - - -");
            System.out.println("1. Cadastrar usuários");
            System.out.println("2. Listar usuários");
            System.out.println("0. Voltar");
            System.out.println("\nEscolha uma opção: ");
            int opcaoMenuUsuarios = lerInput();
            switch (opcaoMenuUsuarios) {
                case 1: cadastrarCliente(); break;
                case 2: listarUsuarios(); break;
                case 0:
                    continuar = false;
                    System.out.println("\n Retornando...");
                    break;
                default:
                    System.out.println("\nOpção inválida!");
                    break;
            }
        }
    }

    public static void menuCliente() {
        boolean voltar = false;
        while (!voltar) {
            System.out.println("\n- - - - - - - - - - - - -");
            System.out.println("  Conecte a sua conta:  ");
            System.out.println("- - - - - - - - - - - - -");
            System.out.println("1. Cadastrar usuário");
            System.out.println("2. Fazer login");
            System.out.println("0. Voltar");
            System.out.println("\nEscolha uma opção: ");
            int opcaoPrincipal = lerInput();
            switch (opcaoPrincipal) {
                case 1: cadastrarCliente(); break;
                case 2: if (fazerLogin()) { menuLogin(); } break;
                case 0: voltar = true; break;
                default: System.out.println("Opção inválida!"); break;
            }
        }
    }

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
            int classificacaoIndicativa = lerInput();
            System.out.print("Gênero: ");
            String genero = sc.nextLine();
            System.out.print("Data de lançamento (AAAA-MM-DD): ");
            LocalDate dataLancamento = lerData();
            boolean disponivel = true;

            Filme filme = new Filme(contadorFilme++, titulo, descricao, duracao,
                    classificacaoIndicativa, genero, dataLancamento, disponivel);
            filmes.add(filme);
            System.out.println("\nFilme cadastrado com sucesso!");
            System.out.println("\nDeseja cadastrar um novo filme?");
            System.out.println("1. Sim");
            System.out.println("2. Não");
            System.out.println("\nEscolha uma opção: ");
            int opcaoCadastrarNovoFilme = lerInput();
            if (opcaoCadastrarNovoFilme != 1) { continuar = false; }
        }
        System.out.println("\nVoltando ao Menu...");
    }

    public static void cadastrarSalas() {
        boolean continuar = true;
        while (continuar) {
            System.out.println("\n- - - - - - - - - - - - -");
            System.out.println("     CADASTRAR SALA      ");
            System.out.println("- - - - - - - - - - - - -");
            System.out.print("Número da sala: ");
            int numeroSala = lerInput();
            System.out.println("Tipo de Sala:");
            System.out.println("1 - Pequena");
            System.out.println("2 - Média");
            System.out.println("3 - Grande");
            int opcaoTipoSala = lerInput();
            Sala.TipoSala tipoSala;
            switch (opcaoTipoSala) {
                case 1: tipoSala = Sala.TipoSala.PEQUENA; break;
                case 2: tipoSala = Sala.TipoSala.MEDIA; break;
                case 3: tipoSala = Sala.TipoSala.GRANDE; break;
                default: System.out.println("Tipo inválido!"); continue;
            }
            Sala sala = new Sala(contadorSala++, numeroSala, tipoSala);
            salas.add(sala);
            System.out.println("\nSala cadastrada com sucesso!");
            System.out.println("\nDeseja cadastrar uma nova sala?");
            System.out.println("1. Sim");
            System.out.println("2. Não");
            int opcaoNovaSala = lerInput();
            if (opcaoNovaSala != 1) { continuar = false; }
        }
    }

    private static void cadastrarSessoes() {
        boolean continuar = true;
        while (continuar) {
            System.out.println("\n- - - - - - - - - - - - -");
            System.out.println("     CADASTRAR SESSÃO      ");
            System.out.println("- - - - - - - - - - - - -");
            System.out.print("Data de Exibição (AAAA-MM-DD): ");
            LocalDate data = lerData();
            System.out.print("Horário de Exibição (HH:MM): ");
            LocalTime horario = lerHora();
            System.out.println("Idiomas disponíveis: ");
            String idioma = sc.nextLine();
            System.out.println("O filme está em estreia?");
            System.out.println("1. Sim");
            System.out.println("2. Não");
            int opcaoEstreia = lerInput();
            boolean estreia = (opcaoEstreia == 1);

            if (filmes.isEmpty()) {
                System.out.println("Nenhum filme cadastrado. Favor, cadastre ao menos um filme.");
                return;
            }
            boolean existeFilmeDisponivel = false;
            for (Filme f : filmes) { if (f.getDisponivel()) { existeFilmeDisponivel = true; break; } }
            if (!existeFilmeDisponivel) {
                System.out.println("Não existem filmes disponíveis.");
                return;
            }

            System.out.println("\nFilmes disponíveis: ");
            for (Filme f : filmes) { if (f.getDisponivel()) System.out.println(f); }

            System.out.println("\nDigite a ID do Filme desejado: ");
            int idFilme = lerInput();
            Filme filmeSelecionado = null;
            for (Filme f : filmes) { if (f.getIdFilme() == idFilme && f.getDisponivel()) { filmeSelecionado = f; break; } }
            if (filmeSelecionado == null) { System.out.println("Filme não encontrado."); continue; }

            if (salas.isEmpty()) { System.out.println("Nenhuma sala cadastrada."); return; }
            listarSalas();
            System.out.println("\nDigite a ID da Sala desejada: ");
            int idSala = lerInput();
            Sala salaSelecionada = null;
            for (Sala s : salas) { if (s.getIdSala() == idSala) { salaSelecionada = s; break; } }
            if (salaSelecionada == null) { System.out.println("Sala não encontrada."); continue; }

            Sessao sessao = new Sessao(contadorSessao++, data, horario, idioma, estreia, filmeSelecionado, salaSelecionada);
            sessoes.add(sessao);
            System.out.println("\nSessão cadastrada com sucesso!");
            System.out.println("\nDeseja cadastrar uma nova Sessão? (1.Sim / 2.Não)");
            if (lerInput() != 1) { continuar = false; }
        }
    }

    private static void listarFilmes() {
        if (filmes.isEmpty()) { System.out.println("\nNenhum filme cadastrado."); return; }
        for (Filme f : filmes) System.out.println(f);
    }

    private static void listarSalas() {
        if (salas.isEmpty()) { System.out.println("\nNenhuma sala cadastrada."); return; }
        for (Sala s : salas) System.out.println(s);
    }

    private static void listarSessoes() {
        if (sessoes.isEmpty()) { System.out.println("\nNenhuma sessão cadastrada."); return; }
        for (Sessao s : sessoes) System.out.println(s);
    }

    private static void listarUsuarios() {
        if (clientes.isEmpty()) { System.out.println("\nNenhum usuário cadastrado."); return; }
        for (Cliente c : clientes) System.out.println(c);
    }

    private static void removerSessao() {
        if (sessoes.isEmpty()) { System.out.println("Nenhuma sessão cadastrada."); return; }
        listarSessoes();
        System.out.println("Digite o ID da sessão: ");
        int id = lerInput();
        for (int i = 0; i < sessoes.size(); i++) {
            if (sessoes.get(i).getIdSessao() == id) {
                sessoes.remove(i);
                System.out.println("Sessão removida com sucesso!");
                return;
            }
        }
        System.out.println("Sessão não encontrada.");
    }

    private static void removerSala() {
        if (salas.isEmpty()) { System.out.println("Nenhuma sala cadastrada."); return; }
        listarSalas();
        System.out.println("\nDigite o ID da sala: ");
        int id = lerInput();
        for (Sessao s : sessoes) {
            if (s.getSala().getIdSala() == id) {
                System.out.println("\nNão é possível remover. Existem sessões vinculadas.");
                return;
            }
        }
        for (int i = 0; i < salas.size(); i++) {
            if (salas.get(i).getIdSala() == id) {
                salas.remove(i);
                System.out.println("\nSala removida com sucesso!");
                return;
            }
        }
        System.out.println("\nSala não encontrada.");
    }

    private static void inativarFilme() {
        if (filmes.isEmpty()) { System.out.println("Nenhum filme cadastrado."); return; }
        listarFilmes();
        System.out.println("Digite o ID do filme: ");
        int id = lerInput();
        for (Filme f : filmes) {
            if (f.getIdFilme() == id) {
                if (!f.getDisponivel()) { System.out.println("O filme já está inativo"); return; }
                f.setDisponivel(false);
                int sessoesRemovidas = 0;
                for (int i = sessoes.size() - 1; i >= 0; i--) {
                    if (sessoes.get(i).getFilme().getIdFilme() == id) {
                        sessoes.remove(i);
                        sessoesRemovidas++;
                    }
                }
                System.out.println("Filme inativado com sucesso!");
                System.out.println(sessoesRemovidas + " sessão(ões) removida(s).");
                return;
            }
        }
        System.out.println("Filme não encontrado.");
    }

    private static void menuRelatorios() {
        boolean voltar = true;
        while (voltar) {
            System.out.println("\n- - - - - - - - - - - - - ");
            System.out.println("      RELATÓRIOS         ");
            System.out.println("- - - - - - - - - - - - - ");
            System.out.println("1. Filmes ativos");
            System.out.println("2. Filmes inativados");
            System.out.println("3. Quantidade de Sessões por Filme");
            System.out.println("4. Relatório Geral");
            System.out.println("0. Voltar");
            int opcaoRelatorio = lerInput();
            switch (opcaoRelatorio) {
                case 1: relatorioFilmesAtivos(); break;
                case 2: relatorioFilmesInativos(); break;
                case 3: relatorioSessoesPorFilme(); break;
                case 4: relatorioGeral(); break;
                case 0: voltar = false; break;
                default: System.out.println("Opção inválida!");
            }
        }
    }

    private static void relatorioFilmesAtivos() {
        int count = 0;
        for (Filme f : filmes) { if (f.getDisponivel()) { System.out.println(f); count++; } }
        System.out.println("Total de ativos: " + count);
    }

    private static void relatorioFilmesInativos() {
        int count = 0;
        for (Filme f : filmes) { if (!f.getDisponivel()) { System.out.println(f); count++; } }
        System.out.println("Total de inativos: " + count);
    }

    private static void relatorioSessoesPorFilme() {
        for (Filme f : filmes) {
            int count = 0;
            for (Sessao s : sessoes) { if (s.getFilme().getIdFilme() == f.getIdFilme()) count++; }
            System.out.println("Filme: " + f.getTitulo() + " | Sessões: " + count);
        }
    }

    private static void relatorioGeral() {
        System.out.println("Filmes: " + filmes.size());
        System.out.println("Salas: " + salas.size());
        System.out.println("Sessões: " + sessoes.size());
        System.out.println("Clientes: " + clientes.size());
    }

    private static void cadastrarCliente() {
        System.out.println("Digite o nome completo: ");
        String nome = sc.nextLine();
        System.out.println("Digite a data de nascimento (AAAA-MM-DD): ");
        LocalDate data = lerData();
        System.out.println("Digite o email: ");
        String email = sc.nextLine();
        for (Cliente c : clientes) {
            if (c.getEmail().equalsIgnoreCase(email)) { System.out.println("E-mail já cadastrado!"); return; }
        }
        System.out.println("Digite o telefone: ");
        String tel = sc.nextLine();
        System.out.println("Digite a senha: ");
        String senha = sc.nextLine();

        clientes.add(new Cliente(contadorCliente++, nome, email, senha, tel, data));
        System.out.println("Usuário cadastrado com sucesso!");
    }

    private static boolean fazerLogin() {
        System.out.print("Digite E-mail: ");
        String email = sc.nextLine();
        System.out.print("Digite a senha: ");
        String senha = sc.nextLine();
        for (Cliente c : clientes) {
            if (c.getEmail().equalsIgnoreCase(email) && c.getSenha().equals(senha)) {
                clienteLogado = c;
                System.out.println("\nBem vindo(a), " + c.getNome());
                return true;
            }
        }
        System.out.println("\nE-mail ou senha inválidos!");
        return false;
    }

    private static void menuLogin() {
        boolean voltar = false;
        while (!voltar) {
            System.out.println("\n- - - - - - - - - - - - -");
            System.out.println("  Area do Cliente  ");
            System.out.println("- - - - - - - - - - - - -");
            System.out.println("1. Comprar Ingresso");
            System.out.println("2. Meus ingressos");
            System.out.println("3. Cancelar Ingresso");
            System.out.println("4. Meu perfil");
            System.out.println("0. Logout");
            System.out.println("\nEscolha uma opção: ");
            int opcao = lerInput();
            switch (opcao) {
                case 1: comprarIngresso(); break;
                case 2: meusIngressos(); break;
                case 3: cancelarIngresso(); break;
                case 4: meuPerfil(); break;
                case 0: voltar = true; break;
                default: System.out.println("Opção inválida!");
            }
        }
    }

    private static void comprarIngresso() {
        if (sessoes.isEmpty()) { System.out.println("Nenhuma sessão disponível."); return; }
        listarSessoes();
        System.out.println("\nDigite o ID da sessão desejada: ");
        int idSessao = lerInput();
        Sessao sessaoSelecionada = null;
        for (Sessao s : sessoes) { if (s.getIdSessao() == idSessao) { sessaoSelecionada = s; break; } }
        if (sessaoSelecionada == null) { System.out.println("Sessão não encontrada."); return; }

        int assentosDisponiveis = sessaoSelecionada.contarAssentosDisponiveis();
        System.out.println("Assentos disponíveis: " + assentosDisponiveis);
        System.out.println("Deseja levar acompanhantes? (1.Sim / 2.Não)");
        int acompanhante = lerInput();
        int quantidadeIngresso = 1;
        if (acompanhante == 1) {
            System.out.println("Quantos acompanhantes? ");
            quantidadeIngresso += lerInput();
        }
        if (quantidadeIngresso > assentosDisponiveis) {
            System.out.println("Quantidade indisponível. Deseja usar os " + assentosDisponiveis + " disponíveis? (1.Sim / 2.Não)");
            if (lerInput() == 1) { quantidadeIngresso = assentosDisponiveis; } else { return; }
        }

        List<Ingresso> carrinhoCompra = new ArrayList<>();
        double valorTotal = 0;

        for (int i = 1; i <= quantidadeIngresso; i++) {
            String nomePortador;
            String responsavelLegal = "";
            if (i == 1) {
                System.out.println("\n=== INGRESSO DO CLIENTE ===");
                nomePortador = clienteLogado.getNome();
            } else {
                System.out.println("\n=== ACOMPANHANTE " + (i - 1) + " ===");
                System.out.print("Nome: ");
                nomePortador = sc.nextLine();
            }

            System.out.println("1. Inteira | 2. Universitário | 3. Idoso | 4. Criança");
            int opcaoTipo = lerInput();
            Ingresso.TipoIngresso tipoIngresso = Ingresso.TipoIngresso.INTEIRA;
            switch (opcaoTipo) {
                case 1: tipoIngresso = Ingresso.TipoIngresso.INTEIRA; break;
                case 2:
                    tipoIngresso = Ingresso.TipoIngresso.UNIVERSITARIO;
                    System.out.println("Código carteirinha:"); sc.nextLine();
                    break;
                case 3:
                    System.out.println("Data nascimento:");
                    int idadeIdoso = Period.between(lerData(), LocalDate.now()).getYears();
                    tipoIngresso = (idadeIdoso >= 60) ? Ingresso.TipoIngresso.IDOSO : Ingresso.TipoIngresso.INTEIRA;
                    break;
                case 4:
                    System.out.println("Data nascimento criança:");
                    int idadeCrianca = Period.between(lerData(), LocalDate.now()).getYears();
                    if (idadeCrianca <= 10) {
                        tipoIngresso = Ingresso.TipoIngresso.CRIANCA;
                        System.out.println("Responsável legal:"); responsavelLegal = sc.nextLine();
                    }
                    break;
                default: System.out.println("Opção inválida!"); i--; continue;
            }

            sessaoSelecionada.mostrarMapaAssentos();
            System.out.println("Escolha o assento:");
            String codigoAssento = sc.nextLine();
            Assento assentoSelecionado = null;
            for (Assento a : sessaoSelecionada.getAssentos()) {
                if (a.getCodigoAssento().equalsIgnoreCase(codigoAssento)) {
                    if (!a.isOcupado()) { assentoSelecionado = a; } else { System.out.println("Ocupado!"); }
                    break;
                }
            }
            if (assentoSelecionado == null) { System.out.println("Assento inválido!"); i--; continue; }

            Ingresso ingresso = new Ingresso(
                    contadorIngresso++,
                    Ingresso.gerarCodigoIngresso(),
                    Ingresso.Status.VALIDO,
                    tipoIngresso,
                    responsavelLegal,
                    nomePortador,
                    clienteLogado,
                    sessaoSelecionada,
                    assentoSelecionado
            );
            carrinhoCompra.add(ingresso);
            valorTotal += ingresso.getValorIngresso();
        }

        System.out.println("\n=== RESUMO DA COMPRA ===");
        for (Ingresso ing : carrinhoCompra) { System.out.println(ing); }
        System.out.println("\nTOTAL: R$ " + String.format("%.2f", valorTotal));
        System.out.println("Confirmar compra? (1.Sim / 2.Não)");
        if (lerInput() == 1) {
            for (Ingresso ing : carrinhoCompra) {
                ing.getAssento().ocupar();
                ingressosGerados.add(ing);
            }
            System.out.println("\nCompra finalizada com sucesso! 🍿");
        } else {
            System.out.println("\nCompra cancelada.");
        }
    }

    private static void meusIngressos() {
        System.out.println("\n=== MEUS INGRESSOS ===");
        boolean achou = false;
        for (Ingresso ing : ingressosGerados) {
            if (ing.getCliente().equals(clienteLogado)) { System.out.println(ing); achou = true; }
        }
        if (!achou) { System.out.println("Nenhum ingresso encontrado."); }
    }

    private static void cancelarIngresso() {
        System.out.println("\nDigite o código do ingresso: ");
        String codigo = sc.nextLine();
        for (Ingresso ing : ingressosGerados) {
            if (ing.getCodigo().equalsIgnoreCase(codigo)) {
                ing.cancelarIngresso();
                ing.getAssento().liberar();
                System.out.println("Ingresso cancelado!");
                return;
            }
        }
        System.out.println("Ingresso não encontrado.");
    }

    private static void meuPerfil() {
        int opcao;
        do {
            System.out.println("\n=== MEU PERFIL ===");
            System.out.println("Nome: " + clienteLogado.getNome());
            System.out.println("Email: " + clienteLogado.getEmail());
            System.out.println("\nAlterar? (1.Nome / 2.Email / 0.Voltar)");
            opcao = lerInput();
            if (opcao == 1) {
                System.out.println("Novo nome: ");
                clienteLogado.setNome(sc.nextLine());
                System.out.println("Nome atualizado!");
            } else if (opcao == 2) {
                System.out.println("Novo email: ");
                clienteLogado.setEmail(sc.nextLine());
                System.out.println("Email atualizado!");
            }
        } while (opcao != 0);
    }
}