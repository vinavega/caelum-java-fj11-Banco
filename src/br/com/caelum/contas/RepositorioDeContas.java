package br.com.caelum.contas;

import br.com.caelum.contas.modelo.Conta;
import br.com.caelum.contas.modelo.ContaCorrente;
import br.com.caelum.contas.modelo.ContaPoupanca;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class RepositorioDeContas {

    private Conta conta;

    public void salva(List<Conta> contas) throws FileNotFoundException {
        PrintStream stream = new PrintStream("contas.txt");
        for (Conta conta : contas) {
            stream.println(conta.getTipo() + "," + conta.getNumero() + ","
                    + conta.getAgencia() + "," + conta.getTitular() + ","
                    + conta.getSaldo());
        }
        stream.close();
    }

    public List<Conta> carrega() throws FileNotFoundException {
        File file = new File("contas.txt");
        Scanner scanner = new Scanner(file);
        List<Conta> contas = new LinkedList<>();
        while (scanner.hasNextLine()){
            String linha = scanner.nextLine();
            String[] valores = linha.split(",");
            String tipo = valores[0];
            String numero = valores[1];
            String agencia = valores[2];
            String titular = valores[3];
            String saldo = valores[4];
            if (tipo.equals("Conta corrente")) {
                conta = new ContaCorrente();
            } else {
                conta = new ContaPoupanca();
            }
            this.conta.setTitular(titular);
            this.conta.setTipo(tipo);
            this.conta.setAgencia(agencia);
            Double dbsaldo = Double.valueOf(saldo);
            this.conta.setSaldo(dbsaldo);
            int intnumero = Integer.parseInt(numero);
            this.conta.setNumero(intnumero);

            contas.add(conta);

        }
        return contas;
    }
}
