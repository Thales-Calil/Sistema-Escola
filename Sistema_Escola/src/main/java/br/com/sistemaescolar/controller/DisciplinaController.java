package br.com.sistemaescolar.controller;

import br.com.sistemaescolar.model.Disciplina;
import br.com.sistemaescolar.model.Professor;
import br.com.sistemaescolar.service.DisciplinaService;

public class DisciplinaController {

    private final DisciplinaService disciplinaService;

    public DisciplinaController() {
        this.disciplinaService = new DisciplinaService();
    }

    public void criarDisciplina(String nome) {
        Disciplina disciplina = new Disciplina(nome);
        disciplinaService.salvarDisciplina(disciplina);
    }

    public void exibirDisciplina(Long id) {
        Disciplina disciplina = disciplinaService.buscarDisciplina(id);
        if (disciplina != null) {
            System.out.println("Disciplina: " + disciplina.getNome());
        } else {
            System.out.println("Disciplina não encontrada.");
        }
    }

    public void atualizarDisciplina(Long id, String novoNome) {
        Disciplina disciplina = disciplinaService.buscarDisciplina(id);
        if (disciplina != null) {
            disciplina.setNome(novoNome);
            disciplinaService.atualizarDisciplina(disciplina);
        } else {
            System.out.println("Disciplina não encontrada para atualização.");
        }
    }

    public void removerDisciplina(Long id) {
        disciplinaService.deletarDisciplina(id);
    }

    public Disciplina buscarPorId(Long id) {
        return disciplinaService.buscarDisciplina(id);
    }

}
