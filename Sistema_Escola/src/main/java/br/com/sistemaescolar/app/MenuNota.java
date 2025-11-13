package br.com.sistemaescolar.app;

import br.com.sistemaescolar.controller.NotaController;
import br.com.sistemaescolar.controller.AlunoController;
import br.com.sistemaescolar.controller.DisciplinaController;
import br.com.sistemaescolar.model.Aluno;
import br.com.sistemaescolar.model.Disciplina;

import java.util.Scanner;

public class MenuNota {

    public static void exibirMenu(Scanner scanner, NotaController notaController,
                                  AlunoController alunoController, DisciplinaController disciplinaController) {
        while (true) {
            System.out.println("\n--- Menu Nota ---");
            System.out.println("1. Criar nota");
            System.out.println("2. Exibir nota");
            System.out.println("3. Atualizar nota");
            System.out.println("4. Remover nota");
            System.out.println("0. Voltar");
            System.out.print("Opção: ");
            int op = Integer.parseInt(scanner.nextLine());
            switch (op) {
                case 1 -> {
                    System.out.print("ID do aluno: ");
                    Long idAluno = Long.parseLong(scanner.nextLine());
                    Aluno aluno = alunoController.buscarPorId(idAluno);
                    if (aluno == null) break;

                    System.out.print("ID da disciplina: ");
                    Long idDisc = Long.parseLong(scanner.nextLine());
                    Disciplina disc = disciplinaController.buscarPorId(idDisc);
                    if (disc == null) break;

                    System.out.print("Nota: ");
                    double valor = Double.parseDouble(scanner.nextLine());
                    notaController.criarNota(valor, aluno, disc);
                }
                case 2 -> {
                    System.out.print("ID da nota: ");
                    Long id = Long.parseLong(scanner.nextLine());
                    notaController.exibirNota(id);
                }
                case 3 -> {
                    System.out.print("ID da nota: ");
                    Long id = Long.parseLong(scanner.nextLine());

                    System.out.print("ID do aluno: ");
                    Long idAluno = Long.parseLong(scanner.nextLine());
                    Aluno aluno = alunoController.buscarPorId(idAluno);
                    if (aluno == null) break;

                    System.out.print("ID da disciplina: ");
                    Long idDisc = Long.parseLong(scanner.nextLine());
                    Disciplina disc = disciplinaController.buscarPorId(idDisc);
                    if (disc == null) break;

                    System.out.print("Nova nota: ");
                    double valor = Double.parseDouble(scanner.nextLine());
                    notaController.atualizarNota(id, valor, aluno, disc);
                }
                case 4 -> {
                    System.out.print("ID da nota: ");
                    Long id = Long.parseLong(scanner.nextLine());
                    notaController.excluirNota(id);
                }
                case 0 -> { return; }
                default -> System.out.println("Opção inválida!");
            }
        }
    }
}
