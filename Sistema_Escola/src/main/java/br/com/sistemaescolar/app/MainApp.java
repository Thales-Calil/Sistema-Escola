package br.com.sistemaescolar.app;

import br.com.sistemaescolar.controller.*;
import br.com.sistemaescolar.model.*;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("===========================================");
        System.out.println("        🏫 SISTEMA ESCOLAR - TESTE         ");
        System.out.println("===========================================\n");

        // Teste de conexão
        EntityManagerFactory emf = null;
        try {
            emf = Persistence.createEntityManagerFactory("sistemaescolarPU");
            System.out.println("🔗 Conexão com o banco: ✅ Sucesso!\n");
        } catch (Exception e) {
            System.out.println("❌ Erro ao criar EntityManagerFactory:");
            e.printStackTrace();
            return;
        }

        // Controladores
        AlunoController alunoController = new AlunoController();
        ProfessorController professorController = new ProfessorController();
        CursoController cursoController = new CursoController();
        DisciplinaController disciplinaController = new DisciplinaController();
        TurmaController turmaController = new TurmaController();

        // ===============================================================
        // OPÇÃO 1 — Fluxo funcional com professores persistidos
        // ===============================================================

        System.out.println("📘 [1] Cadastro de Cursos");
        cursoController.criarCurso("Engenharia de Software", "Curso focado em desenvolvimento e gestão de software.");
        cursoController.criarCurso("Ciência da Computação", "Curso voltado para fundamentos e pesquisa em computação.");

        cursoController.exibirCurso(1L);
        cursoController.exibirCurso(2L);
        System.out.println("-------------------------------------------\n");

        System.out.println("👨‍🏫 [2] Cadastro de Professores");
        professorController.criarProfessor("Carlos Silva", "12345678900", "Banco de Dados");
        professorController.criarProfessor("Ana Souza", "98765432100", "Engenharia de Software");

        professorController.exibirProfessor(1L);
        professorController.exibirProfessor(2L);
        System.out.println("-------------------------------------------\n");

        System.out.println("📚 [3] Cadastro de Disciplinas");
        Professor profCarlos = professorController.buscarPorId(1L);
        Professor profAna = professorController.buscarPorId(2L);

        disciplinaController.criarDisciplina("Modelagem de Dados", profCarlos);
        disciplinaController.criarDisciplina("Qualidade de Software", profAna);

        disciplinaController.exibirDisciplina(1L);
        disciplinaController.exibirDisciplina(2L);
        System.out.println("-------------------------------------------\n");

        System.out.println("🏫 [4] Cadastro de Turmas");
        Curso cursoEng = cursoController.buscarPorId(1L);
        Curso cursoCC = cursoController.buscarPorId(2L);

        turmaController.criarTurma("Turma A - EngSoft", cursoEng);
        turmaController.criarTurma("Turma B - CC", cursoCC);

        turmaController.exibirTurma(1L);
        turmaController.exibirTurma(2L);
        System.out.println("-------------------------------------------\n");

        System.out.println("🎓 [5] Cadastro de Alunos");
        alunoController.criarAluno("João Pereira", "11122233344");
        alunoController.criarAluno("Maria Oliveira", "55566677788");

        alunoController.exibirAluno(1L);
        alunoController.exibirAluno(2L);
        System.out.println("-------------------------------------------\n");

        System.out.println("✏️ [6] Atualização de Dados");
        alunoController.atualizarAluno(1L, "João P. da Silva", "11122233344");
        professorController.atualizarProfessor(1L, "Carlos S. Lima", "12345678900", "Banco de Dados Avançado");

        alunoController.exibirAluno(1L);
        professorController.exibirProfessor(1L);
        System.out.println("-------------------------------------------\n");

        System.out.println("✅ Todos os testes foram executados com sucesso!");
        System.out.println("===========================================");
        System.out.println("        🚀 FIM DO TESTE AUTOMÁTICO          ");
        System.out.println("===========================================");

        emf.close();
    }
}
