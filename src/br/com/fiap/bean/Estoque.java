package br.com.fiap.bean;

import javax.swing.*;

public class Estoque {

    private long idItem;
    private String nome;
    private long idLaboratorio;
    private int quantidadeAtual;
    private long idLote;

    public Estoque(long idItem, long idLaboratorio, int quantidadeAtual, long idLote) {
        this.idItem = idItem;
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
            String message = String.format("%s está com %d unidades. Favor providenciar compras com o fornecedor!", this.nome, this.quantidadeAtual);
            JOptionPane.showMessageDialog(null, message, "ALERTA", JOptionPane.WARNING_MESSAGE);
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

    public void diminuirEstoque(int qnt) {
        this.quantidadeAtual -= qnt;
    }
}
