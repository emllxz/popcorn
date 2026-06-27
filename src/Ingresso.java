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

    private Cliente cliente;
    private Sessao sessao;
    private Assento assento;


    public Ingresso(int idIngresso, String codigo,
                    Status status,
                    TipoIngresso tipoIngresso, String responsavelLegal,
                    Cliente cliente, Sessao sessao, Assento assento) {

        this.idIngresso = idIngresso;
        this.codigo = codigo;

        this.status = status;
        this.tipoIngresso = tipoIngresso;
        this.responsavelLegal = responsavelLegal;

        this.cliente = cliente;
        this.sessao = sessao;
        this.assento = assento;

        this.valorIngresso = calcularValorIngresso();
    }

    //GETTERS E SETTERS

    public int getIdIngresso() {return idIngresso;}

    public String getCodigo() {return codigo;}

    public Cliente getCliente() {return cliente;}

    public Sessao getSessao() {return sessao;}

    public Assento getAssento() {return assento;}

    public Status getStatus() {return status;}

    public void cancelarIngresso() {status = Status.CANCELADO; }
    public void usarIngresso() {status = Status.USADO;}


    public TipoIngresso getTipoIngresso() {return tipoIngresso;}
    public String getResponsavelLegal() {return responsavelLegal;}

    private double calcularValorIngresso() {

        double valorBase = 40.0;

        if (sessao.isEstreia()) {
            valorBase *= 1.10;
        }

        switch (tipoIngresso) {

            case INTEIRA:
                break;

            case UNIVERSITARIO:
            case IDOSO:
            case CRIANCA:
                valorBase *= 0.5;
                break;
        }
        return valorBase;
    }
    @Override
    public String toString() {
        return
                "\n╔════════════════════════════════════════════╗" +
                "\n║            🎬 CINE POPCORN 🎬              ║" +
                "\n╠════════════════════════════════════════════╣" +
                "\n║ Cliente : " + cliente.getNome() +
                "\n║--------------------------------------------║" +
                "\n║ Filme   : " + sessao.getFilme().getTitulo() +
                "\n║ Sala    : " + sessao.getSala().getNumeroSala() +
                "\n║ Assento : " + assento.getCodigoAssento() +
                "\n║ Tipo    : " + tipoIngresso +
                (tipoIngresso == TipoIngresso.CRIANCA
                       ? "\n║ Resp.   : " + responsavelLegal
                       : "") +
                "\n║ Idioma  : " + sessao.getIdioma() +
                "\n║--------------------------------------------║" +
                "\n║ Data    : " + sessao.getData() +
                "\n║ Horário : " + sessao.getHorario() +
                "\n║--------------------------------------------║" +
                "\n║ Valor   : R$ " + String.format("%.2f", valorIngresso) +
                "\n║ Status  : " + status +
                "\n║ Código  : " + codigo +
                "\n╠═════════════════════════════════════════════╣" +
                "\n║         🍿 BOM FILME! APROVEITE! 🍿         ║" +
                "\n╚═════════════════════════════════════════════╝";
    }
}