package br.com.caelum.contas;

import br.com.caelum.contas.modelo.Conta;
import br.com.caelum.contas.modelo.ContaCorrente;
import br.com.caelum.contas.modelo.ContaPoupanca;
import br.com.caelum.javafx.api.util.Evento;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Collections;
import java.util.List;

public class ManipuladorDeContas {
    private Conta conta;

    public void criaConta(Evento evento) {
        String tipo = evento.getSelecionadoNoRadio("tipo");
        if (tipo.equals("Conta Corrente")) {
            this.conta = new ContaCorrente();
        } else if (tipo.equals("Conta Poupança")) {
            this.conta = new ContaPoupanca();
        }
        this.conta.setAgencia(evento.getString("agencia"));
        this.conta.setNumero(evento.getInt("numero"));
        this.conta.setTitular(evento.getString("titular"));
        this.conta.setSaldo(0);
        System.out.println(conta);
    }

    public void saca(Evento evento) throws SaldoInsuficienteException {
        double valorDigitado = evento.getDouble("valorOperacao");
        this.conta.saca(valorDigitado);
    }

    public void deposita(Evento evento) {
        double valorDigitado = evento.getDouble("valorOperacao");
        this.conta.deposita(valorDigitado);
    }

    public void transfere(Evento evento) throws SaldoInsuficienteException {
        Conta destino = (Conta) evento.getSelecionadoNoCombo("destino");
        conta.transfere(evento.getDouble("valorTransferencia"), destino);
    }

    public void ordenaLista(Evento evento){
        List<Conta> contas = evento.getLista("destino");
        Collections.sort(contas);
    }

    public void salvaDados(Evento evento) throws FileNotFoundException {
        List<Conta> contas = evento.getLista("listaContas");
        RepositorioDeContas repositorio = new RepositorioDeContas();
        repositorio.salva(contas);
    }
    public List<Conta> carregaDados() throws FileNotFoundException {
        RepositorioDeContas repositorio = new RepositorioDeContas();
        return repositorio.carrega();
    }
}
