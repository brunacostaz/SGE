package br.com.fiap.main;

import br.com.fiap.bean.*;
import javax.swing.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Inicialização dos objetos
        Funcionario admin = new Administrador(1, "Admin", "admin@lab.com", 12345L, "Administrador", 1, 1);
        Funcionario comum = new Funcionario(2, "Funcionário", "func@lab.com", 98765L, "Comum", 2, 1);

        Materiais luva = new Materiais(1, "Luvas Cirúrgicas", "QR001", "Luvas estéreis");
        Materiais mascara = new Materiais(2, "Máscara N95", "QR002", "Máscara de proteção");
        Materiais dipirona = new Materiais(3, "Dipirona", "QR003", "Analgésico e antitérmico");

        Estoque estoqueLuva = new Estoque(1, "Luvas Cirúrgicas", 1, 15, 101);
        Estoque estoqueMascara = new Estoque(2, "Máscara N95", 1, 12, 102);
        Estoque estoqueDipirona = new Estoque(3, "Dipirona", 1, 50, 103);

        // Sistema de Login
        Funcionario usuarioLogado = null;
        while (usuarioLogado == null) {
            try {
                long cpf = Long.parseLong(JOptionPane.showInputDialog(
                        "SISTEMA DE ESTOQUE\n\n" +
                                "CPFs para teste:\n" +
                                "Admin: 12345\n" +
                                "Comum: 98765\n\n" +
                                "Digite seu CPF:"));

                if (cpf == admin.getCpf()) {
                    usuarioLogado = admin;
                } else if (cpf == comum.getCpf()) {
                    usuarioLogado = comum;
                } else {
                    throw new Exception("CPF inválido!");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }

        // Menu Principal
        boolean executando = true;
        while (executando) {
            String menu = "MENU PRINCIPAL\n\n" +
                    "1. Retirar material\n" +
                    "2. Repor material\n";

            if (usuarioLogado.getTipoConta().equals("Administrador")) {
                menu += "3. Cadastrar preset\n" +
                        "4. Visualizar dashboard\n" +
                        "5. Sair";
            } else {
                menu += "3. Sair";
            }

            String opcao = JOptionPane.showInputDialog(menu);

            switch (opcao) {
                case "1": // Retirar material
                    String lista = "Materiais disponíveis:\n" +
                            "1. " + estoqueLuva.getNome() + " (" + estoqueLuva.consultarEstoque() + ")\n" +
                            "2. " + estoqueMascara.getNome() + " (" + estoqueMascara.consultarEstoque() + ")\n" +
                            "3. " + estoqueDipirona.getNome() + " (" + estoqueDipirona.consultarEstoque() + ")";

                    try {
                        int item = Integer.parseInt(JOptionPane.showInputDialog(lista + "\n\nNúmero do item:"));
                        int qnt = Integer.parseInt(JOptionPane.showInputDialog("Quantidade:"));

                        Estoque estoqueSelecionado = null;
                        Materiais materialSelecionado = null;

                        if (item == 1) {
                            estoqueSelecionado = estoqueLuva;
                            materialSelecionado = luva;
                        } else if (item == 2) {
                            estoqueSelecionado = estoqueMascara;
                            materialSelecionado = mascara;
                        } else if (item == 3) {
                            estoqueSelecionado = estoqueDipirona;
                            materialSelecionado = dipirona;
                        }

                        if (estoqueSelecionado != null && estoqueSelecionado.getQuantidadeAtual() >= qnt) {
                            estoqueSelecionado.diminuirEstoque(qnt);
                            estoqueSelecionado.alertaEstoqueBaixo();
                            long idMovimentacao = usuarioLogado.retirarMateriais();

                            // Cria e exibe o item movimentado
                            ItensMovimentados itemMov = new ItensMovimentados(
                                    idMovimentacao,
                                    estoqueSelecionado.getIdItem(),
                                    qnt
                            );

                            JOptionPane.showMessageDialog(null,
                                    itemMov.exibirEvento(materialSelecionado));

                            MovimentacaoEstoque mov = new MovimentacaoEstoque(
                                    idMovimentacao, "SAÍDA", LocalDate.now(),
                                    usuarioLogado.getIdArea(), usuarioLogado.getIdFuncionario(), usuarioLogado.getIdLab()
                            );
                            mov.exibirEvento();

                        } else {
                            JOptionPane.showMessageDialog(null, "Quantidade indisponível!");
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
                    }
                    break;

                case "2": // Repor material
                    lista = "Materiais disponíveis:\n" +
                            "1. " + estoqueLuva.getNome() + " (" + estoqueLuva.consultarEstoque() + ")\n" +
                            "2. " + estoqueMascara.getNome() + " (" + estoqueMascara.consultarEstoque() + ")\n" +
                            "3. " + estoqueDipirona.getNome() + " (" + estoqueDipirona.consultarEstoque() + ")";

                    try {
                        int item = Integer.parseInt(JOptionPane.showInputDialog(lista + "\n\nNúmero do item:"));
                        int qnt = Integer.parseInt(JOptionPane.showInputDialog("Quantidade:"));

                        Estoque estoqueSelecionado = null;
                        Materiais materialSelecionado = null;

                        if (item == 1) {
                            estoqueSelecionado = estoqueLuva;
                            estoqueSelecionado.aumentarEstoque(qnt);
                            materialSelecionado = luva;
                        } else if (item == 2) {
                            estoqueSelecionado = estoqueMascara;
                            String motivo = JOptionPane.showInputDialog("Motivo da reposição:");
                            estoqueSelecionado.aumentarEstoque(qnt, motivo);
                            materialSelecionado = mascara;
                        } else if (item == 3) {
                            estoqueSelecionado = estoqueDipirona;
                            estoqueSelecionado.aumentarEstoque(qnt, 200);
                            materialSelecionado = dipirona;
                        }

                        if (estoqueSelecionado != null) {
                            estoqueSelecionado.alertaEstoqueBaixo();
                            long idMovimentacao = usuarioLogado.reporMateriais();

                            ItensMovimentados itemMov = new ItensMovimentados(
                                    idMovimentacao,
                                    estoqueSelecionado.getIdItem(),
                                    qnt
                            );

                            JOptionPane.showMessageDialog(null,
                                    itemMov.exibirEvento(materialSelecionado));

                            MovimentacaoEstoque mov = new MovimentacaoEstoque(
                                    idMovimentacao, "ENTRADA", LocalDate.now(),
                                    usuarioLogado.getIdArea(), usuarioLogado.getIdFuncionario(), usuarioLogado.getIdLab()
                            );
                            mov.exibirEvento();
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
                    }
                    break;

                case "3":
                    if (usuarioLogado.getTipoConta().equals("Administrador")) {
                        Administrador adm = (Administrador) usuarioLogado;
                        JOptionPane.showMessageDialog(null, adm.cadastrarPreset());
                    } else {
                        executando = false;
                    }
                    break;

                case "4": // Dashboard (admin)
                    if (usuarioLogado.getTipoConta().equals("Administrador")) {
                        String mensagemDashboard = "📊 DASHBOARD 📊\n\n";
                        mensagemDashboard += "Estoque baixo:\n";

                        if (estoqueLuva.consultarEstoque() <= 10) {
                            mensagemDashboard += "- " + estoqueLuva.getNome() + "\n";
                        }
                        if (estoqueMascara.consultarEstoque() <= 10) {
                            mensagemDashboard += "- " + estoqueMascara.getNome() + "\n";
                        }
                        if (estoqueDipirona.consultarEstoque() <= 10) {
                            mensagemDashboard += "- " + estoqueDipirona.getNome() + "\n";
                        }

                        mensagemDashboard += "\nTotal de itens: 3";
                        JOptionPane.showMessageDialog(null, mensagemDashboard);
                    }
                    break;

                case "5": // Sair (admin)
                    executando = false;
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        }
        JOptionPane.showMessageDialog(null, "Sistema encerrado!");
    }
}