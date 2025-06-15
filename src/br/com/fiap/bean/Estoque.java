package br.com.fiap.bean;

import javax.swing.*;

public class Estoque {

    private long idItem;
    private String nome;
    private long idLaboratorio;
    private int quantidadeAtual;
    private long idLote;

    public Estoque(long idItem, String nome, long idLaboratorio, int quantidadeAtual, long idLote) {
        this.idItem = idItem;
        this.nome = nome;
        this.idLaboratorio = idLaboratorio;
        this.quantidadeAtual = quantidadeAtual;
        this.idLote = idLote;
    }

    public long getIdItem() {
        return idItem;
    }

    public void setIdItem(long idItem) {
        this.idItem = idItem;
    }

    public long getIdLaboratorio() {
        return idLaboratorio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdLaboratorio(long idLaboratorio) {
        this.idLaboratorio = idLaboratorio;
    }

    public int getQuantidadeAtual() {
        return quantidadeAtual;
    }

    public void setQuantidadeAtual(int quantidadeAtual) {
        this.quantidadeAtual = quantidadeAtual;
    }

    public long getIdLote() {
        return idLote;
    }

    public void setIdLote(long idLote) {
        this.idLote = idLote;
    }

    public void alertaEstoqueBaixo() {
        if (this.quantidadeAtual <= 10) {
            String mensagem = String.format(
                    "⚠️ ALERTA: Estoque baixo de %s! Quantidade atual: %d",
                    this.nome,
                    this.quantidadeAtual
            );
            JOptionPane.showMessageDialog(null, mensagem, "ALERTA DE ESTOQUE", JOptionPane.WARNING_MESSAGE);
        }
    }

    public int consultarEstoque() {
        String message = String.format("%s: %d", this.nome, this.quantidadeAtual);
        JOptionPane.showMessageDialog(null, message, "Estoque", JOptionPane.INFORMATION_MESSAGE);
        return this.quantidadeAtual;
    }

    public void aumentarEstoque(int qnt) {
        this.quantidadeAtual += qnt;
    }

    public void aumentarEstoque(int quantidade, String motivo) {
        this.quantidadeAtual += quantidade;
        JOptionPane.showMessageDialog(null,
                "Estoque aumentado em " + quantidade + " unidades. Motivo: " + motivo);
    }

    public void aumentarEstoque(int quantidade, int limiteMaximo) {
        if ((this.quantidadeAtual + quantidade) > limiteMaximo) {
            JOptionPane.showMessageDialog(null,
                    "Atenção: Limite máximo de " + limiteMaximo + " unidades atingido!");
        } else {
            this.quantidadeAtual += quantidade;
        }
    }

    public void diminuirEstoque(int qnt) {
        if (qnt <= 0) {
            JOptionPane.showMessageDialog(null, "Quantidade inválida!");
            return;
        } else if (this.quantidadeAtual >= qnt) {
            this.quantidadeAtual -= qnt;
        } else {
            JOptionPane.showMessageDialog(null, "Quantidade indisponível! Disponível: " + this.quantidadeAtual);
        }
    }
}
