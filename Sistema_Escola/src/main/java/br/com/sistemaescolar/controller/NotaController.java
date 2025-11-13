package br.com.sistemaescolar.controller;

import br.com.sistemaescolar.model.Aluno;
import br.com.sistemaescolar.model.Disciplina;
import br.com.sistemaescolar.model.Nota;
import br.com.sistemaescolar.service.NotaService;

public class NotaController {
    private final NotaService notaService;

    public NotaController() {this.notaService = new NotaService();}

    public void criarNota(double nota, Aluno aluno, Disciplina disciplina) {
        Nota notaAdd = new Nota(nota, aluno, disciplina);
        notaService.salvarNota(notaAdd);
    }

    public void exibirNotas(Long id) {
        Nota nota =  notaService.buscarNota(id);
        if (nota != null) {
            System.out.println("Aluno: " + nota.getId_aluno().getNome() + " | " +
                    "Disciplina: " + nota.getId_disciplina().getNome() + " | " +
                    "Nota: " + nota.getNota());
        } else {
            System.out.println("Nota não encontrada.");
        }
    }

    public void atualizarNota(Long id, double novaNota, Aluno novoAluno, Disciplina novaDisciplina) {
        Nota notaAtt = new Nota(novaNota, novoAluno, novaDisciplina);
        notaAtt.setId(id);
        notaService.atualizarNota(notaAtt);
    }

    public void excluirNota(Long id) {
        notaService.deletarNota(id);
    }

    public Nota buscarPorId(Long id) {
        return notaService.buscarNota(id);
    }
}
