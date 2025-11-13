package br.com.sistemaescolar.controller;

import br.com.sistemaescolar.model.Disciplina;
import br.com.sistemaescolar.model.Professor;
import br.com.sistemaescolar.service.ProfessorService;

public class ProfessorController {
    private final ProfessorService professorService = new ProfessorService();

    public void criarProfessor(String nome, String cpf, String especialidade, Disciplina disciplina) {
        professorService.cadastrarProfessor(nome, cpf, especialidade, disciplina);
    }

    public void exibirProfessor(Long id) {
        Professor professor = professorService.buscarProfessor(id);
        if (professor != null) {
            System.out.println("Professor: " + professor.getNome() + " | " +
                    professor.getCpf() + " | " +
                    professor.getEspecialidade() + " | " +  professor.getDisciplina().getNome());
        } else {
            System.out.println("Professor não encontrado.");
        }
    }

    public void atualizarProfessor(Long id, String novoNome, String novoCpf, String novaEspecialidade, Disciplina novaDisciplina) {
        professorService.atualizarProfessor(id, novoNome, novoCpf, novaEspecialidade, novaDisciplina);
    }

    public void excluirProfessor(Long id) {
        professorService.removerProfessor(id);
    }

    public Professor buscarPorId(Long id) {
        return professorService.buscarProfessor(id);
    }
}
