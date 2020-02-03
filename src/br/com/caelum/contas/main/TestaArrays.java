package br.com.caelum.contas.main;

import br.com.caelum.contas.modelo.Conta;
import br.com.caelum.contas.modelo.ContaCorrente;

public class TestaArrays {
    public static void main(String[] args){
        Conta[] contas = new Conta[10];
        for(int i = 0; i < 10; i++){
            Conta conta = new ContaCorrente();
            conta.deposita(i * 100.0 + 1);
            contas[i] = conta;
        }
        double mediaSaldo = 0;
        for(int i = 0; i< contas.length; i++ ){
            mediaSaldo += contas[i].getSaldo();
            System.out.println("saldo conta nro"+ i +": "+ contas[i].getSaldo());
        }
        System.out.println("media saldo = " + mediaSaldo/contas.length);
    }
}
