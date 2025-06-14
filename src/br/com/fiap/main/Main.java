package br.com.fiap.main;

import br.com.fiap.bean.AreasLab;
import br.com.fiap.bean.Laboratorio;
import br.com.fiap.bean.Materiais;

public class Main {
    public static void main(String[] args) {

        // === ÁREAS ===
        AreasLab area1 = new AreasLab(1, "Coleta", "Responsável pela coleta de amostras de sangue e urina.");
        AreasLab area2 = new AreasLab(2, "Análise Clínica", "Realiza exames laboratoriais de rotina.");
        AreasLab area3 = new AreasLab(3, "Triagem", "Área de recepção e pré-atendimento dos pacientes.");

        // === LABORATÓRIOS ===
        Laboratorio lab1 = new Laboratorio(1, "Dasa Unidade Paulista", "Rua da Saúde", "Paulista", "123", 01311000, "São Paulo");
        Laboratorio lab2 = new Laboratorio(2, "Dasa Unidade Vila Olímpia", "Av. dos Exames", "Vila Olímpia", "456", 04547000, "São Paulo");

        // === MATERIAIS ===
        Materiais mat1 = new Materiais(1, "Seringa 5ml", "QRCOD001", "Usada para coleta de sangue.");
        Materiais mat2 = new Materiais(2, "Algodão", "QRCOD002", "Algodão estéril para curativos.");
        Materiais mat3 = new Materiais(3, "Álcool 70%", "QRCOD003", "Álcool líquido para assepsia.");
        Materiais mat4 = new Materiais(4, "Tubo de ensaio", "QRCOD004", "Utilizado para armazenar amostras.");
        Materiais mat5 = new Materiais(5, "Luvas descartáveis", "QRCOD005", "Luvas de procedimento não cirúrgico.");

    }
}
