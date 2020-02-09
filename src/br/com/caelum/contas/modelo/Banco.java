package br.com.caelum.contas.modelo;

import java.util.*;

public class Banco {
    private String nome;
    private int numero;
    private Set<Conta>contas;
    private Map<String, Conta> mapTitular;

    public Banco(String nome, int numero) {
        this.nome = nome;
        this.numero = numero;
        this.contas = new HashSet<>();
        this.mapTitular = new HashMap<>();
    }

    public int getNumero() {
        return numero;
    }

    public String getNome() {
        return nome;
    }

    public void adiciona(Conta conta) {
       contas.add(conta);
       mapTitular.put(conta.getTitular(), conta);
    }

    public void mostraContas() {
        for (Conta conta : contas) {
            if (conta != null) {
                System.out.println(conta);
            }

        }

    }
    public boolean contem(Conta conta){
        for (Conta contaAux : contas){
            if (contaAux.equals(conta)){
                System.out.println("Conta encontrada" + conta);
                return true;
            }
        }
        return false;
    }

    public int pegaQuantidadeDeContas(){
        return contas.size();
    }


    public Conta buscaPorTitular(String nome){
        return mapTitular.get(nome);

    }

}
