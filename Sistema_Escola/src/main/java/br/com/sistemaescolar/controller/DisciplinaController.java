package br.com.sistemaescolar.controller;

import br.com.sistemaescolar.model.Disciplina;
import br.com.sistemaescolar.model.Professor;
import br.com.sistemaescolar.service.DisciplinaService;

public class DisciplinaController {

    private final DisciplinaService disciplinaService;

    public DisciplinaController() {
        this.disciplinaService = new DisciplinaService();
    }

    public void criarDisciplina(String nome, Professor professor) {
        Disciplina disciplina = new Disciplina(nome, professor);
        disciplinaService.salvarDisciplina(disciplina);
    }

    public void exibirDisciplina(Long id) {
        Disciplina disciplina = disciplinaService.buscarDisciplina(id);
        if (disciplina != null) {
            System.out.println("Disciplina: " + disciplina.getNome() +
                    " | Professor: " + disciplina.getProfessor().getNome());
        } else {
            System.out.println("Disciplina não encontrada.");
        }
    }

    public void atualizarDisciplina(Long id, String novoNome, Professor novoProfessor) {
        Disciplina disciplina = disciplinaService.buscarDisciplina(id);
        if (disciplina != null) {
            disciplina.setNome(novoNome);
            disciplina.setProfessor(novoProfessor);
            disciplinaService.atualizarDisciplina(disciplina);
        } else {
            System.out.println("Disciplina não encontrada para atualização.");
        }
    }

    public void removerDisciplina(Long id) {
        disciplinaService.deletarDisciplina(id);
    }
}
