package br.com.sistemaescolar.dao;

import br.com.sistemaescolar.model.Professor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ProfessorDAO {
    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("sistemaescolarPU");

    public void salvar(Professor professor) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(professor);
            em.getTransaction().commit();
            System.out.println("Professor salvo com sucesso!");
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public Professor buscar(Long id) {
        EntityManager em = emf.createEntityManager();
        Professor professor = em.find(Professor.class, id);
        em.close();
        return professor;
    }

    public void atualizar(Professor professor) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(professor);
            em.getTransaction().commit();
            System.out.println("Professor atualizado com sucesso!");
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public void remover(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            Professor professor = em.find(Professor.class, id);
            if (professor != null) {
                em.getTransaction().begin();
                em.remove(professor);
                em.getTransaction().commit();
                System.out.println("Professor removido com sucesso!");
            } else {
                System.out.println("Professor não encontrado.");
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
