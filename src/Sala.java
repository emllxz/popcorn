public class Sala {

    public enum TipoSala{
        PEQUENA(5, 8),
        MEDIA(8, 12),
        GRANDE(12, 20);

        private final int filas;
        private final int colunas;

        TipoSala(int filas, int colunas){
            this.filas = filas;
            this.colunas = colunas;
        }

        public int getFilas(){
            return filas;
        }

        public int getColunas(){
            return colunas;
        }
    }

    private int idSala;
    public int numeroSala;

    private TipoSala tipoSala;

    public Sala(int idSala, int numeroSala, TipoSala tipoSala){
        this.idSala = idSala;
        this.numeroSala = numeroSala;
        this.tipoSala = tipoSala;
    }

    //GETTERS E SETTERS

    public int getIdSala(){return idSala;}

    public int getNumeroSala(){return numeroSala; }
    public void setNumeroSala(int numeroSala){this.numeroSala = numeroSala; }

    public TipoSala getTipoSala(){return tipoSala;}


    @Override
    public String toString(){
        return "\n----- SALA -----" +
               "\nId: " + idSala +
               "\nNúmero da Sala: " + numeroSala;
    }
}

