import java.time.LocalDate;

public class Filme {
    private int idFilme;
    public String titulo;
    public String descricao;
    public int duracao;
    public int classificacaoIndicativa;
    public String genero;
    public LocalDate dataLancamento;
    protected boolean disponivel;

    public Filme(int idFilme, String titulo, String descricao, int duracao, int classificacaoIndicativa, String genero, LocalDate dataLancamento, boolean disponivel) {
        this.idFilme = idFilme;
        this.titulo = titulo;
        this.descricao = descricao;
        this.duracao = duracao;
        this.classificacaoIndicativa = classificacaoIndicativa;
        this.genero = genero;
        this.dataLancamento = dataLancamento;
        this.disponivel = disponivel;
    }

    //GETTERS E SETTERS

    public int getIdFilme() {return idFilme; }

    public String getTitulo() {return titulo; }
    public void setTitulo(String titulo) {this.titulo = titulo; }

    public String getDescricao() {return descricao; }
    public void setDescricao(String descricao) {this.descricao = descricao; }

    public int getDuracao() {return duracao; }
    public void setDuracao(int duracao) {this.duracao = duracao; }

    public int getClassificacaoIndicativa() {return classificacaoIndicativa; }
    public void setClassificacaoIndicativa(int classificacaoIndicativa) {this.classificacaoIndicativa = classificacaoIndicativa; }

    public String getGenero() {return genero; }
    public void setGenero(String genero) {this.genero = genero; }

    public LocalDate getDataLancamento() {return dataLancamento; }
    public void setDataLancamento(LocalDate dataLancamento) {this.dataLancamento = dataLancamento; }

    public boolean getDisponivel() {return disponivel; }
    public void setDisponivel(boolean disponivel) {this.disponivel = disponivel; }


    @Override
    public String toString() {
        return  "\n----- FILME -----" +
                "\nId: " + idFilme +
                "\nDescrição: " + descricao +
                "\nDuração: " + duracao +
                "\nClassificação Indicativa: " + classificacaoIndicativa +
                "\nGênero: " + genero +
                "\nLançamento: " + dataLancamento +
                "\nDisponível: " + (disponivel ? "Em cartaz" : "Indisponível");
    }
}
