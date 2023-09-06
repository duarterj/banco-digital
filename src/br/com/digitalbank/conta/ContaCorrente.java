package br.com.digitalbank.conta;

import br.com.digitalbank.unidade.Unidade;
import br.com.digitalbank.cliente.Cliente;

public class ContaCorrente extends ContaBancaria {

    public ContaCorrente(Cliente cliente, Unidade banco) {
        super(cliente, banco);
    }

    public void imprimirExtrato () {
        System.out.println("===* Extrato Conta Corrente *===");
        super.extratoInformacoes();
        System.out.println("===============================");
    }
}
