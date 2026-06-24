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

    private Cliente cliente;
    private Sessao sessao;
    private Assento assento;




    public Ingresso(int idIngresso, String codigo,
                    double valorIngresso, Status status, Cliente cliente,
                    Sessao sessao, Assento assento){

        this.idIngresso = idIngresso;
        this.codigo = codigo;
        this.valorIngresso = valorIngresso;

        this.status = status;

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

    @Override
    public String toString(){
        return "\n----- INGRESSO -----" +
               "\nId: " + idIngresso +
               "\nCódigo= " + codigo +
               "\nValor do Ingresso: " + valorIngresso +
               "\nStatus: " + status +
               "\nCliente: " + cliente.getNome() +
               "\nFilme: " +sessao.getFilme().getTitulo() +
               "\nAssento: " + assento.getCodigoAssento() +
               "\nData da Sessão: " + sessao.getData() +
               "\nHorário: " + sessao.getHorario();


    }

}