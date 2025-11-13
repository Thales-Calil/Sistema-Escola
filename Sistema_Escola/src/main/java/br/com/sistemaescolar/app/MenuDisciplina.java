package br.com.sistemaescolar.app;

import br.com.sistemaescolar.controller.DisciplinaController;
import br.com.sistemaescolar.controller.ProfessorController;
import br.com.sistemaescolar.model.Professor;

import java.util.Scanner;

public class MenuDisciplina {

    public static void exibirMenu(Scanner scanner, DisciplinaController disciplinaController, ProfessorController professorController) {
        while (true) {
            System.out.println("\n--- Menu Disciplina ---");
            System.out.println("1. Criar disciplina");
            System.out.println("2. Exibir disciplina");
            System.out.println("3. Atualizar disciplina");
            System.out.println("4. Remover disciplina");
            System.out.println("0. Voltar");
            System.out.print("Opção: ");
            int op = Integer.parseInt(scanner.nextLine());
            switch (op) {
                case 1 -> {
                    System.out.print("Nome da disciplina: ");
                    String nome = scanner.nextLine();
                    System.out.print("ID do professor: ");
                    Long idProf = Long.parseLong(scanner.nextLine());
                    Professor professor = professorController.buscarPorId(idProf);
                    if (professor != null) {
                        disciplinaController.criarDisciplina(nome, professor);
                    } else System.out.println("Professor não encontrado.");
                }
                case 2 -> {
                    System.out.print("ID da disciplina: ");
                    Long id = Long.parseLong(scanner.nextLine());
                    disciplinaController.exibirDisciplina(id);
                }
                case 3 -> {
                    System.out.print("ID da disciplina: ");
                    Long id = Long.parseLong(scanner.nextLine());
                    System.out.print("Novo nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("ID do novo professor: ");
                    Long idProf = Long.parseLong(scanner.nextLine());
                    Professor professor = professorController.buscarPorId(idProf);
                    if (professor != null) {
                        disciplinaController.atualizarDisciplina(id, nome, professor);
                    } else System.out.println("Professor não encontrado.");
                }
                case 4 -> {
                    System.out.print("ID da disciplina: ");
                    Long id = Long.parseLong(scanner.nextLine());
                    disciplinaController.removerDisciplina(id);
                }
                case 0 -> { return; }
                default -> System.out.println("Opção inválida!");
            }
        }
    }
}
