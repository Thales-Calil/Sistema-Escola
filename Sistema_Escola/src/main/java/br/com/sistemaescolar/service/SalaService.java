package br.com.sistemaescolar.service;

import br.com.sistemaescolar.dao.SalaDAO;
import br.com.sistemaescolar.model.Sala;


public class SalaService {
    private final SalaDAO salaDAO;

    public SalaService() {
        this.salaDAO = new SalaDAO();
    }

    public void salvarSala(Sala sala) {
        salaDAO.salvar(sala);
    }

    public Sala buscarSala(Long id) {
        return salaDAO.buscarPorId(id);
    }

    public void atualizarSala(Sala sala) {
        salaDAO.atualizar(sala);
    }

    public void deletarSala(Long id) {
        salaDAO.deletar(id);
    }
}
