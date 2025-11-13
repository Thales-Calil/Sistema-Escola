package br.com.sistemaescolar.app;

import br.com.sistemaescolar.controller.AlunoController;
import br.com.sistemaescolar.model.Aluno;

import java.util.Scanner;

public class MenuAluno {

    public static void exibirMenu(Scanner scanner, AlunoController alunoController) {
        while (true) {
            System.out.println("\n--- Menu Aluno ---");
            System.out.println("1. Criar aluno");
            System.out.println("2. Exibir aluno");
            System.out.println("3. Atualizar aluno");
            System.out.println("4. Remover aluno");
            System.out.println("0. Voltar");
            System.out.print("Opção: ");
            int op = Integer.parseInt(scanner.nextLine());
            switch (op) {
                case 1 -> {
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();
                    alunoController.criarAluno(nome, cpf);
                }
                case 2 -> {
                    System.out.print("ID do aluno: ");
                    Long id = Long.parseLong(scanner.nextLine());
                    alunoController.exibirAluno(id);
                }
                case 3 -> {
                    System.out.print("ID do aluno: ");
                    Long id = Long.parseLong(scanner.nextLine());
                    System.out.print("Novo nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Novo CPF: ");
                    String cpf = scanner.nextLine();
                    alunoController.atualizarAluno(id, nome, cpf);
                }
                case 4 -> {
                    System.out.print("ID do aluno: ");
                    Long id = Long.parseLong(scanner.nextLine());
                    alunoController.removerAluno(id);
                }
                case 0 -> { return; }
                default -> System.out.println("Opção inválida!");
            }
        }
    }
}
