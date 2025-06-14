package br.com.fiap.bean;

import javax.swing.*;
import java.time.LocalDate;

public class MovimentacaoEstoque {

    private long idMovimentacao;
    private String tipo;
    private LocalDate data;
    private long idArea;
    private long idFuncionario;
    private long idLab;

    public MovimentacaoEstoque(long idMovimentacao, String tipo, LocalDate data, long idArea, long idFuncionario, long idLab) {
        this.idMovimentacao = idMovimentacao;
        this.tipo = tipo;
        this.data = data;
        this.idArea = idArea;
        this.idFuncionario = idFuncionario;
        this.idLab = idLab;
    }

    public long getIdMovimentacao() {
        return idMovimentacao;
    }

    public void setIdMovimentacao(long idMovimentacao) {
        this.idMovimentacao = idMovimentacao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public long getIdArea() {
        return idArea;
    }

    public void setIdArea(long idArea) {
        this.idArea = idArea;
    }

    public long getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(long idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public long getIdLab() {
        return idLab;
    }

    public void setIdLab(long idLab) {
        this.idLab = idLab;
    }

    public void exibirEvento() {
        String mensagem = String.format(
                "📦 Evento de Movimentação de Estoque 📦\n\n" +
                        "ID da Movimentação: %d\n" +
                        "Tipo: %s\n" +
                        "Data: %s\n" +
                        "ID da Área: %d\n" +
                        "ID do Funcionário: %d\n" +
                        "ID do Laboratório: %d",
                idMovimentacao,
                tipo,
                data.toString(),
                idArea,
                idFuncionario,
                idLab
        );

        JOptionPane.showMessageDialog(null, mensagem, "Detalhes da Movimentação", JOptionPane.INFORMATION_MESSAGE);
    }
}
