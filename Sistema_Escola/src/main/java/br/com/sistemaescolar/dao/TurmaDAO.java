package br.com.sistemaescolar.dao;

import br.com.sistemaescolar.model.Turma;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TurmaDAO {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("sistemaescolarPU");

    public void salvar(Turma turma) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(turma);
            em.getTransaction().commit();
            System.out.println("Turma salva com sucesso!");
        } finally {
            em.close();
        }
    }

    public Turma buscarPorId(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Turma.class, id);
        } finally {
            em.close();
        }
    }

    public void atualizar(Turma turma) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(turma);
            em.getTransaction().commit();
            System.out.println("Turma atualizada com sucesso!");
        } finally {
            em.close();
        }
    }

    public void deletar(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Turma turma = em.find(Turma.class, id);
            if (turma != null) {
                em.remove(turma);
                System.out.println("Turma removida com sucesso!");
            } else {
                System.out.println("Turma não encontrada.");
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
