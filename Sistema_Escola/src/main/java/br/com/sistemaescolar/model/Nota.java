package br.com.sistemaescolar.model;

import jakarta.persistence.*;

@Entity
public class Nota{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double nota;

    @ManyToOne
    private Aluno aluno;

    @ManyToOne
    private Disciplina disciplina;

    public Nota () {}

    public Nota(double nota, Aluno aluno, Disciplina disciplina) {
        this.nota = nota;
        this.aluno = aluno;
        this.disciplina = disciplina;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public Aluno getId_aluno() {
        return aluno;
    }

    public void setId_aluno(Aluno id_aluno) {
        this.aluno = id_aluno;
    }

    public Disciplina getId_disciplina() {
        return disciplina;
    }

    public void setId_disciplina(Disciplina id_disciplina) {
        this.disciplina = id_disciplina;
    }
}