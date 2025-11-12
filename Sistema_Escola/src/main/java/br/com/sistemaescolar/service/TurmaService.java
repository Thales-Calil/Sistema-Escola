package br.com.sistemaescolar.service;

import br.com.sistemaescolar.dao.TurmaDAO;
import br.com.sistemaescolar.model.Turma;

public class TurmaService {

    private final TurmaDAO turmaDAO;

    public TurmaService() {
        this.turmaDAO = new TurmaDAO();
    }

    public void salvarTurma(Turma turma) {
        turmaDAO.salvar(turma);
    }

    public Turma buscarTurma(Long id) {
        return turmaDAO.buscarPorId(id);
    }

    public void atualizarTurma(Turma turma) {
        turmaDAO.atualizar(turma);
    }

    public void deletarTurma(Long id) {
        turmaDAO.deletar(id);
    }
}
