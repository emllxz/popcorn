import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Sessao {

    private List<Assento> assentos = new ArrayList<>();

    private int idSessao;
    public LocalDate data;
    public LocalTime horario;
    public String idioma;

    private Filme filme;
    private Sala sala;

    public Sessao(int idSessao,LocalDate data, LocalTime horario, String idioma, Filme filme, Sala sala){
        this.idSessao = idSessao;
        this.data = data;
        this.horario = horario;
        this.idioma = idioma;
        this.filme = filme;
        this.sala = sala;

        gerarAssentos();
    }

    //GETTERS E SETTERS

    public int getIdSessao(){return idSessao;}

    public LocalDate getData(){return data;}
    public void setData(LocalDate data){this.data = data;}

    public LocalTime getHorario(){return horario;}
    public void setHorario(LocalTime horario){this.horario = horario;}

    public String getIdioma(){return idioma;}
    public void setIdioma(String idioma){this.idioma = idioma;}

    public Filme getFilme(){return filme;}
    public void setFilme(Filme filme){this.filme = filme;}

    public Sala getSala(){return sala;}
    public void setSala(Sala sala){this.sala = sala;}

    private void gerarAssentos() {

        int filas = sala.getTipoSala().getFilas();
        int colunas = sala.getTipoSala().getColunas();

        for (int linha = 0; linha < filas; linha++) {

            char letra = (char) ('A' + linha);

            for (int coluna = 1; coluna <= colunas; coluna++) {

                assentos.add(
                        new Assento(letra + String.valueOf(coluna))
                );
            }
        }
    }

    public void mostrarMapaAssentos() {

        int filas = sala.getTipoSala().getFilas();
        int colunas = sala.getTipoSala().getColunas();

        System.out.println("\n        TELA");
        System.out.println("================================");

        System.out.print("      ");
        for (int coluna = 1; coluna <= colunas; coluna++) {
            System.out.printf("[%-2d]", coluna);
        }

        System.out.println();
        System.out.print("      ");
        for (int i = 0; i < colunas; i++) {
            System.out.print("------");
        }
        System.out.println();
        int indice = 0;

        for (int linha = 0; linha < filas; linha++) {

            char letra = (char) ('A' + linha);
            System.out.print(letra + " |   ");

            for (int coluna = 1; coluna <= colunas; coluna++) {
                Assento assento = assentos.get(indice++);

                if(assento.isOcupado()) {
                    System.out.printf("[%-2s]", "XX");
                }else{
                    System.out.printf("[%-2s]", assento.getCodigoAssento());
                }
            }
            System.out.println();
        }
        System.out.println("================================");
    }

    public Assento buscarAssento(String codigoAssento) {
        for (Assento assento : assentos) {
            if (assento.getCodigoAssento().equalsIgnoreCase(codigoAssento)) {
                return assento;
            }
        }
        return null;
    }

    public List<Assento> getAssentos() {return assentos; }

    @Override
    public String toString(){
        return  "\n----- SESSÃO -----" +
                "\nId Sessão: " + idSessao +
                "\nFilme: " + filme.getTitulo() +
                "\nSala: " + sala.getNumeroSala() +
                "\nData: " + data +
                "\nHorário: " + horario +
                "\nIdioma: " + idioma;
    }
}


