public class Sala {

    private int idSala;
    public int numeroSala;
    protected int capacidade;

    public Sala(int idSala, int numeroSala, int capacidade){
        this.idSala = idSala;
        this.numeroSala = numeroSala;
        this.capacidade = capacidade;
    }

    //GETTERS E SETTERS

    public int getIdSala(){return idSala;}

    public int getNumeroSala(){return numeroSala; }
    public void setNumeroSala(int numeroSala){this.numeroSala = numeroSala; }

    public int getCapacidade(){return capacidade; }
    public void setCapacidade(int capacidade) {this.capacidade = capacidade; }

    @Override
    public String toString(){
        return "\n----- SALA -----" +
               "\nId: " + idSala +
               "\nNúmero da Sala: " + numeroSala +
               "\nCapacidade de Pessoas: " + capacidade;
    }
}

