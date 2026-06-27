import java.util.Random;

public class Ingresso {

    public enum Status {
        VALIDO,
        USADO,
        CANCELADO
    }

    public enum TipoIngresso {
        INTEIRA,
        IDOSO,
        CRIANCA,
        UNIVERSITARIO
    }

    private int idIngresso;
    private String codigo;
    private Status status;
    private TipoIngresso tipoIngresso;
    private String responsavelLegal;
    private double valorIngresso;
    private String nomePortador;

    private Cliente cliente;
    private Sessao sessao;
    private Assento assento;

    public Ingresso(int idIngresso, String codigo, Status status, TipoIngresso tipoIngresso,
                    String responsavelLegal, String nomePortador, Cliente cliente,
                    Sessao sessao, Assento assento) {
        this.idIngresso = idIngresso;
        this.codigo = codigo;
        this.status = status;
        this.tipoIngresso = tipoIngresso;
        this.responsavelLegal = responsavelLegal;
        this.nomePortador = nomePortador;
        this.cliente = cliente;
        this.sessao = sessao;
        this.assento = assento;
        this.valorIngresso = calcularValorIngresso();
    }

    // GETTERS E SETTERS
    public int getIdIngresso() { return idIngresso; }
    public void setIdIngresso(int idIngresso) { this.idIngresso = idIngresso; }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }

    public TipoIngresso getTipoIngresso() { return tipoIngresso; }
    public void setTipoIngresso(TipoIngresso tipoIngresso) {
        this.tipoIngresso = tipoIngresso;
        this.valorIngresso = calcularValorIngresso();
    }

    public String getResponsavelLegal() { return responsavelLegal; }
    public void setResponsavelLegal(String responsavelLegal) { this.responsavelLegal = responsavelLegal; }

    public double getValorIngresso() { return valorIngresso; }

    public String getNomePortador() { return nomePortador; }
    public void setNomePortador(String nomePortador) { this.nomePortador = nomePortador; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public Sessao getSessao() { return sessao; }
    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
        this.valorIngresso = calcularValorIngresso();
    }

    public Assento getAssento() { return assento; }
    public void setAssento(Assento assento) { this.assento = assento; }

    public void cancelarIngresso() { this.status = Status.CANCELADO; }
    public void usarIngresso() { this.status = Status.USADO; }

    private double calcularValorIngresso() {
        double valorBase = 40.0;
        if (sessao != null && sessao.isEstreia()) {
            valorBase *= 1.10;
        }
        if (tipoIngresso != null) {
            switch (tipoIngresso) {
                case UNIVERSITARIO:
                case IDOSO:
                case CRIANCA:
                    valorBase *= 0.5;
                    break;
                default:
                    break;
            }
        }
        return valorBase;
    }

    public static String gerarCodigoIngresso() {
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder codigo = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 8; i++) {
            codigo.append(caracteres.charAt(random.nextInt(caracteres.length())));
        }
        return codigo.toString();
    }

    @Override
    public String toString() {
        String stringResponsavel = "";
        if (tipoIngresso == TipoIngresso.CRIANCA) {
            stringResponsavel = String.format("\n║ Resp.     : %-30s ║", responsavelLegal);
        }
        return
                "\n╔════════════════════════════════════════════╗" +
                        "\n║            🎬 CINE POPCORN 🎬              ║" +
                        "\n╠════════════════════════════════════════════╣" +
                        String.format("\n║ Comprador : %-30s ║", cliente != null ? cliente.getNome() : "") +
                        String.format("\n║ Portador  : %-30s ║", nomePortador) +
                        "\n║--------------------------------------------║" +
                        String.format("\n║ Filme     : %-30s ║", sessao != null && sessao.getFilme() != null ? sessao.getFilme().getTitulo() : "") +
                        String.format("\n║ Sala      : %-30s ║", sessao != null && sessao.getSala() != null ? String.valueOf(sessao.getSala().getNumeroSala()) : "") +
                        String.format("\n║ Assento   : %-30s ║", assento != null ? assento.getCodigoAssento() : "") +
                        String.format("\n║ Tipo      : %-30s ║", tipoIngresso) +
                        stringResponsavel +
                        String.format("\n║ Idioma    : %-30s ║", sessao != null ? sessao.getIdioma() : "") +
                        "\n║--------------------------------------------║" +
                        String.format("\n║ Data      : %-30s ║", sessao != null ? String.valueOf(sessao.getData()) : "") +
                        String.format("\n║ Horário   : %-30s ║", sessao != null ? String.valueOf(sessao.getHorario()) : "") +
                        "\n║--------------------------------------------║" +
                        String.format("\n║ Valor     : R$ %-27.2f ║", valorIngresso) +
                        String.format("\n║ Status    : %-30s ║", status) +
                        String.format("\n║ Código    : %-30s ║", codigo) +
                        "\n╠════════════════════════════════════════════╣" +
                        "\n║         🍿 BOM FILME! APROVEITE! 🍿        ║" +
                        "\n╚════════════════════════════════════════════╝";
    }
}