package br.com.sistemaescolar.app;

import br.com.sistemaescolar.controller.CursoController;
import br.com.sistemaescolar.model.Curso;

import java.util.Scanner;

public class MenuCurso {

    public static void exibirMenu(Scanner scanner, CursoController cursoController) {
        while (true) {
            System.out.println("\n--- Menu Curso ---");
            System.out.println("1. Criar curso");
            System.out.println("2. Exibir curso");
            System.out.println("3. Atualizar curso");
            System.out.println("4. Remover curso");
            System.out.println("0. Voltar");
            System.out.print("Opção: ");
            int op = Integer.parseInt(scanner.nextLine());
            switch (op) {
                case 1 -> {
                    System.out.print("Nome do curso: ");
                    String nome = scanner.nextLine();
                    System.out.print("Descrição: ");
                    String desc = scanner.nextLine();
                    cursoController.criarCurso(nome, desc);
                }
                case 2 -> {
                    System.out.print("ID do curso: ");
                    Long id = Long.parseLong(scanner.nextLine());
                    cursoController.exibirCurso(id);
                }
                case 3 -> {
                    System.out.print("ID do curso: ");
                    Long id = Long.parseLong(scanner.nextLine());
                    System.out.print("Novo nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Nova descrição: ");
                    String desc = scanner.nextLine();
                    cursoController.atualizarCurso(id, nome, desc);
                }
                case 4 -> {
                    System.out.print("ID do curso: ");
                    Long id = Long.parseLong(scanner.nextLine());
                    cursoController.removerCurso(id);
                }
                case 0 -> { return; }
                default -> System.out.println("Opção inválida!");
            }
        }
    }
}
