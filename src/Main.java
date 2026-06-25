import java.util.Scanner;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public class Main {

    private static final Scanner sc = new Scanner(System.in);
    private static final List<Filme> filmes = new ArrayList<>();
    private static final List<Sala> salas = new ArrayList<>();
    private static final List<Sessao> sessoes = new ArrayList<>();
    private static final List<Cliente> clientes = new ArrayList<>();
    private static final List<Ingresso> ingressos = new ArrayList<>();
    private static int contadorFilme = 1;
    private static int contadorSala = 1;
    private static int contadorSessao = 1;
    private static int contadorCliente = 1;
    private static int contadorIngresso = 1;
    private static Cliente clienteLogado;
    private static String senhaAdmin = ("Admin@!2026");

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
                case 1:
                    menuFilmes();
                    break;
                case 2:
                    menuSalas();
                    break;
                case 3:
                    menuSessoes();
                    break;
                case 4:
                    menuUsuarios();
                    break;
                case 5:
                    menuRelatorios();
                    break;
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
                case 1:
                    cadastrarFilmes();
                    break;
                case 2:
                    listarFilmes();
                    break;
                case 3:
                    inativarFilme();
                    break;
                case 0:
                    continuar = false;
                    System.out.println("\nRetornando ao Menu inicial... ");
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
                case 1:
                    cadastrarSalas();
                    break;
                case 2:
                    listarSalas();
                    break;
                case 3:
                    removerSala();
                    break;
                case 0:
                    continuar = false;
                    System.out.println("\nRetornando ao Menu inicial... ");
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
                case 1:
                    cadastrarSessoes();
                    break;
                case 2:
                    listarSessoes();
                    break;
                case 3:
                    removerSessao();
                    break;
                case 0:
                    continuar = false;
                    System.out.println("\n Retornando ao Menu Inicial...");
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
                case 1:
                    cadastrarCliente();
                    break;
                case 2:
                    listarUsuarios();
                    break;
                case 0:
                    continuar = false;
                    System.out.println("\n Retornando ao Menu Inicial...");
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
                    break;
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
            int classificacaoIndicativa = lerInput();

            System.out.print("Gênero: ");
            String genero = (sc.nextLine());

            System.out.print("Data de lançamento (AAAA-MM-DD): ");
            LocalDate dataLancamento = lerData();

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

            System.out.println("\nDeseja cadastrar um novo filme?");
            System.out.println("1. Sim");
            System.out.println("2. Não");

            System.out.println("\nEscolha uma opção: ");

            int opcaoCadastrarNovoFilme = lerInput();

            switch (opcaoCadastrarNovoFilme) {
                case 1:
                    break;
                case 2:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida!");
                    continuar = false;
                    break;
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
            int numeroSala = lerInput();

            System.out.print("Tipo de Sala: ");
            System.out.println("1 - Pequena");
            System.out.println("2 - Média");
            System.out.println("3 - Grande");

            int opcaoTipoSala = lerInput();

            Sala.TipoSala tipoSala = null;

            switch (opcaoTipoSala) {
                case 1:
                    tipoSala = Sala.TipoSala.PEQUENA;
                    break;
                case 2:
                    tipoSala = Sala.TipoSala.MEDIA;
                    break;
                case 3:
                    tipoSala = Sala.TipoSala.GRANDE;
                    break;
                default:
                System.out.println("Tipo inválido!");
                continue;
            }

            Sala sala = new Sala(
                    contadorSala++,
                    numeroSala,
                    tipoSala
            );

            salas.add(sala);

            System.out.println("\nSala cadastrado com sucesso!");

            System.out.println("\nDeseja cadastrar uma nova sala?");
            System.out.println("1. Sim");
            System.out.println("2. Não");

            System.out.println("\nEscolha uma opção: ");

            int opcaoCadastrarNovaSala = lerInput();

            switch (opcaoCadastrarNovaSala) {
                case 1:
                    break;
                case 2:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida!");
                    continuar = false;
                    break;
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
            LocalDate data = lerData();

            System.out.print("Horário de Exibição (HH:MM): ");
            LocalTime horario = lerHora();

            System.out.println("Idiomas disponíveis: ");
            String idioma = sc.nextLine();

            System.out.println("O filme está em estreia?");
            System.out.println("1. Sim");
            System.out.println("2. Não");

            System.out.println("\nEscolha uma opção: ");

            int opcaoEstreia = lerInput();

            boolean estreia = false;

            switch (opcaoEstreia) {
                case 1:
                    estreia = true;
                    break;
                case 2:
                    estreia = false;
                    break;
                default:
                    System.out.println("Opção inválida!");
                    return;
            }


            if (filmes.isEmpty()) {
                System.out.println("Nenhum filme cadastrado.");
                System.out.println("Favor, cadastre ao menos um filme.");
                return;
            }
            boolean existeFilmeDisponivel = false;

            for (Filme filme : filmes) {
                if (filme.getDisponivel()) {
                    existeFilmeDisponivel = true;
                    break;
                }
            }
            if (!existeFilmeDisponivel) {
                System.out.println("Não existem filmes disponíveis para criar sessões.");
                return;
            }
            System.out.println("\nSegue lista de filmes disponíveis: ");
            for (Filme filme : filmes) {
                if (filme.getDisponivel()) {
                    System.out.println(filme);
                    System.out.println();
                }
            }
            System.out.println("\nDigite a ID do Filme desejado: ");
            int idFilme = lerInput();

            Filme filmeSelecionado = null;

            for (Filme filme : filmes) {
                if (filme.getIdFilme() == idFilme && filme.getDisponivel()) {
                    filmeSelecionado = filme;
                    break;
                }
            }

            if (filmeSelecionado == null) {
                System.out.println("Filme não encontrado ou não está disponível.");
                continue;
            }

            if (salas.isEmpty()) {
                System.out.println("Nenhuma sala cadastrada.");
                System.out.println("Favor, cadastre ao menos uma sala.");
                return;
            }

            System.out.println("Segue lista de salas disponíveis: ");
            listarSalas();
            System.out.println("\nDigite a ID da Sala desejada: ");
            int idSala = lerInput();

            Sala salaSelecionada = null;

            for (Sala sala : salas) {
                if (sala.getIdSala() == idSala) {
                    salaSelecionada = sala;
                    break;
                }
            }
            if (salaSelecionada == null) {
                System.out.println("Sala não encontrada!");
                continue;
            }

            Sessao sessao = new Sessao(
                    contadorSessao++,
                    data,
                    horario,
                    idioma,
                    estreia,
                    filmeSelecionado,
                    salaSelecionada
            );

            sessoes.add(sessao);

            System.out.println("\nSessão cadastrada com sucesso!");
            System.out.println("\nDeseja cadastrar uma nova Sessão?");
            System.out.println("\n1. Sim");
            System.out.println("2. Não");

            System.out.println("\nEscolha uma opção: ");

            int opcaoCadastrarNovaSessao = lerInput();

            switch (opcaoCadastrarNovaSessao) {
                case 1:
                    break;
                case 2:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida!");
                    continuar = false;
                    break;
            }
        }
    }

    //USUÁRIO ADMIN -- 04 LISTA DE FILMES
    private static void listarFilmes() {
        System.out.println("\n- - - - - - - - - - - - -");
        System.out.println("     LISTA DE FILMES      ");
        System.out.println("- - - - - - - - - - - - -");

        if (filmes.isEmpty()) {
            System.out.println("\nNenhum filme cadastrado.");
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
            System.out.println("\nNenhuma sala cadastrada.");
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
            System.out.println("\nNenhuma sessão cadastrada.");
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
            System.out.println("\nNenhum usuário cadastrado.");
            return;
        }
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
            System.out.println();
        }

    }

    //USUÁRIO ADMIN -- 08 REMOVER SESSÃO
    private static void removerSessao() {
        if (sessoes.isEmpty()) {
            System.out.println("Nenhuma sessão cadastrada.");
            return;
        }

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

    //USUÁRIO ADMIN -- 09 REMOVER SALA
    private static void removerSala() {

        if (salas.isEmpty()) {
            System.out.println("Nenhuma sala cadastrada.");
            return;
        }
        listarSalas();

        System.out.println("\nDigite o ID da sala: ");
        int id = lerInput();

        for (Sessao sessao : sessoes) {
            if (sessao.getSala().getIdSala() == id) {
                System.out.println("\nNão é possível remover a sala.");
                System.out.println("Existem sessões vinculadas a ela.");
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

    //USUÁRIO ADMIN -- 10 INATIVAR FILME
    private static void inativarFilme() {

        if (filmes.isEmpty()) {
            System.out.println("Nenhum filme cadastrado.");
            System.out.println("Favor, cadastre um filme antes de tentar inativá-lo.");
            return;
        }

        listarFilmes();

        System.out.println("Digite o ID do filme: ");
        int id = lerInput();

        for (Filme filme : filmes) {
            if (filme.getIdFilme() == id) {

                if (!filme.getDisponivel()) {
                    System.out.println("O filme já está inativo");
                    return;
                }

                filme.setDisponivel(false);

                int sessoesRemovidas = 0;

                for (int i = sessoes.size() - 1; i >= 0; i--) {
                    if (sessoes.get(i).getFilme().getIdFilme() == id) {
                        sessoes.remove(i);
                        sessoesRemovidas++;
                    }
                }
                System.out.println("Filme inativado com sucesso!");
                System.out.println("Sessões removidas: " + sessoesRemovidas);

                return;
            }
        }
        System.out.println("Filme não encontrado.");
    }

    //USUÁRIO ADMIN -- 11 MOSTRAR RELATÓRIOS
    private static void menuRelatorios() {
        boolean voltar = true;

        while (voltar) {
            System.out.println("\n- - - - - - - - - - - - - ");
            System.out.println("      RELATÓRIOS         ");
            System.out.println("- - - - - - - - - - - - - ");
            System.out.println("\n1. Filmes ativos");
            System.out.println("2. Filmes inativados");
            System.out.println("3. Quantidade de Sessões por Filme");
            System.out.println("4. Relatório Geral");
            System.out.println("0. Voltar");
            System.out.println("\n- - - - - - - - - - - - -");
            System.out.println("\nEscolha uma opção: ");

            int opcaoRelatorio = lerInput();

            switch (opcaoRelatorio) {
                case 1:
                    relatorioFilmesAtivos();
                    break;
                case 2:
                    relatorioFilmesInativos();
                    break;
                case 3:
                    relatorioSessoesPorFilme();
                    break;
                case 4:
                    relatorioGeral();
                    break;
                case 0:
                    System.out.println("Voltando para área do Administrador");
                    voltar = false;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    //----------- MÉTODOS DE RELATÓRIOS -----------
    //Relatório de Filmes Ativos
    private static void relatorioFilmesAtivos() {
        if (filmes.isEmpty()) {
            System.out.println("Nenhum filme cadastrado.");
            return;
        }

        int quantidadeAtivos = 0;

        System.out.println("\n- - - - - - - - - - - - -");
        System.out.println("   RELATÓRIO FILMES ATIVOS");
        System.out.println("- - - - - - - - - - - - -");

        for (Filme filme : filmes) {

            if (filme.getDisponivel()) {
                System.out.println(filme);
                System.out.println();

                quantidadeAtivos++;
            }
        }
        if (quantidadeAtivos == 0) {
            System.out.println("Nenhum filme ativo encontrado");
            return;
        }
        System.out.println("Total de filmes ativos: " + quantidadeAtivos);
    }

    //Relatório de Filmes Inativados
    private static void relatorioFilmesInativos() {
        if (filmes.isEmpty()) {
            System.out.println("Nenhum filme cadastrado.");
            return;
        }

        int quantidadeDesativados = 0;

        System.out.println("\n- - - - - - - - - - - - -");
        System.out.println("   RELATÓRIO FILMES DESATIVADOS");
        System.out.println("- - - - - - - - - - - - -");

        for (Filme filme : filmes) {

            if (!filme.getDisponivel()) {
                System.out.println(filme);
                System.out.println();

                quantidadeDesativados++;
            }
        }
        if (quantidadeDesativados == 0) {
            System.out.println("Nenhum filme desativado encontrado");
            return;
        }
        System.out.println("Total de filmes desativados: " + quantidadeDesativados);
    }

    //Relatório de sessões por filme
    private static void relatorioSessoesPorFilme() {
        if (filmes.isEmpty()) {
            System.out.println("Nenhum filme cadastrado.");
            return;
        }
        if (sessoes.isEmpty()) {
            System.out.println("Nenhuma sessão cadastrada.");
            return;
        }

        System.out.println("\n- - - - - - - - - - - - -");
        System.out.println(" RELATÓRIO DE SESSÕES POR FILME ");
        System.out.println("- - - - - - - - - - - - -");

        for (Filme filme : filmes) {

            int quantidadeSessoes = 0;

            for (Sessao sessao : sessoes) {
                if (sessao.getFilme().getIdFilme() == filme.getIdFilme()) {
                    quantidadeSessoes++;
                }
            }

            System.out.println("Filme: " + filme.getTitulo());
            System.out.println("Quantidade de sessões: " + quantidadeSessoes);
            System.out.println();
        }
    }

    //Relatório geral de quantidades
    private static void relatorioGeral() {
        System.out.println("\n- - - - - - - - - - - - -");
        System.out.println("     RELATÓRIO GERAL     ");
        System.out.println("- - - - - - - - - - - - -");

        System.out.println("\nRESUMO DO SISTEMA:");
        System.out.println("- - - - - - - - - - - - -");

        System.out.println("Filmes cadastrados: " + filmes.size());
        System.out.println("- Ativos: " + contarFilmesAtivos());
        System.out.println("- Inativos: " + contarFilmesInativos());

        System.out.println("Salas cadastradas: " + salas.size());
        System.out.println("Sessões cadastradas: " + sessoes.size());
        System.out.println("Clientes cadastrados: " + clientes.size());
        System.out.println("- - - - - - - - - - - - -");
    }

    private static int contarFilmesAtivos() {
        int count = 0;

        for (Filme filme : filmes) {
            if (filme.getDisponivel()) {
                count++;
            }
        }
        return count;
    }

    private static int contarFilmesInativos() {
        int count = 0;

        for (Filme filme : filmes) {
            if (!filme.getDisponivel()) {
                count++;
            }
        }
        return count;
    }

    //USUÁRIO CLIENTE -- 01 CADASTRAR USUÁRIO
    private static void cadastrarCliente() {
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n- - - - - - - - - - - - -");
            System.out.println("     CADASTRAR CLIENTE      ");
            System.out.println("- - - - - - - - - - - - - ");

            System.out.println("Digite o nome completo: ");
            String nome = sc.nextLine();

            System.out.println("Digite a data de nascimento (AAAA-MM-DD): ");
            LocalDate dataNascimento = lerData();

            System.out.println("Digite o email: ");
            String email = sc.nextLine();

            boolean emailExiste = false;

            for (Cliente cliente : clientes) {
                if (cliente.getEmail().equalsIgnoreCase(email)) {
                    emailExiste = true;
                    break;
                }
            }
            if(emailExiste) {
                    System.out.println("E-mail já cadastrado!");
                    continue;
            }

            System.out.println("Digite o telefone: ");
            String telefone = sc.nextLine();

            System.out.println("Digite a senha do usuário: ");
            String senha = sc.nextLine();

            Cliente cliente = new Cliente(
                    contadorCliente++,
                    nome,
                    email,
                    senha,
                    telefone,
                    dataNascimento
            );

            clientes.add(cliente);

            System.out.println("Usuário cadastrado com sucesso!");

            System.out.println("\nDeseja cadastrar um novo usuário?");
            System.out.println("1. Sim");
            System.out.println("2. Não");

            System.out.println("\nEscolha uma opção: ");

            int opcaoCadastrarNovoUsuario = lerInput();

            switch (opcaoCadastrarNovoUsuario) {
                case 1:
                    break;
                case 2:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida!");
                    continuar = false;
                    break;
            }
            System.out.println("\nPara acessar sua conta, selecione a opção 'Fazer login' e informe seus dados.");
            System.out.println("\nVoltando ao Menu...");
        }
    }

    //USUÁRIO CLIENTE -- 02 FAZER LOGIN
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

                System.out.println("\nLogin realizado com sucesso!");
                System.out.println("\nBem vindo(a), " + cliente.getNome());

                return true;
            }
        }
        System.out.print("\nE-mail ou senha inválidos!");
        return (false);
    }

    private static void menuLogin() {
        boolean voltar = false;

        while (!voltar) {

            System.out.println("\n- - - - - - - - - - - - -");
            System.out.println("  Area do Cliente  ");
            System.out.println("- - - - - - - - - - - - -");
            System.out.println("1. Ver sessões");
            System.out.println("2. Comprar Ingresso");
            System.out.println("3. Meus ingressos");
            System.out.println("4. Cancelar Ingresso ");
            System.out.println("5. Meu perfil");
            System.out.println("0. Logout");
            System.out.println("\nEscolha uma opção: ");

            int opcao = lerInput();

            switch (opcao) {
                case 1:
                    verSessoes();
                    break;
                case 2:
                    comprarIngresso();
                    break;
                case 3:
                    meusIngressos();
                    break;
                case 4:
                    cancelarIngresso();
                    break;
                case 5:
                    meuPerfil();
                    break;
                case 0:
                    System.out.println("Usuário sendo desconectado...");
                    System.out.println("\nSua sessão foi encerrada.");
                    voltar = true;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }

    }

    private static void verSessoes() {
        System.out.println("Segue lista de sessões: ");
        listarSessoes();
    }

    private static void comprarIngresso() {
        System.out.println("\nSistema em manutenção");
    }

    private static void meusIngressos() {
        System.out.println("\nSistema em manutenção");
    }

    private static void cancelarIngresso() {
        System.out.println("\nSistema em manutenção");
    }

    private static void meuPerfil() {
        System.out.println("\nSistema em manutenção");
    }

    private static void ingresso() {
        String codigoIngresso = UUID.randomUUID().toString().toUpperCase();

        boolean continuar = true;

        while (continuar) {
            System.out.println("\n- - - - - - - - - - - - -");
            System.out.println("         INGRESSO         ");
            System.out.println("- - - - - - - - - - - - - ");

            System.out.println("código: " + codigoIngresso);

            System.out.println("Data vencimento do ingresso: ");

            System.out.println();

        }
    }
}

