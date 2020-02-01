package br.com.caelum.contas.modelo;

public class ContaCorrente extends Conta {
    @Override
    public String getTipo() {
        return super.getTipo() + "Corrente";
    }

    @Override
    public void saca(double valor) {
        this.saldo -= (valor + 0.1);
    }
}
