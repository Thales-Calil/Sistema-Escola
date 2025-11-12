package br.com.sistemaescolar.service;

import br.com.sistemaescolar.dao.ProfessorDAO;
import br.com.sistemaescolar.model.Professor;

public class ProfessorService {
    private final ProfessorDAO professorDAO = new ProfessorDAO();

    public void cadastrarProfessor(String nome, String cpf, String especialidade) {
        Professor professor = new Professor(nome, cpf, especialidade);
        professorDAO.salvar(professor);
    }

    public Professor buscarProfessor(Long id) {
        return professorDAO.buscar(id);
    }

    public void atualizarProfessor(Long id, String novoNome, String novoCpf, String novaEspecialidade) {
        Professor professor = professorDAO.buscar(id);
        if (professor != null) {
            professor.setNome(novoNome);
            professor.setCpf(novoCpf);
            professor.setEspecialidade(novaEspecialidade);
            professorDAO.atualizar(professor);
        } else {
            System.out.println("Professor não encontrado.");
        }
    }

    public void removerProfessor(Long id) {
        professorDAO.remover(id);
    }
}
