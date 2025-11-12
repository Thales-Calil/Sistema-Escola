package br.com.sistemaescolar.model;

import jakarta.persistence.*;

@Entity
public class Nota{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double nota;

    @OneToOne
    private Aluno id_aluno;

    @OneToOne
    private Disciplina id_disciplina;

     public Nota () {}

    public Nota(double nota, Aluno id_aluno, Disciplina id_disciplina) {
        this.nota = nota;
        this.id_aluno = id_aluno;
        this.id_disciplina = id_disciplina;
    }

    public Long getId() {
        return id;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public Aluno getId_aluno() {
        return id_aluno;
    }

    public void setId_aluno(Aluno id_aluno) {
        this.id_aluno = id_aluno;
    }

    public Disciplina getId_disciplina() {
        return id_disciplina;
    }

    public void setId_disciplina(Disciplina id_disciplina) {
        this.id_disciplina = id_disciplina;
    }
}