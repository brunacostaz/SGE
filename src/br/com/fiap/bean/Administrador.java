package br.com.fiap.bean;

import javax.swing.*;
import java.time.LocalDate;

public class Administrador extends Funcionario {

    public Administrador(long idFuncionario, String nome, String email, long cpf, String tipoConta, long idArea, long idLab) {
        super(idFuncionario, nome, email, cpf, tipoConta, idArea, idLab);
    }

    public void cadastrarPreset() {
        try {

            long idPreset = Long.parseLong(JOptionPane.showInputDialog("ID do Preset:"));
            String nome = JOptionPane.showInputDialog("Nome do Preset:");
            String descricao = JOptionPane.showInputDialog("Descrição do Preset:");

            LocalDate dataCriacao = LocalDate.now();
            LocalDate ultimaAtualizacao = LocalDate.now();

            Presets preset = new Presets(idPreset, nome, descricao, this.getNome(), dataCriacao, ultimaAtualizacao);
            preset.salvar();

            boolean continuar = true;
            while (continuar) {

                String listaMateriais =
                        "📦 Materiais Disponíveis:\n" +
                                "1 - Luvas Cirúrgicas\n" +
                                "2 - Máscara N95\n" +
                                "3 - Dipirona\n" +
                                "4 - Álcool 70%\n" +
                                "5 - Adrenalina";

                JOptionPane.showMessageDialog(null, listaMateriais);

                // Coleta dados do material para o preset
                long idMaterial = Long.parseLong(JOptionPane.showInputDialog("Digite o ID do Material que deseja adicionar:"));
                int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade para este material:"));

                // Cria o PresetMaterial
                PresetsMateriais pm = new PresetsMateriais(idMaterial, idPreset, quantidade);
                pm.salvar();

                int opcao = JOptionPane.showConfirmDialog(null, "Deseja adicionar outro material?", "Continuar?", JOptionPane.YES_NO_OPTION);
                if (opcao != JOptionPane.YES_OPTION) {
                    continuar = false;
                }
            }

            JOptionPane.showMessageDialog(null, "✅ Preset cadastrado com sucesso!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "❌ Erro inesperado: " + e.getMessage());
        }
    }
}
