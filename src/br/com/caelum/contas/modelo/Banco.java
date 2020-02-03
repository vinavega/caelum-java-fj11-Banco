package br.com.caelum.contas.modelo;

public class Banco {
    private String nome;
    private int numero;
    private Conta[] contas;

    public Banco(String nome, int numero) {
        this.nome = nome;
        this.numero = numero;
        this.contas = new Conta[10];
    }

    public int getNumero() {
        return numero;
    }

    public String getNome() {
        return nome;
    }

    public void adiciona(Conta conta) {
        for (int i = 0; i < this.contas.length; i++) {
            if (this.contas[i] == null) {
                this.contas[i] = conta;
                i = 10;
            }
        }

    }

    public void mostraContas() {
        for (int i = 0; i < this.contas.length; i++) {
            if (this.contas[i] != null) {
                System.out.println("Conta da posição " + i + ": " + this.contas[i]);
            }

        }

    }
    public boolean contem(Conta conta){
        for (int i=0; this.contas[i] != null; i++){
            if (this.contas[i].equals(conta)){
                System.out.println("Conta encontrada" + conta);
                return true;
            }
        }
        return false;
    }
}
