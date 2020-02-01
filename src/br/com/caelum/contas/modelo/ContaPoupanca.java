package br.com.caelum.contas.modelo;

public class ContaPoupanca extends Conta {
    @Override
    public String getTipo() {
        return super.getTipo() + "Poupanca";
    }
}
