package Aplicacao;

import ClassesDaAplicacao.Conta;
import ClassesDaAplicacao.Pessoa;

import java.util.ArrayList;
import java.util.Scanner;

public class AplicacaoBancaria {

    static Scanner get = new Scanner(System.in);
    static ArrayList<Conta> contasBancarias;

    public static void main(String[] args) {
        contasBancarias = new ArrayList<>();
        menuDeOperacoes();
    }

    public static void menuDeOperacoes(){

        System.out.println("------------------------------------------------------");
        System.out.println("-------------Bem vindos a nossa Agência---------------");
        System.out.println("------------------------------------------------------");
        System.out.println("***** Selecione uma operação que deseja realizar *****");
        System.out.println("------------------------------------------------------");
        System.out.println("             |   Opção 1 - Criar conta   |");
        System.out.println("             |   Opção 2 - Depositar     |");
        System.out.println("             |   Opção 3 - Sacar         |");
        System.out.println("             |   Opção 4 - Transferir    |");
        System.out.println("             |   Opção 5 - Listar        |");
        System.out.println("             |   Opção 6 - dados da conta|");
        System.out.println("             |   Opção 7 - Sair          |");
        System.out.println();
        System.out.print(">>>: ");

        int opcao = get.nextInt();
        get.nextLine();
        pulaLinhas();

        switch(opcao){
            case 1:
                criarConta();
                break;
            case 2:
                depositar();
                break;
            case 3:
                sacar();
                break;
            case 4:
                transferir();
                break;
            case 5:
                listarContas();
                break;
            case 6:
                dadosDaConta();
                break;
            case 7:
                System.exit(0);
            default:
                System.out.println("Opção Inválida");
                menuDeOperacoes();
                break;
        }
    }
    //Função para Criar uma nova conta
    public static void criarConta(){
        System.out.println("#### CRIANDO UMA NOVA CONTA ####");

        System.out.print("Nome: ");
        String nome = get.nextLine();

        System.out.print("CPF: ");
        String cpf = get.nextLine();

        System.out.print("E-mail: ");
        String email = get.nextLine();

        Pessoa novoCliente = new Pessoa(nome, cpf, email);

        int primeiroDeposito;
       do {
           System.out.println("Deseja realizar um depósito inicial?(1)sim/(2)não:");
           primeiroDeposito = get.nextInt();
           get.nextLine();

            if (primeiroDeposito == 1) {
                System.out.println("Valor do depósito inicial:");
                int depositoInicial = get.nextInt();
                get.nextLine();

                Conta novaConta = new Conta(novoCliente, depositoInicial);
                contasBancarias.add(novaConta);
            }
            else if (primeiroDeposito == 2){
                Conta novaConta = new Conta(novoCliente);
                contasBancarias.add(novaConta);
            }
            else {
                System.out.println("Opção Inválida.");
            }
        } while (primeiroDeposito != 1 && primeiroDeposito != 2);

        pulaLinhas();
        System.out.println("Conta criada com sucesso!");
        System.out.println();
        menuDeOperacoes();
    }

    public static Conta encontrarConta(int numeroConta){
        Conta conta = null;
        if (!contasBancarias.isEmpty()){
            for(Conta listaContas : contasBancarias){
                if (listaContas.getNumeroConta() == numeroConta){
                    conta = listaContas;
                }
            }
        }
        return conta;
    }

    public static void depositar(){
        System.out.println("### OPÇÃO DE DEPÓSITO ###");

        System.out.println("Insira o número da conta:");
        int numeroConta = get.nextInt();
        get.nextLine();

        Conta conta = encontrarConta(numeroConta);

        if (conta != null){
            System.out.println("Quanto deseja depositar: ");
            double valor = get.nextDouble();
            get.nextLine();

            conta.depositar(valor);
        }
        else {
            System.out.println("-----não foi possível depositar------");
        }

        pulaLinhas();
        System.out.printf("Novo saldo: RS %.2f\n", conta.getSaldo());

        menuDeOperacoes();
    }

    public static void sacar(){
        System.out.println("Insira o número da conta:");
        int numeroConta = get.nextInt();
        get.nextLine();

        Conta conta = encontrarConta(numeroConta);

        if (conta != null){
            System.out.println("Quanto deseja sacar: ");
            double valor = get.nextDouble();
            get.nextLine();

            conta.sacar(valor);
        }
        else {
            System.out.println("-----não foi possível realizar saque------");
        }

        pulaLinhas();
        System.out.printf("Novo saldo: RS %.2f\n", conta.getSaldo());

        menuDeOperacoes();
    }

    public static void transferir(){
        System.out.println("Insira o número da conta:");
        int numeroConta = get.nextInt();
        get.nextLine();

        Conta conta = encontrarConta(numeroConta);

        if (conta != null){
            System.out.println("Número da conta que deseja realizar a transferência:");
            int numeroContaTransf = get.nextInt();
            get.nextLine();

            Conta contaTransf = encontrarConta(numeroContaTransf);

            if (contaTransf != null){
                System.out.println("Valor da transferência:");
                double valorTransf = get.nextDouble();
                get.nextLine();

                conta.transferir(contaTransf, valorTransf);
            }
            else
            {
                System.out.println("Conta de transferência não existe.");
            }
        }
        else
        {
            System.out.println("Conta não existente");
        }
        pulaLinhas();
        System.out.printf("Novo saldo: RS %.2f\n", conta.getSaldo());

        menuDeOperacoes();
    }

    public static void listarContas(){
        if (!contasBancarias.isEmpty()){
            for (Conta contas : contasBancarias){
                System.out.println(contas);
                System.out.println("________________________");
            }
        }
        else
        {
            System.out.println("Não há contas cadastradas");
        }

        System.out.println("Precione ENTER para retornar ao MENU:");
        get.nextLine();

        menuDeOperacoes();
    }

    public static void dadosDaConta(){
        System.out.println("Indique o número da conta");
        int numeroConta = get.nextInt();
        get.nextLine();

        Conta conta = encontrarConta(numeroConta);

        if (conta != null){
            System.out.println(conta);
        }else {
            System.out.println("Conta não cadastrada.");
        }

        System.out.println("Precione ENTER para retornar ao MENU:");
        get.nextLine();

        menuDeOperacoes();
    }

    public static void pulaLinhas(){
        for (int i = 0; i < 50; i++){
            System.out.println(">");
        }
    }
}