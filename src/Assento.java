public class Assento {
    private String codigoAssento;
    private boolean ocupado;

    public Assento(String codigoAssento){
        this.codigoAssento = codigoAssento;
        this.ocupado = false;
    }

    public String getCodigoAssento(){
        return codigoAssento;
    }

    public boolean isOcupado(){
        return ocupado;
    }

    public void ocupar(){
        ocupado = true;
    }

    public void liberar(){
        ocupado = false;
    }
}
