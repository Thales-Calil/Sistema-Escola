package br.com.sistemaescolar.app;

import br.com.sistemaescolar.controller.AlunoController;
import br.com.sistemaescolar.controller.TurmaController;
import br.com.sistemaescolar.model.Aluno;
import br.com.sistemaescolar.model.Sala;
import br.com.sistemaescolar.model.Turma;

import java.util.Scanner;

public class MenuAluno {

    public static void exibirMenu(Scanner scanner, AlunoController alunoController) {
        TurmaController turmaController = new TurmaController();

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
                    System.out.print("ID da turma: ");
                    Long idTurma = Long.parseLong(scanner.nextLine());
                    Turma turma = turmaController.buscarPorId(idTurma);
                    if(turma != null) {
                        alunoController.criarAluno(nome, cpf, turma);

                    } else System.out.println("Nenhuma turma foi encontrada.");
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
