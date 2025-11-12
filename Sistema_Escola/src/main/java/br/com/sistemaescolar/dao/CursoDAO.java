package br.com.sistemaescolar.dao;

import br.com.sistemaescolar.model.Curso;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CursoDAO {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("sistemaescolarPU");

    public void salvar(Curso curso) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(curso);
            em.getTransaction().commit();
            System.out.println("Curso salvo com sucesso!");
        } finally {
            em.close();
        }
    }

    public Curso buscarPorId(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Curso.class, id);
        } finally {
            em.close();
        }
    }

    public void atualizar(Curso curso) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(curso);
            em.getTransaction().commit();
            System.out.println("Curso atualizado com sucesso!");
        } finally {
            em.close();
        }
    }

    public void deletar(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Curso curso = em.find(Curso.class, id);
            if (curso != null) {
                em.remove(curso);
                System.out.println("Curso removido com sucesso!");
            } else {
                System.out.println("Curso não encontrado.");
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
