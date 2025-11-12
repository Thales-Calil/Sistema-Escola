package br.com.sistemaescolar.service;

import br.com.sistemaescolar.dao.CursoDAO;
import br.com.sistemaescolar.model.Curso;

public class CursoService {

    private final CursoDAO cursoDAO;

    public CursoService() {
        this.cursoDAO = new CursoDAO();
    }

    public void salvarCurso(Curso curso) {
        cursoDAO.salvar(curso);
    }

    public Curso buscarCurso(Long id) {
        return cursoDAO.buscarPorId(id);
    }

    public void atualizarCurso(Curso curso) {
        cursoDAO.atualizar(curso);
    }

    public void deletarCurso(Long id) {
        cursoDAO.deletar(id);
    }
}
