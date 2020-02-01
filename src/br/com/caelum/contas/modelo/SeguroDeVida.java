package br.com.caelum.contas.modelo;

public class SeguroDeVida implements Tributavel {

    private double valor;
    private String titular;
    private int numeroApolice;

    @Override
    public double getValorImposto() {
        return 42 + this.valor * 0.02;
    }

    public String getTipo() {
        return "Seguro de Vida";
    }

    public int getNumeroApolice() {
        return this.numeroApolice;
    }

    public double getValor() {
        return this.valor;
    }

    public String getTitular() {
        return this.titular;
    }

    public void setNumeroApolice(int numeroApolice) {
        this.numeroApolice = numeroApolice;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
