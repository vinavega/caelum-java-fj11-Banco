package br.com.caelum.contas.modelo;

public class ContaCorrente extends Conta implements Tributavel {
    public String getTipo() {
        return "Conta Corrente";
    }

    public void saca(double valor) {
        if (this.saldo < (valor + 0.1)) {
            throw new IllegalArgumentException("Saldo Insuficiente");
        } else {
            this.saldo -= (valor + 0.1);
        }
    }

    @Override
    public double getValorImposto() {
        return this.getSaldo() * 0.01;
    }
}
