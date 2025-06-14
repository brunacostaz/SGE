package br.com.fiap.bean;

public class Funcionario {

    private long idFuncionario;
    private String nome;
    private String email;
    private long cpf;
    private String tipoConta;
    private long idArea;
    private long idLab;

    public Funcionario(long idFuncionario, String nome, String email, long cpf, String tipoConta, long idArea, long idLab) {
        this.idFuncionario = idFuncionario;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.tipoConta = tipoConta;
        this.idArea = idArea;
        this.idLab = idLab;
    }

    public long getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(long idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    public long getIdArea() {
        return idArea;
    }

    public void setIdArea(long idArea) {
        this.idArea = idArea;
    }

    public long getIdLab() {
        return idLab;
    }

    public void setIdLab(long idLab) {
        this.idLab = idLab;
    }

    public long retirarMaterials() {
        return System.currentTimeMillis();
    }

    public long reporMateriais() {
        return System.currentTimeMillis();
    }


}
