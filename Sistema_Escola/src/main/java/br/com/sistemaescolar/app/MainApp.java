package br.com.sistemaescolar.app;

import br.com.sistemaescolar.controller.*;
import java.util.Scanner;

public class MainApp {
    private static final Scanner scanner = new Scanner(System.in);

    private static final AlunoController alunoController = new AlunoController();
    private static final ProfessorController professorController = new ProfessorController();
    private static final CursoController cursoController = new CursoController();
    private static final DisciplinaController disciplinaController = new DisciplinaController();
    private static final TurmaController turmaController = new TurmaController();
    private static final NotaController notaController = new NotaController();
    private static final SalaController salaController = new SalaController();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== SISTEMA ESCOLAR =====");
            System.out.println("1. Aluno");
            System.out.println("2. Professor");
            System.out.println("3. Curso");
            System.out.println("4. Disciplina");
            System.out.println("5. Turma");
            System.out.println("6. Nota");
            System.out.println("7. Sala");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1 -> MenuAluno.exibirMenu(scanner, alunoController);
                case 2 -> MenuProfessor.exibirMenu(scanner, professorController);
                case 3 -> MenuCurso.exibirMenu(scanner, cursoController);
                case 4 -> MenuDisciplina.exibirMenu(scanner, disciplinaController, professorController);
                case 5 -> MenuTurma.exibirMenu(scanner, turmaController, cursoController);
                case 6 -> MenuNota.exibirMenu(scanner, notaController, alunoController, disciplinaController);
                case 7 -> MenuSala.exibirMenu(scanner, salaController);
                case 0 -> {
                    System.out.println("Saindo...");
                    System.exit(0);
                }
                default -> System.out.println("Opção inválida!");
            }
        }
    }
}
