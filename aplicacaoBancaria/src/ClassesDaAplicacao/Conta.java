package ClassesDaAplicacao;

import Utilitarios.Utils;

public class Conta {

    private static int contadorConta = 1;

    private final int numeroConta;
    private Pessoa pessoa;
    private Double saldo = 0.0;

    public Conta(Pessoa pessoa){
        this.numeroConta = Conta.contadorConta;
        this.pessoa = pessoa;
        this.saldo = 0.0;
        Conta.contadorConta += 1;
    }

    public Conta(Pessoa pessoa, double valorInicial){
        this.numeroConta = Conta.contadorConta;
        this.pessoa = pessoa;
        depositar(valorInicial);
        Conta.contadorConta += 1;
    }

    public int getNumeroConta() {
        return numeroConta;
    }


    public Pessoa getClient() {
        return pessoa;
    }

    public void setClient(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Conta Bancária Nº: " + this.getNumeroConta() + '\n'
                + "Cliente: " + this.pessoa.getNome() + '\n'
                + "CPF: " + this.pessoa.getCpf() + '\n'
                + "E-mail: " + this.pessoa.getEmail() + '\n'
                + "Saldo: " + Utils.doubleParaString(this.getSaldo()) + '\n'
                + "Criação: " + this.pessoa.getDataDeCriacao() + '\n'
                + "*___________________________*";

    }

    public void depositar(double valor){
        if (valor > 0){
            this.setSaldo(getSaldo() + valor);

            System.out.println("Deposito Realizado Com Sucesso!");
        }
        else {
            System.out.println("Não foi possível realizar o depósito.");
        }
    }

    public void sacar(double valor){
        if (valor > 0 && getSaldo() >= valor){
            this.setSaldo(getSaldo() - valor);
            System.out.println("Saque Realizado Com Sucesso!");
        }
        else {
            System.out.println("Não foi possível realizar o saque.");
        }
    }

    public void transferir(Conta contaTransferencia,double valor){
        if (valor > 0 && this.getSaldo() >= valor){
            this.setSaldo(getSaldo() - valor);

            contaTransferencia.setSaldo(contaTransferencia.getSaldo() + valor);

            System.out.println("Transferência realizada com sucesso!");
        }
        else {
            System.out.println("Não foi possível realizar a transferência.");
        }
    }
}
