package br.com.caelum.contas.main;

import br.com.caelum.contas.modelo.*;
import java.util.*;


public class TestaMapa {
    public static void main(String[] args){
        Conta c1 = new ContaCorrente();
        c1.deposita(1000);

        Conta c2 = new ContaCorrente();
        c2.deposita(3000);

        Map<Object, Object> mapaDeContas = new HashMap<>();

        mapaDeContas.put("diretor", c1);
        mapaDeContas.put("gerente", c2);
        Conta contaDoDiretor = (Conta) mapaDeContas.get("gerente");
        System.out.println(contaDoDiretor.getSaldo());


    }
}
