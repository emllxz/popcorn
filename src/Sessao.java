import java.time.LocalDate;
import java.time.LocalTime;

public class Sessao {
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
    }

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

    @Override
    public String toString(){
        return "Id Sessão: " + idSessao +
                ", Filme: " + filme.getTitulo() +
                ", Sala: " + sala.getNumeroSala() +
                ", Data: " + data +
                ", Horário: " + horario +
                ", Idioma: " + idioma;
    }
}


