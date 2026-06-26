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
    private double valorIngresso;

    private Status status;
    private TipoIngresso tipoIngresso;

    private Cliente cliente;
    private Sessao sessao;
    private Assento assento;


    public Ingresso(int idIngresso, String codigo,
                    double valorIngresso, Status status, TipoIngresso tipoIngresso, Cliente cliente,
                    Sessao sessao, Assento assento) {

        this.idIngresso = idIngresso;
        this.codigo = codigo;
        this.valorIngresso = valorIngresso;

        this.status = status;
        this.tipoIngresso = tipoIngresso;


        this.cliente = cliente;
        this.sessao = sessao;
        this.assento = assento;
    }

    //GETTERS E SETTERS

    public int getIdIngresso() {return idIngresso;}

    public String getCodigo() {return codigo;}

    public double getValorIngresso() {return valorIngresso;}

    public Cliente getCliente() {return cliente;}

    public Sessao getSessao() {return sessao;}

    public Assento getAssento() {return assento;}

    public Status getStatus() {return status;}

    public void cancelarIngresso() {status = Status.CANCELADO; }
    public void usarIngresso() {status = Status.USADO;}


    public TipoIngresso getTipoIngresso() {return tipoIngresso;}

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

//private double calcularValorIngresso(
//        Sessao sessao,
//        tipoIngresso tipoIngresso) {
//
//    double valorIngresso = 40.0;
//
//    if (sessao.isEstreia()) {
//        valorIngresso *= 1.10;
//    }
//
//    switch (tipoIngresso) {
//        case INTEIRA:
//            break;
//        case UNIVERSITARIO:
//        case IDOSO:
//        case CRIANCA:
//            valorIngresso *= 0.5;
//            break;
//    }
//    return valorIngresso;
//}