package br.com.sistemaescolar.dao;

import br.com.sistemaescolar.model.Aluno;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class AlunoDAO {

    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("sistemaescolarPU");

    public void salvar(Aluno aluno) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(aluno);
        em.getTransaction().commit();
        em.close();
    }

    public Aluno buscarPorId(Long id) {
        EntityManager em = emf.createEntityManager();
        Aluno aluno = em.find(Aluno.class, id);
        em.close();
        return aluno;
    }

    public void atualizar(Aluno aluno) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(aluno);
        em.getTransaction().commit();
        em.close();
    }

    public void remover(Long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Aluno aluno = em.find(Aluno.class, id);
        if (aluno != null) {
            em.remove(aluno);
        }
        em.getTransaction().commit();
        em.close();
    }
}
