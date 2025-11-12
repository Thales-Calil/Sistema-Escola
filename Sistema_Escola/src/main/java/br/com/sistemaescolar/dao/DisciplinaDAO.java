package br.com.sistemaescolar.dao;

import br.com.sistemaescolar.model.Disciplina;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DisciplinaDAO {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("sistemaescolarPU");

    public void salvar(Disciplina disciplina) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(disciplina);
            em.getTransaction().commit();
            System.out.println("Disciplina salva com sucesso!");
        } finally {
            em.close();
        }
    }

    public Disciplina buscarPorId(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Disciplina.class, id);
        } finally {
            em.close();
        }
    }

    public void atualizar(Disciplina disciplina) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(disciplina);
            em.getTransaction().commit();
            System.out.println("Disciplina atualizada com sucesso!");
        } finally {
            em.close();
        }
    }

    public void deletar(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Disciplina disciplina = em.find(Disciplina.class, id);
            if (disciplina != null) {
                em.remove(disciplina);
                System.out.println("Disciplina removida com sucesso!");
            } else {
                System.out.println("Disciplina não encontrada.");
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
