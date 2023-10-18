package ClassesDaAplicacao;

import java.util.Date;
import Utilitarios.Utils;

public class Pessoa {

    private static int contadorPessoa = 1;//Static para poder ser acessado direto da classe

    private int numeroPessoa;
    private String nome;
    private String cpf;
    private String email;
    private Date dataDeCriacao;

    public Pessoa(){}

    public Pessoa(String nome, String cpf, String email) {
        this.numeroPessoa = Pessoa.contadorPessoa;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.dataDeCriacao = new Date();
        Pessoa.contadorPessoa += 1;// atualiza automaticamente o numero de pessoa criada
    }

    public int getNumeroPessoa(){
        return numeroPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public Date getDataDeCriacao() {
        return dataDeCriacao;
    }

    @Override
    public String toString() {
        return "Pessoa n°: " + this.getNumeroPessoa() + "\n" +
                "Nome: " + this.getNome() + '\n' +
                "CPF: " + this.getCpf() + '\n' +
                "E-mail: " + this.getEmail() + '\n' +
                "Data De Criação: " + Utils.dataParaString(dataDeCriacao) + '\n' +
                "*___________________________________*";
    }
}
