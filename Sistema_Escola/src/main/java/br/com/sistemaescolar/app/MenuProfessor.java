package br.com.sistemaescolar.app;

import br.com.sistemaescolar.controller.ProfessorController;
import java.util.Scanner;

public class MenuProfessor {

    public static void exibirMenu(Scanner scanner, ProfessorController professorController) {
        while (true) {
            System.out.println("\n--- Menu Professor ---");
            System.out.println("1. Criar professor");
            System.out.println("2. Exibir professor");
            System.out.println("3. Atualizar professor");
            System.out.println("4. Remover professor");
            System.out.println("0. Voltar");
            System.out.print("Opção: ");
            int op = Integer.parseInt(scanner.nextLine());
            switch (op) {
                case 1 -> {
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();
                    System.out.print("Especialidade: ");
                    String esp = scanner.nextLine();
                    professorController.criarProfessor(nome, cpf, esp);
                }
                case 2 -> {
                    System.out.print("ID do professor: ");
                    Long id = Long.parseLong(scanner.nextLine());
                    professorController.exibirProfessor(id);
                }
                case 3 -> {
                    System.out.print("ID do professor: ");
                    Long id = Long.parseLong(scanner.nextLine());
                    System.out.print("Novo nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Novo CPF: ");
                    String cpf = scanner.nextLine();
                    System.out.print("Nova especialidade: ");
                    String esp = scanner.nextLine();
                    professorController.atualizarProfessor(id, nome, cpf, esp);
                }
                case 4 -> {
                    System.out.print("ID do professor: ");
                    Long id = Long.parseLong(scanner.nextLine());
                    professorController.excluirProfessor(id);
                }
                case 0 -> { return; }
                default -> System.out.println("Opção inválida!");
            }
        }
    }
}
