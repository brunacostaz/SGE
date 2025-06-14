package br.com.fiap.bean;

public class Materiais {

    private long idItem;
    private String nome;
    private String qrcode;
    private String descricao;

    public Materiais(long idItem, String nome, String qrcode, String descricao) {
        this.idItem = idItem;
        this.nome = nome;
        this.qrcode = qrcode;
        this.descricao = descricao;
    }

    public long getIdItem() {
        return idItem;
    }

    public void setIdItem(long idItem) {
        this.idItem = idItem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void cadastrarPreset(String nome) {
        System.out.println("Material associado ao preset: " + nome);
    }
}
