package br.com.sistemaescolar.service;

import br.com.sistemaescolar.dao.NotaDAO;
import br.com.sistemaescolar.model.Nota;

public class NotaService {
    private final NotaDAO notaDAO;

    public NotaService() {
        this.notaDAO = new NotaDAO();
    }

    public void salvarNota(Nota nota) {
        notaDAO.salvar(nota);
    }

    public Nota buscarNota(Long id) {
        return notaDAO.buscarPorId(id);
    }

    public void atualizarNota(Nota nota) {
        notaDAO.atualizar(nota);
    }

    public void deletarNota(Long id) {
        notaDAO.deletar(id);
    }
}