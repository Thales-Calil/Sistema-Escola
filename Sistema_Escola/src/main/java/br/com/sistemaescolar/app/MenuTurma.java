package br.com.sistemaescolar.app;

import br.com.sistemaescolar.controller.TurmaController;
import br.com.sistemaescolar.controller.CursoController;
import br.com.sistemaescolar.model.Curso;

import java.util.Scanner;

public class MenuTurma {

    public static void exibirMenu(Scanner scanner, TurmaController turmaController, CursoController cursoController) {
        while (true) {
            System.out.println("\n--- Menu Turma ---");
            System.out.println("1. Criar turma");
            System.out.println("2. Exibir turma");
            System.out.println("3. Atualizar turma");
            System.out.println("4. Remover turma");
            System.out.println("0. Voltar");
            System.out.print("Opção: ");
            int op = Integer.parseInt(scanner.nextLine());
            switch (op) {
                case 1 -> {
                    System.out.print("Nome da turma: ");
                    String nome = scanner.nextLine();
                    System.out.print("ID do curso: ");
                    Long idCurso = Long.parseLong(scanner.nextLine());
                    Curso curso = cursoController.buscarPorId(idCurso);
                    if (curso != null) turmaController.criarTurma(nome, curso);
                    else System.out.println("Curso não encontrado.");
                }
                case 2 -> {
                    System.out.print("ID da turma: ");
                    Long id = Long.parseLong(scanner.nextLine());
                    turmaController.exibirTurma(id);
                }
                case 3 -> {
                    System.out.print("ID da turma: ");
                    Long id = Long.parseLong(scanner.nextLine());
                    System.out.print("Novo nome da turma: ");
                    String nome = scanner.nextLine();
                    System.out.print("ID do novo curso: ");
                    Long idCurso = Long.parseLong(scanner.nextLine());
                    Curso curso = cursoController.buscarPorId(idCurso);
                    if (curso != null) turmaController.atualizarTurma(id, nome, curso);
                    else System.out.println("Curso não encontrado.");
                }
                case 4 -> {
                    System.out.print("ID da turma: ");
                    Long id = Long.parseLong(scanner.nextLine());
                    turmaController.removerTurma(id);
                }
                case 0 -> { return; }
                default -> System.out.println("Opção inválida!");
            }
        }
    }
}
