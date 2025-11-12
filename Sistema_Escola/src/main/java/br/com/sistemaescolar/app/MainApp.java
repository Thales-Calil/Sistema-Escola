package br.com.sistemaescolar.app;

import br.com.sistemaescolar.controller.*;
import br.com.sistemaescolar.model.*;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("=== Teste do Sistema Escolar ===");

        AlunoController alunoController = new AlunoController();
        ProfessorController professorController = new ProfessorController();
        CursoController cursoController = new CursoController();
        DisciplinaController disciplinaController = new DisciplinaController();
        TurmaController turmaController = new TurmaController();

        System.out.println("\n--- Teste de Curso ---");
        cursoController.criarCurso("Engenharia de Software", "Curso focado em desenvolvimento e gestão de software.");
        cursoController.criarCurso("Ciência da Computação", "Curso voltado para fundamentos e pesquisa em computação.");

        cursoController.exibirCurso(1L);
        cursoController.exibirCurso(2L);

        System.out.println("\n--- Teste de Professor ---");
        professorController.criarProfessor("Carlos Silva", "12345678900", "Banco de Dados");
        professorController.criarProfessor("Ana Souza", "98765432100", "Engenharia de Software");

        professorController.exibirProfessor(1L);
        professorController.exibirProfessor(2L);

        // Recupera os professores já persistidos no banco
        Professor profCarlos = professorController.buscarPorId(1L);
        Professor profAna = professorController.buscarPorId(2L);

        System.out.println("\n--- Teste de Disciplina ---");
        disciplinaController.criarDisciplina("Modelagem de Dados", profCarlos);
        disciplinaController.criarDisciplina("Qualidade de Software", profAna);

        disciplinaController.exibirDisciplina(1L);
        disciplinaController.exibirDisciplina(2L);

        System.out.println("\n--- Teste de Turma ---");
        Curso cursoEng = cursoController.buscarPorId(1L);
        Curso cursoCC = cursoController.buscarPorId(2L);

        turmaController.criarTurma("Turma A - EngSoft", cursoEng);
        turmaController.criarTurma("Turma B - CC", cursoCC);

        turmaController.exibirTurma(1L);
        turmaController.exibirTurma(2L);

        System.out.println("\n--- Teste de Aluno ---");
        alunoController.criarAluno("João Pereira", "11122233344");
        alunoController.criarAluno("Maria Oliveira", "55566677788");

        alunoController.exibirAluno(1L);
        alunoController.exibirAluno(2L);

        System.out.println("\n--- Teste de Atualização ---");
        alunoController.atualizarAluno(1L, "João P. da Silva", "11122233344");
        professorController.atualizarProfessor(1L, "Carlos S. Lima", "12345678900", "Banco de Dados Avançado");

        alunoController.exibirAluno(1L);
        professorController.exibirProfessor(1L);

        System.out.println("\n--- Teste de Remoção ---");
        // alunoController.removerAluno(2L);
        // cursoController.removerCurso(2L);
        // turmaController.removerTurma(2L);

        System.out.println("\n=== Teste concluído ===");
    }
}
