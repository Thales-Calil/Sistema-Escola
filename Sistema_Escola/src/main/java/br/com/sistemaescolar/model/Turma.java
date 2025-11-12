package br.com.sistemaescolar.model;

import jakarta.persistence.*;

@Entity
public class Turma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToOne
    private Curso curso;

    @OneToMany
    private Aluno id_aluno;

    public Turma() {}

    public Turma(String nome, Curso curso) {
        this.nome = nome;
        this.curso = curso;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
