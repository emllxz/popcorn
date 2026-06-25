import java.time.LocalDate;

public class Ingresso {

    public enum Status{
        VALIDO,
        USADO,
        CANCELADO
    }

    private enum tipoIngresso {
        INTEIRA,
        IDOSO,
        CRIANCA,
        UNIVERSITARIO
    }

    private int idIngresso;
    private String codigo;
    private double valorIngresso;

    private Status status;
    private tipoIngresso tipoIngresso;

    private Cliente cliente;
    private Sessao sessao;
    private Assento assento;




    public Ingresso(int idIngresso, String codigo,
                    double valorIngresso, Status status, tipoIngresso tipoIngresso, Cliente cliente,
                    Sessao sessao, Assento assento){

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

    public int getIdIngresso(){
        return idIngresso;
    }

    public String getCodigo(){
        return codigo;
    }

    public double getValorIngresso(){
        return valorIngresso;
    }
    public void setValorIngresso(double valorIngresso){
        this.valorIngresso = valorIngresso;
    }

    public Cliente getCliente(){ return cliente; }
    public Sessao getSessao(){ return sessao; }
    public Assento getAssento() { return assento; }

    public Status getStatus (){
        return status;
    }
    public void setStatus(Status status){
        this.status = status;
    }

    public tipoIngresso getTipoIngresso() {return tipoIngresso; }

    @Override
    public String toString(){
        return "╔══════════════════════════════════════╗\n" +
                "║           🎬 CINEMA TICKET           ║\n" +
                "╠══════════════════════════════════════╣\n" +
                "║ Filme   : " + sessao.getFilme().getTitulo() + "\n" +
                "║ Sala    : " + sessao.getSala().getNumeroSala() + "\n" +
                "║ Assento : " + assento.getCodigoAssento() + "\n" +
                "║--------------------------------------║\n" +
                "║ Data    : " + sessao.getData() + "\n" +
                "║ Hora    : " + sessao.getHorario() + "\n" +
                "║ Idioma  : " + sessao.getIdioma() + "\n" +
                "║--------------------------------------║\n" +
                "║ Tipo    : " + tipoIngresso + "\n" +
                "║ Valor   : R$ " + String.format("%.2f", valorIngresso) + "\n" +
                "║ Status  : " + status + "\n" +
                "╠══════════════════════════════════════╣\n" +
                "║ Código: " + codigo + "\n" +
                "╚══════════════════════════════════════╝";
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