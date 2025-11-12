package br.com.sistemaescolar.service;

import br.com.sistemaescolar.dao.DisciplinaDAO;
import br.com.sistemaescolar.model.Disciplina;

public class DisciplinaService {

    private final DisciplinaDAO disciplinaDAO;

    public DisciplinaService() {
        this.disciplinaDAO = new DisciplinaDAO();
    }

    public void salvarDisciplina(Disciplina disciplina) {
        disciplinaDAO.salvar(disciplina);
    }

    public Disciplina buscarDisciplina(Long id) {
        return disciplinaDAO.buscarPorId(id);
    }

    public void atualizarDisciplina(Disciplina disciplina) {
        disciplinaDAO.atualizar(disciplina);
    }

    public void deletarDisciplina(Long id) {
        disciplinaDAO.deletar(id);
    }
}
