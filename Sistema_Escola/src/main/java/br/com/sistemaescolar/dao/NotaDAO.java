package br.com.sistemaescolar.dao;

import br.com.sistemaescolar.model.Nota;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class NotaDAO {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("sistemaescolarPU");

    public void salvar(Nota nota) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(nota);
            em.getTransaction().commit();
            System.out.println("Nota salva com sucesso!");
        } finally {
            em.close();
        }
    }
    public Nota buscarPorId(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Nota.class, id);
        } finally {
            em.close();
        }
    }

    public void atualizar(Nota nota) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(nota);
            em.getTransaction().commit();
            System.out.println("Nota atualizada com sucesso!");
        } finally {
            em.close();
        }
    }

    public void deletar(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Nota nota = em.find(Nota.class, id);
            if (nota != null) {
                em.remove(nota);
                System.out.println("Nota removida com sucesso!");
            } else {
                System.out.println("Nota não encontrada.");
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
