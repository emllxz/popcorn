import java.time.LocalDate;

public class Ingresso {

    public enum Status{
        VALIDO,
        USADO,
        CANCELADO
    }

    private int idIngresso;
    protected String codigo;
    public LocalDate dataCompra;
    public double valorIngresso;

    private Status status;

    private Cliente cliente;
    private Sessao sessao;



    public Ingresso(int idIngresso, String codigo, LocalDate dataCompra, double valorIngresso, Status status, Cliente cliente, Sessao sessao){
        this.idIngresso = idIngresso;
        this.codigo = codigo;
        this.dataCompra = dataCompra;
        this.valorIngresso = valorIngresso;

        this.status = status;

        this.cliente = cliente;
        this.sessao = sessao;
    }

    //GETTERS E SETTERS

    public int getIdIngresso(){
        return idIngresso;
    }

    protected String getCodigo(){
        return codigo;
    }
    protected void setCodigo(String codigo){
        this.codigo = codigo;
    }

    public LocalDate getDataCompra(){
        return dataCompra;
    }
    public void setDataCompra(LocalDate dataCompra){
        this.dataCompra = dataCompra;
    }

    public double getValorIngresso(){
        return valorIngresso;
    }
    public void setValorIngresso(double valorIngresso){
        this.valorIngresso = valorIngresso;
    }

    public Cliente getCliente(){
        return cliente;
    }
    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }

    public Sessao getSessao(){
        return sessao;
    }
    public void setSessao(Sessao sessao){
        this.sessao = sessao;
    }

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
               "\nAquisição: " + dataCompra +
               "\nValor do Ingresso: " + valorIngresso +
               "\nStatus: " + status +
               "\nCliente: " + cliente +
               "\nSessão: " +sessao;

    }

}