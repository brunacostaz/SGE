package br.com.fiap.bean;

public class Laboratorio {

    private long idLab;
    private String nome;
    private String rua;
    private String bairro;
    private String numero;
    private int cep;
    private String cidade;

    public Laboratorio(long idLab, String nome, String rua, String bairro, String numero, int cep, String cidade) {
        this.idLab = idLab;
        this.nome = nome;
        this.rua = rua;
        this.bairro = bairro;
        this.numero = numero;
        this.cep = cep;
        this.cidade = cidade;
    }

    public long getIdLab() {
        return idLab;
    }

    public void setIdLab(long idLab) {
        this.idLab = idLab;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
