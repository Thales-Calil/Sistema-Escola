package br.com.sistemaescolar.app;

import br.com.sistemaescolar.controller.SalaController;

import java.util.Scanner;

public class MenuSala {

    public static void exibirMenu(Scanner scanner, SalaController salaController) {
        while (true) {
            System.out.println("\n--- Menu Sala ---");
            System.out.println("1. Criar sala");
            System.out.println("2. Exibir sala");
            System.out.println("3. Atualizar sala");
            System.out.println("4. Remover sala");
            System.out.println("0. Voltar");
            System.out.print("Opção: ");
            int op = Integer.parseInt(scanner.nextLine());
            switch (op) {
                case 1 -> {
                    System.out.print("Nome da sala: ");
                    String nome = scanner.nextLine();
                    System.out.print("Capacidade da sala: ");
                    int capacidade = Integer.parseInt(scanner.nextLine());
                    salaController.criarSala(nome, capacidade);
                }
                case 2 -> {
                    System.out.print("ID da sala: ");
                    Long id = Long.parseLong(scanner.nextLine());
                    salaController.exibirSala(id);
                }
                case 3 -> {
                    System.out.print("ID da sala: ");
                    Long id = Long.parseLong(scanner.nextLine());
                    System.out.print("Novo nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Nova capacidade: ");
                    int capacidade = Integer.parseInt(scanner.nextLine());
                    salaController.atualizarSala(id, nome, capacidade);
                }
                case 4 -> {
                    System.out.print("ID da sala: ");
                    Long id = Long.parseLong(scanner.nextLine());
                    salaController.excluirSala(id);
                }
                case 0 -> { return; }
                default -> System.out.println("Opção inválida!");
            }
        }
    }
}
