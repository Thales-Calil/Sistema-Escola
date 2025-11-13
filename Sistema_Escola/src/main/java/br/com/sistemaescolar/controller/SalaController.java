package br.com.sistemaescolar.controller;

import br.com.sistemaescolar.model.Sala;
import br.com.sistemaescolar.service.SalaService;

public class SalaController {
    private final SalaService salaService;

    public SalaController() {
        this.salaService = new SalaService();
    }

    public void criarSala(String nome, int capacidade) {
        Sala salaAdd = new Sala(nome, capacidade);
        salaService.salvarSala(salaAdd);
    }

    public void exibirSala(Long id) {
        Sala sala = salaService.buscarSala(id);
        if (sala != null) {
            System.out.println("Nome da sala: " + sala.getNome() + "|" + "Capacidade: " + sala.getCapacidade());
        } else {
            System.out.println("Sala não encontrada.");
        }
    }

    public void atualizarSala(Long id, String novoNome, int novaCapacidade) {
        Sala salaAtt = new Sala(novoNome, novaCapacidade);
        salaAtt.setId(id);
        salaService.atualizarSala(salaAtt);
    }

    public void excluirSala(Long id) {
        salaService.deletarSala(id);
    }

    public Sala buscarPorId(Long id) {
        return salaService.buscarSala(id);
    }
}