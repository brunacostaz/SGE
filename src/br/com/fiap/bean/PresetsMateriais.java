package br.com.fiap.bean;

public class PresetsMateriais {
    private long idItem;
    private long idPreset;
    private int quantidadeItens;

    public PresetsMateriais(long idItem, long idPreset, int quantidadeItens) {
        this.idItem = idItem;
        this.idPreset = idPreset;
        this.quantidadeItens = quantidadeItens;
    }

    public long getIdItem() {
        return idItem;
    }

    public void setIdItem(long idItem) {
        this.idItem = idItem;
    }

    public long getIdPreset() {
        return idPreset;
    }

    public void setIdPreset(long idPreset) {
        this.idPreset = idPreset;
    }

    public int getQuantidadeItens() {
        return quantidadeItens;
    }

    public void setQuantidadeItens(int quantidadeItens) {
        this.quantidadeItens = quantidadeItens;
    }

    public void salvar() {
        System.out.println("Material " + idItem + " com " + quantidadeItens + " unidades adicionado ao preset " + idPreset);
    }
}
