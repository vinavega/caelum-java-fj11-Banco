package br.com.caelum.contas.modelo;

public interface Conta {


    public void setAgencia(String agencia);

    public void setNumero(int numero);

    public void setTitular(String titular);

    public void setSaldo(Double saldo);

    public int getNumero();

    public double getSaldo();

    public String getAgencia();

    public String getTitular();

    public void saca(double valor);

    public void deposita(double valor);

    public String getTipo();

    public void transfere(double valor, Conta conta);

    public String recuperaDadosParaImpressao();
}
