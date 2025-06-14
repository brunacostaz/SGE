package br.com.fiap.bean;

public class ItensMovimentados {
    private long idMovimentacao;
    private long idItem;
    private int quantidadeItem;

    public ItensMovimentados(long idMovimentacao, long idItem, int quantidadeItem) {
        this.idMovimentacao = idMovimentacao;
        this.idItem = idItem;
        this.quantidadeItem = quantidadeItem;
    }

    public long getIdMovimentacao() {
        return idMovimentacao;
    }

    public void setIdMovimentacao(long idMovimentacao) {
        this.idMovimentacao = idMovimentacao;
    }

    public long getIdItem() {
        return idItem;
    }

    public void setIdItem(long idItem) {
        this.idItem = idItem;
    }

    public int getQuantidadeItem() {
        return quantidadeItem;
    }

    public void setQuantidadeItem(int quantidadeItem) {
        this.quantidadeItem = quantidadeItem;
    }
}
