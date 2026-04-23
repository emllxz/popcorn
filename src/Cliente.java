import java.time.LocalDate;

public class Cliente extends Pessoa {
    private int idCliente;
    private String senha;
    private LocalDate dataNascimento;

    public Cliente(int idCliente, String nome, String email, String senha, String telefone, LocalDate dataNascimento){
        super(nome, email, telefone);
        this.idCliente = idCliente;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
    }


    public int getIdCliente(){return idCliente;}

    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString(){
        return "Id Cliente: " + idCliente +
                ", Nome: " + getNome() +
                ", Email: " + getEmail() +
                ", Telefone: " + getTelefone() +
                ", Data de Nascimento: " + dataNascimento;
    }
}



