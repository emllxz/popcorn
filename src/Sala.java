public class Sala {
    private int idSala;
    public int numeroSala;
    protected int capacidade;

    public Sala(int idSala, int numeroSala, int capacidade){
        this.idSala = idSala;
        this.numeroSala = numeroSala;
        this.capacidade = capacidade;
    }

    public int getNumeroSala(){return numeroSala; }
    public void setNumeroSala(int numeroSala){this.numeroSala = numeroSala; }
}

