package br.com.digitalbank;

import br.com.digitalbank.conta.ContaCorrente;
import br.com.digitalbank.conta.ContaPoupanca;
import br.com.digitalbank.unidade.Unidade;
import br.com.digitalbank.cliente.Cliente;

public class Main {

    public static void main(String[] args) {

        Unidade curicica = Unidade.CURICICA;
        Unidade taquara = Unidade.TAQUARA;

        Cliente clienteMaria = new Cliente("Maria Silveira", "19103487910");
        Cliente clienteEduardo = new Cliente("Eduardo Silveira", "13193486990");

        ContaCorrente cc = new ContaCorrente(clienteMaria, taquara);
        ContaPoupanca poupanca = new ContaPoupanca(clienteEduardo, curicica);

        poupanca.depositar(350);
        poupanca.transferir(75, cc);
        poupanca.imprimirExtrato();
        poupanca.sacar(75);

    }
}