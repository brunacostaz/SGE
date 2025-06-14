package br.com.fiap.bean;

import javax.swing.*;
import java.time.LocalDate;

public class Administrador extends Funcionario {

    public Administrador(long idFuncionario, String nome, String email, long cpf, String tipoConta, long idArea, long idLab) {
        super(idFuncionario, nome, email, cpf, tipoConta, idArea, idLab);
    }

    public String cadastrarPreset() {
        try {
            String nomePreset = JOptionPane.showInputDialog("Nome do Preset:");
            if (nomePreset == null || nomePreset.trim().isEmpty()) {
                return "Cadastro cancelado!";
            }

            String descricao = JOptionPane.showInputDialog("Descrição do Preset:");

            Presets novoPreset = new Presets(
                    System.currentTimeMillis(),
                    nomePreset,
                    descricao,
                    this.getNome(),
                    LocalDate.now(),
                    LocalDate.now()
            );

            novoPreset.salvar();
            return "✅ Preset '" + nomePreset + "' cadastrado com sucesso!";

        } catch (Exception e) {
            return "❌ Erro ao cadastrar preset: " + e.getMessage();
        }
    }
}
