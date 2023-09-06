package br.com.digitalbank.conta;

import br.com.digitalbank.unidade.Unidade;
import br.com.digitalbank.cliente.Cliente;

public class ContaPoupanca extends ContaBancaria {

    public ContaPoupanca(Cliente cliente, Unidade banco) {
        super(cliente, banco);
    }

    public void imprimirExtrato () {
        System.out.println("===* Extrato Conta Poupança *===");
        super.extratoInformacoes();
        System.out.println("===============================");
    }
}
