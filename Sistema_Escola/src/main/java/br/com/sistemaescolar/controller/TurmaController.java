package br.com.sistemaescolar.controller;

import br.com.sistemaescolar.model.Curso;
import br.com.sistemaescolar.model.Sala;
import br.com.sistemaescolar.model.Turma;
import br.com.sistemaescolar.service.TurmaService;

public class TurmaController {

    private final TurmaService turmaService;

    public TurmaController() {
        this.turmaService = new TurmaService();
    }

    public void criarTurma(String nome, Curso curso, Sala sala) {
        Turma turma = new Turma(nome, curso, sala);
        turmaService.salvarTurma(turma);
    }

    public void exibirTurma(Long id) {
        Turma turma = turmaService.buscarTurma(id);
        if (turma != null) {
            System.out.println("Turma: " + turma.getNome() +
                    " | Curso: " + turma.getCurso().getNome() + " | " + "Sala: " + turma.getSala().getNome());
        } else {
            System.out.println("Turma não encontrada.");
        }
    }

    public void atualizarTurma(Long id, String novoNome, Curso novoCurso, Sala novaSala) {
        Turma turma = turmaService.buscarTurma(id);
        if (turma != null) {
            turma.setNome(novoNome);
            turma.setCurso(novoCurso);
            turma.setSala(novaSala);
            turmaService.atualizarTurma(turma);
        } else {
            System.out.println("Turma não encontrada para atualização.");
        }
    }

    public void removerTurma(Long id) {
        turmaService.deletarTurma(id);
    }
}
