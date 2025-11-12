package br.com.sistemaescolar.service;

import br.com.sistemaescolar.dao.AlunoDAO;
import br.com.sistemaescolar.model.Aluno;

public class AlunoService {

    private final AlunoDAO alunoDAO = new AlunoDAO();

    public void salvarAluno(Aluno aluno) {
        alunoDAO.salvar(aluno);
    }

    public Aluno buscarAluno(Long id) {
        return alunoDAO.buscarPorId(id);
    }

    public void atualizarAluno(Aluno aluno) {
        alunoDAO.atualizar(aluno);
    }

    public void removerAluno(Long id) {
        alunoDAO.remover(id);
    }
}
