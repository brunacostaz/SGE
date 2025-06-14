package br.com.fiap.bean;

import java.time.LocalDate;

public class Presets {
    private long idPreset;
    private String nome;
    private String descricao;
    private String criador;
    private LocalDate dataCriacao;
    private LocalDate ultimaAtualizacao;

    public Presets(long idPreset, String nome, String descricao, String criador, LocalDate dataCriacao, LocalDate ultimaAtualizacao) {
        this.idPreset = idPreset;
        this.nome = nome;
        this.descricao = descricao;
        this.criador = criador;
        this.dataCriacao = dataCriacao;
        this.ultimaAtualizacao = ultimaAtualizacao;
    }

    public long getIdPreset() {
        return idPreset;
    }

    public void setIdPreset(long idPreset) {
        this.idPreset = idPreset;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCriador() {
        return criador;
    }

    public void setCriador(String criador) {
        this.criador = criador;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDate getUltimaAtualizacao() {
        return ultimaAtualizacao;
    }

    public void setUltimaAtualizacao(LocalDate ultimaAtualizacao) {
        this.ultimaAtualizacao = ultimaAtualizacao;
    }

    public void salvar() {
        System.out.println("Preset salvo: " + nome + " por " + criador);
    }
}
