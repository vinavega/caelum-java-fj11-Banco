package br.com.caelum.contas.modelo;

import br.com.caelum.contas.SaldoInsuficienteException;

public class ContaCorrente extends Conta implements Tributavel {
    public String getTipo() {
        return "Conta Corrente";
    }

    public void saca(double valor) throws SaldoInsuficienteException {
        if (valor <= 0){
            throw new IllegalArgumentException("Valor inválido," + "só é possível sacar valores positivos");
        }
        else if (this.saldo < (valor + 0.1)) {
            throw new SaldoInsuficienteException(valor);
        } else {
            this.saldo -= (valor + 0.1);
        }
    }

    @Override
    public double getValorImposto() {
        return this.getSaldo() * 0.01;
    }

}
