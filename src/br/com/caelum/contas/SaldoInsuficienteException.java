package br.com.caelum.contas;

public class SaldoInsuficienteException extends RuntimeException {

    public SaldoInsuficienteException(Double valor){
        super("Saldo insuficiente para sacar o valor de: " + valor);
    }

}
