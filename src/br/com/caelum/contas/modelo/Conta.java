package br.com.caelum.contas.modelo;

import br.com.caelum.contas.SaldoInsuficienteException;

import java.util.Objects;

public abstract class Conta implements Comparable<Conta> {
    protected double saldo;
    private int numero;
    private String titular;
    private String agencia;
    private String tipo;


    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setTitular(String titular) {
        this.titular = titular;
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

    public void saca(double valor) throws SaldoInsuficienteException {
        if (this.saldo < valor) {
            throw new SaldoInsuficienteException(valor);
        } else {
            this.saldo -= valor;
        }
    }

    public void deposita(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor inválido," + "só é possível depositar valores positivos");
        } else {
            this.saldo += valor;
        }
    }

    public abstract String getTipo();

    public void transfere(double valor, Conta conta) throws SaldoInsuficienteException {
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

    @Override
    public String toString() {
        return titular.toUpperCase() + " Saldo:  " + saldo;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        Conta outraConta = (Conta) obj;
        return this.numero == outraConta.numero &&
                this.agencia.equals(outraConta.agencia);
    }

    @Override
    public int compareTo(Conta outraConta) {
        return this.titular.compareTo(outraConta.titular);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero, agencia);
    }
}
