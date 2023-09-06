package br.com.digitalbank.conta;

import br.com.digitalbank.unidade.Unidade;
import br.com.digitalbank.cliente.Cliente;

public abstract class ContaBancaria implements IConta {
    private static final String BANCO = "Digital Bank";
    private static int SEQUENCIAL = 1;
    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;
    protected Unidade unidade;

    public ContaBancaria(Cliente cliente, Unidade unidade) {
        this.cliente = cliente;
        this.unidade = unidade;
        this.numero = SEQUENCIAL++;
        definirAgencia();
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
        definirAgencia();
    }

    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            System.out.println(String.format("Deposito de: %.2f$", valor) + " efetuado com sucesso!");
            System.out.println(String.format("Saldo atual da conta de: " + this.cliente.getNome() + " é de: %.2f$", this.saldo));
            System.out.println("===============================");
        } else {
            System.out.println("O depósito não foi efetuado!");
        }
    }

    public void sacar(double valor) {
        if (valor <= this.saldo) {
            this.saldo -= valor;
            System.out.println(String.format("Saque de: %.2f$", valor) + " efetuado com sucesso!");
            System.out.println(String.format("Saldo atual da conta de: " + this.cliente.getNome() + " é de: %.2f$", this.saldo));
            System.out.println("===============================");
        } else {
            System.out.println("Saldo Insuficiente");
        }
    }

    public void transferir(double valor, ContaBancaria contaDestino) {
        if (valor <= this.saldo) {
            this.saldo -= valor;
            contaDestino.saldo += valor;
            System.out.println(String.format("Transferência de: %.2f$", valor) + " efetuada com sucesso!");
            System.out.println("Para: " + contaDestino.cliente.getNome() + " CPF: " + contaDestino.cliente.getCpf());
            System.out.println("===============================");
        } else {
            System.out.println("Saldo Insuficiente");
        }

    }

    protected void extratoInformacoes() {
        System.out.println("Banco: " + this.BANCO);
        System.out.println("Unidade: " + this.unidade);
        System.out.println("Titular da conta: " + this.cliente.getNome());
        System.out.println(String.format("Agência: %d", this.agencia));
        System.out.println(String.format("Número: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f$", this.saldo));
    }

    private void definirAgencia() {
        if (this.unidade == Unidade.TIJUCA) {
            this.agencia = 10;
        } else if (this.unidade == Unidade.CURICICA) {
            this.agencia = 20;
        } else if (this.unidade == Unidade.TAQUARA) {
            this.agencia = 30;
        }
    }
}
