package br.com.sistemaescolar.controller;

import br.com.sistemaescolar.model.Curso;
import br.com.sistemaescolar.service.CursoService;

public class CursoController {

    private final CursoService cursoService;

    public CursoController() {
        this.cursoService = new CursoService();
    }

    public void criarCurso(String nome, String descricao) {
        Curso curso = new Curso(nome, descricao);
        cursoService.salvarCurso(curso);
    }

    public void exibirCurso(Long id) {
        Curso curso = cursoService.buscarCurso(id);
        if (curso != null) {
            System.out.println("Curso: " + curso.getNome() + " | " + curso.getDescricao());
        } else {
            System.out.println("Curso não encontrado.");
        }
    }

    public void atualizarCurso(Long id, String novoNome, String novaDescricao) {
        Curso curso = cursoService.buscarCurso(id);
        if (curso != null) {
            curso.setNome(novoNome);
            curso.setDescricao(novaDescricao);
            cursoService.atualizarCurso(curso);
        } else {
            System.out.println("Curso não encontrado para atualização.");
        }
    }

    public void removerCurso(Long id) {
        cursoService.deletarCurso(id);
    }

    public Curso buscarPorId(Long id) {
        return cursoService.buscarCurso(id);
    }
}
