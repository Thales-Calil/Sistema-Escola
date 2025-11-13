package br.com.sistemaescolar.dao;

import br.com.sistemaescolar.model.Sala;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class SalaDAO {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("sistemaescolarPU");

    public void salvar(Sala sala) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(sala);
            em.getTransaction().commit();
            System.out.println("Sala salva com sucesso!");
        } finally {
            em.close();
        }
    }
    public Sala buscarPorId(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Sala.class, id);
        } finally {
            em.close();
        }
    }

    public void atualizar(Sala sala) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(sala);
            em.getTransaction().commit();
            System.out.println("Sala atualizada com sucesso!");
        } finally {
            em.close();
        }
    }

    public void deletar(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Sala sala = em.find(Sala.class, id);
            if (sala != null) {
                em.remove(sala);
                System.out.println("Sala removida com sucesso!");
            } else {
                System.out.println("Sala não encontrada.");
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
