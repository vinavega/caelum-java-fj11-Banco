package br.com.caelum.contas.modelo;

public class ContaCorrente implements ContaTributavel {

    protected double saldo;
    private int numero;
    private String titular;
    private String agencia;

    public String getTipo() {
        return "Conta Corrente";
    }

    public void saca(double valor) {
        this.saldo -= (valor + 0.1);
    }

    public double getValorImposto() {
        return this.getSaldo() * 0.01;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public void setSaldo(Double saldo) {

    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getAgencia() {
        return agencia;
    }

    public String getTitular() {
        return titular;
    }


    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }


    public void deposita(double valor) {
        this.saldo += valor;
    }


    public void transfere(double valor, Conta conta) {
        this.saca(valor);
        conta.deposita(valor);
    }

    public String recuperaDadosParaImpressao() {
        String dados = "Titular: " + this.titular;
        dados += "\nNúmero: " + this.numero;
        dados += "\nAgência: " + this.agencia;
        dados += "\nSaldo: R$" + this.saldo;
        dados += "\nTipo: " + this.getTipo();
        return dados;
    }
}
