package br.com.sistemaescolar.controller;

import br.com.sistemaescolar.model.Aluno;
import br.com.sistemaescolar.service.AlunoService;

public class AlunoController {

    private final AlunoService alunoService = new AlunoService();

    public void criarAluno(String nome, String cpf) {
        Aluno aluno = new Aluno(nome, cpf);
        alunoService.salvarAluno(aluno);
        System.out.println("Aluno criado com ID: " + aluno.getId());
    }

    public void atualizarAluno(Long id, String novoNome, String novoCpf) {
        Aluno aluno = alunoService.buscarAluno(id);
        if (aluno != null) {
            aluno.setNome(novoNome);
            aluno.setCpf(novoCpf);
            alunoService.atualizarAluno(aluno);
            System.out.println("Aluno atualizado!");
        } else {
            System.out.println("Aluno não encontrado.");
        }
    }

    public void removerAluno(Long id) {
        alunoService.removerAluno(id);
        System.out.println("Aluno removido!");
    }

    public Aluno exibirAluno(Long id) {
        Aluno aluno = alunoService.buscarAluno(id);
        if (aluno != null) {
            System.out.println("Aluno: " + aluno.getNome() + " | " + aluno.getCpf());
        } else {
            System.out.println("Aluno não encontrado.");
        }
        return aluno;
    }

    public Aluno buscarPorId(Long id) {
        return alunoService.buscarAluno(id);
    }

}
