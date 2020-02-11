package br.com.caelum.contas.main;

import br.com.caelum.contas.modelo.Conta;
import br.com.caelum.contas.modelo.ContaCorrente;
import br.com.caelum.contas.ManipuladorDeContas;
import java.util.*;


public class TestaLista {

    public static void main(String[] args){
        Random random = new Random();
        List<Conta> contas = new LinkedList<Conta>();
        for(int i = 0; i<10;i++){
            ContaCorrente conta = new ContaCorrente();
            conta.setAgencia("0101");
            conta.setSaldo(random.nextInt(10000));
            conta.setNumero(123);
            conta.setTitular("Titular" + i);
            contas.add(conta);
        }
        System.out.println(contas);

    }
}
