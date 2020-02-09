package br.com.caelum.contas.main;

import java.util.*;

public class TestePerformanceFI {
    public static void main(String[] args){
        System.out.println("iniciando...");

        List<Integer> teste = new LinkedList<>();

        long inicio = System.currentTimeMillis();

        int total = 100000;

        for(int i =0;i<total;i++){
            teste.add(0, i);
        }

        long fiminsercao = System.currentTimeMillis();

        for(int i =0;i<total;i++){
            teste.get(i);
        }

        long fim = System.currentTimeMillis();
        long tempo = fim - inicio;
        System.out.println("Tempo de inserção: " + (fiminsercao - inicio));
        System.out.println("Tempo de busca: " + (fim - fiminsercao));
        System.out.println("Tempo gasto: " + tempo);

    }
}
