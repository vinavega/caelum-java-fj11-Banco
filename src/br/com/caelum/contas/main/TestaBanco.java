package br.com.caelum.contas.main;

import br.com.caelum.contas.modelo.Banco;
import br.com.caelum.contas.modelo.Conta;
import br.com.caelum.contas.modelo.ContaCorrente;
import br.com.caelum.contas.modelo.ContaPoupanca;

public class TestaBanco {
    public static void main(String[] args) {
        Banco banco = new Banco("caelum bank", 999);

        for (int i = 1; i < 7; i++) {
            ContaCorrente conta = new ContaCorrente();
            conta.setTitular("usuario" + i);
            conta.setNumero(i);
            conta.setAgencia("100");
            conta.deposita(100000 + i);
            banco.adiciona(conta);
        }
        banco.mostraContas();


        System.out.println("qtde contas: "+ banco.pegaQuantidadeDeContas());
        String nomeUsuario = "usuario4";
        System.out.println("Busca por nome de "+ nomeUsuario + ": "+banco.buscaPorTitular(nomeUsuario));
    }

}
